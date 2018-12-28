package com.demo.apps;

import java.util.ArrayList;
import java.util.Collections;

import com.demo.model.Person;

public class MethodReferenceDemo {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
		people.add(new Person("Amit", 33));
		people.add(new Person("Aman", 23));
		people.add(new Person("Anilesh", 63));
		
		// Java 8 method Reference 
		// Here it is called instance method reference. Because, comparator class 
		// also takes 2 parameters, this is not required to mention below
		Collections.sort(people, Person :: compareAges);
		people.forEach(p -> System.out.println(p.toString()));
		
		
	}
}
