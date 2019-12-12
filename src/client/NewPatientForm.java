package client;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewPatientForm extends Application
{
	private TextField firstName = new TextField();
	private TextField middleInitial = new TextField();
	private TextField lastName = new TextField();
	private TextField eMail = new TextField();
	private TextField dob = new TextField();
	private TextField gender = new TextField();
	private TextField street = new TextField();
	private TextField city = new TextField();
	private TextField state = new TextField();
	private TextField zip = new TextField();
	private TextField phone = new TextField();
	private TextArea history = new TextArea();

	private Button newPatient = new Button("Create New Patient");
	
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Patient> patients = new ArrayList<Patient>();


	@Override

	public void start(Stage primaryStage)
	{

		middleInitial.setPrefWidth(30);
		middleInitial.setMaxWidth(30); 

		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
		pane.add(new Label("First Name: "), 0, 0);
		pane.add(firstName, 1, 0);
		pane.add(new Label("MI: "), 2, 0);
		pane.add(middleInitial, 3, 0);
		pane.add(new Label("Last Name: "), 0, 1);
		pane.add(lastName, 1, 1);
		pane.add(new Label("Gender: "), 0, 2);
		pane.add(gender, 1, 2);
		pane.add(new Label("Date of Birth: "), 0, 3);
		pane.add(dob, 1, 3);
		pane.add(new Label("Email: "), 0, 4);
		pane.add(eMail, 1, 4);
		pane.add(new Label("Street Address: "), 0, 5);
		pane.add(street, 1, 5);
		pane.add(new Label("City: "), 0, 6);
		pane.add(city, 1, 6);
		pane.add(new Label("State: "), 0, 7);
		pane.add(state, 1, 7);
		pane.add(new Label("Zip: "), 0, 8);
		pane.add(zip, 1, 8);
		pane.add(new Label("Phone#: "), 0, 9);
		pane.add(phone, 1, 9);
		pane.add(new Label("History: "), 0, 10);
		pane.add(history, 1, 10);
		pane.add(newPatient, 1,11);
		GridPane.setHalignment(newPatient, HPos.RIGHT);

		newPatient.setOnAction(e -> createNewPatient());

		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("New Patient Form");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void createNewPatient() {
		// Get values from text fields
		
		System.out.println("User Created!");
		// Create a loan object.
//		Patient p = new Patient(firstName.getText(), middleInitial.getText(), lastName.getText(), gender.getValue(), dob.getValue(), phone.getText(), street.getText(), city.getText(), state.getText(), Integer.parseInt(zip.getText()), eMail.getText(), "boy", "password", "PATIENT", 0, 0, "", "", 0);
//		Patient q = new Patient(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, city, state, zip_code, email, username, password, user_type, heightInInches, weightInPounds, medications, healthHistory, doctor_id)
		// String first_name, String middle_name, String last_name, String gender, String date_of_birth, String phone_number,
//		String street, int zip_code, String email, String username, String password, String user_type, double heightInInches, double weightInPounds, 
//		String medications, String healthHistory, int doctor_id)
//		users.add(p);
//		patients.add(p);
		
		System.out.println(users.get(0));
		System.out.println(patients.get(0));
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}

