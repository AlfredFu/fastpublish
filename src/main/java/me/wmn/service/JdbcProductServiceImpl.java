package me.wmn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.wmn.domain.Product;
import me.wmn.persistence.IProductDao;

@Component
public class JdbcProductServiceImpl implements IProductService {

	@Autowired
	public IProductDao productDao;
	
	public List<Product> getAll() {
		return productDao.getAll();
	}
	
	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	public Product getById(Integer id) {
		return this.productDao.getProductByID(id);
	}

	public Product saveProduct(Product product) {
		return this.productDao.addProduct(product);
	}

	public void deleteById(Integer id) {
		this.productDao.deleteProductById(id);
		
	}

}