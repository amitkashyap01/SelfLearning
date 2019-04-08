package com.demo.apps.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {
	public static void main(String args[]) throws IOException {

		//To print 
		IntStream
		.range(1, 4)
		.forEach(System.out::println);

		//Integer stream with skip
		System.out.println("Integer stream with skip");
		IntStream
		.range(0, 10)
		.skip(5)
		.forEach(x -> System.out.println(x));

		//Integer Stream with Sum
		System.out.println("Integer Stream with Sum");

		System.out.println(
				IntStream
				.range(1, 5)
				.sum()
				);

		//Use of Steam.of, sorted and findFirst()
		System.out.println("Use of Steam.of, sorted and findFirst()");

		Stream.of("Amit","Kumar", "Kashyap")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);

		System.out.println("Use of Stream.of on array, filter and forEach");

		//Array
		String[] myArray = {"Ankit", "Aman", "Amit", "Manish", "Kisan"}; 

		Stream.of(myArray)
		.filter(x -> x.startsWith("A"))
		.findFirst()
		.ifPresent(System.out::println);

		//Use of Stream on list, map and forEach
		System.out.println("Use of Stream on list, map and forEach");

		List<String> myList = Arrays.asList("Amit", "Ankit", "Aman", "Manish", "Kisan");
		
		myList
		.stream()
		.map(String::toLowerCase)
		.filter(x -> x.startsWith("m"))
		.forEach(x -> System.out.println(x));

		//Use of Stream on text file, sort, filter and print
		System.out.println("Use of Stream on text file, sort, filter and print");
	
		Stream<String> lines = Files.lines(Paths.get("files/mynotes.txt"));
		List<String> linesWithLengthMoreThanThree = lines
			.sorted()
			.filter(x -> x.length() > 3)
			.collect(Collectors.toList());
		
		linesWithLengthMoreThanThree.forEach(System.out::println);
		
		lines.close();
	}
}
