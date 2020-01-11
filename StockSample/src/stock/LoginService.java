package stock;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;

/**
* @author Anjali
*/
 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
@Path("/loginservices")
public class LoginService {
		@Path("/checkuservalidity")
		@POST
		@Consumes(MediaType.TEXT_PLAIN)
		@Produces(MediaType.TEXT_PLAIN)
	    public Response isValidUser(String jon) {
			System.out.println("inside");
			JSONParser parser = new JSONParser();
			JSONObject json = new JSONObject();
			
			try {
				json = (JSONObject) parser.parse(jon);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String userName = json.get("username").toString();
			String password = json.get("password").toString();
			
			
			try {
				DBConnection conn = DBConnection.getInstance();
				PreparedStatement preparedStatement = null; 				
				String query="select * from useraccount where Username = ? and Password = ?";
				
				Connection connection = conn.executePrepareStatement(query);
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println(query);
				if(resultSet != null) {
					return Response.status(200).entity("Done").build();
				}
				else {
					return Response.status(400).entity("Not Done").build();
				}
			}catch (Exception e) {
				System.out.println(e);
				System.out.println("exception"+e.getMessage());
			}
			return Response.status(400).entity("Not Done").build();
//			if(userName.compareTo("admin")==0 && password.compareTo("admin")==0) {
//				return Response.status(200).entity("Done").build();
//			}else {
//				return Response.status(400).entity("Not Done").build();
//			}
		}
}
