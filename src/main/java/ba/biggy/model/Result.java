package ba.biggy.model;

public class Result {
	
	public String formatted_address;
	public String place_id;
	private Geometry geometry;
	
	
	public String getFormattedAddress() {
		return formatted_address;
	}
	public void setFormattedAddress(String formattedAddress) {
		this.formatted_address = formattedAddress;
	}
	public String getPlaceId() {
		return place_id;
	}
	public void setPlaceId(String placeId) {
		this.place_id = placeId;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	

}
