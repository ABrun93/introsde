package document.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import document.webservice.HelloWorldInterface;

public class HelloWorldClient{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:6901/ws/hello?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://webservice.document/", "HelloWorldImplementationService");
        Service service = Service.create(url, qname);
        HelloWorldInterface hello = service.getPort(HelloWorldInterface.class);
        System.out.println(hello.getHelloWorldAsString("Andrea"));
    }
}