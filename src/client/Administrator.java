package client;

import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Administrator extends User{
    static int number_of_administrators = 0;
    private int administrator_id;
    private LocalDate join_date;
    private int user_id;
   
    // ==[Constructor]==
    // Need to add user_id
    public Administrator(String first_name, String middle_name, String last_name, String gender, String date_of_birth, String phone_number,
    String street, int zip_code, String email, String username, String password, String user_type, String join_date) {

		super(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, zip_code, email, username, password, user_type);

        // Formatting join_date string to LocalDate format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        this.join_date = LocalDate.parse(join_date, formatter);
      
        Administrator.number_of_administrators += 1;
        this.administrator_id = Administrator.number_of_administrators;

    }

    // ==[Accessors]==
    public int getAdministratorID(){
        return administrator_id;
    }

    public String getJoinDate(){
        return join_date.toString();
    }

    @Override
    public String toString() {
        String stringToReturn = "";
        stringToReturn += "Name: " + super.getFirstName() + " " + super.getLastName() + "\n";
        stringToReturn += "Gender: " + super.getGender() + "\n";
        stringToReturn += "Age: " + super.getAge() + "\n";
        stringToReturn += "DOB: " + super.getDateOfBirth() + "\n";
		stringToReturn += "Address: " + super.getAddress() + "\n";
        stringToReturn += "Email: " + super.getEmailAddress() + "\n";
        stringToReturn += "Phone Number: " + super.getPhoneNumber() + "\n";
        stringToReturn += "Join Date: " + join_date + "\n";
        stringToReturn += "User Type: " + super.getUserType() + "\n";
        stringToReturn += "Admin ID: " + administrator_id + "\n";
		stringToReturn += "User ID: " + super.getUserID() + "\n";

        return stringToReturn;
    }
    

}