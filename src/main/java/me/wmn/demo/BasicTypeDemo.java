package me.wmn.demo;

public class BasicTypeDemo {
	
	static int intField=10;

	public static void main(String[] args){
		int i=0;
		System.out.println(BasicTypeDemo.intField);
		
		BasicTypeDemo btd = new BasicTypeDemo();
		System.out.println(btd.intField);

	}
}
