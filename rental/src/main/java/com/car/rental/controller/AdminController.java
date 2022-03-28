package com.car.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.entity.Admin;
import com.car.rental.entity.Customer;
import com.car.rental.service.IAdminService;

@RestController
public class AdminController {

	@Autowired
	public IAdminService as;
	
	
	@PostMapping("/addcusadmin")
	public String addCustomer(@RequestBody Customer c) {
		as.addCustomer(c);
		return "Customer added by admin";
	}
	
	@PostMapping("/addadmin")
	public String addAdmin(@RequestBody Admin a) {
		as.addAdmin(a);
		return "Admin added successfully";
	}
	
	
}
