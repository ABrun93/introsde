import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class HealthProfileReader 
{	
	static Document doc;
	static XPath xpath; 

	public static String getName(int bound)
	{
		String res = "";
		
		System.out.println("Reading list of " + bound + " name...");
	    System.out.println("(using xpath = /people/person[position()<"+ bound +"]/firstname/text()");
	    
		try 
		{
			XPathExpression expr = xpath.compile("/people/person[position()<"+ bound +"]/firstname/text()");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
		    NodeList nodes = (NodeList) result;
		    for (int i = 0; i < nodes.getLength(); i++) 
		    {
		        res = res + nodes.item(i).getNodeValue() + "\n";
		    }
		} 
		catch (XPathExpressionException e) 
		{
			e.printStackTrace();
		}

	    return res;
	}
	
	public static String getLastName(int bound)
	{
		String res = "";
		
		System.out.println("Reading list of " + bound + " lastname...");
	    System.out.println("(using xpath = /people/person[position()<"+ bound +"]/lastname/text()");
	    
		try 
		{
			XPathExpression expr = xpath.compile("/people/person[position()<"+ bound +"]/lastname/text()");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
		    NodeList nodes = (NodeList) result;
		    for (int i = 0; i < nodes.getLength(); i++) 
		    {
		        res = res + nodes.item(i).getNodeValue() + "\n";
		    }
		} 
		catch (XPathExpressionException e) 
		{
			e.printStackTrace();
		}

	    return res;
	}
	
	public static String getHealthProfile(String name)
	{
		String res = "";
		
		System.out.println("Reading " + name + "'s health profile...");
	    System.out.println("(using xpath = /people/person[./firstname/text()=\""+ name +"\"]/healthprofile");
	    
		try 
		{
			XPathExpression expr = xpath.compile("/people/person[./firstname/text()=\""+ name +"\"]/healthprofile");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
		    NodeList nodes = (NodeList) result;
		    for (int i = 0; i < nodes.getLength(); i++) 
		    {
		        res = res + nodes.item(i).getNodeValue() + "\n";
		    }
		} 
		catch (XPathExpressionException e) 
		{
			e.printStackTrace();
		}

	    return res;
	}
	
	public static String getPeopleCond(String op, Double weight)
	{
		String res = "";
		
		System.out.println("Reading people who weight " + op + " " + weight + "...");
	    System.out.println("(using xpath = /people/person[./healthprofile/weight"+ op + weight +"]/firstname/text()");
	    
		try 
		{
			XPathExpression expr = xpath.compile("/people/person[./healthprofile/weight"+ op + weight +"]/firstname/text()");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
		    NodeList nodes = (NodeList) result;
		    for (int i = 0; i < nodes.getLength(); i++) 
		    {
		        res = res + nodes.item(i).getNodeValue() + "\n";
		    }
		} 
		catch (XPathExpressionException e) 
		{
			e.printStackTrace();
		}

	    return res;
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException,
		IOException, XPathExpressionException {
		
		String fname, weight, op;
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    System.out.println("Loading people.xml...");
	    doc = builder.parse("people.xml");

	    XPathFactory factory = XPathFactory.newInstance();
	    xpath = factory.newXPath();	    
	    
		int argCount = args.length;
		
		System.out.println(getName(10));
		System.out.println(getLastName(10));
		
		if(argCount > 0) 
		{
			fname = args[0];						
			
			System.out.println(getHealthProfile(args[0]));			
		}
		
		if(argCount == 3)
		{
			op = args[1];
			weight = args[2];
			
			System.out.println(getPeopleCond(op, Double.parseDouble(weight)));
		}
	}
}