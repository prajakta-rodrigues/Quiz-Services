package com.quiz.app.services.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.app.domain.Questionnaire;
import com.quiz.app.domain.QuestionnaireOptions;
import com.quiz.app.domain.QuestionnaireQuestion;
import com.quiz.app.enums.Status;
import com.quiz.app.repositories.QuestionnaireOptionsRepository;
import com.quiz.app.repositories.QuestionnaireQuestionRepository;
import com.quiz.app.repositories.QuestionnaireRepository;
import com.quiz.app.services.QuestionService;
import com.quiz.app.vo.CreateQuestionRequest;
import com.quiz.app.vo.GenericResponse;
import com.quiz.app.vo.Option;

@Service
public class QuestionServiceImpl implements QuestionService {

  @Autowired
  private QuestionnaireRepository questionnaireRepository;
  
  @Autowired
  private QuestionnaireQuestionRepository questionnaireQuestionRepository;
  
  @Autowired
  private QuestionnaireOptionsRepository questionnaireOptionsRepository; 
  
  @Override
  @Transactional
  public GenericResponse addQuestion(CreateQuestionRequest createQuestionRequest) {
    Questionnaire questionnaire = questionnaireRepository.getOne(createQuestionRequest.getQuestionnaireId());
    QuestionnaireQuestion question = new QuestionnaireQuestion();
    question.setQuestionnaire(questionnaire);
    question.setQuestionDescription(createQuestionRequest.getQuestionDescription());
    questionnaireQuestionRepository.save(question);
    QuestionnaireOptions questionnaireOptions = null;
    for(Option op: createQuestionRequest.getQuestionOptions()) {
      questionnaireOptions = new QuestionnaireOptions();
      questionnaireOptions.setQuestion(question);
      questionnaireOptions.setText(op.getText());
      questionnaireOptions.setOptionImage(op.getOptionImage());
      questionnaireOptions.setIsAnswer(op.getIsAnswer());
      questionnaireOptionsRepository.save(questionnaireOptions);
    }
    return new GenericResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getDescription());
  }

}
