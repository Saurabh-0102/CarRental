package com.car.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String email) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("Demo Subject"); 
        message.setText("Hello how are you");
        emailSender.send(message);
    }
    
    public void sendMail(String email,String otp) {
    	SimpleMailMessage m = new SimpleMailMessage();
    	m.setTo(email);
    	m.setSubject("Otp verification");
    	m.setText(otp);
    	emailSender.send(m);
    }
    
    
    public void sendEmailForNewRegistration(String email) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("Thank you for Registering with us!"); 
        message.setText("Thank you for Registering with us!");
        emailSender.send(message);
	 }

    
    
}