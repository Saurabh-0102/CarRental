package com.car.rental.service;

import com.car.rental.entity.Admin;
import com.car.rental.entity.Customer;

public interface IAdminService {

	public String addCustomer(Customer c);
	
	public void addAdmin(Admin a);
	
}
