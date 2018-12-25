package com.javacore.javasevenpathdemo;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryWithResourceDemo {
	public static void main(String[] args) {

		try(
				FileReader fileReader = new FileReader("Details.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				){
			
			String s;
			while ((s = bufferedReader.readLine())!= null)
				System.out.println(s);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}	
