package rpc.client;

import rpc.webservice.HelloWorldInterface;
import rpc.webservice.HelloWorldImplementationService;

public class HelloWorldClient{
    public static void main(String[] args) {
        HelloWorldImplementationService helloService = new HelloWorldImplementationService();
        HelloWorldInterface hello = helloService.getHelloWorldImplementationPort();
        System.out.println(hello.getHelloWorldAsString("Andrea"));
    }
}

/* Importare endpoint service
 		wsimport -keep http://localhost:6900/ws/hello?wsdl
 */

/* Eseguire da terminale
		javac rpc/client/HelloWorldClient.java
		java rpc/client/HelloWorldClient
*/