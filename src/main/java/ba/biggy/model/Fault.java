package ba.biggy.model;


import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Fault {
	
	private int idFault;
	
	private Date dateTime;
	
	private Date lastEdit;
	
	@NotEmpty
	private String productSerialNumber;
	
	@NotEmpty
	private String productId;
	
	private String productType;
	
	@NotEmpty
	private String clientName;
	
	@NotEmpty
	private String clientStreet;
	
	private String clientPostalCode;
	
	@NotEmpty
	private String clientPlace;
	
	@NotEmpty
	private String clientPhoneOne;
	
	private String clientPhoneTwo;
	
	@NotEmpty
	@Email
	private String clientEmail;
	
	@NotEmpty
	@Size(min = 10)
	private String faultDescription;
	
	private String faultNote;
	
	@NotEmpty
	private String faultIssuedTo;
	
	@NotEmpty
	private String faultIssuedBy;
	
	@NotEmpty
	private String faultType;
	
	@NotEmpty
	private String faultPriority;
	
	private String faultStatus;
	
	private double faultLat;
	
	private double faultLng;
	
	
	public int getIdFault() {
		return idFault;
	}
	
	public void setIdFault(int idFault) {
		this.idFault = idFault;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date date) {
		this.dateTime = date;
	}
	
	public String getProductSerialNumber() {
		return productSerialNumber;
	}
	
	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public String getClientStreet() {
		return clientStreet;
	}
	
	public void setClientStreet(String clientStreet) {
		this.clientStreet = clientStreet;
	}
	
	public String getClientPlace() {
		return clientPlace;
	}
	
	public void setClientPlace(String clientPlace) {
		this.clientPlace = clientPlace;
	}
	
	public String getClientPhoneOne() {
		return clientPhoneOne;
	}
	
	public void setClientPhoneOne(String clientPhoneOne) {
		this.clientPhoneOne = clientPhoneOne;
	}
	
	public String getClientPhoneTwo() {
		return clientPhoneTwo;
	}
	
	public void setClientPhoneTwo(String clientPhoneTwo) {
		this.clientPhoneTwo = clientPhoneTwo;
	}
	
	public String getClientEmail() {
		return clientEmail;
	}
	
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	
	public String getFaultDescription() {
		return faultDescription;
	}
	
	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}
	
	public String getFaultNote() {
		return faultNote;
	}
	
	public void setFaultNote(String faultNote) {
		this.faultNote = faultNote;
	}
	
	public String getFaultIssuedTo() {
		return faultIssuedTo;
	}
	
	public void setFaultIssuedTo(String faultIssuedTo) {
		this.faultIssuedTo = faultIssuedTo;
	}
	
	public String getFaultIssuedBy() {
		return faultIssuedBy;
	}
	
	public void setFaultIssuedBy(String faultIssuedBy) {
		this.faultIssuedBy = faultIssuedBy;
	}
	
	public String getFaultType() {
		return faultType;
	}
	
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}
	
	public String getFaultPriority() {
		return faultPriority;
	}
	
	public void setFaultPriority(String faultPriority) {
		this.faultPriority = faultPriority;
	}
	
	public String getFaultStatus() {
		return faultStatus;
	}
	
	public void setFaultStatus(String faultStatus) {
		this.faultStatus = faultStatus;
	}
	
	public Date getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	public String getClientPostalCode() {
		return clientPostalCode;
	}

	public void setClientPostalCode(String clientPostalCode) {
		this.clientPostalCode = clientPostalCode;
	}

	public double getFaultLat() {
		return faultLat;
	}

	public void setFaultLat(double faultLat) {
		this.faultLat = faultLat;
	}

	public double getFaultLng() {
		return faultLng;
	}

	public void setFaultLng(double faultLng) {
		this.faultLng = faultLng;
	}

	
	


}
