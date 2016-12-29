package me.wmn.demo.xml;

public class TypeDemo {

	public static void main(String[] args){
		byte i =10;
		byte j = 20;
		byte h = (byte)(i + j);
		
		short k = 3;
		short s = 4;
		short l = (short)(k + s);
		
		String uname = "fred";
		switch(uname){
		case "fred":
			System.out.println("He is Yu's father");
		case "Lisa":
			System.out.println("She is Yu's mother");
			break;
		case "Unknow":
			System.out.println("Don't know who is he/she");

		}
	}
}
