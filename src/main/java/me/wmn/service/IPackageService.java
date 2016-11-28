package me.wmn.service;

import java.util.List;

import me.wmn.domain.OSPackage;

public interface IPackageService {

	public void addPackage(OSPackage osp);
	
	public void deleteById(int id);
	
	public List<OSPackage> getByProductId(int productId);
	
	public String getPackageName(String productName, String versionType, String versionName, int build, String suffix);
	
	public OSPackage getById(int id);
}
