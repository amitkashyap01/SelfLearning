package com.springdatademo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.springdatademo.dao.FoodGroupDAO;
import com.springdatademo.model.FoodGroup;


public class SpringDataDemoApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");

		FoodGroupDAO dao = applicationContext.getBean("foodGroupDAO", FoodGroupDAO.class);

		try {
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


			/*** use of batch update ***/

			/*
			FoodGroup newFoodGroup1 = new FoodGroup(6, "NewFoodGroup1","1 Description for the new Food Group");
			FoodGroup newFoodGroup2 = new FoodGroup(7, "NewFoodGroup2","2 Description for the new Food Group");
			FoodGroup newFoodGroup3 = new FoodGroup(8, "NewFoodGroup3","3 Description for the new Food Group");	
			//FoodGroup newFoodGroup4 = new FoodGroup(8, "NewFoodGroup3","3 Description for the new Food Group");	

			List<FoodGroup> listFoodGroups = new ArrayList<FoodGroup>();
			listFoodGroups.add(newFoodGroup1);
			listFoodGroups.add(newFoodGroup2);
			listFoodGroups.add(newFoodGroup3);
			//listFoodGroups.add(newFoodGroup4);

			int[] noOfRowsAffected = dao.bulkInsertFoodGroup(listFoodGroups);

			for(int i : noOfRowsAffected)
				System.out.println("No of row updated: "+i);

			 */

			//Using SimpleJdbcInsert
			//			FoodGroup newFoodGroup1 = new FoodGroup(6, "NewFoodGroup1","1 Description for the new Food Group");
			//			System.out.println("No of rows affected: "+ dao.createFoodGroupUsingSimpleJdbcInsert(newFoodGroup1));
			
			
			System.out.println("No of rows: "+dao.countFoodGroups());


		}catch (DataAccessException e) {
			System.out.println("Database Exception Occured. Message: "+e.getMessage());
		}


	}
}
