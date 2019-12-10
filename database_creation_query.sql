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
	gender VARCHAR(6), 
	birth_date DATE,
	phone_number VARCHAR(11),  
	street VARCHAR(25),
	city VARCHAR(25),
	US_state VARCHAR(25),
	zip_code INT(5),
	email VARCHAR(30),
	username VARCHAR(10),   
	passwd VARCHAR(16),   
	user_type VARCHAR(20),
	PRIMARY KEY (user_id)
); 

CREATE TABLE Administrators (
	administrator_id INT NOT NULL AUTO_INCREMENT,
	join_date DATE,
	user_id INT,
	PRIMARY KEY (administrator_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Receptionists (
	receptionist_id INT NOT NULL AUTO_INCREMENT,
	join_date DATE,
	user_id INT,
	PRIMARY KEY (receptionist_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Doctors (
	doctor_id INT NOT NULL AUTO_INCREMENT,
	join_date DATE,
	specialty VARCHAR(15),
	department VARCHAR(15),
	user_id INT,
	PRIMARY KEY (doctor_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Patients (
	patient_id INT NOT NULL AUTO_INCREMENT,
	ht DOUBLE,
	wt DOUBLE,
	medications VARCHAR(500),
	health_history VARCHAR(500),
	notes VARCHAR(500),
	user_id INT,
	doctor_id INT,
	PRIMARY KEY (patient_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Appointments (
	appointment_id INT NOT NULL AUTO_INCREMENT,
	appointment_date DATE,
	appointment_time TIMESTAMP,
	notes VARCHAR(500),
	doctor_id INT,
	patient_id INT,
	PRIMARY KEY (appointment_id),
	FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id),
	FOREIGN KEY (patient_id) REFERENCES Patients(patient_id)
);
