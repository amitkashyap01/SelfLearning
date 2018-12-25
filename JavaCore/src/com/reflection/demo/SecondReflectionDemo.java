package com.reflection.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SecondReflectionDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		People myPublic = new People("Someone");
		
		
		Class<?> myClass = myPublic.getClass();
		
		System.out.println("Class Name: "+myClass.getName());
		System.out.println("Simple Class Name: "+myClass.getSimpleName());
		
		Constructor<?>[] constructors = myClass.getConstructors();
		
		System.out.println("No. of constructors for People: "+constructors.length);
		
		Constructor<?> con = constructors[0];
		
		People newInstance = (People) con.newInstance("Amit");
		
		System.out.println(newInstance.getName());
		
		
		System.out.println("--------------GET SUPERCLASS --------------------");
		System.out.println("Super class of People: "+myClass.getSuperclass().getName());
	}
}
