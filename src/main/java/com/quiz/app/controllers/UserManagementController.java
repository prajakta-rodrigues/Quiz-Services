package com.quiz.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserManagementController {
	
	@RequestMapping(value = "/register", method= RequestMethod.POST )
	public void register() {
		
	}
	
	@RequestMapping(value = "/login")
	public void login() {
		
	}

}
