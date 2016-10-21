package me.wmn.editor;

import java.beans.PropertyEditorSupport;

import me.wmn.domain.VersionTypeEnum;

public class VersionTypeEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		if("1".equals(text) || "DEV".equals(text)){
			setValue(VersionTypeEnum.DEV);
		}
		
		if("2".equals(text) || "PREVIEW".equals(text)){
			setValue(VersionTypeEnum.PREVIEW);
		}
		//super.setAsText(text);
		
	}
	
}
