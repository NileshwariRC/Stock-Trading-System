package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

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

@Path("/ForgotPwdServices")
public class ForgotPwdService {
	@Path("/updatepwd")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
    public Response updatepwd(String jon) {
		System.out.println("inside updatepwd");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ssn = json.get("SSN").toString();
		String username = json.get("Username").toString();
		String password = json.get("Password").toString();
		//Create database connection and execute 'select'
		try {
			DBConnection conn = DBConnection.getInstance();
			PreparedStatement preparedStatement = null; 
			String query = "select Username from useraccount where SSN = ? ";
			Connection connection = conn.executePrepareStatement(query);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, ssn);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String uname = resultSet.getString("Username");
			System.out.println(query);
			System.out.println("username: " + uname);
			if(uname.length() > 0) {
				query=" update useraccount SET Password = ?, Username = ? WHERE SSN = ?";
				
				connection = conn.executePrepareStatement(query);
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, password);
				preparedStatement.setString(2, username);
				preparedStatement.setString(3, ssn);
				System.out.println(query);
				System.out.println("update pwd query: " + query);
				int rs = preparedStatement.executeUpdate(); 
				if(rs==1){
					return Response.status(200).entity("Done").build();
				} 
			}else {
				return Response.status(400).entity("failed").build();
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
