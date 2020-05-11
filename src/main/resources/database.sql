create schema quiz;

CREATE TABLE quiz.User (
    id INT PRIMARY KEY,
    email VARCHAR(30) unique,
    name VARCHAR(50) not null,
    dob DATE not null,
    created_date TIMESTAMP,
    password VARCHAR(200) not null,
    points INT
);

CREATE TABLE quiz.category (
    id INT PRIMARY KEY,
    description VARCHAR(100),
    title VARCHAR(15)
);
						  

CREATE TABLE quiz.Questionnaire (
    id INT PRIMARY KEY,
    creator_id INT REFERENCES quiz.user (id),
    created_date TIMESTAMP,
    category_id INT REFERENCES quiz.category (id),
    information VARCHAR(200),
    thumbnail VARCHAR(200)
);

CREATE TABLE quiz.Questionnaire_questions (
    id INT PRIMARY KEY,
    questionaire_id INT REFERENCES quiz.questionnaire (id),
    question_description VARCHAR(250)
);

CREATE TABLE quiz.Questionnaire_options (
    id INT PRIMARY KEY,
    question_id INT REFERENCES quiz.questionnaire_questions (id),
    option_description VARCHAR(200),
    option_image VARCHAR(200)
);

CREATE TABLE quiz.Questionnaire_answers (
	id INT PRIMARY KEY,
    question_id INT REFERENCES quiz.Questionnaire_questions (id),
    option_id INT REFERENCES quiz.Questionnaire_options (id)
);

CREATE TABLE quiz.questionnaire_Respondent (
    id INT PRIMARY KEY,
    user_id INT REFERENCES quiz.user (id),
    questionnaire_id INT REFERENCES quiz.questionnaire (id),
    result_description VARCHAR(250),
    score INT
); 





