package stock.Entities;

import java.sql.Date;

public class StockEntity {
	
private String tickerSymbol;
private String price;
private String companyName;
private String sector;
private String marketcap;
private String ipoyear;
private String date;
private String volume;
private String high;
private String low;
private String close;
private String open;



public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
public String getMarketcap() {
	return marketcap;
}
public void setMarketcap(String marketcap) {
	this.marketcap = marketcap;
}
public String getIpoyear() {
	return ipoyear;
}
public void setIpoyear(String ipoyear) {
	this.ipoyear = ipoyear;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getVolume() {
	return volume;
}
public void setVolume(String volume) {
	this.volume = volume;
}
public String getHigh() {
	return high;
}
public void setHigh(String high) {
	this.high = high;
}
public String getLow() {
	return low;
}
public void setLow(String low) {
	this.low = low;
}
public String getClose() {
	return close;
}
public void setClose(String close) {
	this.close = close;
}
public String getOpen() {
	return open;
}
public void setOpen(String open) {
	this.open = open;
}
public String getTickerSymbol() {
	return tickerSymbol;
}
public void setTickerSymbol(String tickerSymbol) {
	this.tickerSymbol = tickerSymbol;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

}
