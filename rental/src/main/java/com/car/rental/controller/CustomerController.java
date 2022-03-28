package com.car.rental.controller;

import java.util.List;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.CustomException.CustomException;
import com.car.rental.entity.Customer;
import com.car.rental.service.CustomerServiceImpl;
import com.car.rental.service.EmailService;
import com.car.rental.service.ICustomerService;
import com.car.rental.service.OtpGenerator;

@RestController
public class CustomerController {

	@Autowired
	public ICustomerService cs;

	@Autowired
	public EmailService em;

	@Autowired
	public OtpGenerator ot;

	/*
	 * @PostMapping("/add") public String addCustomer(@RequestBody Customer c) {
	 * cs.add(c); return "Customer added"; }
	 */

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Customer c) {
		Customer cus = (Customer)c;
		try {
			Customer l = cs.login(cus.getName(), cus.getPassword());
			if (l != null) {
				return new ResponseEntity<>(l, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Logine failed", HttpStatus.NOT_FOUND);
	}


	@GetMapping("/get")
	public List<Customer> get() {
		List<Customer> l = cs.getCustomers();
		return l;
	}

	@PostMapping("/validlogin")
	public List<Customer> validateLogin(@RequestBody Customer c) {
		List<Customer> list = cs.validateLogin(c.getName(), c.getPassword());
		return list;
	}

	@GetMapping("/sayHello")
	public String sayhello() {
		return "Hello from spring boot";
	}

	@PostMapping("/addcus")
	public String addCus(@RequestBody Customer c) {
		cs.addCustomer(c);
		return "Cutomer added successfully";
	}

	@PostMapping("/cusbyid")
	public Customer getCustomerById(@RequestParam int i) {
		return cs.getCustomerById(i);
	}

	@PostMapping("/fogpass")
	public String forgetPass(@RequestParam String email) {
		String otp = ot.generateOTP();
		em.sendMail(email, otp);
		return "email sent successfully";
	}

	@PostMapping("/passver")
	public String otpver(@RequestParam String otp) {

		boolean res = ot.verifyOtp(otp);
		if (res)
			return "otp verified";
		else
			return "please enter correct otp";
	}

	@PostMapping("/mail")
	public String sendEmail(@RequestParam String email) {
		System.out.println(email);
		em.sendSimpleMessage(email);
		return "sent";
	}

}
