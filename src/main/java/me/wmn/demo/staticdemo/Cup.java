package me.wmn.demo.staticdemo;


public class Cup {
	Cup(int marker){
		System.out.println("Cup("+marker+")");
	}
	
	void f(int marker){
		System.out.println("f("+marker+")");
	}
	
	public static void main(String[] args){
		System.out.println("Inside main()");
		Cups.cup1.f(99);
	}
}


class Cups{
	static Cup cup1;
	static Cup cup2;
	
	static{
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	
	Cups(){
		System.out.println("Cups()");
	}
	public static void t(char...cs){
		System.out.println("t(char...is )");
	}
	
	public static void t(int...is ){
		System.out.println("t(int...is )");
	}

}

class ExplicitStatic{
	public static void main(String[] args){
		System.out.println("Inside main()");
		Cups.cup1.f(99);
		Cups.t();
	}
	static Cups cups1 = new Cups();
	static Cups cups2 = new Cups();
}

