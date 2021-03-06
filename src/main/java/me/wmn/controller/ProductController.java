package me.wmn.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import me.wmn.domain.OSPackage;
import me.wmn.domain.Product;
import me.wmn.domain.Version;
import me.wmn.domain.VersionTypeEnum;
import me.wmn.exception.ImageUploadException;
import me.wmn.service.IPackageService;
import me.wmn.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public IProductService productService;
	
	@Autowired
	public IPackageService packageService;
	
	@Value("${attachement.folder}")
	private String uploadFolder;
	
	HashMap<String, Boolean> activityTypeHashMap = new HashMap<String, Boolean>();
	
	public ProductController(){
		VersionTypeEnum[] allVersionType = VersionTypeEnum.values();
		for(VersionTypeEnum type : allVersionType){
			activityTypeHashMap.put(type.toString(), true);
		}
		
	}

	@RequestMapping("list")
	public String listProducts(Map<String, Object> model){
		
		List<Product> products = this.productService.getAll();
		model.put("products", products);
		return "product/list";
	}
	
	@RequestMapping("{id}/activity")
	public String showProductDetails2(@PathVariable("id") Integer id, ModelMap model, HttpServletRequest request){
		return "redirect:/product/activity/"+id;
	}
	
	@RequestMapping("activity/{id}")
	public ModelAndView showProductDetails(@PathVariable("id") Integer id, ModelMap model, HttpServletRequest request){
		if(id != null){
			List<String> allActivityType = new ArrayList<String>();
			String[] selActivityType = request.getParameterValues("sel_activity_type");
			if(selActivityType == null){
				selActivityType = activityTypeHashMap.keySet().toArray(new String[5]);
			}

			Product p = this.productService.getById(id);
			List<OSPackage> packages = this.packageService.getByProductId(p.getId());
			Iterator<Version> vi = p.getVersionList().iterator();
			while(vi.hasNext()){
				Version v = vi.next();
				
				if(selActivityType != null && !containsVersionType(selActivityType, v.getVersionType())){
					vi.remove();
					continue;
				}
					
				v.setPackages(new ArrayList<OSPackage>());
				for(OSPackage pke : packages){
					if(pke.getVersionId() == v.getId()){
						v.getPackages().add(pke);
					}
				}	
			}
			System.err.println(selActivityType);
			model.put("selActivityType", selActivityType);			
			model.put("product", p);
			model.put("subtab", "activity");
		}
		return new ModelAndView("product/activity", model);
	}
	
	boolean containsVersionType(String[] activityType, VersionTypeEnum vte){
		if(activityType != null){
			for(String type : activityType){
				if(type.equals(vte.toString())){
					return true;
				}
			}
		}

		return false;
	}
	
	@RequestMapping("{id}")
	public String showProductActivity(@PathVariable("id") Integer id, ModelMap model){
		return "redirect:/product/overview/"+id;
	}
	
	@RequestMapping("overview/{id}")
	public ModelAndView showProductOverview(@PathVariable("id") Integer id, ModelMap model){
		if(id != null){
			Product p = this.productService.getById(id);
			List<OSPackage> packages = this.packageService.getByProductId(p.getId());
			for(Version v : p.getVersionList()){
				v.setPackages(new ArrayList<OSPackage>());
				for(OSPackage pke : packages){
					if(pke.getVersionId() == v.getId()){
						v.getPackages().add(pke);
					}
				}
			}
			model.put("product", p);
			model.put("subtab", "overview");
		}
		return new ModelAndView("product/overview", model);
	}
	
	@RequestMapping("delete/{id}")
	public String deleteById(@PathVariable("id") Integer id){
		this.productService.deleteById(id);
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newProducts(){
		return "product/new";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String editProducts(@PathVariable Integer id, ModelMap map){
		Product p = this.productService.getById(id);
		map.put("product", p);
		return "product/edit";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.POST)
	public String updateProducts(@Valid Product product, BindingResult bindingResult, @RequestParam(value="image", required=false) MultipartFile image, HttpServletRequest request, ModelMap map){
		if(bindingResult.hasErrors()){
			List<FieldError> errorList = bindingResult.getFieldErrors();
			for(FieldError err : errorList){
				map.put("ERR_" + err.getField(), err.getDefaultMessage());
			}
			return "product/edit/" + product.getId();
		}else{
			this.productService.updateProduct(product);
		}
		
		return "redirect:/product/list";
	}
	
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String createProduct(@Valid Product product, BindingResult bindingResult, @RequestParam(value="image", required=false) MultipartFile image, HttpServletRequest request, ModelMap map){
		if(bindingResult.hasErrors()){
			List<FieldError> errorList = bindingResult.getFieldErrors();
			for(FieldError error : errorList){
				map.put("ERR_" + error.getField(), error.getDefaultMessage());
			}
			return "product/new";
		}else{
			Product savedProduct = this.productService.saveProduct(product);
			System.out.println(savedProduct);
			
			try{
				if(!image.isEmpty()){        
					this.validateImage(image);
					String filepath = this.uploadFolder + savedProduct.getId() +  ".jpg"; 
					System.out.println(filepath);
					
					this.saveImage(filepath, image);	
				}
			}catch(ImageUploadException e){
				e.printStackTrace();
				return "product/edit";
			}
			
			return "redirect:list";
		}
	}
	
	@RequestMapping(value="{id}.jpg", method=RequestMethod.GET)
	public void downloadImage(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response){
		String filepath = this.uploadFolder  + id + ".jpg";
		try{
			byte[] bytesArr = FileUtils.readFileToByteArray(new File(filepath));
			
			response.getOutputStream().write(bytesArr);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void validateImage(MultipartFile image) throws ImageUploadException{
//		if(!image.getContentType().equals("image/jpeg")){
//			throw new ImageUploadException("Only JPG images accepted");
//		}
	}
	
	private void saveImage(String filename, MultipartFile image) throws ImageUploadException{
		File file = new File(filename);
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			throw new ImageUploadException("Unable to save image" + e);
		}
		
	}

}
