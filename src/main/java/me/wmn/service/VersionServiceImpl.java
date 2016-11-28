package me.wmn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.wmn.domain.Version;
import me.wmn.persistence.IVersionDao;

@Service
public class VersionServiceImpl implements IVersionService{
	
	@Autowired
	private IVersionDao versionDao;

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

}
