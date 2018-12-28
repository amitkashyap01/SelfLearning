package com.demo.apps;

import com.demo.interfaces.SimpleInterface;

public class UseSimpleInterface {
	public static void main(String[] args) {
		SimpleInterface myInterface = () -> System.out.println("Hello from simple interface implementation");
		
		myInterface.doSomething();
	}
}
