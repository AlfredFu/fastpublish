package me.wmn.demo;

import java.util.HashSet;
import java.util.Set;

public class CollectionDemo {

	public static void main(String[] args){
		Set<String> s = new HashSet<String>();
		s.add("Hello");
		s.add("Hello");
		
		System.out.println(s);
		
		//泛型类不能使用基本数据类型
		//List<int> ss;
		
	}
}
