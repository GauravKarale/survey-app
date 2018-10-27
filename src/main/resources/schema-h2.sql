CREATE TABLE survey (
	id  INTEGER PRIMARY KEY,
	start_date DATE,
	end_date DATE,
	description VARCHAR(600)
);

CREATE TABLE questions (
	QUESTION_ID INTEGER PRIMARY KEY ,
	text VARCHAR(600)
);

CREATE TABLE survey_questions(
	survey_id INTEGER ,
	question_id INTEGER 
);


CREATE TABLE answer(
   QUESTION_ID INTEGER ,
   ANSWER_ID INTEGER  ,
   ANSWER_TEXT VARCHAR(600),
   PRIMARY KEY (QUESTION_ID, ANSWER_ID)
);


/*CREATE TABLE question_answer(
   QUESTION_ID  INTEGER,
   ANSWER_ID INTEGER
);*/

CREATE TABLE response(
    response_id INTEGER PRIMARY KEY ,
	survey_id INTEGER ,
	question_id INTEGER ,
	user_id INTEGER ,
	answer_id INTEGER ,
);

