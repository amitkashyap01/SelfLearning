package com.javacore;

public class MyClass {
	
	private String name;
	
	//Default Constructor
	public MyClass() {
		System.out.println("I am in MyClass");
	}
	
	//Custom Constructor
	public MyClass(String incomingName) {
		//Initializing the name variable
		this.name = incomingName;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public String testAndProvideOutput(String x, String y) {
		
		return "I have received x="+x;
	}
}
