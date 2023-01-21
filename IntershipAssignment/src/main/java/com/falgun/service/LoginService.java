package com.falgun.service;

import com.falgun.exceptions.LoginException;
import com.falgun.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
