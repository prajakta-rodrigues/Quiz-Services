package com.quiz.app.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.quiz.app.vo.CreateQuestionnaireRequest;
import com.quiz.app.vo.GenericResponse;


public interface QuestionnaireService {
  
  public GenericResponse createQuestionnaire(CreateQuestionnaireRequest createQuestionaireRequest);
}
