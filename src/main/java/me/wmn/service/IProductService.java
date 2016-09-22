package me.wmn.service;

import java.util.List;

import me.wmn.domain.Product;

public interface IProductService {
	public List<Product> getAll();
	
	public Product getById(Integer id);
	
	public Product saveProduct(Product product);

	public void deleteById(Integer id);
}
