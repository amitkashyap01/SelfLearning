package com.javacore;

import java.util.Random;

public class MyThirdClass {
	public static void main(String argsp[]) {	
		
		Random random = new Random();
		
		int randomValue = random.nextInt(100) + 1;
		
		System.out.println(randomValue);
	}
}
