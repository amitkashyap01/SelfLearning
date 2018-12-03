package com.javacore;

import com.javacore.model.DeadLockDemo;
import com.javacore.model.LongWrapper;

public class MyFirstThread {
	public static void main(String args[]) throws InterruptedException  {
		
		MyFirstThread firstThreadDemo = new MyFirstThread();
		
		//firstThreadDemo.sychnorizationOfThread();
		
		firstThreadDemo.deadLockScenario();
		
	}
	
	public void deadLockScenario() throws InterruptedException {
		DeadLockDemo deadLockDemo = new DeadLockDemo();
		
		
		Runnable task1 = () -> {deadLockDemo.a();};
		Runnable task2 = () -> {deadLockDemo.b();};
		
		
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
	}
	
	
	public void sychnorizationOfThread() throws InterruptedException {
		LongWrapper longWrapper = new LongWrapper(0);
		
		Runnable runnable = () -> {
			//String 	name = Thread.currentThread().getName();
			//System.out.println("I am running thread "+name); // Task
		
			for(int i=0; i < 1_000; i++)
				longWrapper.incrementValue();
				
		};

		Thread[] thread = new Thread[1000];
		
		for(int i=0; i<thread.length; i++) {
			thread[i] = new Thread(runnable);
			thread[i].setName("My Thread: "+i);
			thread[i].start();
		}
		
		
		for(int i=0; i<thread.length; i++) {
			// It will wait for all the Thread to stop
			thread[i].join();
		}
		
		
		System.out.println("Here is the value: "+longWrapper.getMyLongVar());

		// thread.run(); // Don't be called to execute the task
	}
}
