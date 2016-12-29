package me.wmn.demo.algorithm;

public class Lights {
	
	public static long lightOn(int number){
		return Math.round(Math.sqrt((double)number));
	}

	public static void main(String[] args) {
		System.out.println(Lights.lightOn(1000));
	}

}
