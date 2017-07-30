package me.wmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.wmn.domain.Product;
import me.wmn.service.IProductService;

@RestController
public class PController {
	
	@Autowired
	public IProductService productService;
		

	@RequestMapping(value="/p/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Product getById(@PathVariable Integer id){
		Product p = this.productService.getById(id);
		return p;
	}


	public IProductService getProductService() {
		return productService;
	}


	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	
}
