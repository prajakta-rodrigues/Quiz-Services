package com.quiz.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quiz.app.domain.QuestionnaireOptions;

@Repository
public interface QuestionnaireOptionsRepository extends JpaRepository<QuestionnaireOptions, Long> {

}
