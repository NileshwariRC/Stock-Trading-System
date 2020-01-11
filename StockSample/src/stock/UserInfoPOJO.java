package stock;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONObject;

@XmlRootElement
public class UserInfoPOJO {
	private String username;
	private String password;
	private double ssn;
	private String address;
	private String emailid;
	
	public UserInfoPOJO(String username, String password, double ssn, String address, String emailid){
		this.address = address;
		this.username = username;
		this.emailid = emailid;
		this.password = password;
		this.ssn = ssn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSsn() {
		return ssn;
	}

	public void setSsn(double ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	public String toJsonString() {
		JSONObject qsn = new JSONObject();
		qsn.put("username", this.username);
		qsn.put("address",this.address);
		qsn.put("ssn",this.ssn);
		qsn.put("password", this.password);
		qsn.put("emailid", this.emailid);
		return qsn.toString();
	}
}
