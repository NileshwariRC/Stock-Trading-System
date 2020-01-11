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



@WebServlet(urlPatterns = "/buyStock")
public class StockBuy extends HttpServlet {
	
	
	
	static final String REST_URI = "http://localhost:9443/StockSample/rest/";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<String> selectedStockValuesList=new ArrayList<String>();
		String[] values=request.getParameterValues("selectedStocks");
        System.out.println("Selected Values...");    
        for(int i=0;i<values.length;i++)
       {
        	System.out.println("<li>"+values[i]+"</li>");
        	selectedStockValuesList.add(values[i]);
       }
        request.setAttribute("selectedTickerList", selectedStockValuesList);
        request.setAttribute("date", LocalDate.now());
        System.out.println("stock buy"+request.getParameter("username"));
        request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("password", request.getParameter("password"));
        request.getRequestDispatcher("/buyselection.jsp").forward(request, response);
		
	}

	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
 
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
	
}