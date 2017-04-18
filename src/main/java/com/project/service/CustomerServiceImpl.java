package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	//inject dao/repository classes through this service can delegate calls
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void removeCustomer(Customer customer) {
		customerDao.removeCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer id) {
		return customerDao.getCustomer(id);
	}

	@Override
	public List<Customer> getCustomersByName(String lastName) {
		return customerDao.getCustomerByName(lastName);
	}

}
