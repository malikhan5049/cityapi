package test.cityapi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@SuppressWarnings("unchecked")
public class CityApiApplication {

	private static final String URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(CityApiApplication.class);
	
	public static void main(String[] args) {
		String cityName = args[0];
		if(cityName==null || cityName == "") return;
		RestTemplate restTemplae = new RestTemplate();
		ResponseEntity<CityReponseWrapper[]> response = restTemplae.getForEntity(URL+cityName,CityReponseWrapper[].class);
		if(HttpStatus.OK == response.getStatusCode()){
			try {
				if(response.getBody().length!=0)
					writeToCSV(response.getBody());
			} catch (IOException e) {
				log.error("error occured while writing to csv file",e);
			}
		}
	}
	private static void writeToCSV(CityReponseWrapper[] body) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter("cities.csv"));
		writer.writeNext(new String[]{"ID", "Name", "Type","Longitude","Latitude"});
		for(CityReponseWrapper e:body)
			writer.writeNext(new String[]{e.getId(), e.getName(), e.getType(), e.getLongitude(), e.getLatitude()});
		writer.flush();
		writer.close();
		
	}
}
