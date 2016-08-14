package com.bsp.dao;

import com.bsp.model.Customer;
public interface CustomerDao {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
