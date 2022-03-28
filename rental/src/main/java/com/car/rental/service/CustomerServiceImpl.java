package com.car.rental.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.CustomException.CustomException;
import com.car.rental.entity.Customer;
import com.car.rental.repository.CustomerRepo;
import com.car.rental.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	
	@Autowired
	public CustomerRepo o;
	
	@Autowired
	public EmailService es;
	
	@Autowired
	public ICustomerRepository cus;
	
	
	/*
	 * @Transactional public void add(Customer c) {
	 * es.sendEmailForNewRegistration(c.getEmail()); o.save(c); }
	 */
	
	public void addCustomer(Customer c) {
		cus.save(c);
		es.sendEmailForNewRegistration(c.getEmail());
	}
	
	public List<Customer> validateLogin(String name,String password){
		 List<Customer> c = cus.validateLogin(name, password);
		return c;
	}
 		
	public List<Customer> getCustomers(){
		List<Customer> list = o.getAllCustomer();
		return list;
	}
	
	public Customer login(String name , String password){
		Customer l =  o.login(name, password);
		return l;
	}
	

	@Override
	public Customer getCustomerById(int i) {
		return cus.findById(i).orElseThrow(() -> new CustomException("Customer not found")); 
	}
	
}
