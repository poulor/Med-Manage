package client;

import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Receptionist{
    static int number_of_receptionists = 0;
    private int receptionist_id;
    private LocalDate join_date;
    private int user_id;
   
    // ==[Constructor]==
    // Need to add user_id
    public Receptionist(String join_date) {

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