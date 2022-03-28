package com.car.rental.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_car")
public class Car{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int carId;
	
	@Column(length = 30, unique = false, nullable = false )
	private String carName;
	
	@Column(length = 30, unique = false, nullable = false )
	private String type;
	
	@Column(nullable = false)
	private int noOfSeats;
	
	@Enumerated(EnumType.STRING)
	private CarType carType;
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}


	
	
	
	
	
	
	
}
