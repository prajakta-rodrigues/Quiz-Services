package com.quiz.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.app.services.QuestionnaireService;
import com.quiz.app.vo.CreateQuestionnaireRequest;
import com.quiz.app.vo.GenericResponse;

@RestController
public class QuestionaireController {

  @Autowired
  private QuestionnaireService questionnaireService;

  @RequestMapping(value = "/createQuestionnaire", method = RequestMethod.POST)
  public ResponseEntity<GenericResponse> createQuestionaire(
      @RequestBody CreateQuestionnaireRequest createQuestionaireRequest) {
    try {
      return new ResponseEntity<>(
          questionnaireService.createQuestionnaire(createQuestionaireRequest), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }
  
  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test() {
      // TO DO
      return "hello";
  }

}
