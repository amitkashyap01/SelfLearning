package com.javacore.IODemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {

		try(
				//Scanner is used to read tokenized file such a csv file with a delimiter
				// Default delimiter is space
				Scanner scanner = new Scanner(new BufferedReader(new FileReader("Files\\myFile.csv")));				
				){
			
			scanner.useDelimiter(",");
			
			while(scanner.hasNext() ) {
				System.out.println(scanner.next());
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

