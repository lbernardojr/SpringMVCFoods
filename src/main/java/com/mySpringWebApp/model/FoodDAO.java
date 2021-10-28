package com.mySpringWebApp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/* This FoodDAO is the class that's going to contain the methods 
 * that our application can use in order to query the database. 
 */
@Component("foodsDAO")
public class FoodDAO {

	/*  
	 * This class is used to query our database and get some info from our foods table
	 */
	private JdbcTemplate myJdbcTemplate;
	final Logger log = LoggerFactory.getLogger(FoodDAO.class);

	public List<Foods> getFoods() {
		log.info("executing the sql script");
		return myJdbcTemplate.query("select * from foods", new RowMapper<Foods>() {

			@Override
			public Foods mapRow(ResultSet rs, int rowNum) throws SQLException {

				Foods fg = new Foods();
				fg.setId(rs.getInt("id"));
				fg.setName(rs.getString("name"));
				fg.setDescription(rs.getString("description"));

				return fg;
			}

		});

	}

	public JdbcTemplate getMyJdbcTemplate() {
		return myJdbcTemplate;
	}

	@Autowired
	// Initializing jdbc template
	public void setMyJdbcTemplate(DataSource ds) {
		this.myJdbcTemplate = new JdbcTemplate(ds);

	}

}
