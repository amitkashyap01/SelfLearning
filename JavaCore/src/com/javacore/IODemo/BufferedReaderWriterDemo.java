package com.javacore.IODemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {
	
	public static void main(String[] args) {
		try (
				// When dealing with very large text files, we should use BufferedSteams
				// This provides a better memory management and optimum use of system resources.
				BufferedReader fileReader= new BufferedReader(new FileReader("Files\\copiedFile.txt"));
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Files\\newCopiedFile.txt"));
				){
			
			int c;
			
			long startTime = System.currentTimeMillis();
			while((c = fileReader.read()) != -1) {
				fileWriter.write(c);
			}
			long endTime = System.currentTimeMillis();
			
			System.out.println("Time Taken"+(endTime-startTime));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
