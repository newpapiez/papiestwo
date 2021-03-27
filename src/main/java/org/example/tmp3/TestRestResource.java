package org.example.tmp3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.HashMap;

@Component
@Path("/test")
@Slf4j
public class TestRestResource {

    @GET
    @Produces("application/json")
    public Object getTest() {
        return new HashMap<String, String>() {{
            put("key", "value");
        }};
    }

    @POST
    @Consumes("application/json")
    public void postTest(@Valid TestObject testObject) {
        log.trace(testObject.toString());
        log.debug(testObject.toString());
        log.info(testObject.toString());
        log.warn(testObject.toString());
        log.error(testObject.toString());
    }
}
