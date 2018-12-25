package com.demo.apps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UseComparator {
	public static void main(String[] args) {
	
		ArrayList<String> strings = new ArrayList<>();
		strings.add("AAA");		
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");
		
		
		//By default, sorting is case sensetive
		Collections.sort(strings);
		
		for (String string: strings){
			System.out.println(string);
		}
		
		System.out.println("--------------------------------");
		
		// To sort by ignore cases
//		Collections.sort(strings, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareToIgnoreCase(o2);
//			}
//		});
		
		// By using Lambda expression....we can replace above code with following codes
		Comparator<String> comp = (o1, o2) -> {
			return o1.compareToIgnoreCase(o2);
		};
		
		Collections.sort(strings, comp);

		for (String string: strings){
			System.out.println(string);
		}
		
	}
}
