create schema quiz;

create table quiz.User(id int primary key,
email varchar(30),
name varchar(50),
dob date,
created_date timestamp,
password varchar(100),
points int);

create table quiz.category(id int primary key,
						  description varchar(100), title varchar(15));
						  

create table quiz.Questionnaire(
id int primary key,
creator_id int references quiz.user(id),
created_date timestamp,
category_id int references quiz.category(id),
information varchar(200),
thumbnail varchar(200));

create table quiz.Questionnaire_questions(
id int primary key,
questionaire_id int references quiz.questionnaire(id),
question_description varchar(250));

create table quiz.Questionnaire_options(id int primary key,
question_id int references quiz.questionnaire_questions(id),
text varchar(200),
option_image varchar(200),
is_answer boolean
);

create table quiz.questionnaire_Respondent(id int primary key,
user_id int references quiz.user(id),
questionnaire_id int references quiz.questionnaire(id),
result_description varchar(250),										 
score int); 





