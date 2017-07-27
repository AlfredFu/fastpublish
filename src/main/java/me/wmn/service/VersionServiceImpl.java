package me.wmn.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.wmn.domain.OSPackage;
import me.wmn.domain.Version;
import me.wmn.persistence.IPackageDao;
import me.wmn.persistence.IVersionDao;

@Service
public class VersionServiceImpl implements IVersionService{
	
	@Autowired
	private IVersionDao versionDao;
	
	@Autowired
	private IPackageDao packageDao;
	
	@Value("${attachment.folder}")
	private String uploadFolder;

	public List<Version> getByProductID(Integer productID) {
		return this.versionDao.getByProductID(productID);
	}

	public IVersionDao getVersionDao() {
		return versionDao;
	}

	public void setVersionDao(IVersionDao versionDao) {
		this.versionDao = versionDao;
	}

	public void saveVersion(Version version) {
		this.versionDao.saveVersion(version);
		
	}

	@Override
	public Version getById(Integer id) {
		return this.versionDao.getById(id);
	}
	
	//@Transactional
	public void deleteById(Integer id){
		
		//remove package file
		List<OSPackage> packages = this.packageDao.getByVersionId(id);
		if(packages != null && packages.size() > 0){
			for(OSPackage p : packages){
				File f = new File(uploadFolder + p.getPackageName());
				f.delete();
			}
		}
		
		//remove package info in db
		this.packageDao.deleteByVersionId(id);
		
		//remove verion info in db
		this.versionDao.deleteById(id);
		
	}

	public IPackageDao getPackageDao() {
		return packageDao;
	}

	public void setPackageDao(IPackageDao packageDao) {
		this.packageDao = packageDao;
	}

	public String getUploadFolder() {
		return uploadFolder;
	}

	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}
	
	

}
