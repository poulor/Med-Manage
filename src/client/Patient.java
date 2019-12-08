package client;

public class Patient {
    private int patient_id;
    private double heightInInches;
    private double weightInPounds;
    private String medications = "";
    private String healthHistory = "\n";
    private String notes = "\n";
    private int doctor_id;
    private int user_id;

    // add automatic age calculator?

    public Patient(double heightInInches, double weightInPounds, String medications, String healthHistory) {
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.medications = medications;
        this.healthHistory = healthHistory;
    }
    
    public void setHeight(double newHeight){
    	heightInInches = newHeight;
    }

    public void setWeight(double newWeight){
    	weightInPounds = newWeight;
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

    public double getHeight(){
    	return heightInInches;
    }

    public double getWeight(){
    	return weightInPounds;
    }

    public String getMedications(){
        return medications;
    }

    public String getHealthHistory(){
        return healthHistory;
    }

    public String getNotes(){
        return notes;
    }

    public int getDoctorID(){
        return doctor_id;
    }

    public int getPatientID(){
        return patient_id;
    }

    /* @Override
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
    } */
    

}
