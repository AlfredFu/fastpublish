package me.wmn.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import me.wmn.domain.OSPackage;

public interface IPackageService {

	public void addPackage(OSPackage osp);
	
	public OSPackage uploadPackage(int versionId, OSPackage osp, MultipartFile ospackageFile)  throws IOException;
	
	public void deleteById(int id);
	
	public List<OSPackage> getByProductId(int productId);
	
	public String getPackageName(String productName, String osType, String versionType, String versionName, int build, String suffix);
	
	public OSPackage getById(int id);
	
	
}
