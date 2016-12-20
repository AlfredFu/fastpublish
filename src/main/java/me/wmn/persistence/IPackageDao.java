package me.wmn.persistence;

import java.util.List;

import me.wmn.domain.OSPackage;

public interface IPackageDao {

	public void savePackage(OSPackage osp);
	
	public void deleteById(int id);
	
	public List<OSPackage> getByProductId(int productId);
	
	public OSPackage getById(int id);
	
	public void deleteByVersionId(int versionId);
	
	
}
