DROP DATABASE IF EXISTS MedicalClient;
CREATE DATABASE MedicalClient;
-- drop user IF EXISTS 'scott'@'localhost';
-- create user 'scott'@'localhost' identified by 'tiger';
-- grant select, insert, upDATE, delete, create, create view, drop, execute, REFERENCES on javabook.* to 'scott'@'localhost';

USE MedicalClient;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Administrators;
DROP TABLE IF EXISTS Appointments;
DROP TABLE IF EXISTS Doctors;
DROP TABLE IF EXISTS Patients;
DROP TABLE IF EXISTS Receptionists;


CREATE TABLE Users ( 
	user_id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(25), 
	middle_name VARCHAR(1), 
	last_name VARCHAR(25),
	gender VARCHAR(6). 
	phone_number VARCHAR(11),  
	birth_date DATE,  
	street VARCHAR(25), 
	zip_code VARCHAR(5),
	username VARCHAR   
	passwd VARCHAR   
	user_type int
	PRIMARY KEY (user_id)
); 


CREATE TABLE Administrators (
	administrator_id INT NOT NULL AUTO_INCREMENT,
	join_DATE DATE,
	PRIMARY KEY (administrator_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Receptionists (
	receptionist_id INT NOT NULL AUTO_INCREMENT,
	join_DATE DATE,
	PRIMARY KEY (receptionist_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Doctors (
	doctor_id INT NOT NULL AUTO_INCREMENT,
	join_date DATE,
	specialty VARCHAR(15),
	department VARCHAR(15),
	PRIMARY KEY (doctor_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Patients (
	patient_id INT NOT NULL AUTO_INCREMENT,
	ht DOUBLE,
	wt DOUBLE,
	medications VARCHAR(150)
	health_history VARCHAR(500),
	notes VARCHAR(500),
	PRIMARY KEY (patient_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Appointments (
	appointment_id INT NOT NULL AUTO_INCREMENT,
	appointment_date DATE,
	appointment_time TIMESTAMP,
	notes VARCHAR(500),
	PRIMARY KEY (appointment_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id),
	FOREIGN KEY (patient_id) REFERENCES Patients(patient_id)

	
);
