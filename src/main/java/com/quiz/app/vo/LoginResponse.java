package com.quiz.app.vo;

import java.io.Serializable;

public class LoginResponse implements Serializable {
	
	private static final long serialVersionUID = -4171889021974043445L;
	private final String token;
	
	public LoginResponse(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
	
	
}
