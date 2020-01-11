package stock;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


 
@Path("/addBankAccountsServices")
public class AddBankAccountService {
		@Path("/addBankAccountsServiceMethod")
		@POST
		@Consumes(MediaType.TEXT_PLAIN)
		@Produces(MediaType.TEXT_PLAIN)
	    public Response addBankAccountDetails(String jon) {
			System.out.println("inside");
			JSONParser parser = new JSONParser();
			JSONObject json = new JSONObject();
			
			try {
				json = (JSONObject) parser.parse(jon);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ssn = json.get("ssn").toString();
			String bankAccountNumber = json.get("bankAccountNumber").toString();
			String bankRoutingNumber = json.get("bankRoutingNumber").toString();
			int rs = 0;
			Connection connection=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 connection = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/stock","root","mysql100");
				 PreparedStatement preparedStatement = null;
					String query=" insert into userBankAccounts (userSSN, AccountNumber, RoutingNumber) "
							+ " values (?,?,?)";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, ssn);
					preparedStatement.setString(2, bankAccountNumber);
					preparedStatement.setString(3,bankRoutingNumber );
					 rs = preparedStatement.executeUpdate(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

			
			if(rs==1){
				return Response.status(200).entity("Done").build();
			}
		 return Response.status(400).entity("Not Done").build();

			
			}
		}
