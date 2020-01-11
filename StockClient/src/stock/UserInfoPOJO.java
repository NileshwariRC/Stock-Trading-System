package stock;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserInfoPOJO {
	private String username;
	private String password;
	private String ssn;
	private String address;
	private String emailid;
	
	public UserInfoPOJO(String username, String password, String ssn, String address, String emailid){
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
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
	
}
