package me.wmn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.wmn.domain.Product;
import me.wmn.persistence.IProductDao;
import me.wmn.persistence.IVersionDao;

@Component
public class ProductServiceImpl implements IProductService {

	@Autowired
	public IProductDao productDao;
	
	@Autowired
	public IVersionDao versionDao;
	
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
		Product p = this.productDao.getProductByID(id);
		return p; 
	}

	public Product saveProduct(Product product) {
		return this.productDao.addProduct(product);
	}

	public void deleteById(Integer id) {
		this.productDao.deleteProductById(id);
		
	}

	@Override
	public void updateProduct(Product product) {
		this.productDao.updateProduct(product);
	}

}
