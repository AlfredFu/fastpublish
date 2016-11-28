package me.wmn.domain;

public class OSPackage {

	private int id;
	
	private String packageName;
	
	private int versionId;
	
	private int productId;
	
	private OSTypeEnum osType;
	
	private int build;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public OSTypeEnum getOsType() {
		return osType;
	}

	public void setOsType(OSTypeEnum osType) {
		this.osType = osType;
	}

	public int getBuild() {
		return build;
	}

	public void setBuild(int build) {
		this.build = build;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
	
}
