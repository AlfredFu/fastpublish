package me.wmn.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import me.wmn.domain.Product;
import me.wmn.service.IProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	public IProductService productService;

	@RequestMapping("list")
	public String listProducts(Map<String, Object> model){
		List<Product> products = this.productService.getAll();
		model.put("products", products);
		return "product/list";
	}
	
	@RequestMapping("{id}")
	public ModelAndView showProductDetails(@PathVariable("id") Integer id, ModelMap model){
		if(id != null){
			Product p = this.productService.getById(id);
			model.put("product", p);
		}
		return new ModelAndView("product/detail", model);
	}
	
	@RequestMapping("{id}/delete")
	public String deleteById(@PathVariable("id") Integer id){
		this.productService.deleteById(id);
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newProducts(){
		return "product/new";
	}
	
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String createProduct(@Valid Product product, BindingResult bindingResult, ModelMap map){
		if(bindingResult.hasErrors()){
			List<FieldError> errorList = bindingResult.getFieldErrors();
			for(FieldError error : errorList){
				map.put("ERR_" + error.getField(), error.getDefaultMessage());
			}
			return "product/new";
		}else{
			this.productService.saveProduct(product);
			return "redirect:list";
		}
	}
}
