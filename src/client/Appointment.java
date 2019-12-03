package client;

import java.util.Locale;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Appointment{
    static int number_of_appointments = 0;
    private int appointment_id;
    private LocalDate appointment_date;
    private Time appointment_time;
    private int doctor_id;
    private int patient_id;
    private String notes;
   
    // ==[Constructor]==
    // Need to add user_id
    public Appointment(String appointment_date, String appointment_time, int doctor_id, int patient_id) {

        // Formatting join_date string to LocalDate format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        this.appointment_date = LocalDate.parse(appointment_date, formatter);
      
        Appointment.number_of_appointments += 1;
        this.appointment_id = Appointment.number_of_appointments;
        
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;

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

    public void setDateOfBirth(String newDateOfBirth) throws Exception{
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        date_of_birth = LocalDate.parse(newDateOfBirth, formatter);
    }

    public void setAge(int newAge){
        age = newAge;
    }

    public void setPhoneNumber(String newPhoneNumber){
        phone_number = newPhoneNumber;
    }

    public void setAddress(String newStreetName, int newZipCode ){
        street = newStreetName;
        zip_code = newZipCode;
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

    public String getAddress(){
        return street + " " + zip_code;
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
        stringToReturn += "Address: " + street + " " + zip_code + "\n";
        stringToReturn += "User Type: " + user_type + "\n";
        stringToReturn += "User ID: " + user_id + "\n";

        
        return stringToReturn;
    }
    

}