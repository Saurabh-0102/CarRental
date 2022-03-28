package com.car.rental.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.rental.entity.Admin;
import com.car.rental.entity.Customer;
import com.car.rental.repository.IAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository ar;
	
	
	@Override
	@Transactional
	public String addCustomer(Customer c) {
		ar.addCustomer(c);
		return "Customer added by admin";
	}
	
	@Override
	@Transactional
	public void addAdmin(Admin a) {
		ar.addAdmin(a);
	}
	
	
	
	
}
