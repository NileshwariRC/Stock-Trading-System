package stock;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONObject;

@XmlRootElement
public class StockInfoPOJO {
	private String userssn;
	private String tickerid;
	private String scheduletype;
	private double numberofstocks;
	
	
	public StockInfoPOJO(String username, String password, double ssn, String address, String emailid,String scheduletype){
		this.userssn = username;
		this.tickerid = password;
		this.numberofstocks = ssn;
		this.scheduletype=scheduletype;
	}

	public String getScheduletype() {
		return scheduletype;
	}

	public void setScheduletype(String scheduletype) {
		this.scheduletype = scheduletype;
	}

	public String getUsername() {
		return userssn;
	}

	public void setUsername(String username) {
		this.userssn = username;
	}

	public String getPassword() {
		return tickerid;
	}

	public void setPassword(String password) {
		this.tickerid = password;
	}

	public double getSsn() {
		return numberofstocks;
	}

	public void setSsn(double ssn) {
		this.numberofstocks = ssn;
	}

	public String toJsonString() {
		JSONObject qsn = new JSONObject();
		qsn.put("username", this.userssn);
		qsn.put("ssn",this.numberofstocks);
		qsn.put("password", this.tickerid);
		qsn.put("scheduletype", this.scheduletype);
		return qsn.toString();
	}
}
