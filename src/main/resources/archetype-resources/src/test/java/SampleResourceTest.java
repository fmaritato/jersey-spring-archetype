package ${groupId};

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.api.json.JSONConfiguration;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import org.springframework.web.context.ContextLoaderListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Unit test for simple SampleResource.
 */
public class SampleResourceTest extends JerseyTest {

    public static final transient Log log = LogFactory.getLog(SampleResourceTest.class);

    public SampleResourceTest() {
        super(new WebAppDescriptor.Builder("${groupId}")
                      .contextPath("")
                      .contextParam("contextConfigLocation",
                                    "classpath:/spring.cfg.xml")
                      .servletClass(SpringServlet.class)
                      .contextListenerClass(ContextLoaderListener.class)
                      .initParam(JSONConfiguration.FEATURE_POJO_MAPPING, "true")
                      .build()
        );
    }

    @Test
    public void testSampleResource() throws IOException {

        WebResource r = resource();

        String response = r.path("/sample/test")
                           .accept(MediaType.APPLICATION_JSON)
                           .get(String.class);

        if (log.isDebugEnabled()) {
            log.debug(response);
        }
        ObjectMapper mapper = new ObjectMapper();

        Map map = mapper.readValue(response, new TypeReference<HashMap>() {});
        Assert.assertTrue(map.containsKey("key1"));
        Assert.assertEquals("stuff1", map.get("key1"));
    }
}
