package client;

import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Receptionist extends User{
    static int number_of_receptionists = 0;
    private int receptionist_id;
    private LocalDate join_date;
   
    // ==[Constructor]==
    // Need to add user_id
    public Receptionist(String first_name, String middle_name, String last_name, String gender, LocalDate date_of_birth, String phone_number,
    String street, String city, String state, int zip_code, String email, String username, String password, String user_type, String join_date) {

		super(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, city, state, zip_code, email, username, password, user_type);
        
        // Formatting join_date string to LocalDate format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        this.join_date = LocalDate.parse(join_date, formatter);
      
        Receptionist.number_of_receptionists += 1;
        this.receptionist_id = Receptionist.number_of_receptionists;

    }

    // ==[Accessors]==

    // Precondition: none
    // Postcondition: returns receptionist id as an int
    public int getReceptionistID(){
        return receptionist_id;
    }


    // Precondition: none
    // Postcondition: returns join date as a string
    public String getJoinDate(){
        return join_date.toString();
    }
    

    // Precondition: none
    // Postcondition: returns string representation of the receptionist
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
        stringToReturn += "Receptionist ID: " + receptionist_id + "\n";
        stringToReturn += "User ID: " + super.getUserID() + "\n";
        
        return stringToReturn;
    }
    

}