package com.falgun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.falgun.exceptions.signUpException;
import com.falgun.model.Registration;
import com.falgun.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService cService;
	
	
	@PostMapping("/SignUp")
	public ResponseEntity<Registration> SignUp(@RequestBody Registration registration) throws signUpException {
		
		Registration signUp= cService.createCustomer(registration);
		
		
		return new ResponseEntity<Registration>(signUp,HttpStatus.CREATED);
	}
	
	
}
