package com.falgun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falgun.dao.RegistrationDao;
import com.falgun.dao.SessionDao;
import com.falgun.exceptions.signUpException;
import com.falgun.model.CurrentUserSession;
import com.falgun.model.Registration;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao rDao;
	
	
	
	
	@Override
	public Registration createCustomer(Registration registration)throws signUpException {
		
		
		Registration existingCustomer= rDao.findByMobileNo(registration.getMobileNo());
		
		
		
		if(existingCustomer != null) 
			throw new signUpException("You Are Already Registered with Mobile number");
			
		
		
		
			return rDao.save(registration);
			
			
		}


		
		
		
	}


