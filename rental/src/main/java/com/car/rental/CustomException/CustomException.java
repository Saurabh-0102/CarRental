package com.car.rental.CustomException;

import java.util.function.Supplier;

public class CustomException extends RuntimeException {

	public CustomException(String msg){
		super(msg);
	}

}
