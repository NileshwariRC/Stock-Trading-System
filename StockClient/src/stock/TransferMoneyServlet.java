package stock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@WebServlet(urlPatterns = "/transferMoney.do")
public class TransferMoneyServlet extends HttpServlet{
	static final String REST_URI = "http://localhost:9443/StockSample/rest/";
	//static final String SIGN_UP = "/signUpService/signUpUser/";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("transfermoney.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		JSONObject transferMoneyForm = new JSONObject();
		transferMoneyForm.put("Username", request.getParameter("Username"));
		transferMoneyForm.put("FromAccountNo", request.getParameter("FromAccountNo"));
		transferMoneyForm.put("ToAccNo", request.getParameter("ToAccNo"));
		transferMoneyForm.put("Password", request.getParameter("password"));
		transferMoneyForm.put("Amount", request.getParameter("amount"));
		
		System.out.println(transferMoneyForm);
		String proto = "http://";
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse clientResponse = service.path("transferMoneyServices").path("transferMoney").
				type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).
				post(ClientResponse.class, transferMoneyForm.toString());
		System.out.println("status: " + clientResponse.getStatus());
		if (clientResponse.getStatus() != 200) {
			System.out.println(clientResponse.getEntity(String.class));
			System.out.println("Please check your balance or provide correct credentials");
			//response.sendRedirect("signup.html");
		}else {
			System.out.println(clientResponse.getEntity(String.class));
			System.out.println("Amount transferred");
			request.setAttribute("message", "Amount has been transferred");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
	}

	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
 
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
}
