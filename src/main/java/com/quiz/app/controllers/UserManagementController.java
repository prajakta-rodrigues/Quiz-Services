package com.quiz.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.app.exceptions.QuizServicesException;
import com.quiz.app.services.UserManagementService;
import com.quiz.app.util.Jwt;
import com.quiz.app.vo.LoginResponse;
import com.quiz.app.vo.RegistrationResult;
import com.quiz.app.vo.UserLogin;
import com.quiz.app.vo.UserRegister;

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private Jwt jwtTokenUtil;
    
    @Autowired
    private UserManagementService userDetailsService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RegistrationResult> registerUser(@RequestBody UserRegister userRegister) {
	  try {
	     return new ResponseEntity<>(userManagementService.registerUser(userRegister), HttpStatus.OK);
	  }
	  catch(QuizServicesException qse) {
	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  
	  }
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<LoginResponse> login(@RequestBody UserLogin userLogin) {
	  try {
      authenticate(userLogin.getUsername(), userLogin.getPassword());
      final UserDetails userDetails = userDetailsService.loadUserByUsername(userLogin.getUsername());
      final String token = jwtTokenUtil.generateToken(userDetails);
      return ResponseEntity.ok(new LoginResponse(token));
	  } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	

    private void authenticate(String username, String password) throws QuizServicesException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new QuizServicesException("User is disabled", e);
        } catch (BadCredentialsException e) {
            throw new QuizServicesException("Invalid Credentials", e);
        }
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        // TO DO
        return "hello";
    }
	
}
