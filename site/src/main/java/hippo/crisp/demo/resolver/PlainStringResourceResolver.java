package hippo.crisp.demo.resolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.onehippo.cms7.crisp.api.exchange.ExchangeHint;
import org.onehippo.cms7.crisp.api.resource.Resource;
import org.onehippo.cms7.crisp.api.resource.ResourceException;
import org.onehippo.cms7.crisp.core.resource.jackson.JacksonResource;
import org.onehippo.cms7.crisp.core.resource.jackson.SimpleJacksonRestTemplateResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jgreely on 3/12/18.
 */
public class PlainStringResourceResolver extends SimpleJacksonRestTemplateResourceResolver {
    private static Logger log = LoggerFactory.getLogger(PlainStringResourceResolver.class);

    private static ThreadLocal<Map<Resource, Object>> tlResourceResultCache = new ThreadLocal<Map<Resource, Object>>() {
        protected Map<Resource, Object> initialValue() {
            return new HashMap();
        }
    };

    public PlainStringResourceResolver(){
        super();
    }

    @Override
    public Resource resolve(String absPath, Map<String, Object> pathVariables, ExchangeHint exchangeHint) throws ResourceException {
        try {
            HttpMethod httpMethod = exchangeHint != null?HttpMethod.resolve(exchangeHint.getMethodName()):HttpMethod.GET;
            Object requestObject = this.getRequestEntityObject(exchangeHint);
            RestTemplate restTemplate = this.getRestTemplate();
            ResponseEntity result;
            if(HttpMethod.POST.equals(httpMethod)) {
                result = restTemplate.postForEntity(this.getBaseResourceURI(absPath), requestObject, String.class, pathVariables);
            } else {
                result = restTemplate.getForEntity(this.getBaseResourceURI(absPath), String.class, pathVariables);
            }

            if(this.isSuccessfulResponse(result)) {
                String bodyText = (String)result.getBody();
                log.info(bodyText);
                JsonNode jsonNode = this.getObjectMapper().readTree(bodyText);
                Resource resource = new JacksonResource(jsonNode);
                if(this.isCacheEnabled()) {
                    ((Map)tlResourceResultCache.get()).put(resource, bodyText);
                }

                return resource;
            } else {
                throw new ResourceException("Unexpected response status: " + result.getStatusCode());
            }
        } catch (JsonProcessingException var11) {
            throw new ResourceException("JSON processing error.", var11);
        } catch (RestClientException var12) {
            throw new ResourceException("REST client invocation error.", var12);
        } catch (IOException var13) {
            throw new ResourceException("IO error.", var13);
        } catch (Exception var14) {
            throw new ResourceException("Unknown error.", var14);
        }
    }

    @Override
    public Resource findResources(String baseAbsPath, Map<String, Object> pathVariables, ExchangeHint exchangeHint) throws ResourceException {
        try {
            HttpMethod httpMethod = exchangeHint != null?HttpMethod.resolve(exchangeHint.getMethodName()):HttpMethod.GET;
            Object requestObject = this.getRequestEntityObject(exchangeHint);
            RestTemplate restTemplate = this.getRestTemplate();
            ResponseEntity result;
            if(HttpMethod.POST.equals(httpMethod)) {
                result = restTemplate.postForEntity(this.getBaseResourceURI(baseAbsPath), requestObject, String.class, pathVariables);
            } else {
                result = restTemplate.getForEntity(this.getBaseResourceURI(baseAbsPath), String.class, pathVariables);
            }

            if(this.isSuccessfulResponse(result)) {
                String bodyText = (String)result.getBody();
                log.info(bodyText);
                JsonNode jsonNode = this.getObjectMapper().readTree(bodyText);
                Resource rootResource = new JacksonResource(jsonNode);
                if(this.isCacheEnabled()) {
                    ((Map)tlResourceResultCache.get()).put(rootResource, bodyText);
                }

                return rootResource;
            } else {
                throw new ResourceException("Unexpected response status: " + result.getStatusCode());
            }
        } catch (JsonProcessingException var11) {
            throw new ResourceException("JSON processing error.", var11);
        } catch (RestClientException var12) {
            throw new ResourceException("REST client invocation error.", var12);
        } catch (IOException var13) {
            throw new ResourceException("IO error.", var13);
        } catch (Exception var14) {
            throw new ResourceException("Unknown error.", var14);
        }
    }

}
