package ba.biggy.global;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import ba.biggy.model.geocoding.GeocodingResponse;
import ba.biggy.model.geocoding.Geometry;
import ba.biggy.model.geocoding.Location;
import ba.biggy.model.geocoding.Result;

public class Geocoding {
	
	
	
	/** 
	 * 
	 * @param street
	 * @param postalCode
	 * @param place
	 * @return location 	Object containing lat and lng values if the result was successful, otherwise this object is null
	 */
	public Location getLatLng (String street, String postalCode, String place) {
		
		Location location = null;
		
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + street + "+" + postalCode + "+" + place + "&key=" + Constants.GOOGLE_API_KEY;
		
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse gResp = restTemplate.getForObject(url, GeocodingResponse.class);
		
		//Get the status code from the response
		String status = gResp.getStatus();
		
		switch (status) {
		
			//If the response was successful and we got the status code "OK"
			case Constants.STATUS_CODE_OK:
				List<Result> results = gResp.getResults();
				Result result = results.get(0);
				Geometry geometry = result.getGeometry();
				location = geometry.getLocation();
				break;
			
			//If there were not found any results
			case Constants.STATUS_CODE_ZERO_RESULTS:
				break;
				
			//not implemented yet
			/*case Constants.STATUS_CODE_OVER_QUERY_LIMIT:
				break;*/
			
			//not implemented yet
			/*case Constants.STATUS_CODE_REQUEST_DENIED:
				break;*/
				
			//not implemented yet
			/*case Constants.STATUS_CODE_INVALID_REQUEST:
				break;*/
				
			//not implemented yet
			/*case Constants.STATUS_CODE_UNKNOWN_ERROR:
				break;*/
				
			default:
				break;
		
		}
		
		
		return location;
		
		
		
	}
	

}
