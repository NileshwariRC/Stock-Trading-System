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

@Path("/transferMoneyServices")
public class TransferMoneyService {
	@Path("/transferMoney")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
    public Response showUserProfile(String jon) {
		System.out.println("inside transferMoney");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		
		try {
			json = (JSONObject) parser.parse(jon);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String username = json.get("Username").toString();
		String password = json.get("Password").toString();
		String FromAccountNo = json.get("FromAccountNo").toString();
		String ToAccNo = json.get("ToAccNo").toString();
		String amount = json.get("Amount").toString();
		//Create database connection and execute 'select'
		
		double fromacc = Double. parseDouble(FromAccountNo);
		double toacc = Double. parseDouble(ToAccNo);
		double transferAmount = Double.parseDouble(amount);
		
		try {
				DBConnection conn = DBConnection.getInstance();
				PreparedStatement preparedStatement = null; 
				//task 1: fetch current amount
				//task 2: update 'current amount' - entered amount 'amount' in db for this user
				
				String query="select CurrentBalance from userBankAccounts where AccountNumber = ? and userSSN in (select SSN from useraccount where username= ? and Password= ?)";
				
				Connection connection = conn.executePrepareStatement(query);
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setDouble(1, fromacc);
				preparedStatement.setString(2, username);
				preparedStatement.setString(3, password);
				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println(query);
				
				JSONObject jsonobject = null;
				JSONArray jArray = new JSONArray();
				if(resultSet != null) {
					resultSet.next();
					double currBalance = resultSet.getDouble("CurrentBalance");
					if(currBalance > transferAmount) {
						double updatedBalance = currBalance - transferAmount;
						conn = DBConnection.getInstance();
						preparedStatement = null;
						query="update userBankAccounts set CurrentBalance = ? where AccountNumber = ? and userSSN in (select SSN from useraccount where username= ? and Password= ?)";
						
						connection = conn.executePrepareStatement(query);
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setDouble(1, updatedBalance);
						preparedStatement.setDouble(2, fromacc);
						preparedStatement.setString(3, username);
						preparedStatement.setString(4, password);
						int count = preparedStatement.executeUpdate();
						System.out.println(query);
						if(count > 0) {
							return Response.status(200).entity("success").build();
						}
					}else {
						return Response.status(400).entity("failed").build();
					}
					return Response.status(200).entity(jArray).build();
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
