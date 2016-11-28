package me.wmn.persistence;

import java.util.List;

import me.wmn.domain.Version;

public interface IVersionDao {

	public List<Version> getByProductID(Integer productID);
	
	public void saveVersion(Version version);
	
	public Version getById(Integer id);
 }
