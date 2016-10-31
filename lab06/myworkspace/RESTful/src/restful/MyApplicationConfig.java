package restful;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("sdelab/resources")
public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig () {
        packages("restful"); // Jersey will load all the resources under this package
    }
}
