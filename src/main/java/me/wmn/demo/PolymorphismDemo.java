package me.wmn.demo;

public class PolymorphismDemo {
	public static void main(String[] args){
		PrivateOverride v = new Derived();
	}
}

class PrivateOverride{
	
	private void f(){
		System.out.println("private f()");
	}
	public static void main(String[] args){
		PrivateOverride v = new Derived();
		v.f();
	}
	
	public int h(){
		return 1;
	}
}

class Derived extends PrivateOverride{
	static{
		System.out.println("Static block");

	}
	{
		System.out.println("Instance block");
	}
	public Derived(){
		super();
		System.out.println("Derived constrctor");
	}
	
	public void f(){
		System.out.println("public f()");
	}
	
	public int h(){
		return 2;
	}
	
	
}
interface t{
}