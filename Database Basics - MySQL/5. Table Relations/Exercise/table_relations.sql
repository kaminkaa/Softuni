create database test;
use test;

/* ###### 1 One-to-One relationship -> UNIQUE ###### */ 
CREATE TABLE persons (
    person_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    salary DECIMAL(10 , 2 ),
    passport_id INT UNIQUE
);

CREATE TABLE passports (
    passport_id INT PRIMARY KEY AUTO_INCREMENT,
    passport_number VARCHAR(20)
);

INSERT INTO persons(person_id,first_name,salary,passport_id) VALUES 
(1,"Roberto", 43300.00,102),(2,"Tom", 56100.00,103),(3,"Yana", 60200.00,101);

INSERT INTO passports(passport_id, passport_number) VALUES 
(101, "N34FG21B"),(102, "K65LO4R7"),(103, "ZE657QP2");

ALTER TABLE persons
ADD CONSTRAINT fk_passport_id
FOREIGN KEY(passport_id) REFERENCES passports(passport_id);

/* ###### 2 One-to-Many relationship ###### */ 
CREATE TABLE manufacturers (
    manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    established_on DATE
);

CREATE TABLE models (
    model_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    manufacturer_id INT
);

INSERT INTO manufacturers(manufacturer_id, name, established_on) VALUES 
(1,"BMW",01/03/1916), (2,"Tesla",01/01/2003), (3,"Lada",01/05/1966);

INSERT INTO models(model_id, name, manufacturer_id) VALUES
(101,"x1",1), (102,"i6",1), (103,"model s",2), (104,"model x",2), (105,"model 3",2), (106,"nova",3);

ALTER TABLE models
ADD CONSTRAINT fk_manufacturer_id
FOREIGN KEY(manufacturer_id) REFERENCES manufacturers(manufacturer_id);

/* ###### 3 Many-to-Many relationship ###### */ 
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE exams (
    exam_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE students_exams (
    exam_id INT,
    student_id INT,
    CONSTRAINT pk_students_exams PRIMARY KEY (exam_id , student_id),
    CONSTRAINT fk_students_exams_students FOREIGN KEY (student_id)
        REFERENCES students (student_id),
    CONSTRAINT fk_students_exams_exams FOREIGN KEY (exam_id)
        REFERENCES exams (exam_id)
);