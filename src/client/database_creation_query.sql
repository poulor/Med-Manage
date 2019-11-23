-- drop database if exists javabook;
create database MedicalClient;
-- drop user if exists 'scott'@'localhost';
-- create user 'scott'@'localhost' identified by 'tiger';
-- grant select, insert, update, delete, create, create view, drop, execute, references on javabook.* to 'scott'@'localhost';

use MedicalClient;
-- drop table if exists Student;
-- drop table if exists Course;
-- drop table if exists Enrollment;

create table Users ( 
  firstName varchar(25), 
  midName char(1), 
  lastName varchar(25), 
  phone char(11),  
  birthDate date,  
  street varchar(25), 
  zipCode char(5),
  deptId char(4),  
  primary key (ssn)
); 

create table Administrators (
  courseId char(5),
  subjectId char(4) not null, 
  courseNumber integer, 
  title varchar(50) not null, 
  numOfCredits integer, 
  primary key (courseId)
);

create table Appointments (
  courseId char(5),
  subjectId char(4) not null, 
  courseNumber integer, 
  title varchar(50) not null, 
  numOfCredits integer, 
  primary key (courseId)
);
create table Doctors (
  ssn char(9), 
  courseId char(5),
  dateRegistered date,  
  grade char(1),
  primary key (ssn, courseId),
  foreign key (ssn) references Student(ssn),
  foreign key (courseId) references Course(courseId)
); 

create table Patients (
  ssn char(9), 
  courseId char(5),
  dateRegistered date,  
  grade char(1),
  primary key (ssn, courseId),
  foreign key (ssn) references Student(ssn),
  foreign key (courseId) references Course(courseId)
); 

create table Receptionists (
  ssn char(9), 
  courseId char(5),
  dateRegistered date,  
  grade char(1),
  primary key (ssn, courseId),
  foreign key (ssn) references Student(ssn),
  foreign key (courseId) references Course(courseId)
); 

insert into Student values (
  '444111110', 'Jacob', 'R', 'Smith', null,
  '1985-04-09', '99 Kingston Street', '31435', 'BIOL');
insert into Student values (
  '444111111', 'John', 'K', 'Stevenson', '9129219434',
  null, '100 Main Street', '31411', 'BIOL');
insert into Student values (
  '444111112', 'George', 'R', 'Heintz', '9129213454',
  '1974-10-10', '1200 Abercorn Street', '31419', 'CS');
insert into Student values (
  '444111113', 'Frank', 'E', 'Jones', '9125919434',
  '1970-09-09', '100 Main Street', '31411', 'BIOL');
insert into Student values (
  '444111114', 'Jean', 'K', 'Smith', '9129219434',
  '1970-02-09', '100 Main Street', '31411', 'CHEM');
insert into Student values (
  '444111115', 'Josh', 'R', 'Woo', '7075989434',
  '1970-02-09', '555 Franklin Street', '31411', 'CHEM');
insert into Student values (
  '444111116', 'Josh', 'R', 'Smith', '9129219434',
  '1973-02-09', '100 Main Street', '31411', 'BIOL');
insert into Student values (
  '444111117', 'Joy', 'P', 'Kennedy', '9129229434',
  '1974-03-19', '103 Bay Street', '31412', 'CS');
insert into Student values (
  '444111118', 'Toni', 'R', 'Peterson', '9129229434',
  '1964-04-29', '103 Bay Street', '31412', 'MATH');
insert into Student values (
  '444111119', 'Patrick', 'R', 'Stoneman', null,
  '1969-04-29', '101 Washington Street', '31435', 'MATH');
insert into Student values (
  '444111120', 'Rick', 'R', 'Carter', null,
  '1986-04-09', '19 West Ford Street', '31411', 'BIOL');



insert into Course values (
  '11111', 'CSCI', '1301', 'Intro to Java I', 4);
insert into Course values (
  '11112', 'CSCI', '1302', 'Intro to Java II', 3);
insert into Course values (
  '11113', 'CSCI', '4720', 'Database Systems', 3);
insert into Course values (
  '11114', 'CSCI', '4750', 'Rapid Java Application', 3);
insert into Course values (
  '11115', 'MATH', '2750', 'Calculus I', 5);
insert into Course values (
  '11116', 'MATH', '3750', 'Calculus II', 5);
insert into Course values (
  '11117', 'EDUC', '1111', 'Reading', 3);
insert into Course values (
  '11118', 'ITEC', '1344', 'Database Administration', 3);

insert into Enrollment values (
  '444111110', '11111', now(), 'A');
/* In MS Access, replace now() by date() */
insert into Enrollment values (
  '444111110', '11112', now(), 'B');
insert into Enrollment values (
  '444111110', '11113', now(), 'C');
insert into Enrollment values (
  '444111111', '11111', now(), 'D');
insert into Enrollment values (
  '444111111', '11112', now(), 'F');
insert into Enrollment values (
  '444111111', '11113', now(), 'A');
insert into Enrollment values (
  '444111112', '11111', now(), null);
insert into Enrollment values (
  '444111112', '11112', now(), null);
insert into Enrollment values (
  '444111112', '11114', now(), 'B');
insert into Enrollment values (
  '444111112', '11115', now(), 'C');
insert into Enrollment values (
  '444111112', '11116', now(), null);
insert into Enrollment values (
  '444111113', '11111', now(), null);
insert into Enrollment values (
  '444111113', '11113', now(), null);
insert into Enrollment values (
  '444111114', '11115', now(), null);
insert into Enrollment values (
  '444111115', '11115', now(), null);
insert into Enrollment values (
  '444111115', '11116', now(), null);
insert into Enrollment values (
  '444111116', '11111', now(), null);
insert into Enrollment values (
  '444111117', '11111', now(), null);
insert into Enrollment values (
  '444111118', '11111', now(), null);
insert into Enrollment values (
  '444111118', '11112', now(), null);
insert into Enrollment values (
  '444111118', '11113', now(), null);

