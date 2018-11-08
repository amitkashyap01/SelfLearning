package mySimpleSpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import mySimpleSpringApp.model.Fruit;
import mySimpleSpringApp.model.Grain;
import mySimpleSpringApp.model.Meal;
import mySimpleSpringApp.model.Meat;
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


		//Using constructor and ref initialization
		Meal meal1 = (Meal)applicationContext.getBean("whatsInMealBeanUsingConstructor");
		System.out.println("-----What's in meal? (Using Constructor)-----\n"+meal1.whatsInMeal());



		//Making use of external properties for initialization
		Grain grain = (Grain) applicationContext.getBean("grain");
		System.out.println("-------Introduction using external property--------\n"+grain.introduceYouself());


		//Making use of innerclass initialization
		Meal mealOuterClass = (Meal) applicationContext.getBean("mealOuterClass");
		System.out.println("-------Using outer bean--------\n"+mealOuterClass.whatsInMeal());


		//Using init and destroy methods
		Meat meat = (Meat) applicationContext.getBean("meat");
		System.out.println("-----Use of Init and Destroy beans---------\n"+meat.introduceYourself());


		//Using Autowiring byType 
		Meal mealAutoWired = (Meal) applicationContext.getBean("mealAutoWired");
		System.out.println("----------Using autowiring byType------------\n"+mealAutoWired.whatsInMeal());


		//Using Autowiring byType 
		Meal mealAutoWiredByName = (Meal) applicationContext.getBean("mealAutoWired");
		System.out.println("----------Using autowiring byType------------\n"+mealAutoWiredByName.whatsInMeal());

		
		//Using Autowiring constructor 
		Meal mealAutoWiredConstructor= (Meal) applicationContext.getBean("mealAutoWiredConstructor");
		System.out.println("----------Using autowiring contructor------------\n"+mealAutoWiredConstructor.whatsInMeal());

		
		
		((FileSystemXmlApplicationContext)applicationContext).close();
	}
}
