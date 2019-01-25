package com.jaxbdemo.springbootwithjaxb.util;

public class StopWatchUtil {
	String label;
	Long startTime;
	
	public StopWatchUtil start(String label) {
		this.label = label;
		this.startTime = System.currentTimeMillis();
		return this;
	}
	
	public void stop() {
		Long endTime = System.currentTimeMillis();
		System.out.println(label + ": Time taken: "+(endTime-startTime)+" ms");
	}
}
