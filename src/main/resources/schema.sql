CREATE DATABASE IF NOT EXISTS school;

DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS course_students;

CREATE TABLE IF NOT EXISTS students  (
    id BIGINT NOT NULL PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT key_students_code UNIQUE (code)
);

CREATE TABLE IF NOT EXISTS courses  (
    id BIGINT NOT NULL PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT key_courses_code UNIQUE (code),
    CONSTRAINT key_courses_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS  course_students  (
    id BIGINT NOT NULL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    CONSTRAINT key_course_students_code_name UNIQUE (student_id,course_id)
);

INSERT INTO students (code, name) VALUES
 (1,'S001','JOHN'),
 (2,'S002','PETER'),
 (3,'S003','ROBERT'),
 (4,'S004','TUSHER'),
 (5,'S005','JUAN'),
 (6,'S006','INNA'),
 (7,'S007','RONALDO'),
 (8,'S008','MESSI'),
 (9,'S009','MBAPPE'),
 (10,'S010','NEYMER');

INSERT INTO courses (code, name) VALUES
 (1,'C001','CSE'),
 (2,'C002','Physics'),
 (3,'C003','Math'),
 (4,'C004','User'),
 (5,'C005','Chemistry'),
 (6,'C006','Biology'),
 (7,'C007','Database'),
 (8,'C008','Computer'),
 (9,'C009','Numerical Analysis'),
 (10,'C010','Number Theory');


INSERT INTO course_students (code, name) VALUES
 (1,1,1),
 (1,1,2),
 (1,1,3),
 (1,1,4),
 (1,1,5),
 (1,2,1),
 (1,2,2),
 (1,2,3),
 (1,2,4),
 (1,2,5);
