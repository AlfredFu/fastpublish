package me.wmn.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

import me.wmn.domain.OSPackage;
import me.wmn.domain.Product;
import me.wmn.domain.Version;
import me.wmn.service.IPackageService;
import me.wmn.service.IProductService;
import me.wmn.service.IVersionService;

@Controller
@RequestMapping("/package")
public class PackageController {
	
	
	@Value("${attachement.folder}")
	private String uploadFolder;
	
	@Autowired
	private IPackageService packageService;
	
	@Autowired
	private IVersionService versionService;
	
	@Autowired
	private IProductService productService;

	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newPackage(ModelMap map, HttpServletRequest request){
		int productId = Integer.parseInt(request.getParameter("pid"));
		List<Version> versions = this.versionService.getByProductID(productId);
		Product p = this.productService.getById(productId);
		
		map.put("versions", versions);
		map.put("product", p);
		return "package/upload_package";
	}
	
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String uploadNewPackage(@Valid OSPackage osp, BindingResult bindingResult,ModelMap map, HttpServletRequest request, @RequestParam(value="ospackage", required=true) MultipartFile ospackageFile){
		if(bindingResult.hasErrors()){
			List<FieldError> errors = bindingResult.getFieldErrors();
			for(FieldError error : errors){
				map.put("ERR_" + error.getField(), error.getDefaultMessage());
			}
			return "package/new";
		}else{
			//upload file to server
			Version  v = this.versionService.getById(Integer.parseInt(request.getParameter("versionId")));
			String[] tmpNames = ospackageFile.getOriginalFilename().split("\\.");
			
			String targetPackageName = this.packageService.getPackageName("Lexis_Red",  v.getVersionType().toString(), v.getName(), osp.getBuild(), tmpNames[tmpNames.length -1]);
			
			String absFilePath = this.uploadFolder + targetPackageName;
			File osPackageFile = new File(absFilePath);
			try{
				if(!osPackageFile.exists()){
					osPackageFile.createNewFile();
				}
				FileUtils.writeByteArrayToFile(osPackageFile, ospackageFile.getBytes());
			}catch (IOException fe){
				
			}
			
			osp.setPackageName(targetPackageName);
			osp.setProductId(v.getProductId());
			
			//persist package info to database
			this.packageService.addPackage(osp);
			return "redirect:/product/" + v.getProductId();
			
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws FileNotFoundException
	 */
	@RequestMapping("download/{packageId}")
	public void downloadPackage(@PathVariable int packageId, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException{
		
		OSPackage ospackage = this.packageService.getById(packageId);
		
		
		String absPackagePath = this.uploadFolder + ospackage.getPackageName();
		File packageFile = new File(absPackagePath);
		if(!packageFile.exists()){
			throw new FileNotFoundException("The package is not available");
		}else{
			try {
				response.addHeader("Content-Disposition", "attachment;filename=" + ospackage.getPackageName());
				response.addHeader("Content-Length", "" + packageFile.length());
				response.getOutputStream().write(FileUtils.readFileToByteArray(packageFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	@RequestMapping("delete")
	public String deletePackage(@RequestParam int id, @RequestParam int pid){
		this.packageService.deleteById(id);
		return "redirect:/product/" + pid;
	}
	
	

	public String getUploadFolder() {
		return uploadFolder;
	}


	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}


	public IPackageService getPackageService() {
		return packageService;
	}


	public void setPackageService(IPackageService packageService) {
		this.packageService = packageService;
	}


	public IVersionService getVersionService() {
		return versionService;
	}


	public void setVersionService(IVersionService versionService) {
		this.versionService = versionService;
	}
	
}
