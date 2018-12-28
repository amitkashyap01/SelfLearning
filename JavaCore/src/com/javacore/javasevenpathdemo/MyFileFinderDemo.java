package com.javacore.javasevenpathdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MyFileFinderDemo {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("Files");
		FileFinder fileFinder = new FileFinder("sample*");
		Files.walkFileTree(path, fileFinder);

		ArrayList<Path> foundFiles = fileFinder.foundFiles;
		
		if(foundFiles.size() > 0) {
			for (Path foundFile : foundFiles) {
				System.out.println("Found: "+foundFile.toRealPath(LinkOption.NOFOLLOW_LINKS));
			}
		}else
			System.out.println("No file found");
	}
}
