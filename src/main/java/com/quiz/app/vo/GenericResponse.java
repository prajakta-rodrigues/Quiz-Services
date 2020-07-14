package com.quiz.app.vo;

public class GenericResponse {
  public GenericResponse(int status, String message) {
    super();
    this.status = status;
    this.message = message;
  }

  private int status;
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

}
