package hippo.crisp.demo.rest;

import hippo.crisp.demo.beans.Animal;
import org.onehippo.cms7.essentials.components.rest.BaseRestResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jgreely on 3/12/18.
 */
@Path("/animal")
public class AnimalEndpoint extends BaseRestResource {

    @GET
    @Path("/string")
    public String getPlainString(){
        return "Hippo";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal getPlainJson(){

        Animal animal = new Animal();
        animal.setName("Hippo");
        animal.setColor("Grey");
        animal.setDescription("A large, river bound mammal.");
        animal.setWeight(600);
        animal.setHeightFeet(6);
        animal.setHeightInch(3);

        return animal;
    }
}
