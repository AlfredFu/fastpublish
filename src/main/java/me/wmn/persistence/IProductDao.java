package me.wmn.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import me.wmn.domain.Product;

@Component
public interface IProductDao {
	
	public void addProduct(Product product);
	
	public List<Product> getAll();
	
	public boolean deleteProductById(String id);
	
	public Product getProductByID(String id);
}
