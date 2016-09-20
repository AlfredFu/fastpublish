package me.wmn.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import me.wmn.domain.Product;

public class JdbcProductDao implements IProductDao {
	
	NamedParameterJdbcTemplate npJdbcTemplate;

	public NamedParameterJdbcTemplate getNpJdbcTemplate() {
		return npJdbcTemplate;
	}

	public void setNpJdbcTemplate(NamedParameterJdbcTemplate npJdbcTemplate) {
		this.npJdbcTemplate = npJdbcTemplate;
	}

	public void addProduct(Product product) {
		if(product !=null){
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("name", product.getName());
			this.npJdbcTemplate.update("INSERT INTO product(name)values(:name)", params);
		}
	}

	public List<Product> getAll() {
		List<Product> products = this.npJdbcTemplate.query("SELECT id,name FROM product", new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				return p;
			}
		});
		
		return products;
	}
	
	public boolean deleteProductById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Product getProductByID(String id) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		Product target = this.npJdbcTemplate.queryForObject("SELECT id, name FROM product WHERE id=:id", params, Product.class);
		return target;
	}

}
