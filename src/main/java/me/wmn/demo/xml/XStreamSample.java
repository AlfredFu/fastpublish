package me.wmn.demo.xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSample {

	private static XStream xstream;
	
	static{
		xstream = new XStream(new DomDriver());
	}
	
	public static User getUser(){
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.0.1");
		log1.setLoginDate(new Date());
		
		User user = new User();
		user.setUserId(1);
		user.setUsername("xstream");
		user.addLoginLog(log1);
		
		return user;
	}
	
	public static void objectToXML() throws Exception{
		FileOutputStream foutput = new FileOutputStream ("/Users/fredfu/XStreamSample.xml");
		User u = getUser();
		xstream.toXML(u, foutput);
	}
	
	public static void main(String[] args) throws Exception{
		XStreamSample.objectToXML();
	}
}