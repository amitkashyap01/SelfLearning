package com.javacore.javasevenpathdemo;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileFinder extends SimpleFileVisitor<Path> {

	private PathMatcher pathMatcher;
	public ArrayList<Path> foundFiles = new ArrayList<>();

	public FileFinder(String pattern) {
		pathMatcher = FileSystems.getDefault().getPathMatcher("glob:"+pattern);
	}

	

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Path visitingFile = file.getFileName();
		
		System.out.println("Examining: "+visitingFile);
		
		if(pathMatcher.matches(visitingFile)) {
			foundFiles.add(file);
		}
		return super.visitFile(file, attrs);
	}

}
