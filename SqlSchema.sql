CREATE DATABASE quiz_app;

USE quiz_app;

CREATE TABLE questions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  question_text VARCHAR(255) NOT NULL
);

CREATE TABLE answers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  question_id INT,
  answer_text VARCHAR(255) NOT NULL,
  is_correct BOOLEAN,
  FOREIGN KEY (question_id) REFERENCES questions(id)
);

-- Insert 10 General Knowledge questions

-- Question 1: What is the capital of France?
INSERT INTO questions (question_text) VALUES ('What is the capital of France?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (1, 'Paris', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (1, 'London', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (1, 'Berlin', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (1, 'Madrid', false);

-- Question 2: Who is the president of the United States?
INSERT INTO questions (question_text) VALUES ('Who is the president of the United States?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (2, 'Joe Biden', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (2, 'Donald Trump', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (2, 'Barack Obama', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (2, 'George W. Bush', false);

-- Question 3: What is the largest planet in our solar system?
INSERT INTO questions (question_text) VALUES ('What is the largest planet in our solar system?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (3, 'Jupiter', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (3, 'Earth', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (3, 'Saturn', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (3, 'Mars', false);

-- Question 4: Who wrote "Romeo and Juliet"?
INSERT INTO questions (question_text) VALUES ('Who wrote "Romeo and Juliet"?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (4, 'William Shakespeare', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (4, 'Charles Dickens', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (4, 'Mark Twain', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (4, 'Jane Austen', false);

-- Question 5: What is the smallest country in the world?
INSERT INTO questions (question_text) VALUES ('What is the smallest country in the world?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (5, 'Vatican City', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (5, 'Monaco', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (5, 'Nauru', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (5, 'San Marino', false);

-- Question 6: In which continent is the Sahara Desert located?
INSERT INTO questions (question_text) VALUES ('In which continent is the Sahara Desert located?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (6, 'Africa', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (6, 'Asia', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (6, 'Australia', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (6, 'North America', false);

-- Question 7: Who invented the telephone?
INSERT INTO questions (question_text) VALUES ('Who invented the telephone?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (7, 'Alexander Graham Bell', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (7, 'Thomas Edison', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (7, 'Nikola Tesla', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (7, 'Marie Curie', false);

-- Question 8: What is the longest river in the world?
INSERT INTO questions (question_text) VALUES ('What is the longest river in the world?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (8, 'Amazon River', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (8, 'Nile River', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (8, 'Yangtze River', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (8, 'Mississippi River', false);

-- Question 9: What is the currency of Japan?
INSERT INTO questions (question_text) VALUES ('What is the currency of Japan?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (9, 'Yen', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (9, 'Won', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (9, 'Ringgit', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (9, 'Peso', false);

-- Question 10: Which planet is known as the "Red Planet"?
INSERT INTO questions (question_text) VALUES ('Which planet is known as the "Red Planet"?');
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (10, 'Mars', true);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (10, 'Venus', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (10, 'Jupiter', false);
INSERT INTO answers (question_id, answer_text, is_correct) VALUES (10, 'Saturn', false);
