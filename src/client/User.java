package client;

import java.time.LocalDate;
import java.time.Period;  

public class User {
	static int number_of_users = 0;
	private int user_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String gender;
	private int age;
	private LocalDate date_of_birth;
	private String phone_number;
	private String street;
	private String city;
	private String state;
	private int zip_code;
	public String email;
	private String username;
	private String password;
	private String user_type;

	// ==[Constructor]==
	public User(String first_name, String middle_name, String last_name, String gender, LocalDate date_of_birth, 
			String phone_number, String street, String city, String state, int zip_code, String email, String username, String password, String user_type) {

		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.gender = gender;

		this.date_of_birth = date_of_birth;
		this.age = Period.between(this.date_of_birth, LocalDate.now()).getYears();

		this.phone_number = phone_number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;

		this.email = email;
		this.username = username;
		this.password = password;
		this.user_type = user_type;
		User.number_of_users += 1;
		this.user_id = User.number_of_users;

	}

	// Constructor if no username/password provided
	public User(String first_name, String middle_name, String last_name, String gender, LocalDate date_of_birth, 
		String phone_number, String street, String city, String state, int zip_code, String email, String user_type) {

		this(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, city, state, zip_code, email, "", "", user_type);

	}

	// ==[Mutators]==

	// Precondition: none
	// Postcondition: first_name is set to newFirstName
	public void setFirstName(String newFirstName){
		first_name = newFirstName;
	}

	// Precondition: none
	// Postcondition: middle_name is set to newMiddleName
	public void setMiddleName(String newMiddleName){
		middle_name = newMiddleName;
	}

	// Precondition: none
	// Postcondition: last_name is set to newLastName
	public void setLastName(String newLastName){
		last_name = newLastName;
	}

	// Precondition: none
	// Postcondition: gender is set to newGender
	public void setGender(String newGender){
		gender = newGender;
	}

	// Precondition: date_of_birth
	// Postcondition: first_name is set to newDateOfBirth
	public void setDateOfBirth(LocalDate newDateOfBirth) {
		date_of_birth = newDateOfBirth;
	}


	// Precondition: none
	// Postcondition: age is set to newAge
	public void setAge(int newAge){
		age = newAge;
	}
	
	// Precondition: none
	// Postcondition: age is set to the User's current age (int)
	public void updateAge() {
		setAge(Period.between(this.date_of_birth, LocalDate.now()).getYears());
	}

	// Precondition: none
	// Postcondition: phone_number is set to newPhoneNumber
	public void setPhoneNumber(String newPhoneNumber){
		phone_number = newPhoneNumber;
	}

	// Precondition: none
	// Postcondition: street is set to newStreetName
	public void setStreet(String newStreetName ){
		street = newStreetName;
	}
	
	// Precondition: none
	// Postcondition: city is set to newCityName
	public void setCity(String newCityName ){
		city = newCityName;
	}

	// Precondition: none
	// Postcondition: state is set to newStateName
	public void setState(String newStateName ){
		state = newStateName;
	}
	
	// Precondition: none
	// Postcondition: zip_code is set to newZipCode
	public void setZipCode(int newZipCode ){
		zip_code = newZipCode;
	}

	// Precondition: none
	// Postcondition: email is set to newEmailAddress
	public void setEmailAddress(String newEmailAddress){
		email = newEmailAddress;
	}

	// Precondition: none
	// Postcondition: password is set to newPassword
	public void setPassword(String newPassword){
		password = newPassword;
	}


	// Precondition: none
	// Postcondition: user_type is set to newUserType
	public void setUserType(String newUserType){
		user_type = newUserType;
	}

	// ==[Accessors]==
	// Precondition: none
	// Postcondition: first name of the user is returned as a string
	public String getFirstName(){
		return first_name;
	}

	// Precondition: none
	// Postcondition: middle name of the user is returned as a string
	public String getMiddleName(){
		return middle_name;
	}

	// Precondition: none
	// Postcondition: last name is returned as a string
	public String getLastName(){
		return last_name;
	}

	// Precondition: none
	// Postcondition: gender is returned as a string
	public String getGender(){
		return gender;
	}

	// Precondition: none
	// Postcondition: age of the user is returned as a string
	public int getAge(){
		return age;
	}

	// Precondition: none
	// Postcondition: user's birthday was returned as a string
	public String getDateOfBirth(){
		return date_of_birth.toString();
	}
	
	// Precondition: none
	// Postcondition: user's phone number is returned as a phone number
	public String getPhoneNumber(){
		return phone_number;
	}

	// Precondition: none
	// Postcondition: the user's street is returned as a string
	public String getStreet(){
		return street;
	}
	
	// Precondition: none
	// Postcondition: the user's city is returned as a string
	public String getCity(){
		return city;
	}
	
	// Precondition: none
	// Postcondition: the user's state is returned as a string
	public String getState(){
		return state;
	}

	// Precondition: none
	// Postcondition: the user's zip code is returned as an int
	public int getZipCode(){
		return zip_code;
	}
	
	// Precondition: none
	// Postcondition: the user's full address is returned as a string
	public String getAddress() {
		return street + " " + city + " " + state + " " + zip_code;
	}
	
	// Precondition: none
	// Postcondition: the user's email address is returned as a string
	public String getEmailAddress() {
		return email;
	}

	// Precondition: none
	// Postcondition: the user's username is returned, if they do not have one an empty string is returned
	public String getUsername(){
		return username;
	}

	// Precondition: none
	// Postcondition: the user's password is returned as a string, if they do not have one an empty string is returned
	public String getPassword(){
		return password;
	}

	// Precondition: none
	// Postcondition: the user's user type is returned as as string: PATIENT, DOCTOR, RECEPTIONIST
	public String getUserType(){
		return user_type;
	}

	// Precondition: none
	// Postcondition: the user's id is returned
	public int getUserID(){
		return user_id;
	}

	// Precondition: none
	// Postcondition: String representation of the user is returned 
	@Override
	public String toString() {
		
		String stringToReturn = "";
		stringToReturn += "Name: " + first_name + " " + last_name + "\n";
		stringToReturn += "Gender: " + gender + "\n";
		stringToReturn += "Age: " + age + "\n";
		stringToReturn += "DOB: " + date_of_birth + "\n";
		stringToReturn += "Phone Number: " + phone_number + "\n";
		stringToReturn += "Address: " + getAddress() + "\n";
		stringToReturn += "User Type: " + user_type + "\n";
		stringToReturn += "User ID: " + user_id + "\n";

		return stringToReturn;
	}


}

