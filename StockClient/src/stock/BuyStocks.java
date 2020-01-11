package stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericEntity;

import org.apache.commons.collections4.CollectionUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import stock.Entities.StockEntity;



@WebServlet(urlPatterns = "/buyStocks")
public class BuyStocks extends HttpServlet {
	
	
	
	static final String REST_URI = "http://localhost:9443/StockSample/rest/";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<String> selectedStockValuesList=new ArrayList<String>();
//		String stockList=request.getParameter("stockList");
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
		JSONObject profileInfoForm = new JSONObject();
		profileInfoForm.put("Username", request.getParameter("username"));
		profileInfoForm.put("Password", request.getParameter("password"));
		System.out.println("Inside showprofile");
		System.out.println(profileInfoForm);
		String proto = "http://";
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		System.out.println("Inside user profile");
		ClientResponse clientResponse = service.path("UserProfileServices").path("showUserProfile").
				type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).
				post(ClientResponse.class, profileInfoForm.toString());
		System.out.println("status: " + clientResponse.getStatus());
		if (clientResponse.getStatus() != 200) {
			System.out.println(clientResponse.getEntity(String.class));
			System.out.println("failure");
			//response.sendRedirect("signup.html");
		}
		else {
			
			JSONParser parser = new JSONParser();
			JSONObject json = new JSONObject();
			
			try {
				json = (JSONObject) parser.parse(clientResponse.getEntity(String.class));
				System.out.println(json);
				request.setAttribute("username", json.get("username"));
				request.setAttribute("password",json.get("password"));
				request.setAttribute("address",json.get("address"));
				request.setAttribute("ssn",json.get("ssn"));
				request.setAttribute("emailid",json.get("emailid"));
				request.setAttribute("tickerid", json.get("tickerid"));
				request.setAttribute("scheduletype", json.get("scheduletype"));
				request.setAttribute("tickerid", json.get("tickerid"));
				request.setAttribute("username", request.getParameter("userName"));
				request.setAttribute("password", request.getParameter("password"));
				request.getRequestDispatcher("/displayUserProfileInfo.jsp").forward(request, response);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			/*
			//UserInfoPOJO userInfo = new UserInfoPOJO();
			System.out.println(clientResponse.getEntity(UserInfoPOJO.class));
			UserInfoPOJO userdata = clientResponse.getEntity(UserInfoPOJO.class);
			System.out.println(userdata.getAddress());
			//userInfo.setAddress(clientResponse.get);
			//request.getRequestDispatcher("/WEB-INF/displayUserProfileInfo.jsp").forward(request, response);
			System.out.println("success user profile");
			/* Write code to send fetched json data to html here
			 * response.getWriter().write(jArray.toString());
			 */
			//response.sendRedirect("profileInfo.html");*/
		}
		
		
		
		
		
        request.getRequestDispatcher("/buyselection.jsp").forward(request, response);
		
	}

	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
 
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
	
}