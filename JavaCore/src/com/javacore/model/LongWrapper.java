package com.javacore.model;

public class LongWrapper {

	//Creating this to avoid the race condition among threads
	Object key = new Object();

	long myLongVar;

	public LongWrapper(long myLongVar) {
		super();
		this.myLongVar = myLongVar;
	}

	public long getMyLongVar() {
		return myLongVar;
	}

	public void incrementValue() {
		synchronized (key) {
			//Using synchronized, each thread will be wait for other thread to release the 
			// variable myLongVar before start writing
			myLongVar = myLongVar + 1;
		}
	}


}
