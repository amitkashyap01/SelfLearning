package com.demo.demos;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class StringJoinerDemo {
	public static void main(String[] args) {
		
		//Creating a StringJoiner
		StringJoiner joiner = new StringJoiner(" # ");
		joiner.add("FirstItem");
		joiner.add("SecondItem");
		joiner.add("ThirdItem");
		joiner.add("ForuthItem");
		joiner.add("FifthItem");
	
		System.out.println(joiner);
	
		//Merging two StringJoiner
		StringJoiner joiner2 = new StringJoiner(" , ");
		joiner2.add("SixthItem");
		joiner2.add("SeventhItem");
		joiner.merge(joiner2);
		System.out.println(joiner);
		
		//Working with Collections
		Set<String> setOfItems = new HashSet<>();
		setOfItems.add("Item No 1");
		setOfItems.add("Item No 2");
		setOfItems.add("Item No 3");
		setOfItems.add("Item No 4");
		
		StringJoiner joiner3 = new StringJoiner(" * ");
	
		setOfItems.forEach(s -> joiner3.add(s));
		System.out.println(joiner3);
	}
}
