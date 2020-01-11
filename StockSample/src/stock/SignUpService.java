package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/signUpServices")
public class SignUpService {
	@Path("/signUpUser")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
    public Response isValidUser(String jon) {
		System.out.println("inside signup");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String SSN = json.get("SSN").toString();
		String username = json.get("Username").toString();
		String address = json.get("Address").toString();
		String email = json.get("Email").toString();
		String password = json.get("Password").toString();
		//Create database connection and execute 'insert'
		try {
				DBConnection conn = DBConnection.getInstance();
				PreparedStatement preparedStatement = null; 				
				String query=" insert into useraccount (SSN, Username, Password, EmailID, Address) "
						+ " values (?,?,?,?,?)";
				
				Connection connection = conn.executePrepareStatement(query);
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, SSN);
				preparedStatement.setString(2, username);
				preparedStatement.setString(3, password);
				preparedStatement.setString(4, email);
				preparedStatement.setString(5, address);
				System.out.println(query);
				int rs = preparedStatement.executeUpdate(); 
				if(rs==1){
					return Response.status(200).entity("Done").build();
				} 
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("exception"+e.getMessage());
			// TODO: handle exception
		}
		return Response.status(400).entity("failed").build();
		
		
		//
		/*
		if(userName.compareTo("admin")==0 && password.compareTo("admin")==0) {
			return Response.status(200).entity("Done").build();
		}else {
			return Response.status(400).entity("Not Done").build();
		}
		*/
	}
}
