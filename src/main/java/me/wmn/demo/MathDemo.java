package me.wmn.demo;

import java.util.*;

public class MathDemo {

	public static void main(String[] args) {
//		System.out.println(Math.random());
//		System.out.println(Math.random());
//		System.out.println(Math.random());
//		
//		Random r = new Random();
//		System.out.println(r.nextInt(9999));
		List<Integer> vampire = new ArrayList<Integer>();

		for(int i=1000; i<= 9999; i++){
			char[] numChar = Integer.toString(i).toCharArray();
			for(char c : numChar){
				System.out.println(c);
			}
			break;
		}
		
		

	}

}
