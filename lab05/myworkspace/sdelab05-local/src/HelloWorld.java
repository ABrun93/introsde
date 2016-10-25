import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(name = "/HelloWorld", urlPatterns = "/salutation/*")
public class HelloWorld extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	private static enum Languages 
	{   italian("it", "Ciao Mondo!"),
        english("en", "Hello World!"),
        spanish("es", "Hola Mundo!");
		
		private String language, greeting;
		
		private Languages(String language, String greeting)
		{
			this.language = language;
			this.greeting = greeting;
		}
		
		public String getLanguage()
		{
			return language;
		}
		
		public String getGreeting()
		{
			return greeting;
		}
    };
	
    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.print("Request path: ");
		String pathInfo = request.getPathInfo();
		System.out.print(pathInfo + "\n");
		
		String language = pathInfo.replace("/", "");
		System.out.println("Language request: " + language);
		
		System.out.print("Request format: ");
		String formatParam = request.getParameter("format");
		System.out.print(formatParam + "\n");
				
		
		if ("json".equals(formatParam)) 
		{
			try 
			{
				jsonReply(response, language);
			} 
			catch (JSONException e) 
			{
				e.printStackTrace();
				try 
				{
					errorReply(response, e, new Error("JSON Exception"));
				} 
				catch (JSONException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} 
		else
		{
			if ("csv".equals(formatParam)) 
			{
				csvReply(response, language);
			} 
			else
			{
				if ("xml".equals(formatParam)) 
				{
					try 
					{
						xmlReply(response, language);
					} 
					catch (TransformerFactoryConfigurationError e) 
					{
						try 
						{
							errorReply(response, null, e);
						} 
						catch (JSONException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						e.printStackTrace();
					} 
					catch (ParserConfigurationException e) 
					{
						try 
						{
							errorReply(response, e, null);
						} 
						catch (JSONException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						e.printStackTrace();
					} 
					catch (TransformerException e) 
					{
						try 
						{
							errorReply(response, e, null);
						} 
						catch (JSONException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						e.printStackTrace();
					}
				}
				else 
				{
					htmlReply(response, language);
				}
			}
		}	
	}

	private void htmlReply(HttpServletResponse response, String language) throws IOException 
	{
		Boolean flag = false;
		
		System.out.println("Preparing HTML reply...");
		String html = "<html><head><title>Hello World</title></head><body><ol>";
				
		for(Languages lang : Languages.values())
		{
			if(lang.getLanguage().equals(language))
			{
				html = html + "<li>" + lang.getGreeting() + "</li>";
				flag = true;
				break;
			}
		}
		
		if(!flag)
		{
			html = html + "Possible languages: <ol>";
			
			for(Languages lang : Languages.values())
			{
				html = html + "<li>" + lang.toString() + "</li>";
			}
			
			html = html + "</ol>";
		}
		
		html = html + "</ol></body></html>";
		
		response.setContentType("text/html");
		response.getWriter().write(html);
		
		System.out.println("--> " + html);
	}

	private void xmlReply(HttpServletResponse response, String language) throws TransformerFactoryConfigurationError, ParserConfigurationException, TransformerException, IOException 
	{
		Boolean flag = false;
		
		System.out.println("Preparing XML reply...");
		response.setContentType("text/xml");
		
		// Creating a new instance of a DOM to build a DOM tree
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element root = doc.createElement("regards");
		doc.appendChild(root);
	
		
		
		for(Languages lang : Languages.values())
		{
			if(lang.getLanguage().equals(language))
			{
				Element salutation = doc.createElement("salutation");
				
				Element state = doc.createElement("language");
				state.setTextContent(lang.getLanguage());
				salutation.appendChild(state);
				
				Element greeting = doc.createElement("greeting");
				greeting.setTextContent(lang.getGreeting());
				salutation.appendChild(greeting);
				
				root.appendChild(salutation);
				
				flag = true;
				break;
			}
		}
		
		if(!flag)
		{
			for(Languages lang : Languages.values())
			{	
				Element salutation = doc.createElement("salutation");
				
				Element state = doc.createElement("language");
				state.setTextContent(lang.getLanguage());
				salutation.appendChild(state);
				
				Element greeting = doc.createElement("greeting");
				greeting.setTextContent(lang.getGreeting());
				salutation.appendChild(greeting);
				
				root.appendChild(salutation);
			}
		}
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		
		// Create string from xml tree
		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		String xmlString = sw.toString();
		
		response.getWriter().write(xmlString);
		System.out.println("--> " + xmlString);
	}
	
	private void csvReply(HttpServletResponse response, String language) throws IOException 
	{
		Boolean flag = false;
		
		System.out.println("Preparing CSV reply...");
		response.setContentType("text/csv");
		
		String output = "Regards,Salutation\r\n";
		
		for(Languages lang : Languages.values())
		{
			if(lang.getLanguage().equals(language))
			{
				output = output + lang.getLanguage() + "," + lang.getGreeting() + "\r\n";
				flag = true;
				break;
			}
		}
		
		if(!flag)
		{		
			for(Languages lang : Languages.values())
			{
				output = output + lang.getLanguage() + "," + lang.getGreeting() + "\r\n";
			}
		}
		
		getServletContext().log(output);
				
		response.getWriter().write(output);
		System.out.println("--> " + output);
	}
	
	private void jsonReply(HttpServletResponse response, String language) throws IOException, JSONException 
	{
		Boolean flag = false;
		
		System.out.println("Preparing JSON reply...");
		response.setContentType("text/json");
		
		JSONObject obj = new JSONObject();
		obj.put("Regards", "Salutation");
		JSONArray jsonGreetings = new JSONArray();
				
		for(Languages lang : Languages.values())
		{
			if(lang.getLanguage().equals(language))
			{
				jsonGreetings.put(lang.getGreeting());
				flag = true;
				break;
			}
		}
		
		if(!flag)
		{		
			for(Languages lang : Languages.values())
			{
				jsonGreetings.put(lang.getGreeting());
			}
		}
		
		obj.put("Salutation",jsonGreetings);
		
		response.getWriter().write(obj.toString());
		System.out.println("--> "+obj.toString());
	}
	
	private void errorReply(HttpServletResponse response, Exception e, Error err) throws IOException, JSONException 
	{
		String errorMsg = err == null ? e.getMessage() : err.getMessage();
		response.sendError(500, errorMsg);;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
