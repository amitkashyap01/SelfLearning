package mySimpleSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import mySimpleSpringApp.model.Fruit;
import mySimpleSpringApp.model.Meal;
import mySimpleSpringApp.model.Vegetables;

public class AppStarter {
	public static void main(String args[]) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("appContext.xml");
		
		
		// Below are the 2ways to get bean from Spring application container
		Fruit fruit = applicationContext.getBean("fruit", Fruit.class);
		Vegetables vegetables = (Vegetables)applicationContext.getBean("vegetables");

		System.out.println(fruit.introduceYourself());
		System.out.println(vegetables.introduceYourself());
		
		Fruit fruitWithListAndMap = applicationContext.getBean("fruitWithListAndMap", Fruit.class);
		
		System.out.println("-----Fruits with List and Map---------\n"+fruitWithListAndMap.introduceYourself());
		
		
		//Using PNamespace
		Fruit fruitWithPNamespace = applicationContext.getBean("fruitWithPNamespace", Fruit.class);
		System.out.println("----Using PNamespace-------\n"+fruitWithPNamespace.introduceYourself());
	
	
		//Using ref
		Meal meal = (Meal)applicationContext.getBean("whatsInMealBean");
		System.out.println("-----What's in meal?-----\n"+meal.whatsInMeal());
		
	}
}
