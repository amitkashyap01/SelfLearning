package com.javacore.collectionsdemo;

import java.util.LinkedList;

import com.javacore.model.Fruit;
import com.javacore.model.Grain;
import com.javacore.model.Meal;

public class LinkedListQueueDemo {
	public static void main(String[] args) {
		//Meal meal = new Meal();
		
		LinkedList<Meal> linkedList = new LinkedList<>();
		
		linkedList.add(new Fruit());
		linkedList.add(new Grain());
		printName(linkedList);
		
		System.out.println("--------------------------");
		//Add the specified item at the last index
		linkedList.offer(new Fruit());
		printName(linkedList);
		
		System.out.println("--------------------------");
		//This method retrieve and print the first item from queue. But doesn't remove
		System.out.println(linkedList.peek());
		printName(linkedList);
		
		System.out.println("--------------------------");
		//This method print and remove the first item 
		System.out.println(linkedList.poll());
		printName(linkedList);
		
		System.out.println("--------------------------");
		linkedList.remove();
		printName(linkedList);
	}
	
	private static void printName(LinkedList<Meal> linkedList) {
		for (Meal meal : linkedList) {
			System.out.println(meal.getName());
		}
	}
}
