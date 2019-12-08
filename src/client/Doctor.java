package client;

import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Doctor extends User{
    static int number_of_doctors = 0;
    private int doctor_id;
    private LocalDate join_date;
    private String specialty;
    private String department;
   
    // ==[Constructor]==
    // Need to add user_id
    public Doctor(String first_name, String middle_name, String last_name, String gender, String date_of_birth, String phone_number,
    String street, String city, String state, int zip_code, String email, String username, String password, String user_type, String join_date, String specialty, String department) {

		super(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, city, state, zip_code, email, username, password, user_type);

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
        stringToReturn += "Name: " + super.getFirstName() + " " + super.getLastName() + "\n";
        stringToReturn += "Gender: " + super.getGender() + "\n";
        stringToReturn += "Age: " + super.getAge() + "\n";
        stringToReturn += "DOB: " + super.getDateOfBirth() + "\n";
		stringToReturn += "Address: " + super.getAddress() + "\n";
        stringToReturn += "Email: " + super.getEmailAddress() + "\n";
        stringToReturn += "Phone Number: " + super.getPhoneNumber() + "\n";
        stringToReturn += "User Type: " + super.getUserType() + "\n";
        stringToReturn += "Doctor ID: " + doctor_id + "\n";
		stringToReturn += "User ID: " + super.getUserID() + "\n";
        stringToReturn += "Join Date: " + join_date + "\n";
        stringToReturn += "Specialty: " + specialty + "\n";
        stringToReturn += "Department: " + department + "\n";
        
        return stringToReturn;
    }
    

}
