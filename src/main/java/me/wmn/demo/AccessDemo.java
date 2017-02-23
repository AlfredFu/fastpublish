package me.wmn.demo;

public class AccessDemo {
	public static void main(String[] args){
		ClassA ca = new ClassA();
		ca.print();
	}
	
	protected void print(){
		System.out.println("Invoke a protected method");
	}
}

class ClassA{
	protected void print(){
		System.out.println("Invoke a protected method");
	}
}