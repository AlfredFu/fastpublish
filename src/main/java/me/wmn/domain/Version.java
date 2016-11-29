package me.wmn.domain;

import java.util.Date;
import java.util.List;

public class Version {
	
	private Integer id;
	
	private VersionTypeEnum versionType;
	
	private String name;

	private Integer productId;
	
	private List<OSPackage> packages;
	
	private Date createDate;
	
	private int build;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VersionTypeEnum getVersionType() {
		return versionType;
	}

	public void setVersionType(VersionTypeEnum versionType) {
		this.versionType = versionType;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public List<OSPackage> getPackages() {
		return packages;
	}

	public void setPackages(List<OSPackage> packages) {
		this.packages = packages;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getBuild() {
		return build;
	}

	public void setBuild(int build) {
		this.build = build;
	}
	
	

}
