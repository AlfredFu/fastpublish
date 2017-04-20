package me.wmn.domain;

public enum VersionTypeEnum {
	PREVIEW(1, "PREVIEW"),
	DEV(2, "DEV"),
	UAT(3, "UAT"),
	RC(4, "RC"),
	OFFICIAL(5, "OFFICIAL");
	
	private int id;
	private String name;
	
	private VersionTypeEnum(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static VersionTypeEnum getVersionTypeEnum(int id){
		switch(id){
		case 1:
			return PREVIEW;
		case 2:
			return DEV;
		case 3:
			return UAT;
		case 4:
			return RC;
		default:
			return OFFICIAL;
		}
	}
}