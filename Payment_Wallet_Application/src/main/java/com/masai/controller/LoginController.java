package com.masai.controller;


import com.masai.exception.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@Valid @RequestBody LoginDTO dto) throws LoginException {
		String result = customerLogin.logIntoAccount(dto);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@Valid @RequestParam String key) throws LoginException {
		String result = customerLogin.logOutFromAccount(key);
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
	}
}
