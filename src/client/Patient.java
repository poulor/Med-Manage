package client;

public class Patient extends User {
	static int number_of_patients = 0;
	private int patient_id;
	private double heightInInches;
	private double weightInPounds;
	private String medications = "";
	private String healthHistory = "\n";
	private String notes = "\n";
    private int doctor_id;
    
	// add automatic age calculator?

	public Patient(String first_name, String middle_name, String last_name, String gender, String date_of_birth, String phone_number,
			String street, String city, String state, int zip_code, String email, String username, String password, String user_type, double heightInInches, double weightInPounds, 
			String medications, String healthHistory, int doctor_id) {
		
		super(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, city, state,  zip_code, email, username, password, user_type);
		this.heightInInches = heightInInches;
		this.weightInPounds = weightInPounds;
		this.medications = medications;
        this.healthHistory = healthHistory;
		this.doctor_id = doctor_id;
		
		Patient.number_of_patients += 1;
		this.patient_id = Patient.number_of_patients;
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


	@Override
    public String toString() {
        String stringToReturn = "";
        stringToReturn += "Name: " + super.getFirstName() + " " + super.getLastName() + "\n";
        stringToReturn += "Gender: " + super.getGender() + "\n";
        stringToReturn += "Age: " + super.getAge() + "\n";
        stringToReturn += "DOB: " + super.getDateOfBirth() + "\n";
        stringToReturn += "Height: " + heightInInches + " in." + "\n";
        stringToReturn += "Weight: " + weightInPounds + " lb." + "\n";
        stringToReturn += "Address: " + super.getAddress() + "\n";
		stringToReturn += "Phone Number: " + super.getPhoneNumber() + "\n";
        stringToReturn += "Medication(s): " + medications + "\n";
        stringToReturn += "Health History: " + healthHistory + "\n";
        stringToReturn += "Notes: " + notes + "\n";

        return stringToReturn;
    }


}
