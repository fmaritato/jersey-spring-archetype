package $com.maritatf.archetypes;


import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/sample")
@Component
public class SampleResource {

    private static transient final Log log = LogFactory.getLog(SampleResource.class);

    @Path("/test")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTest() {
        return Response.status(200).entity("test successful").build();
    }
}
