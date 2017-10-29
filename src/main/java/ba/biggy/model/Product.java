package ba.biggy.model;

public class Product {
	
	private int id;
	private String productId;
	private String productDescription;
	
	public Product() {
		
	}
	
	public Product (String productId, String productDescription) {
		this.productId = productId;
		this.productDescription = productDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	

}
