package client;

import java.time.LocalDate;

public class Patient extends User {
	static int number_of_patients = 0;
	private int patient_id;
	private double heightInInches;
	private double weightInPounds;
	private String medications = "";
	private String healthHistory = "\n";
	private String notes = "\n";
    private int doctor_id;
	
	// ==[Constructor]==
	public Patient(String first_name, String middle_name, String last_name, String gender, LocalDate date_of_birth, String phone_number,
			String street, String city, String state, int zip_code, String email, String username, String password, String user_type, double heightInInches, double weightInPounds, 
			String medications, String healthHistory, int doctor_id) {
		
		super(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, city, state, zip_code, email, username, password, user_type);
		this.heightInInches = heightInInches;
		this.weightInPounds = weightInPounds;
		this.medications = medications;
        this.healthHistory = healthHistory;
		this.doctor_id = doctor_id;
		
		Patient.number_of_patients += 1;
		this.patient_id = Patient.number_of_patients;
	}

	// ==[Mutators]==
	
	// Precondition: None
	// Postcondition: height is set to newHeight
	public void setHeight(double newHeight){
		heightInInches = newHeight;
	}

	// Precondition: None
	// Postcondition: weight is set to newWeight
	public void setWeight(double newWeight){
		weightInPounds = newWeight;
	}

	// Precondition: None
	// Postcondition: doctor_id is set to newDoctorID
	public void setDoctorID(int newDoctorID) {
		doctor_id = newDoctorID;
	}

	// Precondition: None
	// Postcondition: updatedMeds is appended to medications with a comma and a space at the end
	public void addMedications(String updatedMeds){
		medications += updatedMeds + ", ";
	}

	// Precondition: None
	// Postcondition: updatedHistory is appended to healthHistory with a new line at the end
	public void addHealthHistory(String updatedHistory){
		healthHistory += updatedHistory + "\n";
	}

	// Precondition: None
	// Postcondition: newNote is appended to notes with a new line at the end
	public void addNotes(String newNote){
		notes += newNote + "\n";
	}


	// ==[Accessors]==

	// Precondition: None
	// Postcondition: height is returned as a double
	public double getHeight(){
		return heightInInches;
	}

	// Precondition: None
	// Postcondition: weight is returned as a double
	public double getWeight(){
		return weightInPounds;
	}

	// Precondition: None
	// Precondition: medications is returned as a string
	public String getMedications(){
		return medications;
	}

	// Precondition: None
	// Postcondition: healthHistory is returned as a string
	public String getHealthHistory(){
		return healthHistory;
	}

	// Precondition: None
	// Postcondition: notes is returned as a string
	public String getNotes(){
		return notes;
	}

	// Precondition: None
	// Postcondition: doctor id is returned as an int
	public int getDoctorID(){
		return doctor_id;
	}

	// Precondition: None
	// Postcondition: patient id is returned as an int
	public int getPatientID(){
		return patient_id;
	}


	@Override

	// Precondition: none
	// Postcondition: string representation of the patient is returned
    public String toString() {
        String stringToReturn = "";
        stringToReturn += "Name: " + super.getFirstName() + " " + super.getLastName() + "\n";
        stringToReturn += "Gender: " + super.getGender() + "\n";
        stringToReturn += "Age: " + super.getAge() + "\n";
        stringToReturn += "DOB: " + super.getDateOfBirth() + "\n";
        stringToReturn += "Height: " + heightInInches + " in." + "\n";
        stringToReturn += "Weight: " + weightInPounds + " lb." + "\n";
		stringToReturn += "Address: " + super.getAddress() + "\n";
        stringToReturn += "Email: " + email + "\n";
		stringToReturn += "Phone Number: " + super.getPhoneNumber() + "\n";
        stringToReturn += "Medication(s): " + medications + "\n";
        stringToReturn += "Health History: " + healthHistory + "\n";
		stringToReturn += "Notes: " + notes + "\n";
		stringToReturn += "User Type: " + super.getUserType() + "\n";
		stringToReturn += "User ID: " + super.getUserID() + "\n";
		

        return stringToReturn;
    }


}
