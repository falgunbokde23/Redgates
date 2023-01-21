package com.falgun.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.falgun.dao.RegistrationDao;
import com.falgun.dao.SessionDao;
import com.falgun.exceptions.LoginException;
import com.falgun.model.CurrentUserSession;
import com.falgun.model.Registration;
import com.falgun.model.LoginDTO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private RegistrationDao rDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException{
		
		
		Registration existingCustomer= rDao.findByMobileNo(dto.getMobileNo());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
			
		}
			
		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getRegistrationId());
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getRegistrationId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	}


	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}

}
