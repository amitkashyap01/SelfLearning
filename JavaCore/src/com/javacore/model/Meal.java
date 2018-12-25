package com.javacore.model;

public class Meal {
	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Meal [name=" + name + "]";
	}

}
