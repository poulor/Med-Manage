package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
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

public class ViewExistingPatientPage extends Application
{

//	private ArrayList<Patient> patientList = new ArrayList<Patient>();

	private PreparedStatement preparedStatement;
	private TextField firstName = new TextField();
	private TextField middleInitial = new TextField();
	private TextField lastName = new TextField();
	private TextField eMail = new TextField();
	private TextField dob = new TextField();
	private TextField gender = new TextField();
	private TextField address = new TextField();
	private TextField city = new TextField();
	private TextField state = new TextField();
	private TextField zip = new TextField();
	private TextField phone = new TextField();
	private TextArea history = new TextArea();

	private Button findPatient = new Button("Find Patient");


	@Override

	public void start(Stage primaryStage)
	{
//		Patient p = new Patient("John", "A", "Doe", "Male", LocalDate.of(2003, 10, 21), "800000000", "21 Here St.",  "Dobbs Ferry", "NY", 10000, "jadoe@gmail.com", "jdoe", "password", "Patient", 70, 165, "", "", 21);
//		patientList.add(p);
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
		pane.add(new Label("Address: "), 0, 5);
		pane.add(address, 1, 5);
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
		GridPane.setHalignment(findPatient, HPos.RIGHT);

		findPatient.setOnAction(e -> pullInfo());

		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("PatientInfo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



	private void initializeDB() {    
		try {
			Class.forName("com.mysql.jdbc.Driver");      // Load the JDBC driver
			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/javabook", "scott", "tiger");
			System.out.println("Database connected");
			String queryString = "select user_id " +
					"where User.first_name = ? and User.last_name = ? ";
			//test values- 444111110, 11111
			// Create a statement
			preparedStatement = connection.prepareStatement(queryString);    
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void pullInfo() {
		String fName = firstName.getText();
		String lName = lastName.getText();
		try {

//			preparedStatement.setString(1,  fName);
//			preparedStatement.setString(2,  lName);
//
//			ResultSet Id = preparedStatement.executeQuery();

//			System.out.println(Id);


		}
		finally { 
			System.out.println("failed");
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