package me.wmn.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name){
		return this.clearXss(super.getParameter(name));
	}
	
	@Override
	public String getHeader(String name){
		return this.clearXss(super.getHeader(name));
	}
	
	@Override
	public String[] getParameterValues(String name){
		return super.getParameterValues(name);
	}
	
	private String clearXss(String value){
		if(value == null || "".equals(value)){
			return value;
		}
		
		value = value.replaceAll(">", "&gt;").replaceAll("<", "&lt;");
		
		return value;
		
		
	}
	

}
