package com.quiz.app.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.quiz.app.exceptions.QuizServicesException;
import com.quiz.app.vo.RegistrationResult;
import com.quiz.app.vo.UserRegister;

public interface UserManagementService extends UserDetailsService {

  public RegistrationResult registerUser(UserRegister userRegister) throws QuizServicesException;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
