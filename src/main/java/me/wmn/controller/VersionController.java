package me.wmn.controller;

import java.util.Hashtable;
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

import me.wmn.domain.Version;
import me.wmn.service.IVersionService;

@Controller
@RequestMapping("/version")
public class VersionController {
	
	@Autowired
	private IVersionService versionService;
	
	@RequestMapping(value="list/{productId}", method=RequestMethod.GET, headers={"Accept=text/xml, application/json"})
	public @ResponseBody List<Version> getByProductID(@PathVariable Integer productId){
		return this.versionService.getByProductID(productId);
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String saveVersion(@Valid Version version, BindingResult bs, @RequestParam(value="productId", required=false) Integer productId, ModelMap map){
		if(bs.hasErrors()){
			List<FieldError> errors = bs.getFieldErrors();
			for(FieldError error : errors){
				map.put("ERR_" + error.getField(), error.getDefaultMessage());
			}
			map.put("productId", productId);
			return "version/new";
		}else{
			version.setProductId(productId);
			this.versionService.saveVersion(version);
			return "redirect:/product/" + productId;
		}
		
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newVersion(@RequestParam("productId") Integer productId, ModelMap map){
		map.put("productId", productId);
		Hashtable<String, String> test= new Hashtable<String, String>();
		return "version/new";
	}

}
