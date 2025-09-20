package com.infybuzz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infybuzz.entity.Address;

@Repository
public class AddressJdbcRepository {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	public Address getByIdJdbcTemplate(long id) {
		   
		String sql = "SELECT * FROM Address WHERE id = ?";
		Address address = this.jdbcTemplate.queryForObject(sql, new Object[]{id}, userRowMapper);
		//this.jdbcTemplate.execute(sql); DDL statement (example insert)
		//this.jdbcTemplate.update(sql, null)
		return address;
	}   
	   
	   
   private RowMapper<Address> userRowMapper = (rs, rowNum) -> {
	   Address user = new Address();
       user.setId(rs.getLong("id"));
       user.setCity(rs.getString("city"));
       user.setStreet(rs.getString("street"));
       return user;
   };

}
