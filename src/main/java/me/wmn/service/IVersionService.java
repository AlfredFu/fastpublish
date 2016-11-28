package me.wmn.service;

import java.util.List;

import me.wmn.domain.Version;

public interface IVersionService {
	public List<Version> getByProductID(Integer productID);
	
	public void saveVersion(Version version);
	
	public Version getById(Integer id);
}
