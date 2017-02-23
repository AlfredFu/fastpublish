package me.wmn.demo;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityDemo {

	public static void main(String[] args){
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",  ClasspathResourceLoader.class.getName());
		ve.init();
		
		Template t = ve.getTemplate("VelocityDemo.vm");
		
		VelocityContext ctx = new VelocityContext();
		//ctx.put("name", "Velocity");
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		ctx.put("list", list);
		
		StringWriter sw = new StringWriter();
		t.merge(ctx, sw);
		System.out.println(sw.toString());
	}
}
