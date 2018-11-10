package com.springdatademo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springdatademo.model.FoodGroup;

public class FoodGroupRowMapper implements RowMapper<FoodGroup> {

	public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
		FoodGroup foodGroup = new FoodGroup();
		
		foodGroup.setId(rs.getInt("id"));
		foodGroup.setName(rs.getString("name"));
		foodGroup.setDescription(rs.getString("description"));
		
		
		return foodGroup;
	}

}
