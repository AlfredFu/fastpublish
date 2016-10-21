package me.wmn.convertor;

import org.springframework.core.convert.converter.Converter;

import me.wmn.domain.VersionTypeEnum;

public class VersionTypeConvertor implements Converter<String, VersionTypeEnum>{

	public VersionTypeEnum convert(String source) {
		switch(source){
		case "2":
			return VersionTypeEnum.PREVIEW;
		default:
			return VersionTypeEnum.DEV;
		}
	}

}
