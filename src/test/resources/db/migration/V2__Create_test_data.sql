INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (1, 'Tom', NULL, 'Smith', 'American', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (2, 'Mike', NULL, 'Williamns', 'American', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (3, 'Michał', NULL, 'Nowak', 'Polish', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (4, 'Mikhail', NULL, '', 'Russian', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (5, 'Bart', NULL, 'Simpson', 'American', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (6, 'Richard', NULL, 'White', 'English', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (7, 'Henry', NULL, 'Yellow', 'English', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (8, 'Grzegorz', 'Jędrzej', 'Kowalski', 'Polish', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (9, 'Simon', NULL, 'Allard', 'French', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (10, 'Brian', 'Ronald', 'Clark', 'American', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');
INSERT INTO student(id, name, middle_name, surname, nationality, uuid) VALUES (11, 'Mario', NULL, 'Vario', 'Italian', 'fa56f0f4-94c6-4c2d-9d2c-84714084cafe');


INSERT INTO document(student_id, name, uuid) VALUES(1, 'Passport', '123e4567-e89b-13d3-a456-426655440000');
INSERT INTO document(student_id, name, uuid) VALUES(2, 'Passport', '0aeb83b6-9d63-11e6-80f5-76304dec7eb7');
INSERT INTO document(student_id, name, uuid) VALUES(3, 'Passport', '114bdd50-9d63-11e6-80f5-76304dec7eb7');
INSERT INTO document(student_id, name, uuid) VALUES(4, 'Id', '15f7e9de-9d63-11e6-80f5-76304dec7eb7');
INSERT INTO document(student_id, name, uuid) VALUES(5, 'Id', '1b8574de-9d63-11e6-80f5-76304dec7eb7');
INSERT INTO document(student_id, name, uuid) VALUES(6, 'Id', '224e6ea6-9d63-11e6-80f5-76304dec7eb7');
INSERT INTO document(student_id, name, uuid) VALUES(6, 'Criminal Record', '268c8304-9d63-11e6-80f5-76304dec7eb7');
INSERT INTO document(student_id, name, uuid) VALUES(7, 'Passport', '268c8304-9d63-11e6-80f5-76304dec7eb7');
INSERT INTO document(student_id, name, uuid) VALUES(8, 'Id', '123e4567-189b-12d3-a456-426655440000');

INSERT INTO course(id, name) VALUES(1, 'Algebra');
INSERT INTO course(id, name) VALUES(2, 'Algorithms');
INSERT INTO course(id, name) VALUES(3, 'AI');
INSERT INTO course(id, name) VALUES(4, 'Functional Programming');
INSERT INTO course(id, name) VALUES(5, 'Bioinformatics');
INSERT INTO course(id, name) VALUES(6, 'Calculus');

INSERT INTO semester(id, year, part) VALUES(1, 2013, 'Winter');
INSERT INTO semester(id, year, part) VALUES(2, 2014, 'Summer');
INSERT INTO semester(id, year, part) VALUES(3, 2014, 'Winter');
INSERT INTO semester(id, year, part) VALUES(4, 2015, 'Summer');
INSERT INTO semester(id, year, part) VALUES(5, 2015, 'Winter');
INSERT INTO semester(id, year, part) VALUES(6, 2016, 'Summer');
INSERT INTO semester(id, year, part) VALUES(7, 2016, 'Winter');

INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(1,1,1,1);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(2,1,1,2);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(3,1,1,3);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(4,1,2,3);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(5,1,2,4);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(6,1,3,3);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(7,1,3,4);

INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(8,2,1,1);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(9,2,1,2);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(10,2,1,3);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(11,2,2,3);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(12,2,2,4);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(13,2,3,3);
INSERT INTO student_course_segment(id, student_id, course_id, semester_id) values(14,2,3,4);

INSERT INTO grade(student_course_segment_id, grade) VALUES(1, 5);
INSERT INTO grade(student_course_segment_id, grade) VALUES(2, 5);
INSERT INTO grade(student_course_segment_id, grade) VALUES(3, 5);
INSERT INTO grade(student_course_segment_id, grade) VALUES(4, 5);
INSERT INTO grade(student_course_segment_id, grade) VALUES(5, 5);
INSERT INTO grade(student_course_segment_id, grade) VALUES(6, 5);
INSERT INTO grade(student_course_segment_id, grade) VALUES(7, 4);

INSERT INTO grade(student_course_segment_id, grade) VALUES(8, 3);
INSERT INTO grade(student_course_segment_id, grade) VALUES(9, 4);
INSERT INTO grade(student_course_segment_id, grade) VALUES(10, 3);
INSERT INTO grade(student_course_segment_id, grade) VALUES(11, 3);
INSERT INTO grade(student_course_segment_id, grade) VALUES(12, 4);
INSERT INTO grade(student_course_segment_id, grade) VALUES(13, 4);
INSERT INTO grade(student_course_segment_id, grade) VALUES(14, 3);
