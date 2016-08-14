package com.bsp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Object>{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustId(rs.getInt("CUST_ID"));
		customer.setFullName(rs.getString("FULL_NAME"));
		customer.setAddress(rs.getString("ADDRESS"));
		customer.setEmail(rs.getString("EMAIL"));
		return customer;
	}
	
}
