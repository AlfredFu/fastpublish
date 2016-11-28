package me.wmn.service;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import me.wmn.domain.OSPackage;
import me.wmn.persistence.IPackageDao;

@Service
public class PackageServiceImpl implements IPackageService{
	
	private final String PACKAGE_NAME_PATTERN = "%s_%s_%s_%d.%s";
	
	@Autowired
	private IPackageDao packageDao;
	
	@Value("${attachement.folder}")
	private String uploadFolder;
	
	@Override
	public void addPackage(OSPackage osp) {
		this.packageDao.savePackage(osp);
	}

	@Override
	public void deleteById(int id) {
		OSPackage osp = this.getById(id);
		if(osp != null){
			FileUtils.deleteQuietly(new File(this.uploadFolder + osp.getPackageName()));
			this.packageDao.deleteById(id);
		}
	}

	public IPackageDao getPackageDao() {
		return packageDao;
	}

	public void setPackageDao(IPackageDao packageDao) {
		this.packageDao = packageDao;
	}

	@Override
	public List<OSPackage> getByProductId(int productId) {
		return this.packageDao.getByProductId(productId);
	}

	@Override
	public String getPackageName(String productName, String versionType, String versionName, int build, String suffix) {
		return String.format(this.PACKAGE_NAME_PATTERN, productName,versionType, versionName, build, suffix);
	}
	
	public OSPackage getById(int id){
		return this.packageDao.getById(id);
	}

	public String getUploadFolder() {
		return uploadFolder;
	}

	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}
	
	
}
