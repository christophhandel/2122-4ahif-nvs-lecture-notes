package at.htl;


import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Person hello() {
        return new Person("Susi", "Leonding");
    }

    @GET
    @Path("jsonp")
    @Produces({MediaType.APPLICATION_JSON})
    public JsonObject jsonp() {
        JsonObject susi = Json.createObjectBuilder()
                .add("name","Susi")
                .add("city","Leonding")
                .build();
        return susi;
    }
}