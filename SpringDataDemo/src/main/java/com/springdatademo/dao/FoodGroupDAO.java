package com.springdatademo.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdatademo.mapper.FoodGroupRowMapper;
import com.springdatademo.model.FoodGroup;

@Repository("foodGroupDAO")
public class FoodGroupDAO {

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	private SimpleJdbcCall procedureReadFoodGroup;
	

	public List<FoodGroup> getAllFoodGroup(){
		return namedJdbcTemplate.query("select * from foodgroups", new FoodGroupRowMapper());
	}

	public List<FoodGroup> getFoodGroupByName(String foodGroup){
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("groupName", foodGroup);
		
		
		return namedJdbcTemplate.query("select * from foodgroups where name=:groupName", mapSqlParameterSource, new FoodGroupRowMapper());
	}
	
	
	public FoodGroup getFoodGroupById(int foodGroupId){
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id", foodGroupId);
		
		
		return namedJdbcTemplate.queryForObject("select * from foodgroups where id=:id", mapSqlParameterSource, new FoodGroupRowMapper());
	}
	
	public Boolean addFoodGroup(FoodGroup foodGroup){
		Boolean response = false;
		
		BeanPropertySqlParameterSource mapSqlParameterSource = new BeanPropertySqlParameterSource(foodGroup);
		
		int noOfRowAffected = namedJdbcTemplate.update("insert into foodgroups values(:id, :name, :description)", mapSqlParameterSource);
		
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
		
		int noOfRowAffected = namedJdbcTemplate.update("update foodgroups set name=:name, description=:description where "
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
		
		int noOfRowAffected = namedJdbcTemplate.update("delete from foodgroups where id=:id", mapSqlParameterSource);
		
		if(noOfRowAffected == 1)
		{
			System.out.println("Deleted Successful");
			response = true;
		}else
			System.out.println("Deletion Failed.");
		
		return response;
	}
	
	// With this Transactional annotation, this method will treat each sql as transaction. If any of the 
	// transaction fails, it will rollback all the update made in database by calling this method.
	@Transactional("myTransactionManager")
	public int[] bulkInsertFoodGroup(List<FoodGroup> foodGroupList) {
		int[] numberOfAffectedRows = null;
			
		SqlParameterSource[] batchParams = SqlParameterSourceUtils.createBatch(foodGroupList.toArray());
		
		numberOfAffectedRows = namedJdbcTemplate.batchUpdate("insert into foodgroups values(:id, :name, :description)", batchParams);
		
		return numberOfAffectedRows;
	}
	
	
	/*******Using SimpleJdbcInsert************/
	
	
	public int createFoodGroupUsingSimpleJdbcInsert(FoodGroup foodGroup) {
		int noOfRowsAffected = 0;
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(foodGroup);
		
		noOfRowsAffected = simpleJdbcInsert.execute(parameterSource);
		
		return noOfRowsAffected;
	}
	
	
	public FoodGroup readFoodGroupUsingSimpleJdbcCall(int foodGroupId) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id_in", foodGroupId);
		
		Map<String, Object> result = procedureReadFoodGroup.execute(mapSqlParameterSource);
		
		
		FoodGroup out = new FoodGroup();
		
		out.setName((String) result.get("out_name"));
		out.setDescription((String) result.get("out_description"));
		
		
		return out;
		
	}
	
	
	public int countFoodGroups() {
		return jdbcTemplate.queryForObject("select count(*) from foodgroups", Integer.class);
	}
	
	/**
	 * @return the namedJdbcTemplate
	 */
	public NamedParameterJdbcTemplate getnamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	/**
	 * @param namedJdbcTemplate the namedJdbcTemplate to set
	 */
	@Autowired
	public void setNamedJdbcTemplate(DataSource dataSource) {
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("foodgroups");
		
		this.procedureReadFoodGroup = new SimpleJdbcCall(dataSource).withProcedureName("procedureName");
	}





}
