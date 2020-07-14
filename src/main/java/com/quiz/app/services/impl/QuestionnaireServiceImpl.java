package com.quiz.app.services.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.quiz.app.domain.Category;
import com.quiz.app.domain.Questionnaire;
import com.quiz.app.domain.User;
import com.quiz.app.enums.Status;
import com.quiz.app.repositories.CategoryRepository;
import com.quiz.app.repositories.QuestionnaireRepository;
import com.quiz.app.repositories.UserRepository;
import com.quiz.app.services.QuestionnaireService;
import com.quiz.app.vo.CreateQuestionnaireRequest;
import com.quiz.app.vo.GenericResponse;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

  @Autowired
  CategoryRepository categoryRepository;

  @Autowired
  QuestionnaireRepository questionnaireRepository;
  
  @Autowired
  UserRepository userRepository;
  
  @Override
  public GenericResponse createQuestionnaire(CreateQuestionnaireRequest createQuestionaireRequest) {
    try
    {
      Questionnaire questionnaire = new Questionnaire();
      Optional<Category> category =
          categoryRepository.findById(createQuestionaireRequest.getCategoryId());
      System.out.println("1");
      questionnaire.setCategoryId(category.get());
      questionnaire.setInformation(createQuestionaireRequest.getInformation());
      questionnaire.setThumbnail(createQuestionaireRequest.getThumbnail());
      questionnaire.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
      String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
      List<User> userList = userRepository.findByUsername(currentUsername);
      if (!userList.isEmpty()) {
        questionnaire.setCreator(userList.get(0));
      }
      questionnaireRepository.save(questionnaire);
      return new GenericResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getDescription());
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
      throw e;
    }
  }

}
