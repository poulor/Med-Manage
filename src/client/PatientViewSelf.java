package client;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PatientViewSelf extends Application
{

	// texfields
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
	private TextArea appointments = new TextArea();



	@Override
	public void start(Stage primaryStage)
	{

		// Disable fields that shouldn't be inputted into
		eMail.setEditable(false);
		dob.setEditable(false);
		gender.setEditable(false);
		address.setEditable(false);
		city.setEditable(false);
		state.setEditable(false);
		zip.setEditable(false);
		phone.setEditable(false);
		appointments.setEditable(false);

		middleInitial.setPrefWidth(30);
		middleInitial.setMaxWidth(30); 


		// Put everything in a grid pane
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
		pane.add(new Label("Zipcode: "), 0, 7);
		pane.add(zip, 1, 7);
		pane.add(new Label("State: "), 0, 8);
		pane.add(state, 1, 8);
		pane.add(new Label("Phone#: "), 0, 9);
		pane.add(phone, 1, 9);
		pane.add(new Label("Appointments: "), 0, 10);
		pane.add(appointments, 1, 10);

		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("<Patient Name Here>");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}