package com.javacore.IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStreamDemo {
	public static void main(String[] args) {
		
		try (
				// Mostly used for reading and writing binary files
				FileInputStream fileInputStream = new FileInputStream("Files\\Docks.jpg");
				FileOutputStream fileOutputStream = new FileOutputStream("Files\\NewDocks.jpg");
				){
			
			int c;
			
			long startTime = System.currentTimeMillis();
			while((c = fileInputStream.read()) != -1) {
				fileOutputStream.write(c);
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
