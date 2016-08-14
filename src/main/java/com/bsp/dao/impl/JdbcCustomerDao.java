package com.bsp.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bsp.dao.CustomerDao;
import com.bsp.model.Customer;
import com.bsp.model.CustomerRowMapper;;

public class JdbcCustomerDao implements CustomerDao{
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {
		JdbcTemplate template;
		String query = "INSERT INTO customer "
				+ "(cust_id, full_name, address, email) VALUES (?,?,?,?)";
		
		template = new JdbcTemplate(dataSource);
		
		template.update(query, new Object[] {
				customer.getCustId(),
				customer.getFullName(),
				customer.getAddress(),
				customer.getEmail()});
	}

	public Customer findByCustomerId(int custId) {
		JdbcTemplate template;
		String sql = "SELECT * FROM customer WHERE cust_id = ?";
		
		template = new JdbcTemplate(dataSource);
		
		//Customer customer = (Customer) template.queryForObject(sql, new Object[]{custId()}, );
		Customer customer = null;
		customer = (Customer) template.queryForObject(sql, new Object[]{ custId }, new CustomerRowMapper());
		return customer;
	}
	
	
}
