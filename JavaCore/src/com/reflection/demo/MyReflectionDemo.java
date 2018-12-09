package com.reflection.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyReflectionDemo {
	public static void main(String args[]) {

		Person person = new Person("Amit");

		// System.out.println(person.name); //Because name is private, it is not accessiable

		/*
		 * Now using reflection, we can access this field
		 */
		try {
			Field field = person.getClass().getDeclaredField("name");
			field.setAccessible(true);
			System.out.println(field.get(person));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		// Let's try accessing static field

		//System.out.println(person.personCount); // Even this is not accessible because of being private

		try {
			Field field = Person.class.getDeclaredField("personCount");
			field.setAccessible(true);

			//Because it is a static field we are trying to access. 
			//We don't need any instance to access it. So, passing null
			System.out.println(field.get(null));

		} catch (Exception e) {
			e.printStackTrace();
		}


		// Let's try accessing a method
		System.out.println(person.getName()); //we can do it with plain java

		//Using reflection
		try {
			Method method = person.getClass().getDeclaredMethod("getName");
			System.out.println(method.invoke(person, null));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Let's try accessing a set method
		person.setName("Kashyap"); //we can do it with plain java
		System.out.println("After setting: "+person.getName());
		
		person.setName("Amit");
		//Using reflection
		try {
			Method method = person.getClass().getDeclaredMethod("setName", String.class);
			method.invoke(person, "Kashyap");
			System.out.println(person.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		person.setName("Amit");

		// Let's try accessing a static method
		//Person.printPerson(person); //we can do it with plain java

		//Using reflection
		try {
			Method method = Person.class.getDeclaredMethod("printPerson", Person.class);
			method.invoke(null, person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Calling constructor
		
		Person person2 = new Person("Sonu");
		Person.printPerson(person2);
		try {
			Constructor<Person> constructor = Person.class.getDeclaredConstructor(String.class);
			person2 = constructor.newInstance("SonuFromConstructor");
			
			Person.printPerson(person2);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
