package com.quiz.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quiz.app.domain.QuestionnaireQuestion;

@Repository
public interface QuestionnaireQuestionRepository extends JpaRepository<QuestionnaireQuestion, Long> {

}
