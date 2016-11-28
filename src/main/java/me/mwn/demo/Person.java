package me.mwn.demo;

public class Person {
	
	private String name;
	
	private int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public Person(int age, String name){
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args){
		Person p = new Person("Fred", 30);
		System.out.println(p);
	}

}
