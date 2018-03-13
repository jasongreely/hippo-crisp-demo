package hippo.crisp.demo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.onehippo.cms7.essentials.components.rest.BaseRestResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by jgreely on 3/12/18.
 */
public class StringEndpoint extends BaseRestResource {

    @GET
    @Path("/string")
    public String getPlainString(){
        return "thisIsAString";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPlainJson(){
        JsonObject object = new JsonObject();
        object.setDescription("thisisthedescription");
        object.setTitle("thisisthetitle");
        return object;
    }
}
