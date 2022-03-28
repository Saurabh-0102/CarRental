package com.car.rental.service;

import java.util.List;

import com.car.rental.entity.Customer;

public interface ICustomerService {

	/*
	 * //Manual public void add(Customer c);
	 */
	//JPA Repo
	public void addCustomer(Customer c);
	
	public List<Customer> getCustomers();
	
	public Customer login(String name , String password);
	
	public List<Customer> validateLogin(String name,String password);
	
	public Customer getCustomerById(int i);
}
