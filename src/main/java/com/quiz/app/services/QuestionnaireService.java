package com.quiz.app.services;

import com.quiz.app.vo.CreateQuestionnaireRequest;
import com.quiz.app.vo.GenericResponse;


public interface QuestionnaireService {
  
  public GenericResponse createQuestionnaire(CreateQuestionnaireRequest createQuestionaireRequest);
}
