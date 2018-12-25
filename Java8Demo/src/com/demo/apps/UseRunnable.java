package com.demo.apps;

public class UseRunnable {
	public static void main(String[] args) {
		
//		Runnable r1 = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Running Thread r1");
//			}
//		};
//		
//		Runnable r2 = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Running Thread r2");
//			}
//		};
		
		// With java 8, we can replace above codes with following 2lines
		Runnable r1 = () -> System.out.println("Running Thread r1");
		Runnable r2 = () -> System.out.println("Running Thread r2");
		
	
		new Thread(r1).start();
		new Thread(r2).start();
		
	}
}
