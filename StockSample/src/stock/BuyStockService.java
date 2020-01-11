package stock;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


@Path("/buyServices")
public class BuyStockService {
	
	final static Logger logger = Logger.getLogger(BuyStockService.class.getName());
	
	
	@Path("/showUserProfile")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
    public Response showUserProfile(String jon) {
		System.out.println("inside showUserProfile");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 String username = json.get("Username").toString(); 
		 String password =json.get("Password").toString();
		
		
//		String username = "sneha";
//		String password = "12345";
		
		//Create database connection and execute 'select'
		try {
			
				DBConnection conn = DBConnection.getInstance();
				PreparedStatement preparedStatement = null; 				
				String query="select * from useraccount where Username = ? and Password = ?";
				
				Connection connection = conn.executePrepareStatement(query);
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println(query);
				
				double SSN ;
				if(resultSet != null) {
					resultSet.next();
					 SSN = resultSet.getDouble("SSN");
					String EmailID = resultSet.getString("EmailID");
					String Address = resultSet.getString("Address");
					System.out.println("in service class "+SSN);
					System.out.println("in service class "+EmailID);
					System.out.println("in service class "+Address);
					
				} 
//				return Response.status(200).entity(userInfo1.toJsonString()).build();
				
				//uncomment this bracket when db connection code is uncommented
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("exception"+e.getMessage());
		}
		return Response.status(400).entity("failed").build();
	}
}
