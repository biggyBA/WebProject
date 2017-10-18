package ba.biggy.global;

public class Constants {
	
	/**
	 * 
	 * Strings related to MySQL 
	 * 
	 */
	
	/*
	 * Table to store to do and done faults
	 */
	
	// Fault table name
	public static final String FAULT_TABLE_NAME = "Fault";
	
	//Fault table column names
	public static final String FAULT_TABLE_ID_COLUMN = "idFault";
	public static final String FAULT_TABLE_DATE_TIME_COLUMN = "dateTime";
	public static final String FAULT_TABLE_LAST_EDIT_COLUMN = "lastEdit";
	public static final String FAULT_TABLE_SERIAL_NUMBER_COLUMN = "productSerialNumber";
	public static final String FAULT_TABLE_PRODUCT_ID_COLUMN = "productId";
	public static final String FAULT_TABLE_PRODUCT_TYPE_COLUMN = "productType";
	public static final String FAULT_TABLE_CLIENT_NAME_COLUMN = "clientName";
	public static final String FAULT_TABLE_CLIENT_STREET_COLUMN = "clientStreet";
	public static final String FAULT_TABLE_CLIENT_POSTAL_CODE = "clientPostalCode";
	public static final String FAULT_TABLE_CLIENT_PLACE_COLUMN = "clientPlace";
	public static final String FAULT_TABLE_CLIENT_PHONE_ONE_COLUMN = "clientPhoneOne";
	public static final String FAULT_TABLE_CLIENT_PHONE_TWO_COLUMN = "clientPhoneTwo";
	public static final String FAULT_TABLE_CLIENT_EMAIL_COLUMN = "clientEmail";
	public static final String FAULT_TABLE_FAULT_DESCRIPTION_COLUMN = "faultDescription";
	public static final String FAULT_TABLE_FAULT_NOTE_COLUMN = "faultNote";
	public static final String FAULT_TABLE_FAULT_ISSUED_TO_COLUMN = "faultIssuedTo";
	public static final String FAULT_TABLE_FAULT_ISSUED_BY_COLUMN = "faultIssuedBy";
	public static final String FAULT_TABLE_FAULT_TYPE_COLUMN = "faultType";
	public static final String FAULT_TABLE_FAULT_PRIORITY_COLUMN = "faultPriority";
	public static final String FAULT_TABLE_FAULT_STATUS_COLUMN = "faultStatus";
	public static final String FAULT_TABLE_FAULT_FAULT_LAT = "faultLat";
	public static final String FAULT_TABLE_FAULT_FAULT_LNG = "faultLng";
	
	//Possible fault status
	public static final String FAULT_TABLE_TO_DO_STATUS = "UrgentToDo";
	public static final String FAULT_TABLE_DONE_STATUS = "ServiceDone";
	
	
	
	
	
	/**
	 * Strings related to geocoding
	 * 
	 * For more info visit https://developers.google.com/maps/documentation/geocoding/intro
	 * 
	 */
	
	//
	public static final String LOCATION_JSON_RESPONSE_URL = "";
	//Application API key
	public static final String GOOGLE_API_KEY = "AIzaSyDiC6WFTBReLHHd7dPBhsBBSKYeezb-zYk";
	
	/*
	 * Google Maps API Status Codes
	 */
	
	//indicates that no errors occurred; the address was successfully parsed and at least one geocode was returned
	public static final String STATUS_CODE_OK = "OK";
	
	//Indicates that the geocode was successful but returned no results. This may occur if the geocoder was passed a non-existent address
	public static final String STATUS_CODE_ZERO_RESULTS = "ZERO_RESULTS";
	 
	//Indicates that you are over your quota
	public static final String STATUS_CODE_OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT"; 
	
	//Indicates that your request was denied
	public static final String STATUS_CODE_REQUEST_DENIED = "REQUEST_DENIED"; 
	
	//Generally indicates that the query (address, components or latlng) is missing
	public static final String STATUS_CODE_INVALID_REQUEST = "INVALID_REQUEST"; 
	
	//Indicates that the request could not be processed due to a server error. The request may succeed if you try again
	public static final String STATUS_CODE_UNKNOWN_ERROR = "UNKNOWN_ERROR"; 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
