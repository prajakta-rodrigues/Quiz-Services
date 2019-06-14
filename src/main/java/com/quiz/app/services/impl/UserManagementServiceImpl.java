package com.quiz.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.domain.User;
import com.quiz.app.repositories.UserRepository;
import com.quiz.app.services.UserManagementService;
import com.quiz.app.vo.UserRegister;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean registerUser(UserRegister userRegister) {
		User user = new User();
		user.setEmail(userRegister.getEmail());
		user.setDateOfBirth(userRegister.getDateofBirth());
		user.setName(userRegister.getName());
		userRepository.save(user);
		//TO DO error handling
		return true;
	}

}
