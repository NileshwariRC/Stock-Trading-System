package stock;


import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import java.io.FileWriter;
import java.io.PrintWriter;
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

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


@Path("/UserProfileServices")
public class UserProfileService {
	
	final static Logger logger = Logger.getLogger(UserProfileService.class.getName());
	
	
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
			e.printStackTrace();}
			
		
		
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
				
				String[] servers = {"localhost:11211"};
				SockIOPool pool = SockIOPool.getInstance("Test1");
				pool.setServers( servers );
				pool.setFailover( true );
				pool.setInitConn( 10 );
				pool.setMinConn( 5 );
				pool.setMaxConn( 250 );
				pool.setMaintSleep( 30 );
				pool.setNagle( false );
				pool.setSocketTO( 3000 );
				pool.setAliveCheck( true );
				pool.initialize();
				
				FileWriter myWriter = new FileWriter("C://log/log.txt");
			      
				
				if(resultSet != null) {
					resultSet.next();
					double SSN = resultSet.getDouble("SSN");
					String EmailID = resultSet.getString("EmailID");
					String Address = resultSet.getString("Address");
					System.out.println("in service class "+SSN);
					System.out.println("in service class "+EmailID);
					System.out.println("in service class "+Address);
	 
					UserInfoPOJO userInfo = new UserInfoPOJO(Address,EmailID, SSN, password, username);
					
					MemCachedClient mcc = new MemCachedClient("Test1");
					
					//DOMConfigurator.configure("log4j.xml");
					//add some value in cache
				/*
				 * logger.info("add to cache: "+mcc.add("1", SSN)); //Get value from cache
				 * logger.info("Get from Cache: "+mcc.get("1"));
				 */
					myWriter.write("Writing to cache");
					myWriter.append('\n');
					myWriter.write("Add to cache: "+mcc.add("1", SSN));
					myWriter.append('\n');
					//Get value from cache
					myWriter.write("Get from Cache: "+mcc.get("1"));
					myWriter.append('\n');


					//Use getMulti function to retrieve multiple keys values in one function
					// Its helpful in reducing network calls to 1
					mcc.set("2", EmailID);
					mcc.set("3", Address);
					String [] keys = {"1", "2","3"};
					HashMap<String,Object> hm = (HashMap<String, Object>) mcc.getMulti(keys);
				    
					for(String key : hm.keySet()){
						System.out.println("KEY: "+key+" VALUE: "+hm.get(key));
						myWriter.write("KEY: "+key+" VALUE: "+hm.get(key));
						myWriter.append('\n');
					}
					myWriter.close();
					System.out.println("Successfully wrote to the file.");
					UserInfoPOJO userInfo1 = new UserInfoPOJO(username,password,SSN,Address,EmailID);
					return Response.status(200).entity(userInfo1.toJsonString()).build();
					
					
				     
				} 
				//uncomment this bracket when db connection code is uncommented
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    
	}
		
		catch (Exception e) {
			System.out.println(e);
			System.out.println("exception"+e.getMessage());
		}
		
		return Response.status(400).entity("failed").build();
	}
}