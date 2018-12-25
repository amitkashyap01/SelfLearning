package com.demo.apps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TraverseCollectionWithLamdaExpression {
	public static void main(String[] args) {
	
		ArrayList<String> strings = new ArrayList<>();
		strings.add("AAA");		
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");
		
		
		//By default, sorting is case sensetive
		Collections.sort(strings);
		
//		for (String string: strings){
//			System.out.println(string);
//		}
		
		//We can replace above iteration with below lambda expression
		strings.forEach(str -> System.out.println(str));
		
		System.out.println("--------------------------------");
		
		// To sort by ignore case
		Comparator<String> comp = (o1, o2) -> {
			return o1.compareToIgnoreCase(o2);
		};
		
		Collections.sort(strings, comp);

//		for (String string: strings){
//			System.out.println(string);
//		}

		//We can replace above iteration with below lambda expression
		strings.forEach(str -> System.out.println(str));
	}
}
