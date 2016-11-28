package me.wmn.dynamicproxy;

public class MethodPerformance {
	
	private long begin;
	
	private long end;
	
	private String serviceMethod;

	public MethodPerformance(String method){
		this.serviceMethod = method;
		this.begin = System.currentTimeMillis();
	}

	public void printPerformance() {
		end = System.currentTimeMillis();
		long elapse = end - begin;
		
		System.out.println(serviceMethod + "elapse " + elapse + "millis"); 
	}
}
