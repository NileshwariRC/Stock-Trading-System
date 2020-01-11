package stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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



@WebServlet(urlPatterns = "/currentStock")
public class StockCurrentServlet extends HttpServlet {
	static final String REST_URI = "http://localhost:9443/StockSample/rest/";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		JSONObject tickerform = new JSONObject();
		String tickerSymbol=request.getParameter("tickerSymbol");
		String requestedData=request.getParameter("requestedData");
		tickerform.put("tickersymbol", tickerSymbol);
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		List<StockEntity> stockList=new ArrayList<StockEntity>();
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		String methodPath="";
		if(requestedData.compareTo("today")==0) {
			methodPath="getallcurrentstock";
		}else if(requestedData.compareTo("curweek")==0) {
			methodPath="getcurrentweekstockdata";
		}else if(requestedData.compareTo("pastweek")==0) {
			methodPath="getpastweekstockdata";
		}else if(requestedData.compareTo("month")==0) {
			methodPath="getmonthstockdata";
		}else if(requestedData.compareTo("curryear")==0) {
			methodPath="getyearstockdata";
		}else if(requestedData.compareTo("pastyear")==0) {
			methodPath="getpastfiveyearstockdata";
		}
		System.out.println("method"+methodPath);
		ClientResponse cresponse= service.path("stockdetailsservice").path(methodPath).accept(MediaType.TEXT_PLAIN)
				.post(ClientResponse.class,tickerform.toString());
		if (cresponse.getStatus() != 200) {
			System.out.println(cresponse.getStatus());
//			response.sendRedirect("login.jsp");
		}else {
//			System.out.println(cresponse.getEntity(String.class));
			String jsonstring = cresponse.getEntity(String.class);
			Object object=null;
			JSONParser jsonParser=new JSONParser();
			System.out.println("currentstockdata"+jsonstring);
			try {
				object=jsonParser.parse(jsonstring);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray arrayObj=null;
			arrayObj=(JSONArray)object;
			System.out.println("arrayObj"+arrayObj);
			Iterator i = arrayObj.iterator();
			while(i.hasNext())
			{
				StockEntity stockEntity=new StockEntity();
				JSONObject jon=(JSONObject)i.next();
				stockEntity.setTickerSymbol(tickerSymbol);
				stockEntity.setDate(jon.get("date").toString());
				stockEntity.setClose(jon.get("close").toString());
				stockEntity.setOpen(jon.get("open").toString());
				stockEntity.setHigh(jon.get("high").toString());
				stockEntity.setLow(jon.get("low").toString());
				stockList.add(stockEntity);
			}
			
			
//			response.sendRedirect("userProfile.jsp");
		}
		
//		if (c.getStatus() != 200) {
//		System.out.println(c.getStatus());
// 
//			}
//		else
//		{ 
//			GenericType<List<StockEntity>> genericType = new GenericType<List<StockEntity>>(){};
//		List<StockEntity> stockList = c.getEntity(genericType);
			
//			ArrayList<StockEntity> stockList = c.getEntity(ArrayList.class);
		
		System.out.println("servletstock"+stockList);
		
		request.setAttribute("stockList", stockList);
		
//		}
	
		
		
		request.getRequestDispatcher("/displaycurrentstock.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		JSONObject loginform = new JSONObject();
		System.out.println(loginform);
		String proto = "http://";
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ArrayList<StockEntity> stockList = service.path("stockdetailsservice").path("getallstockdetails").type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).get(ArrayList.class);
//		if (clientResponse.getStatus() != 200) {
//			System.out.println(clientResponse.getEntity(String.class));
//			response.sendRedirect("login.jsp");
//		}else {
//			System.out.println(clientResponse.getEntity(String.class));
//			response.sendRedirect("userProfile.jsp");
//		}
		System.out.println("servletstock"+stockList);
		
		request.setAttribute("stockList", stockList);
		
	
	}

	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
 
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}
	
}