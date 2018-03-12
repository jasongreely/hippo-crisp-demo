package hippo.crisp.demo.rest;

import org.onehippo.cms7.essentials.components.rest.BaseRestResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by jgreely on 3/12/18.
 */
public class StringEndpoint extends BaseRestResource {

    @GET
    @Path("/string")
    public String getPlainString(){
        return "thisIsAString";
    }
}
