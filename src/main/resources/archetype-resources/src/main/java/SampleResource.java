package ${groupId};

import java.util.HashMap;
import java.util.Map;

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
    public Map getTest() {

        Map m = new HashMap();
        m.put("key1", "stuff1");
        return m;
    }
}
