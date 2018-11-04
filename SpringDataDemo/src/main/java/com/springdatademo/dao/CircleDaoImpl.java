package com.springdatademo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.springdatademo.model.Circle;

@Component
public class CircleDaoImpl {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;
	
	
	
	//Using old method of querying database
	public Circle getCircle(int circleId)
	{
		
		Connection connection = null;
		Circle circle = null;
		
		try {
			connection =  dataSource.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("select * from circle where id = ?");
			preparedStatement.setInt(1, circleId);

			ResultSet  resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				circle = new Circle(circleId, resultSet.getString("name"));
			}
			
			resultSet.close();
			preparedStatement.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return circle;


	}

	//Using JdbcTemplate
	public int getCircleCount() {
		String sql = "select count(*) from circle";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}
	
	
	//Using JdbcTemplate
	public String getCircleName(int circleId) {
		String sql = "select name from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
		
	}
	
	
	public Circle getCircleForId(int circleId) {
		String sql = "select * from circle where id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles(){
		String sql = "select * from circle";
		
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = new JdbcTemplate(getDataSource());
	}

	
	
}
