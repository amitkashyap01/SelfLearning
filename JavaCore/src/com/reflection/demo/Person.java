package com.reflection.demo;

public class Person {
	
	private String name;
	
	private static int personCount = 0;
	
	public Person(String name) {
		this.name = name;
		personCount++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static void printPerson(Person person) {
		System.out.println("Person Name: "+person.getName());
	}
}
