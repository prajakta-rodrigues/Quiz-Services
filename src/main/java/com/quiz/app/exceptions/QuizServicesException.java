package com.quiz.app.exceptions;

public class QuizServicesException extends Exception {

  public QuizServicesException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public QuizServicesException(String message, Throwable cause) {
    super(message, cause);
  }

  public QuizServicesException(String message) {
    super(message);
  }

  public QuizServicesException(Throwable cause) {
    super(cause);
  }

  private static final long serialVersionUID = 1L;

}
