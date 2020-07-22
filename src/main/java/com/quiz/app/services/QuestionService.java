package com.quiz.app.services;

import com.quiz.app.vo.CreateQuestionRequest;
import com.quiz.app.vo.GenericResponse;

public interface QuestionService {
  public GenericResponse addQuestion(CreateQuestionRequest createQuestionRequest);
}
