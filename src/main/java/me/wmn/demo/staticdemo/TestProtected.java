package me.wmn.demo.staticdemo;

import me.wmn.demo.AccessDemo;

class TestProtected {
	static final AccessDemoChild adc = new AccessDemoChild();
	public static void main(String[] args){
		TestProtected tp = new TestProtected();
		AccessDemoChild ca = new AccessDemoChild();
		ca.echo();
	}
}

class AccessDemoChild extends AccessDemo{
	protected void echo(){
		super.print();
	}
}
