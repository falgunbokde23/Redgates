package com.falgun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.falgun.exceptions.LoginException;
import com.falgun.model.LoginDTO;
import com.falgun.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService uLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = uLogin.logIntoAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	@PostMapping("/logout")
	public String logout(@RequestParam(required = false) String key) throws LoginException {
		return uLogin.logOutFromAccount(key);
		
	}
	
	
	
}
