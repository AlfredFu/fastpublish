package me.mwn.task;

public class Test {

	public String[] strArr;
	
	public Test(){
		strArr = new String[]{"hello", "world"};
	}
	
	public String[] getS(){
		return this.strArr;
	}
	
	public static void main(String[] args){
		Test t = new Test();
		System.out.println(t.strArr);
		String[] s = t.getS();
		System.out.println(s);
		s[1]="Fred";
		System.out.println(s);
		System.out.println(t.strArr[1]);
	}
}
