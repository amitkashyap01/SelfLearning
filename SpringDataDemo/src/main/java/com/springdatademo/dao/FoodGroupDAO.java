package com.springdatademo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.springdatademo.mapper.FoodGroupRowMapper;
import com.springdatademo.model.FoodGroup;

@Component("foodGroupDAO")
public class FoodGroupDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<FoodGroup> getAllFoodGroup(){
		return jdbcTemplate.query("select * from foodgroups", new FoodGroupRowMapper());
	}

	public List<FoodGroup> getFoodGroupByName(String foodGroup){
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("groupName", foodGroup);
		
		
		return jdbcTemplate.query("select * from foodgroups where name=:groupName", mapSqlParameterSource, new FoodGroupRowMapper());
	}
	
	
	public FoodGroup getFoodGroupById(int foodGroupId){
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id", foodGroupId);
		
		
		return jdbcTemplate.queryForObject("select * from foodgroups where id=:id", mapSqlParameterSource, new FoodGroupRowMapper());
	}
	
	public Boolean addFoodGroup(FoodGroup foodGroup){
		Boolean response = false;
		
		BeanPropertySqlParameterSource mapSqlParameterSource = new BeanPropertySqlParameterSource(foodGroup);
		
		int noOfRowAffected = jdbcTemplate.update("insert into foodgroups values(:id, :name, :description)", mapSqlParameterSource);
		
		if(noOfRowAffected == 1)
		{
			System.out.println("One row inserted. Successful");
			response = true;
		}else
			System.out.println("Insertion Failed.");
		
		return response;
	}
	
	
	public Boolean updateFoodGroup(FoodGroup foodGroup){
		Boolean response = false;
		
		BeanPropertySqlParameterSource mapSqlParameterSource = new BeanPropertySqlParameterSource(foodGroup);
		
		int noOfRowAffected = jdbcTemplate.update("update foodgroups set name=:name, description=:description where "
				+ "id=:id", mapSqlParameterSource);
		
		if(noOfRowAffected == 1)
		{
			System.out.println("Updated Successful");
			response = true;
		}else
			System.out.println("Updation Failed.");
		
		return response;
	}

	public Boolean removeFoodGroup(int foodGroupId){
		Boolean response = false;
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id", foodGroupId);
		
		int noOfRowAffected = jdbcTemplate.update("delete from foodgroups where id=:id", mapSqlParameterSource);
		
		if(noOfRowAffected == 1)
		{
			System.out.println("Deleted Successful");
			response = true;
		}else
			System.out.println("Deletion Failed.");
		
		return response;
	}
	
	/**
	 * @return the jdbcTemplate
	 */
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}





}
