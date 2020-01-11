package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.Monthly;
import org.patriques.output.timeseries.data.StockData;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Path("/timeseriesdata")
public class TimeSeriesData {

	@Path("/getallstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllStockDetails(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(jon);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("ticker web2" + tickersymbol);
		String apiKey = "B97QTHQR90WWXF8L";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		JSONArray jsonArray = new JSONArray();
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
//		    JSONArray jsonArray=new JSONArray();
		try {
			IntraDay response = stockTimeSeries.intraDay(tickersymbol, Interval.ONE_MIN, OutputSize.COMPACT);
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			System.out.println(stockData);
			for (int i = 0; i < stockData.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				System.out.println("Debug message");
				System.out.println("date:   " + stockData.get(i).getDateTime());
				System.out.println("open:   " + stockData.get(i).getOpen());
				System.out.println("high:   " + stockData.get(i).getHigh());
				System.out.println("low:    " + stockData.get(i).getLow());
				System.out.println("close:  " + stockData.get(i).getClose());
				System.out.println("volume: " + stockData.get(i).getVolume());
				jsonObject.put("date", stockData.get(i).getDateTime().toString());
				jsonObject.put("open", stockData.get(i).getOpen());
				jsonObject.put("high", stockData.get(i).getHigh());
				jsonObject.put("low", stockData.get(i).getLow());
				jsonObject.put("close", stockData.get(i).getClose());
				jsonObject.put("volume", stockData.get(i).getVolume());
				jsonArray.add(jsonObject);
			}
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
//
//
//
//		return Response.ok().entity(jsonArray.toString()).build();
//
		return Response.ok().entity(jsonArray.toString()).build();

	}

	@Path("/getcurrentweekstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCurrentWeekStock(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(jon);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("ticker web2" + tickersymbol);
		String apiKey = "B97QTHQR90WWXF8L";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		JSONArray jsonArray = new JSONArray();
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
//		    JSONArray jsonArray=new JSONArray();
		try {

			Daily response = stockTimeSeries.daily(tickersymbol, OutputSize.COMPACT);
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			System.out.println(stockData);
			for (int i = 0; i < 7; i++) {
				JSONObject jsonObject = new JSONObject();
				if ((LocalDate.now().toEpochDay() - stockData.get(i).getDateTime().toLocalDate().toEpochDay()) < 5) {
					System.out.println("date:   " + stockData.get(i).getDateTime());
					System.out.println("date diff:" + (LocalDate.now().toEpochDay()
							- stockData.get(i).getDateTime().toLocalDate().toEpochDay()));
					System.out.println("open:   " + stockData.get(i).getOpen());
					System.out.println("high:   " + stockData.get(i).getHigh());
					System.out.println("low:    " + stockData.get(i).getLow());
					System.out.println("close:  " + stockData.get(i).getClose());
					System.out.println("volume: " + stockData.get(i).getVolume());
					jsonObject.put("date", stockData.get(i).getDateTime().toString());
					jsonObject.put("open", stockData.get(i).getOpen());
					jsonObject.put("high", stockData.get(i).getHigh());
					jsonObject.put("low", stockData.get(i).getLow());
					jsonObject.put("close", stockData.get(i).getClose());
					jsonObject.put("volume", stockData.get(i).getVolume());
					jsonArray.add(jsonObject);
				}
			}
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return Response.ok().entity(jsonArray.toString()).build();
	}

	@Path("/getpastweekstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPastWeekStock(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(jon);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("ticker web2" + tickersymbol);
		String apiKey = "B97QTHQR90WWXF8L";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		JSONArray jsonArray = new JSONArray();
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
//		    JSONArray jsonArray=new JSONArray();
		try {

			Daily response = stockTimeSeries.daily(tickersymbol, OutputSize.COMPACT);
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			System.out.println(stockData);
			for (int i = 0; i < 15; i++) {
				JSONObject jsonObject = new JSONObject();
				if ((LocalDate.now().toEpochDay() - stockData.get(i).getDateTime().toLocalDate().toEpochDay()) > 5
						&& (LocalDate.now().toEpochDay()
								- stockData.get(i).getDateTime().toLocalDate().toEpochDay()) < 12) {
					System.out.println("date:   " + stockData.get(i).getDateTime());
					System.out.println("date diff:" + (LocalDate.now().toEpochDay()
							- stockData.get(i).getDateTime().toLocalDate().toEpochDay()));
					System.out.println("open:   " + stockData.get(i).getOpen());
					System.out.println("high:   " + stockData.get(i).getHigh());
					System.out.println("low:    " + stockData.get(i).getLow());
					System.out.println("close:  " + stockData.get(i).getClose());
					System.out.println("volume: " + stockData.get(i).getVolume());
					jsonObject.put("date", stockData.get(i).getDateTime().toString());
					jsonObject.put("open", stockData.get(i).getOpen());
					jsonObject.put("high", stockData.get(i).getHigh());
					jsonObject.put("low", stockData.get(i).getLow());
					jsonObject.put("close", stockData.get(i).getClose());
					jsonObject.put("volume", stockData.get(i).getVolume());
					jsonArray.add(jsonObject);
				}
			}
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return Response.ok().entity(jsonArray.toString()).build();
	}
	@Path("/getmonthstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMonthStock(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(jon);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("ticker web2" + tickersymbol);
		String apiKey = "B97QTHQR90WWXF8L";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		JSONArray jsonArray = new JSONArray();
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
//		    JSONArray jsonArray=new JSONArray();
		try {

			Daily response = stockTimeSeries.daily(tickersymbol, OutputSize.COMPACT);
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			System.out.println(stockData);
			for (int i = 0; i < 15; i++) {
				JSONObject jsonObject = new JSONObject();
				if (LocalDate.now().getMonthValue()==stockData.get(i).getDateTime().toLocalDate().getMonthValue()) {
					System.out.println("date:   " + stockData.get(i).getDateTime());
					System.out.println("date diff:" + (LocalDate.now().toEpochDay()
							- stockData.get(i).getDateTime().toLocalDate().toEpochDay()));
					System.out.println("open:   " + stockData.get(i).getOpen());
					System.out.println("high:   " + stockData.get(i).getHigh());
					System.out.println("low:    " + stockData.get(i).getLow());
					System.out.println("close:  " + stockData.get(i).getClose());
					System.out.println("volume: " + stockData.get(i).getVolume());
					jsonObject.put("date", stockData.get(i).getDateTime().toString());
					jsonObject.put("open", stockData.get(i).getOpen());
					jsonObject.put("high", stockData.get(i).getHigh());
					jsonObject.put("low", stockData.get(i).getLow());
					jsonObject.put("close", stockData.get(i).getClose());
					jsonObject.put("volume", stockData.get(i).getVolume());
					jsonArray.add(jsonObject);
				}
			}
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return Response.ok().entity(jsonArray.toString()).build();
	}

	@Path("/getyearstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getYearStock(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(jon);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("ticker web2" + tickersymbol);
		String apiKey = "B97QTHQR90WWXF8L";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		JSONArray jsonArray = new JSONArray();
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
//		    JSONArray jsonArray=new JSONArray();
		try {

			Monthly response = stockTimeSeries.monthly(tickersymbol);
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			System.out.println(stockData);
			for (int i = 0; i < stockData.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				if (LocalDate.now().getYear()==stockData.get(i).getDateTime().toLocalDate().getYear()) {
					System.out.println("date:   " + stockData.get(i).getDateTime());
					System.out.println("date diff:" + (LocalDate.now().toEpochDay()
							- stockData.get(i).getDateTime().toLocalDate().toEpochDay()));
					System.out.println("open:   " + stockData.get(i).getOpen());
					System.out.println("high:   " + stockData.get(i).getHigh());
					System.out.println("low:    " + stockData.get(i).getLow());
					System.out.println("close:  " + stockData.get(i).getClose());
					System.out.println("volume: " + stockData.get(i).getVolume());
					jsonObject.put("date", stockData.get(i).getDateTime().toString());
					jsonObject.put("open", stockData.get(i).getOpen());
					jsonObject.put("high", stockData.get(i).getHigh());
					jsonObject.put("low", stockData.get(i).getLow());
					jsonObject.put("close", stockData.get(i).getClose());
					jsonObject.put("volume", stockData.get(i).getVolume());
					jsonArray.add(jsonObject);
				}
			}
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return Response.ok().entity(jsonArray.toString()).build();
	}
	@Path("/getpastfiveyearstockdata")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPastFiveYearStock(String jon) {
		System.out.println("inside");
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(jon);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tickersymbol = json.get("tickersymbol").toString();
		System.out.println("ticker web2" + tickersymbol);
		String apiKey = "B97QTHQR90WWXF8L";
		int timeout = 3000;
		AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		JSONArray jsonArray = new JSONArray();
		TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
//		    JSONArray jsonArray=new JSONArray();
		try {

			Monthly response = stockTimeSeries.monthly(tickersymbol);
			Map<String, String> metaData = response.getMetaData();
			System.out.println("Information: " + metaData.get("1. Information"));
			System.out.println("Stock: " + metaData.get("2. Symbol"));

			List<StockData> stockData = response.getStockData();
			System.out.println(stockData);
			for (int i = 0; i < stockData.size() ; i++) {
				JSONObject jsonObject = new JSONObject();
//				if (stockData.get(i).getDateTime().toLocalDate().getYear()+5<=LocalDate.now().getYear()) {
					System.out.println("date:   " + stockData.get(i).getDateTime());
					System.out.println("date diff:" + (LocalDate.now().toEpochDay()
							- stockData.get(i).getDateTime().toLocalDate().toEpochDay()));
					System.out.println("open:   " + stockData.get(i).getOpen());
					System.out.println("high:   " + stockData.get(i).getHigh());
					System.out.println("low:    " + stockData.get(i).getLow());
					System.out.println("close:  " + stockData.get(i).getClose());
					System.out.println("volume: " + stockData.get(i).getVolume());
					jsonObject.put("date", stockData.get(i).getDateTime().toString());
					jsonObject.put("open", stockData.get(i).getOpen());
					jsonObject.put("high", stockData.get(i).getHigh());
					jsonObject.put("low", stockData.get(i).getLow());
					jsonObject.put("close", stockData.get(i).getClose());
					jsonObject.put("volume", stockData.get(i).getVolume());
					jsonArray.add(jsonObject);
				}
//			}
		} catch (AlphaVantageException e) {
			System.out.println("something went wrong");
		}
		return Response.ok().entity(jsonArray.toString()).build();
	}

}
