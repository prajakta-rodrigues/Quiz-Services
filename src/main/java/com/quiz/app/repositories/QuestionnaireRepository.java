package com.quiz.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quiz.app.domain.Questionnaire;
import com.quiz.app.domain.User;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

}
