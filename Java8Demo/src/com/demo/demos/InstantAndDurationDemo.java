package com.demo.demos;

import java.time.Duration;
import java.time.Instant;

public class InstantAndDurationDemo {
	public static void main(String[] args) throws InterruptedException {
		
		Instant start = Instant.now();
		System.out.println("We have started the processing");
		
		Thread.sleep(10);
		
		Instant end = Instant.now();
		
		Duration elapsed = Duration.between(start, end);
		
		System.out.println("Total Elapsed Time: "+elapsed.toNanos());
	}
}
