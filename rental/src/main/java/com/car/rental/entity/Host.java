package com.car.rental.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_host")
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hostId;

	@Column(length = 30, unique = false, nullable = false )
	private String name;
	
	@Column(length = 50, unique = true, nullable = false)
	private String email;
	
	@Column(length= 20, unique = false, nullable = false)
	private String password;
	
	@Column(length = 15 , unique = true , nullable = false)
	private String mobileNumber;
	
	@Column(length = 15 , unique = false , nullable = false)
	private String address;
	
	@Column(length=30,unique = true , nullable = false)
	private String govId;
	
	@Column(length = 30 , unique = false , nullable = false)
	private String role;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registerDate;
	
	@OneToMany
	@JoinColumn(name = "carId")
	private List<Car> car;

	public String getGovId() {
		return govId;
	}

	public void setGovId(String govId) {
		this.govId = govId;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
