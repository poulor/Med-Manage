package client;

import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Doctor{
    static int number_of_doctors = 0;
    private int doctor_id;
    private LocalDate join_date;
    private String specialty;
    private String department;
   
    // ==[Constructor]==
    // Need to add user_id
    public Doctor(String join_date, String specialty, String department) {

        // Formatting join_date string to LocalDate format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        this.join_date = LocalDate.parse(join_date, formatter);
        this.specialty = specialty;
        this.department = department;
        Doctor.number_of_doctors += 1;
        this.doctor_id = Doctor.number_of_doctors;

    }

    // ==[Mutators]==
    public void setSpecialty(String newSpecialty){
        specialty = newSpecialty;
    }

    public void setDepartment(String newDepartment){
        department = newDepartment;
    }
    
    // ==[Accessors]==
    public String getJoinDate(){
        return join_date.toString();
    }

    public String getSpecialty(){
        return specialty;
    }
    
    public String getDepartment(){
        return department;
    }

    public int getDoctorID(){
        return doctor_id;
    }

    @Override
    public String toString() {
        String stringToReturn = "";
        stringToReturn += "Doctor ID: " + doctor_id + "\n";
        stringToReturn += "Join Date: " + join_date + "\n";
        stringToReturn += "Specialty: " + specialty + "\n";
        stringToReturn += "Department: " + department + "\n";
        
        return stringToReturn;
    }
    

}
