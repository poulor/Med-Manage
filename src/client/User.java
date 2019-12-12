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

		// Formatting date_of_birth string to LocalDate format
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		formatter = formatter.withLocale( Locale.US );
//		this.date_of_birth = LocalDate.parse(date_of_birth, formatter);
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

	// ==[Mutators]==
	public void setFirstName(String newFirstName){
		first_name = newFirstName;
	}

	public void setMiddleName(String newMiddleName){
		middle_name = newMiddleName;
	}

	public void setLastName(String newLastName){
		last_name = newLastName;
	}

	public void setGender(String newGender){
		gender = newGender;
	}

	public void setDateOfBirth(LocalDate newDateOfBirth) {
		date_of_birth = newDateOfBirth;
	}

	public void setAge(int newAge){
		age = newAge;
	}
	
	public void updateAge() {
		setAge(Period.between(this.date_of_birth, LocalDate.now()).getYears());
	}

	public void setPhoneNumber(String newPhoneNumber){
		phone_number = newPhoneNumber;
	}

	public void setStreet(String newStreetName ){
		street = newStreetName;
	}
	
	public void setCity(String newCityName ){
		city = newCityName;
	}
	
	public void setState(String newStateName ){
		state = newStateName;
	}
	
	public void setZipCode(int newZipCode ){
		zip_code = newZipCode;
	}

	public void setEmailAddress(String newEmailAddress){
		email = newEmailAddress;
	}

	public void setPassword(String newPassword){
		password = newPassword;
	}

	public void setUserType(String newUserType){
		user_type = newUserType;
	}

	// ==[Accessors]==
	public String getFirstName(){
		return first_name;
	}

	public String getMiddleName(){
		return middle_name;
	}

	public String getLastName(){
		return last_name;
	}

	public String getGender(){
		return gender;
	}

	public int getAge(){
		return age;
	}

	public String getDateOfBirth(){
		return date_of_birth.toString();
	}

	public String getPhoneNumber(){
		return phone_number;
	}

	public String getStreet(){
		return street;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getState(){
		return state;
	}

	public int getZipCode(){
		return zip_code;
	}
	
	public String getAddress() {
		return street + " " + city + " " + state + " " + zip_code;
	}
	
	public String getEmailAddress() {
		return email;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public String getUserType(){
		return user_type;
	}

	public int getUserID(){
		return user_id;
	}

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

