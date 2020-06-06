package com.quiz.app.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.quiz.app.domain.User;
import com.quiz.app.enums.Status;
import com.quiz.app.exceptions.QuizServicesException;
import com.quiz.app.repositories.UserRepository;
import com.quiz.app.services.UserManagementService;
import com.quiz.app.vo.PrimaryUser;
import com.quiz.app.vo.RegistrationResult;
import com.quiz.app.vo.UserRegister;

@Service
public class UserDetailsServiceImpl implements UserManagementService {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private PasswordEncoder pwdEncoder; 

  @Override
  public RegistrationResult registerUser(UserRegister userRegister) throws QuizServicesException {
    User user = new User();

    if (null != userRegister.getUsername()) {
      user.setUsername(userRegister.getUsername());
    }
    if (null != userRegister.getName()) {
      user.setName(userRegister.getName());
    } else {
      new QuizServicesException("User name is null");
    }
    if (null != userRegister.getPassword()) {
      user.setPassword(pwdEncoder.encode(userRegister.getPassword()));
    } else {
      new Exception("Password is null");
    }
    RegistrationResult registrationResult = new RegistrationResult();

    try {
      userRepository.save(user);
      registrationResult.setDescription(Status.SUCCESS.getDescription());
      registrationResult.setResultCode(Status.SUCCESS.getCode());
    } catch (Exception e) {
      registrationResult.setDescription(Status.FAILURE.getDescription());
      registrationResult.setResultCode(Status.FAILURE.getCode());
    }

    return registrationResult;
  }

  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<User> userList = userRepository.findByUsername(username);
    if (userList.isEmpty()) {
      throw new UsernameNotFoundException("No user available with given username");
    } else {
      UserDetails userDetails = new PrimaryUser(userList.get(0));
      return userDetails;
    }
  }

}
