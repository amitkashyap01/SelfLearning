package com.springdatademo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdatademo.dao.FoodGroupDAO;
import com.springdatademo.model.FoodGroup;


public class SpringDataDemoApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");

		FoodGroupDAO dao = applicationContext.getBean("foodGroupDAO", FoodGroupDAO.class);
		List<FoodGroup> foodGroups = dao.getAllFoodGroup();

		System.out.println("Size: "+foodGroups.size());

		for(FoodGroup foodGroup: foodGroups) {
			System.out.println(foodGroup.talkAboutYourSelf());
		}


		FoodGroup fruits = dao.getFoodGroupById(1);
		System.out.println(fruits.talkAboutYourSelf());

		//Adding the new FoodGroup
		/*
		FoodGroup newFoodGroup = new FoodGroup(6, "NewFoodGroup","Description for the new Food Group");
		dao.addFoodGroup(newFoodGroup);
		 */

		//Updating the existing record
		/*
		FoodGroup newFoodGroup = new FoodGroup(6, "UpdatedFoodGroupName","Updated Description for the new Food Group");
		dao.updateFoodGroup(newFoodGroup);
		*/
		
		//Deleting the existing record
		//dao.removeFoodGroup(6);
		
		

	}
}
