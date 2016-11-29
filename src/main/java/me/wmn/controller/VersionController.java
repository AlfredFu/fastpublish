package me.wmn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import me.wmn.domain.Product;
import me.wmn.domain.Version;
import me.wmn.service.IProductService;
import me.wmn.service.IVersionService;

@Controller
@RequestMapping("/version")
public class VersionController {
	
	@Autowired
	private IVersionService versionService;
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="list/{productId}", method=RequestMethod.GET, headers={"Accept=text/xml, application/json"})
	public @ResponseBody List<Version> getByProductID(@PathVariable Integer productId){
		return this.versionService.getByProductID(productId);
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String saveVersion(@Valid Version version, BindingResult bs, @RequestParam(value="pid", required=false) Integer pid, ModelMap map){
		if(bs.hasErrors()){
			List<FieldError> errors = bs.getFieldErrors();
			for(FieldError error : errors){
				map.put("ERR_" + error.getField(), error.getDefaultMessage());
			}
			map.put("pid", pid);
			return "version/new";
		}else{
			version.setProductId(pid);
			this.versionService.saveVersion(version);
			return "redirect:/product/" + pid;
		}
		
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newVersion(@RequestParam("pid") Integer pid, ModelMap map){
		Product p = this.productService.getById(pid);
		map.put("pid", pid);
		map.put("product", p);
		return "version/create";
	}
	
	@RequestMapping("delete")
	public String deleteVersionById(@RequestParam int id, @RequestParam int pid){
		this.versionService.deleteById(id);
		
		return "redirect:/product/" + pid;
	}

	public IVersionService getVersionService() {
		return versionService;
	}

	public void setVersionService(IVersionService versionService) {
		this.versionService = versionService;
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	

}
