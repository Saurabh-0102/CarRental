package com.car.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.car.rental.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.name = ?1 and c.password = ?2")
	List<Customer> validateLogin(String name,String password);
	
}
