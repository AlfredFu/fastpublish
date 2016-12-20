package me.wmn.demo;

public class Person  extends Annimal implements Activity{
	
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

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breath(){
		
	}
}

interface Activity{
	void eat();
	
	void sleep();
	
}

class Annimal{
	public void breath(){
		System.out.println("breath ...");
	}
}
