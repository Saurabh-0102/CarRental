package com.car.rental.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.car.rental.entity.Admin;
import com.car.rental.entity.Customer;

@Repository
public class AdminRepo implements IAdminRepository {


	@PersistenceContext
	EntityManager em;

	@Override
	public String addCustomer(Customer c) {
		em.merge(c);
		return null;
	}
	
	@Override
	public void addAdmin(Admin a) {
		em.merge(a);
	}
	
	
}
