package ba.biggy.dao;

import java.util.List;

import ba.biggy.model.Product;

public interface ProductDAO {
	
	public List<Product> getAllProducts();
	
	public Product getProductByProductId();
	

}
