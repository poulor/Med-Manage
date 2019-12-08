package client;

import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Receptionist extends User{
    static int number_of_receptionists = 0;
    private int receptionist_id;
    private LocalDate join_date;
    private int user_id;
   
    // ==[Constructor]==
    // Need to add user_id
    public Receptionist(String first_name, String middle_name, String last_name, String gender, String date_of_birth, String phone_number,
    String street, int zip_code, String username, String password, String user_type, String join_date) {

		super(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, zip_code, username, password, user_type);
        
        // Formatting join_date string to LocalDate format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        this.join_date = LocalDate.parse(join_date, formatter);
      
        Receptionist.number_of_receptionists += 1;
        this.receptionist_id = Receptionist.number_of_receptionists;

    }

    // ==[Accessors]==
    public int getReceptionistID(){
        return receptionist_id;
    }

    public String getJoinDate(){
        return join_date.toString();
    }
    
    @Override
    public String toString() {
        String stringToReturn = "";
        stringToReturn += "Receptionist ID: " + receptionist_id + "\n";
        stringToReturn += "Join Date: " + join_date + "\n";
        
        return stringToReturn;
    }
    

}