package ba.biggy.model.geocoding;

import java.util.List;

public class GeocodingResponse {
	
	public List<Result> results = null;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	

}
