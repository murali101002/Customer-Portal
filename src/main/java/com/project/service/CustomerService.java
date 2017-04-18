package com.project.service;

import java.util.List;

import com.project.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public void removeCustomer(Customer customer);

	public Customer getCustomer(Integer id);
	
	public List<Customer> getCustomersByName(String lastName);
}
