package com.quiz.app.enums;

public enum Status {
	SUCCESS("Sucess", 200), FAILURE("Failure", 400);

	private String description;
	private int code;

	private Status(String description, int code) {
		this.description = description;
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	

}
