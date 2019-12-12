package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class NewPatientForm extends Application
{
	private TextField firstName = new TextField();
	private TextField middleInitial = new TextField();
	private TextField lastName = new TextField();
	private TextField eMail = new TextField();
	private DatePicker dob = new DatePicker();
	private ObservableList<String> genderList = FXCollections.observableArrayList( "Female", "Male", "Other" );
	private ComboBox<String> gender = new ComboBox<String>(genderList);
	private TextField street = new TextField();
	private TextField city = new TextField();
	private TextField state = new TextField();
	private TextField zip = new TextField();
	private TextField phone = new TextField();
	private TextArea history = new TextArea();

	private Button newPatient = new Button("Add New Patient");

	private HBox outcomeStatus = new HBox();

	private Label outcomeStatusLabel = new Label();

	private PreparedStatement userPreparedStatement;
	
	private PreparedStatement patientPreparedStatement;
	
	private PreparedStatement userIDPreparedStatement;

	
	private int userID = 0;
	
	private int doctorID = 1;

	//	private ArrayList<User> users = new ArrayList<User>();
	//	private ArrayList<Patient> patients = new ArrayList<Patient>();


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
		pane.add(new Label("Health History: "), 0, 10);
		pane.add(history, 1, 10);
		pane.add(newPatient, 1,11);
		pane.add(outcomeStatus, 0, 12);
		outcomeStatus.getChildren().add(outcomeStatusLabel);
		GridPane.setHalignment(newPatient, HPos.RIGHT);

		initializeDB();
		newPatient.setOnAction(e -> createNewPatient());

		Scene scene = new Scene(pane, 1000, 1000);
		primaryStage.setTitle("New Patient Form");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void createNewPatient() {
		// Get values from text fields

		//		System.out.println("User Created!");
		// Create a loan object.
		//		Patient p = new Patient(firstName.getText(), middleInitial.getText(), lastName.getText(), gender.getValue(), dob.getValue(), phone.getText(), street.getText(), city.getText(), state.getText(), Integer.parseInt(zip.getText()), eMail.getText(), "boy", "password", "PATIENT", 0, 0, "", "", 0);
		//		Patient q = new Patient(first_name, middle_name, last_name, gender, date_of_birth, phone_number, street, city, state, zip_code, email, username, password, user_type, heightInInches, weightInPounds, medications, healthHistory, doctor_id)
		// String first_name, String middle_name, String last_name, String gender, String date_of_birth, String phone_number,
		//		String street, int zip_code, String email, String username, String password, String user_type, double heightInInches, double weightInPounds, 
		//		String medications, String healthHistory, int doctor_id)
		//		users.add(p);
		//		patients.add(p);

		//		System.out.println(users.get(0));
		//		System.out.println(patients.get(0));

		insertNewPatientIntoDB();
		clearAllTextFields();
	}

	private void clearAllTextFields() {
		firstName.clear();
		middleInitial.clear();
		lastName.clear();
		eMail.clear();
		dob.getEditor().clear();
		gender.getEditor().clear();
		street.clear();
		city.clear();
		state.clear();
		zip.clear();
		phone.clear();
		history.clear();


	}
	
	private void getNewPatientUserID() {
		
		try {
			userIDPreparedStatement.setString(1, firstName.getText());
			userIDPreparedStatement.setString(2, lastName.getText());
			userIDPreparedStatement.setString(3, dob.getValue().toString());
			
			ResultSet resultSet = userIDPreparedStatement.executeQuery();
			
			if (resultSet.next()) {
//				userID = Integer.parseInt(resultSet.getString(1));
				userID = resultSet.getInt(1);
				
				
				
			}
			else {
				System.out.println("User ID not found");
			}
			
			
			
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		
	}
	


	private void initializeDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");      // Load the JDBC driver
			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/MedicalClient", "test_user", "password");
			System.out.println("Database connected");
			String userQueryString = "INSERT INTO Users VALUES ( NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, \"\", \"\", \"PATIENT\")";
			//			System.out.println(queryString);
			userPreparedStatement = connection.prepareStatement(userQueryString);
			
			String userIDQueryString = "SELECT user_id FROM Users WHERE first_name = ? AND last_name = ? AND birth_date = ?";
			
			userIDPreparedStatement = connection.prepareStatement(userIDQueryString);
			
			String patientQueryString = "INSERT INTO Patients VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
			patientPreparedStatement = connection.prepareStatement(patientQueryString);
			
//			PreparedStatement numPatientsPreparedStatement = Connection.prepare
		}
		catch(Exception ex){
			ex.printStackTrace();

		}

	}

	private void insertNewPatientIntoDB() {
		
		

		try {
			userPreparedStatement.setString(1,firstName.getText());
			userPreparedStatement.setString(2,middleInitial.getText());
			userPreparedStatement.setString(3,lastName.getText());
			userPreparedStatement.setString(4,gender.getValue());
			userPreparedStatement.setString(5,dob.getValue().toString());
			userPreparedStatement.setString(6,phone.getText());
			userPreparedStatement.setString(7,street.getText());
			userPreparedStatement.setString(8,city.getText());
			userPreparedStatement.setString(9,state.getText());
			userPreparedStatement.setString(10,zip.getText());
			userPreparedStatement.setString(11,eMail.getText());
			//			System.out.println(preparedStatement);

			userPreparedStatement.executeUpdate();

			
			

		}
		catch (SQLException ex) {
			outcomeStatusLabel.setText("Failed: Could not add Patient");
			ex.printStackTrace();

		}
		
		getNewPatientUserID();
		
		try {
			patientPreparedStatement.setInt(1,0);
			patientPreparedStatement.setInt(2,0);
			patientPreparedStatement.setString(3,"");
			patientPreparedStatement.setString(4,history.getText());
			patientPreparedStatement.setString(5,"");
			patientPreparedStatement.setInt(6,userID);
			patientPreparedStatement.setInt(7,doctorID);

			//			System.out.println(preparedStatement);

			patientPreparedStatement.executeUpdate();
			
			outcomeStatusLabel.setText("Success: Added Patient");

			
			

		}
		catch (SQLException ex) {
			

			outcomeStatusLabel.setText("Failed: Could not add Patient");
			ex.printStackTrace();

		}
		

	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}

