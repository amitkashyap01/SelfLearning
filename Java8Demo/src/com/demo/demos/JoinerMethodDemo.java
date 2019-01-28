package com.demo.demos;

public class JoinerMethodDemo {
	public static void main(String[] args) {
		// Here, first argument is delimiter and after  this, we can add as many strings as we want to concat
		String myJoinedStrings = String.join(":", "Amit", "Kumar", "Kashyap");
		System.out.println(myJoinedStrings);
		
		//We can also join elements of any iterable object
		String[] myStringArray = {"Amit","Kumar","Kashyap"};
		String joinedElementsOfArray = String.join("#", myStringArray);
		System.out.println(joinedElementsOfArray);
	}
}
