package stock;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.data.StockData;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside");
		   String apiKey = "B97QTHQR90WWXF8L";
		    int timeout = 3000;
		    AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		    JSONArray jsonArray=new JSONArray();
		    TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
//		    JSONArray jsonArray=new JSONArray();
		    try {
		    	
		      Daily response = stockTimeSeries.daily("MSFT", OutputSize.COMPACT);
		      Map<String, String> metaData = response.getMetaData();
		      System.out.println("Information: " + metaData.get("1. Information"));
		      System.out.println("Stock: " + metaData.get("2. Symbol"));
		      
		      List<StockData> stockData = response.getStockData();
		      System.out.println(stockData);
		      for(int i=0;i<30;i++) {
		    	  JSONObject jsonObject=new JSONObject();
		    	  if(LocalDate.now().getYear()==stockData.get(i).getDateTime().toLocalDate().getYear()) {
			        System.out.println("date:   " + stockData.get(i).getDateTime());
			        System.out.println("date diff:" + (LocalDate.of(2019, 11, 27).getDayOfWeek().getValue()-stockData.get(i).getDateTime().toLocalDate().getDayOfWeek().getValue()));
			        System.out.println( LocalDate.now().minusDays(5));
			        System.out.println(stockData.get(i).getDateTime().toLocalDate().getDayOfWeek().getValue());
			        System.out.println("open:   " + stockData.get(i).getOpen());
			        System.out.println("high:   " + stockData.get(i).getHigh());
			        System.out.println("low:    " + stockData.get(i).getLow());
			        System.out.println("close:  " + stockData.get(i).getClose());
			        System.out.println("volume: " + stockData.get(i).getVolume());
			        jsonObject.put("date", stockData.get(i).getDateTime().toString());
					jsonObject.put("open", stockData.get(i).getOpen());
					jsonObject.put("high",stockData.get(i).getHigh());
					jsonObject.put("low", stockData.get(i).getLow());
					jsonObject.put("close", stockData.get(i).getClose());
					jsonObject.put("volume", stockData.get(i).getVolume());
					jsonArray.add(jsonObject);
		    	  }
		      }
		    } catch (AlphaVantageException e) {
		      System.out.println("something went wrong");
		    }
}}