package me.wmn.editor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import me.wmn.domain.VersionTypeEnum;

public class MyWebBindingInitializer implements WebBindingInitializer {

	  @Override
	  public void initBinder(WebDataBinder binder, WebRequest request) {
		  binder.registerCustomEditor(VersionTypeEnum.class, new VersionTypeEditor());  
	  }
}