package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	//inject dependencies required for data persistence
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Customer> getCustomers() {
		TypedQuery<Customer> query = em.createNamedQuery("findAll", Customer.class);
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		if(customer.getId()==null||customer.getId()==0)
		em.persist(customer);
		else em.merge(customer);
	}

	@Override
	public void removeCustomer(Customer customer) {
//		Query query = em.createQuery("delete from Customer where id=:customerId");
//		query.setParameter("customerId", customer.getId());
//		query.executeUpdate();
		em.remove(em.find(Customer.class, customer.getId()));

	}

	@Override
	public Customer getCustomer(Integer id) {
		return em.find(Customer.class, id);
	}

	@Override
	public List<Customer> getCustomerByName(String lastName) {
		TypedQuery<Customer> query = em.createNamedQuery("findByName", Customer.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

}
