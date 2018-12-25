package com.javacore.javasevenpathdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;

public class FileReadingWritingDemo {

	public static void main(String[] args) {
		Path existingFile = Paths.get("Files/sample.txt");
		System.out.println(existingFile.getFileName());
		
		Path newFile = Paths.get("Files/newFile.txt");
		System.out.println(newFile.getFileName());
		
		ArrayList<String> lines = new ArrayList<>();
		
		Charset charset = Charset.forName("US-ASCII");
		
		String line = null;
		
		// Reading the file using BufferedReader
		try(BufferedReader bufferedReader = Files.newBufferedReader(existingFile, charset)){
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				lines.add(line);
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		// Writing the content to a new File
		try(BufferedWriter bufferedWriter = Files.newBufferedWriter(newFile, charset, StandardOpenOption.APPEND)){
			
			Iterator<String> iterator = lines.iterator();
			
			while (iterator.hasNext()) {
				String string = (String) iterator.next();
				bufferedWriter.append(string, 0, string.length());
				bufferedWriter.newLine();
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
