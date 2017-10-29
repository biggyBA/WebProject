package ba.biggy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ba.biggy.dao.ProductDAO;
import ba.biggy.global.Constants;
import ba.biggy.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT * FROM " + Constants.PRODUCTS_TABLE_NAME;
	    List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>(){
	    	
	    	@Override
	    	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	    		Product product = new Product();
	    		
	    		product.setId(rs.getInt(Constants.PRODUCTS_TABLE_ID_COLUMN));
	    		product.setProductId(rs.getString(Constants.PRODUCTS_TABLE_PRODUCT_ID_COLUMN));
	    		product.setProductDescription(rs.getString(Constants.PRODUCTS_TABLE_PRODUCT_DESCRIPTION_COLUMN));
				return product;
	    	}
	    	
	    });
		return products;
	}

	@Override
	public Product getProductByProductId() {
		// TODO Auto-generated method stub
		return null;
	}

}
