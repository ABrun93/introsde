package rpc.endpoint;

import javax.xml.ws.Endpoint;
import rpc.webservice.HelloWorldImplementation;

// Endpoint publisher
public class HelloWorldPublisher{
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:6900/ws/hello", new HelloWorldImplementation());
    }
}

/* Richiesta del servizio
	Metodo POST: 
		Head: Contetnt-type = text/xml
	 	Body: <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
				   soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
				<soap:Body xmlns:m="http://webservice.rpc/">
				  <m:getHelloWorldAsString>
				    <arg0>Nome</arg0>
				  </m:getHelloWorldAsString>
			  	</soap:Body>
			  </soap:Envelope>
*/
