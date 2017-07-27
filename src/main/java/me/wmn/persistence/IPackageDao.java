package me.wmn.persistence;

import java.util.List;

import me.wmn.domain.OSPackage;

public interface IPackageDao {
	
	static int a = 0;

	void savePackage(OSPackage osp);
	
	public void deleteById(int id);
	
	public List<OSPackage> getByProductId(int productId);
	
	public List<OSPackage> getByVersionId(int versionId);
	
	public OSPackage getById(int id);
	
	public void deleteByVersionId(int versionId);
	
	
}
