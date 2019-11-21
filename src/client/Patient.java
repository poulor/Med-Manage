package client;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Patient {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    // private Date dateOfBirth;
    private LocalDate dateOfBirth;
    private double height;
    private double weight;
    private String address;
    private String phoneNumber;
    private String medications = "";
    private String healthHistory = "\n";
    private String notes = "\n";

    // add automatic age calculator?

    public Patient(String firstName, String lastName, String gender, int age, String dateOfBirth, String address, String phoneNumber) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.firstName = firstName;
        // this.dateOfBirth = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfBirth);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        formatter = formatter.withLocale( Locale.US );
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
        this.address = address;
        this.phoneNumber = phoneNumber;

    }
    
    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }
    
    public void setLastName(String newLastName){
        lastName = newLastName;
    }

    public void setGender(String newGender){
        gender = newGender;
    }

    public void setAge(int newAge){
        age = newAge;
    }

    public void setDateOfBirth(String newDateOfBirth) throws Exception{
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        dateOfBirth = LocalDate.parse(newDateOfBirth, formatter);
    }

    public void setHeight(double newHeight){
        height = newHeight;
    }

    public void setWeight(double newWeight){
        weight = newWeight;
    }

    public void setAddress(double newWeight){
        weight = newWeight;
    }
    
    public void setPhoneNumber(double newWeight){
        weight = newWeight;
    }

    public void addMedications(String updatedMeds){
        medications += updatedMeds + ", ";
    }

    public void addHealthHistory(String updatedHistory){
        healthHistory += updatedHistory + "\n";
    }

    public void addNotes(String newNote){
        notes += newNote + "\n";
    }

    @Override
    public String toString() {
        String stringToReturn = "";
        stringToReturn += "Name: " + firstName + " " + lastName + "\n";
        stringToReturn += "Gender: " + gender + "\n";
        stringToReturn += "Age: " + age + "\n";
        stringToReturn += "DOB: " + dateOfBirth + "\n";
        stringToReturn += "Height: " + height + " in." + "\n";
        stringToReturn += "Weight: " + weight + "lb." + "\n";
        stringToReturn += "Address: " + address + "\n";
        stringToReturn += "Phone Number: " + phoneNumber + "\n";
        stringToReturn += "Medication(s): " + medications + "\n";
        stringToReturn += "Health History: " + healthHistory + "\n";
        stringToReturn += "Notes: " + notes + "\n";


        
        return stringToReturn;
    }
    

}
