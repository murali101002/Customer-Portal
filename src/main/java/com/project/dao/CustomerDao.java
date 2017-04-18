package com.project.dao;

import java.util.List;

import com.project.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
	
	public void removeCustomer(Customer customer);
	
	public Customer getCustomer(Integer id);
	
	public List<Customer> getCustomerByName(String lastName);
	
}
