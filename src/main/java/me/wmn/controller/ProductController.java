package me.wmn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.wmn.domain.Product;
import me.wmn.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	public IProductService productService;

	@RequestMapping("product/list")
	public String listProducts(Map<String, Object> model){
		List<Product> products = this.productService.getAll();
		model.put("products", products);
		return "product/list";
	}
	
	@RequestMapping("/product/{id}")
	public String showProducts(@PathVariable String id){
		
		return "product/detail";
	}
	
	@RequestMapping(value="product/new", method=RequestMethod.GET)
	public String newProducts(){
		return "product/new";
	}
	
	
//	@RequestMapping(method=RequestMethod.POST)
//	public String createProduct(@Valid Product product, BindingResult bindingResult){
//		return "";
//	}
}
