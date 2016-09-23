package me.wmn.domain;

public class Version {
	
	private Integer id;
	
	private VersionTypeEnum versionType;
	
	private String name;

	private Integer productId;
	
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
	
}
