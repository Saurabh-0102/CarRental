package com.car.rental.service.demo;

import java.util.Random;

public class Practice {

	public static String otp;
	
	public String generateotp() {
		Random r = new Random();
		String number = "1234567890abcdeghijklmnopqrstuvwxyz";
		otp = "";
		for(int i = 0; i<6 ; i++) {
		char ch = number.charAt(r.nextInt(number.length()));
		otp = otp + ch;
		}
		return otp;
	}
	
	public static void main(String[] args) {
		Practice p = new Practice();
		System.out.println(p.generateotp());
	}
	
}
