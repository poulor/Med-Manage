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
    private String notes = "";
   
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
    public void setAppointmentDate(String newAppointmentDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	formatter = formatter.withLocale( Locale.US );
        appointment_date = LocalDate.parse(newAppointmentDate, formatter);
    }

    public void setAppointmentTime(String newAppointmentTime){
        // TO DO
    }

    public void addNotes(String newNote){
        notes += newNote + "\n";
    }
    
    // ==[Accessors]==
    public String getAppointmentDate(){
        return appointment_date.toString();
    }

    /* public String getAppointmentTime(){
        // return appointment_time.toString();

        // TO DO
    } */
    
    public int getDoctorID(){
        return doctor_id;
    }

    public int getPatientID(){
        return patient_id;
    }

    public String getNotes(){
        return notes;
    }

    @Override
    public String toString() {
        String stringToReturn = "";
        stringToReturn += "Appointment ID: " + appointment_id + "\n";
        stringToReturn += "Appointment Date: " + appointment_date + "\n";
        stringToReturn += "Appointment Time: " + appointment_time + "\n";
        stringToReturn += "Doctor ID: " + doctor_id + "\n";
        stringToReturn += "Patient ID: " + patient_id + "\n";
        stringToReturn += "Notes: " + "\n" + notes + "\n";

        return stringToReturn;
    }
    

}