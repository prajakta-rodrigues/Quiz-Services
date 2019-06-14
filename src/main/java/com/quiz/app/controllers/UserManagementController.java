package com.quiz.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.services.UserManagementService;
import com.quiz.app.vo.RegistrationResult;
import com.quiz.app.vo.UserRegister;

@RestController
@RequestMapping(value = "/user")
public class UserManagementController {
	
	@Autowired
	private UserManagementService userManagementService;
	
	@RequestMapping(value = "/register", method= RequestMethod.POST)
    @ResponseBody
	public RegistrationResult registerUser(UserRegister userRegister) {
		//TO DO error handling
		return userManagementService.registerUser(userRegister);
	}
	
	@RequestMapping(value = "/login", method= RequestMethod.GET)
	public void login() {
		//TO DO
	}

}
