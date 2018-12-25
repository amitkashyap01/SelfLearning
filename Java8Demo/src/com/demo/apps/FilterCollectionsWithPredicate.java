package com.demo.apps;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.demo.model.Person;

public class FilterCollectionsWithPredicate {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
		people.add(new Person("Amit", 33));
		people.add(new Person("Aman", 23));
		people.add(new Person("Anilesh", 63));


		//		Predicate<Person> predicate = new Predicate<Person>() {
		//			@Override
		//			public boolean test(Person p) {
		//				return (p.getAge() > 60);
		//			}
		//		};
		//		
		//		for (Person person : people) {
		//			if(predicate.test(person))
		//				System.out.println(person.toString());
		//		}
		
		
		//Java 8 has introduced a new functional interface which has a method test(<T>)
		//This method can be used for conditional code to make the condtional code a lot cleaner

		Predicate<Person> perdLambda = (p) -> p.getAge() > 60;
		Predicate<Person> perdLambda2 = (p) -> p.getAge() <= 30;

		people.forEach(p -> {
			if(perdLambda.test(p))
				System.out.println(p);
			if(perdLambda2.test(p))
				System.out.println(p);
		});
	}
}
