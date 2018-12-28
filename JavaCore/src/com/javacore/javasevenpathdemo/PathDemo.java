package com.javacore.javasevenpathdemo;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
	public static void main(String[] args) throws IOException {
		
		//Path is introduced as part of Java 7 and its package name is java.nio
		Path path = Paths.get("src/com/javacore/MyFirstThread.java");
		
		System.out.println(path.toString());
		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getName(1));
		System.out.println(path.getName(path.getNameCount() - 1));
		
		Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		
		System.out.println(realPath.toString());
	}
}
