package me.wmn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wmn.domain.OSPackage;
import me.wmn.persistence.IPackageDao;

@Service
public class PackageServiceImpl implements IPackageService{
	
	private final String PACKAGE_NAME_PATTERN = "%s_%s_%s_%i.%s";
	
	@Autowired
	private IPackageDao packageDao;
	
	@Override
	public void addPackage(OSPackage osp) {
		this.packageDao.savePackage(osp);
	}

	@Override
	public void deleteById(int id) {
		this.packageDao.deleteById(id);
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
		return String.format(this.PACKAGE_NAME_PATTERN, productName, versionName, build, suffix);
	}
	
	public OSPackage getById(int id){
		return this.packageDao.getById(id);
	}
	
	

	
}
