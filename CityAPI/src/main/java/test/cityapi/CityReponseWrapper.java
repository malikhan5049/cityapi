package test.cityapi;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CityReponseWrapper {
	@JsonProperty("_id")
	private String id;
	private String name;
	private String type;
	@JsonProperty("geo_position")
	private Map<String, String> geoPosition;;
	private String latitude;
	private String longitude;
	
	
	public Map<String, String> getGeoPosition() {
		return geoPosition;
	}
	public void setGeoPosition(Map<String, String> geoPosition) {
		this.geoPosition = geoPosition;
		if(geoPosition!=null){
			latitude = geoPosition.get("latitude");
			longitude = geoPosition.get("longitude");
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "CityReponseWrapper [id=" + id + ", name=" + name + ", type=" + type + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
	
	
}
