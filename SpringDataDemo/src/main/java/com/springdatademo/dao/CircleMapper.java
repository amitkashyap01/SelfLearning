package com.springdatademo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springdatademo.model.Circle;

public class CircleMapper implements RowMapper<Circle>{

	public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
		Circle circle = new Circle(rs.getInt("ID"), rs.getString("NAME"));
		return circle;
	}

}
