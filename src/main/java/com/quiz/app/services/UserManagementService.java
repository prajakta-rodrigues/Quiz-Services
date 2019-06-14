package com.quiz.app.services;

import com.quiz.app.vo.RegistrationResult;
import com.quiz.app.vo.UserRegister;

public interface UserManagementService {

	public RegistrationResult registerUser(UserRegister userRegister);
	
}
