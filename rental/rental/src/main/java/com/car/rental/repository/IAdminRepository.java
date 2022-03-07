package com.car.rental.repository;

import org.springframework.stereotype.Repository;

import com.car.rental.entity.Admin;
import com.car.rental.entity.Customer;

@Repository
public interface IAdminRepository {
	
	public String addCustomer(Customer c);

	public void addAdmin(Admin a);
}
