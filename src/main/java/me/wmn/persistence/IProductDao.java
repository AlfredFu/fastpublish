package me.wmn.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import me.wmn.domain.Product;

@Component
public interface IProductDao {
	
	public Product addProduct(Product product);
	
	public List<Product> getAll();
	
	public boolean deleteProductById(Integer id);
	
	public Product getProductByID(Integer id);

	public boolean saveProduct(Product product);
	
	public boolean updateProduct(Product product);
}
