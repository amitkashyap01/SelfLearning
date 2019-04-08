package com.javacore;

public class MySecondClass {
	public static void main(String[] args) {
		
		
		MyClass myClass = new MyClass("Neelam");

		String name =  myClass.getName();
		
		System.out.println("Hi "+name+". How are you?");
		
		
		MyClass myClass2 = new MyClass();
		String returnValue = myClass2.testAndProvideOutput("X", "Z");
		
		System.out.println(returnValue);
	}
}
