package com.javacore.javasevenpathdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;

public class PathFileOpDemo {
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("Files/sample.txt");
		System.out.println(path.getFileName());
		
		//Copying a file
		Path target = Paths.get("Files/copiedFile.txt");
		Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
		
		//To delte a file
//		Path toBeDeleted = Paths.get("Files/todelete.txt");
//		Files.delete(toBeDeleted);
		

		//To Create a new directory
		Path theNewDir = Paths.get("Files/newDir");
		Files.createDirectories(theNewDir);
		
		//TO move a file into another directory
		Files.move(path, theNewDir.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
		
	}
}
