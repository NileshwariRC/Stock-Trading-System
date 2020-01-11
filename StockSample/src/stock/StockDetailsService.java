package stock;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import stock.Entities.StockEntity;

@Path("/stockdetailsservice")
public class StockDetailsService {
	static final String REST_URI = "http://localhost:7000/StockApiCalls/rest/";
	@Path("/getallstockdetails")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllStockDetails() {
		List<StockEntity> stockEntityList = new ArrayList<StockEntity>();
		JSONArray jsonArray=new JSONArray();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/stock","root","mysql100");
					Statement statement=connection.createStatement();  
					ResultSet rs=statement.executeQuery("select * from stockInfo");  
					boolean dataEmpty=true;
					while(rs.next()){  
						dataEmpty=false;
						JSONObject json=new JSONObject();
					System.out.println(rs.getString(1)+"  "+rs.getString(2)); 
					json.put("tickerSymbol", rs.getString(1));
					json.put("price", rs.getString(2));
					json.put("companyName",rs.getString(3));
					json.put("sector", rs.getString(4));
					json.put("marketcap", rs.getString(5));
					json.put("ipoyear", rs.getString(6));
					jsonArray.add(json);
					}
					
					
					
					
					
					
//					GenericEntity<List<StockEntity>> genericEntity = new GenericEntity<List<StockEntity>>(stockEntityList){};
					if(!dataEmpty) {
						return Response.ok().entity(jsonArray.toString()).build();
					}
					
					System.out.println("serviceStockdata"+stockEntityList);
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return Response.status(400).build();
		
	}
	@Path("/getallcurrentstock")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
    public Response getAllCurrentStocks(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		String jsonstring;
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("tickersymbol web1"+tickersymbol);
		JSONObject tickerform = new JSONObject();
		tickerform.put("tickersymbol", tickersymbol);
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse cresponse= service.path("timeseriesdata").path("getallstockdata").type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN)
				.post(ClientResponse.class,tickerform.toString());
		if (cresponse.getStatus() != 200) {
			System.out.println(cresponse.getStatus());
			return Response.status(400).build();
//			response.sendRedirect("login.jsp");
		}else {
//			System.out.println(cresponse.getEntity(String.class));
			 jsonstring = cresponse.getEntity(String.class);
		}
		
		
		
		return Response.ok().entity(jsonstring).build();
		
		}	
		
	//current week
	@Path("/getcurrentweekstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
    public Response getAllCurrentWeekStocks(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		String jsonstring;
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("tickersymbol web1"+tickersymbol);
		JSONObject tickerform = new JSONObject();
		tickerform.put("tickersymbol", tickersymbol);
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse cresponse= service.path("timeseriesdata").path("getcurrentweekstockdata").type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN)
				.post(ClientResponse.class,tickerform.toString());
		if (cresponse.getStatus() != 200) {
			System.out.println(cresponse.getStatus());
			return Response.status(400).build();
//			response.sendRedirect("login.jsp");
		}else {
//			System.out.println(cresponse.getEntity(String.class));
			 jsonstring = cresponse.getEntity(String.class);
		}
		
		
		
		return Response.ok().entity(jsonstring).build();
		
		}	
//past week
	@Path("/getpastweekstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
    public Response getAllPastWeekStocks(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		String jsonstring;
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("tickersymbol web1"+tickersymbol);
		JSONObject tickerform = new JSONObject();
		tickerform.put("tickersymbol", tickersymbol);
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse cresponse= service.path("timeseriesdata").path("getpastweekstockdata").type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN)
				.post(ClientResponse.class,tickerform.toString());
		if (cresponse.getStatus() != 200) {
			System.out.println(cresponse.getStatus());
			return Response.status(400).build();
//			response.sendRedirect("login.jsp");
		}else {
//			System.out.println(cresponse.getEntity(String.class));
			 jsonstring = cresponse.getEntity(String.class);
		}
		
		
		
		return Response.ok().entity(jsonstring).build();
		
		}	
//month
	
	@Path("/getmonthstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
    public Response getAllMonthStocks(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		String jsonstring;
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("tickersymbol web1"+tickersymbol);
		JSONObject tickerform = new JSONObject();
		tickerform.put("tickersymbol", tickersymbol);
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse cresponse= service.path("timeseriesdata").path("getmonthstockdata").type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN)
				.post(ClientResponse.class,tickerform.toString());
		if (cresponse.getStatus() != 200) {
			System.out.println(cresponse.getStatus());
			return Response.status(400).build();
//			response.sendRedirect("login.jsp");
		}else {
//			System.out.println(cresponse.getEntity(String.class));
			 jsonstring = cresponse.getEntity(String.class);
		}
		
		
		
		return Response.ok().entity(jsonstring).build();
		
		}	
//year
	
	@Path("/getyearstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
    public Response getAllYearStocks(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		String jsonstring;
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("tickersymbol web1"+tickersymbol);
		JSONObject tickerform = new JSONObject();
		tickerform.put("tickersymbol", tickersymbol);
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse cresponse= service.path("timeseriesdata").path("getyearstockdata").type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN)
				.post(ClientResponse.class,tickerform.toString());
		if (cresponse.getStatus() != 200) {
			System.out.println(cresponse.getStatus());
			return Response.status(400).build();
//			response.sendRedirect("login.jsp");
		}else {
//			System.out.println(cresponse.getEntity(String.class));
			 jsonstring = cresponse.getEntity(String.class);
		}
		
		
		
		return Response.ok().entity(jsonstring).build();
		
		}	

	//past 5 year
	@Path("/getpastfiveyearstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
    public Response getAllPastFiveStocks(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		String jsonstring;
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("tickersymbol web1"+tickersymbol);
		JSONObject tickerform = new JSONObject();
		tickerform.put("tickersymbol", tickersymbol);
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);	
		WebResource service = client.resource(REST_URI);
		ClientResponse cresponse= service.path("timeseriesdata").path("getpastfiveyearstockdata").type(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN)
				.post(ClientResponse.class,tickerform.toString());
		if (cresponse.getStatus() != 200) {
			System.out.println(cresponse.getStatus());
			return Response.status(400).build();
//			response.sendRedirect("login.jsp");
		}else {
//			System.out.println(cresponse.getEntity(String.class));
			 jsonstring = cresponse.getEntity(String.class);
		}
		
		
		
		return Response.ok().entity(jsonstring).build();
		
		}	

	
	
}
