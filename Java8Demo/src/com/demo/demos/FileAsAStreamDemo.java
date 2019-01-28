package com.demo.demos;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class FileAsAStreamDemo {
	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath("files/mynotes.txt");
		
		String searchText = "My name is Amit Kashyap";
		
		try (Stream<String> stream = Files.lines(path)){
			Optional<String> foundString = stream.filter(s -> s.contains(searchText)).findFirst();
			
			if(foundString.isPresent())
				System.out.println(foundString.get());
			else
				System.out.println("Not Found");
			
		} catch (Exception e) {
			System.out.println("Exception Occured"+e);
		}
	}
}
