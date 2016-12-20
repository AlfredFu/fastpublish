package me.wmn.demo;

public class ReflectionDemo {
	
	public static void main(String[] args){
		ReflectionDemo rd = new ReflectionDemo();
		rd.testReflection();
	}
	
	public void testReflection(){
		System.out.println(getClass());
		System.out.println(getClass().getGenericSuperclass());
	}

}
