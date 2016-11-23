package document.endpoint;

import javax.xml.ws.Endpoint;

import document.webservice.HelloWorldImplementation;

//Endpoint publisher
public class HelloWorldPublisher{
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:6901/ws/hello", new HelloWorldImplementation());
    }
}

/* Generare artifacts
		wsgen -keep -cp . document.webservice.HelloWorldImplementation
   e spostare le cleaasi csì generate 
   		da build/classes/document/webservice/jaxws 
   		in src/document/webservice/jaxws
*/

/* Richiesta del servizio
		Metodo POST: 
			Head: Contetnt-type = text/xml
		 	Body: <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
							soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
					  <soap:Body xmlns:m="http://webservice.document/">
						  <m:getHelloWorldAsString>
						    <arg0>Andrea</arg0>
						  </m:getHelloWorldAsString>
					  </soap:Body>
				  </soap:Envelope>
*/