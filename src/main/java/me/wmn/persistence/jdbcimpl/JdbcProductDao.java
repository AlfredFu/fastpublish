package me.wmn.persistence.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import me.wmn.domain.Product;
import me.wmn.persistence.IProductDao;

public class JdbcProductDao implements IProductDao {
	
	NamedParameterJdbcTemplate npJdbcTemplate;
	
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNpJdbcTemplate() {
		return npJdbcTemplate;
	}

	public void setNpJdbcTemplate(NamedParameterJdbcTemplate npJdbcTemplate) {
		this.npJdbcTemplate = npJdbcTemplate;
	}

	public Product addProduct(Product product) {
		if(product !=null){
//			final String sql =  "INSERT INTO product(name,description)values(:name, :description)";
//			HashMap<String, String> params = new HashMap<String, String>();
//			params.put("name", product.getName());
//			params.put("description", product.getDescription() == null ? "" : product.getDescription());
//			//this.npJdbcTemplate.update(sql, params);
//			
//			Integer id =  this.npJdbcTemplate.execute(sql, params, new PreparedStatementCallback<Integer>(){
//				public Integer doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {  	
//			        ResultSet rs = pstmt.getGeneratedKeys();
//			        if(rs != null){
//			        	rs.next();  
//				        return rs.getInt(0);
//			        }else{
//			        	return -1;
//			        }
//			        
//			    }
//			});
			
			
			KeyHolder key = new GeneratedKeyHolder();
			final String sql =  "INSERT INTO product(name,description)values(?, ?)";
			final String pname = product.getName();
			final String pdescription = product.getDescription();
			
			this.jdbcTemplate.update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(sql, new String[]{"name", "description"});
					pst.setString(1, pname);
					pst.setString(2, pdescription);
					return pst;
				}
				
			}, key);
			
			System.out.println(key.getKey().intValue());
			product.setId(key.getKey().intValue());

		}
		return product;
	}

	public List<Product> getAll() {
		List<Product> products = this.npJdbcTemplate.query("SELECT id,name,description FROM product", new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				return p;
			}
		});
		
	
		return products;
	}
	
	public boolean deleteProductById(Integer id) {
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		this.npJdbcTemplate.update("DELETE FROM product WHERE id=:id", params);
		return false;
	}

	public Product getProductByID(Integer id) {
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		Product target = this.npJdbcTemplate.queryForObject("SELECT id, name,description FROM product WHERE id=:id", params, new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				return p;
			}
		});
		return target;
	}

	public boolean saveProduct(Product product) {
		
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		return false;
	}

}
