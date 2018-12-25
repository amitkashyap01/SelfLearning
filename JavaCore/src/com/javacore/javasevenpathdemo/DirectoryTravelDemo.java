package com.javacore.javasevenpathdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryTravelDemo{
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("Files");
		
		MyFileVisitor  fileVisitor = new MyFileVisitor();
		Files.walkFileTree(path, fileVisitor);
		
	}
}
