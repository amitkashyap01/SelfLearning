package com.javacore.IODemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
	
	public static void main(String[] args) {
		try (
				// It's recommended to use FileReader and FileWriter when dealing with Character set i.e. text files
				FileReader fileReader= new FileReader("Files\\copiedFile.txt");
				FileWriter fileWriter = new FileWriter("Files\\newCopiedFile.txt");
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
