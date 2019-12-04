package client;

import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Administrator{
    static int number_of_administrators = 0;
    private int administrator_id;
    private LocalDate join_date;
    private int user_id;
   
    // ==[Constructor]==
    // Need to add user_id
    public Administrator(String join_date) {

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
        stringToReturn += "administrator_id: " + administrator_id;

        return stringToReturn;
    }
    

}