package rpc.webservice;

import javax.jws.WebService;

// Service Implementation
@WebService(endpointInterface = "rpc.webservice.HelloWorldInterface")
public class HelloWorldImplementation implements HelloWorldInterface {
  @Override
  public String getHelloWorldAsString(String name) {
      return "Hello World JAX-WS " + name;
  }
}
