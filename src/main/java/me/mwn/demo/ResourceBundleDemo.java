package me.mwn.demo;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("i18n/message", Locale.CHINA);
		System.out.println(rb.getString("product.name.notempty"));
		
		System.out.println(MessageFormat.format("你好，{0}", "Fred"));
		
		System.out.println(Locale.getDefault());
	}

}
