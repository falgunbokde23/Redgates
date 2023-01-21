package com.falgun.service;

import com.falgun.exceptions.signUpException;
import com.falgun.model.Registration;

public interface RegistrationService {
	
	
	public Registration createCustomer(Registration registration)throws signUpException;
	
}
