package ba.biggy.global;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import ba.biggy.model.geocoding.GeocodingResponse;
import ba.biggy.model.geocoding.Geometry;
import ba.biggy.model.geocoding.Location;
import ba.biggy.model.geocoding.Result;

public class Geocoding {
	//TODO
	
	
	
	public Location getLatLng (String street, String postalCode, String place) {
		
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + street + "+" + postalCode + "+" + place + "&key=" + Constants.GOOGLE_API_KEY;
		
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse gResp = restTemplate.getForObject(url, GeocodingResponse.class);
		
		List<Result> results = gResp.getResults();
		Result result = results.get(0);
		Geometry geometry = result.getGeometry();
		Location location = geometry.getLocation();
		
		return location;
		
	}
	

}
