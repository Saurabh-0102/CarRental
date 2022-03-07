package com.car.rental.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.car.rental.entity.Customer;

@Repository
public class CustomerRepo {

		@PersistenceContext
	 	public EntityManager em;	
		
		public List<Customer> login(String name, String password){
			Query q = em.createQuery("select c from Customer c where c.name = :em and c.password = :ps ");
			q.setParameter("em",name);
			q.setParameter("ps", password);
			List<Customer> l = q.getResultList();
			return l;
		}
		
		
		public void addCustomer(Customer c) {
			em.merge(c);
		}
		
		
		
		public List<Customer> getAllCustomer() {
			Query q = em.createQuery("select c from Customer c");
			List<Customer> list = q.getResultList();
			return list;
		}
		
}
