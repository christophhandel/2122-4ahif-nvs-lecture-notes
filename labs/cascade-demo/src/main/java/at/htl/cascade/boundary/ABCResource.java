package at.htl.cascade.boundary;

import at.htl.cascade.control.ARepository;
import at.htl.cascade.control.BRepository;
import at.htl.cascade.entity.A;
import at.htl.cascade.entity.B;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

@Path("abc")
public class ABCResource {

    @Inject
    Logger LOG;

    @Inject
    ARepository aRepository;

    @Inject
    BRepository bRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createA(JsonObject abcJson, @Context UriInfo uriInfo) {

        A a = new A(abcJson.getString("name"));

        a = aRepository.save(a);

        LOG.infof("%s", a);

        JsonArray bList = abcJson.getJsonArray("b");

        for (JsonValue bjson : bList) {
            String text = bjson.asJsonObject().getString("text");
            LOG.info(text);
            B b = new B(text, a);
            bRepository.save(b);
        }

        UriBuilder uriBuilder =
                uriInfo.getAbsolutePathBuilder()
                        .path("1");

        return Response
                .created(uriBuilder.build())
                .build();

    }

}
