package ba.biggy.model.geocoding;

public class Location {
	
	public Double lat;
	public Double lng;
	
	
	public Location () {
		
	}
	
	public Location (Double lat, Double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	

}
