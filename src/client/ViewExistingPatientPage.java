package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewExistingPatientPage extends Application
{

	//	private ArrayList<Patient> patientList = new ArrayList<Patient>();

	// Prepared statement to view patient from DB
	private PreparedStatement preparedStatement;

	// Textfields
	private TextField firstName = new TextField();
	private TextField middleInitial = new TextField();
	private TextField lastName = new TextField();
	private TextField eMail = new TextField();
	private DatePicker dob = new DatePicker();
	private TextField gender = new TextField();
	private TextField street = new TextField();
	private TextField city = new TextField();
	private TextField state = new TextField();
	private TextField zip = new TextField();
	private TextField phone = new TextField();
	private TextArea history = new TextArea();
	
	private HBox outcomeStatus = new HBox();

	private Label outcomeStatusLabel = new Label();

	private Button findPatient = new Button("Find Patient");


	@Override

	public void start(Stage primaryStage)
	{
		middleInitial.setPrefWidth(30);
		middleInitial.setMaxWidth(30); 


		// Add everything ot gridpane
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
		
		pane.add(new Label("Date of Birth: "), 0, 2);
		pane.add(dob, 1, 2);
		pane.add(new Label("Gender: "), 0, 3);
		pane.add(gender, 1, 3);
	
		pane.add(new Label("Email: "), 0, 4);
		pane.add(eMail, 1, 4);
		pane.add(new Label("Street Address: "), 0, 5);
		pane.add(street, 1, 5);
		pane.add(new Label("City: "), 0, 6);
		pane.add(city, 1, 6);
		pane.add(new Label("Zip: "), 0, 7);
		pane.add(zip, 1, 7);
		pane.add(new Label("State: "), 0, 8);
		pane.add(state, 1, 8);
		pane.add(new Label("Phone#: "), 0, 9);
		pane.add(phone, 1, 9);
		pane.add(new Label("History: "), 0, 10);
		pane.add(history, 1, 10);
		pane.add(findPatient, 1,11);
		
		pane.add(outcomeStatus, 0, 12);
		
		outcomeStatus.getChildren().add(outcomeStatusLabel);
		
		GridPane.setHalignment(findPatient, HPos.RIGHT);

		initializeDB();
		
		disableTextFields();
		findPatient.setOnAction(e -> getPatientInfo());

		Scene scene = new Scene(pane, 1000, 1000);
		primaryStage.setTitle("PatientInfo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/* private void clearAllTextFields() {
		firstName.clear();
		middleInitial.clear();
		lastName.clear();
		eMail.clear();
		dob.clear();
		gender.clear();
		street.clear();
		city.clear();
		state.clear();
		zip.clear();
		phone.clear();
		history.clear();

	} */
	

	// Precondiiton: none
	// Postcondition: disables all appropriate textfields
	private void disableTextFields() {
	
		eMail.setEditable(false);
		gender.setEditable(false);
		street.setEditable(false);
		city.setEditable(false);
		state.setEditable(false);
		zip.setEditable(false);
		phone.setEditable(false);
		history.setEditable(false);

	}

	// Precondition: none
	// Postcondition: textfields are filled from info from the db
	private void fillTextFields(ResultSet rSet) {
		
		try {
			eMail.setText(rSet.getString(1));
			gender.setText(rSet.getString(2));;
			street.setText(rSet.getString(3));
			city.setText(rSet.getString(4));
			state.setText(rSet.getString(5));
			zip.setText(rSet.getString(6));
			phone.setText(rSet.getString(7));
			history.setText(rSet.getString(8));
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	
		
	}

	// Precondition: None
	// Postcondition: DB is initialize is error is caught
	private void initializeDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Load the JDBC driver

			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/MedicalClient", "test_user", "password");
			System.out.println("Database connected");
			String queryString = "SELECT email, gender, street, city, US_state, zip_code, phone_number, "
					+ "health_history FROM Users, Patients WHERE first_name = ? and last_name = ? AND birth_date = ? AND Users.user_id = Patients.user_id";

			// System.out.println(queryString);

			preparedStatement = connection.prepareStatement(queryString);
		}

		catch(Exception ex){
			ex.printStackTrace();

		}

	}


	// Precondition: None
	// Postcondition: Patient info is retrieved from database
	private void getPatientInfo() {
		
		try {
			preparedStatement.setString(1,firstName.getText());
			preparedStatement.setString(2,lastName.getText());
			preparedStatement.setString(3,dob.getValue().toString());
			
			ResultSet rSet = preparedStatement.executeQuery();
			
			if (rSet.next()) {
				outcomeStatusLabel.setText("Success: Found Patient");
				fillTextFields(rSet);

				
			}
			else {
				
				outcomeStatusLabel.setText("Failed: Could not find Patient or Patient does not exist");
				
			}
			
			

			


		}
		catch (SQLException ex) {
			outcomeStatusLabel.setText("Failed");
			outcomeStatus.getChildren().add(outcomeStatusLabel);
			ex.printStackTrace();

		}

		/*
		 middleInitial.setText(String.format("%s", patientList.get(Id - 1).getMiddleName()));
		 eMail.setText(String.format("%s", p.getEmailAddress()));
		 dob.setText(String.format("%s", p.getDateOfBirth()));
		 gender.setText(String.format("%s", p.getGender()));
		 address.setText(String.format("%s", p.getStreet()));
		 city.setText(String.format("%s", p.getCity()));
		 state.setText(String.format("%s", p.getState()));
		 zip.setText(String.format("%s", p.getZipCode()));
		 phone.setText(String.format("%s", p.getPhoneNumber()));
		 history.setText(String.format("%s", p.getHealthHistory()));
		 */
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}