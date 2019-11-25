drop database if exists MedicalClient;
create database MedicalClient;
-- drop user if exists 'scott'@'localhost';
-- create user 'scott'@'localhost' identified by 'tiger';
-- grant select, insert, update, delete, create, create view, drop, execute, references on javabook.* to 'scott'@'localhost';

use MedicalClient;
drop table if exists Users;
drop table if exists Administrators;
drop table if exists Appointments;
drop table if exists Doctors;
drop table if exists Patients;
drop table if exists Receptionists;


create table Users ( 
  user_id INT NOT NULL AUTO_INCREMENT,
  first_name varchar(25), 
  middle_name char(1), 
  last_name varchar(25), 
  phone char(11),  
  birth_date date,  
  street varchar(25), 
  zip_code char(5),
  deptId char(4),  
  primary key (user_id)


  first_name varchar
  
  middle_name varchar
  
  last_name varchar
  
  gender varchar

  username varchar   

  password varchar   

  user_type int 
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

insert into Course values (
  '11111', 'CSCI', '1301', 'Intro to Java I', 4);
insert into Course values (
  '11112', 'CSCI', '1302', 'Intro to Java II', 3);

insert into Enrollment values (
  '444111110', '11111', now(), 'A');
/* In MS Access, replace now() by date() */
insert into Enrollment values (
  '444111110', '11112', now(), 'B');
