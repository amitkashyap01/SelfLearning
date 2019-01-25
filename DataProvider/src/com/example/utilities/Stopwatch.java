package com.example.utilities;

public class Stopwatch {

	private long start;
	private String label;
	
	public Stopwatch start(String label) {
		this.start = System.currentTimeMillis();
		this.label = label;
		return this;
	}

	public long stop() {
		long end = System.currentTimeMillis();
		long result = end - start;
		System.out.println(label + ": " + result + " milliseconds");
		return result;
	}
	
}
