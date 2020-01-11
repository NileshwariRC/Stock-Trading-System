package stock.Entities;

import java.sql.Date;

public class StockEntity {
	
private String tickerSymbol;
private Date releaseDate;
private String companyName;
private String employees;
private String country;

public String getTickerSymbol() {
	return tickerSymbol;
}
public void setTickerSymbol(String tickerSymbol) {
	this.tickerSymbol = tickerSymbol;
}
public Date getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getEmployees() {
	return employees;
}
public void setEmployees(String employees) {
	this.employees = employees;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

}
