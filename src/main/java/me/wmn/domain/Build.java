package me.wmn.domain;

public class Build {
	
	private int id;
	
	private Version version;
	
	private int buildNum;
	
	private String fileName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public int getBuildNum() {
		return buildNum;
	}

	public void setBuildNum(int buildNum) {
		this.buildNum = buildNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	
}
