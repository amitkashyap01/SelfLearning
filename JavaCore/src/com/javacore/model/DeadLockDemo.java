package com.javacore.model;

public class DeadLockDemo {
	
	Object key1 = new Object();
	Object key2 = new Object();
	
	
	public void a() {
		synchronized(key1) {
			System.out.println("By Thread: "+Thread.currentThread().getName());
			b();
		}
	}
	
	public void b() {
		synchronized(key2) {
			System.out.println("By Thread: "+Thread.currentThread().getName());
			c();
		}
	}
	
	public void c() {
		synchronized(key1) {
			System.out.println("By Thread: "+Thread.currentThread().getName());
		}
	}
}
