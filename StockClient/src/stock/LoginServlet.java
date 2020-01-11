package stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;



@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	static final String REST_URI = "http://localhost:9443/StockSample/rest/loginservices/checkuservalidity";
	static final String CHECK_USER = "/loginservice/checkUser/";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		JSONObject loginform = new JSONObject();
		loginform.put("username", request.getParameter("userName"));
		loginform.put("password", request.getParameter("password"));
		System.out.println(loginform);
		String proto = "http://";
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse clientResponse = service.
				type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).
				post(ClientResponse.class, loginform.toString());
		if (clientResponse.getStatus() != 200) {
			System.out.println(clientResponse.getEntity(String.class));
			response.sendRedirect("login.jsp");
		}else {
			System.out.println(clientResponse.getEntity(String.class));
//			response.sendRedirect("displaystock.jsp");
			request.setAttribute("username", request.getParameter("userName"));
			request.setAttribute("password", request.getParameter("password"));
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
 
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
	
}