package client;

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
import javafx.stage.Stage;

public class DoctorViewPatientFrontEnd extends Application
{
	private TextField firstName = new TextField();
	private TextField middleInitial = new TextField();
	private TextField lastName = new TextField();
	private TextField dob = new TextField();
	private TextField gender = new TextField();
	private TextField medications = new TextField();
	private TextArea history = new TextArea();
	private TextArea notes = new TextArea();

	
	private Button viewPatient = new Button("View Patient");

	

	@Override
	public void start(Stage primaryStage)
	{
		dob.setEditable(false);
		gender.setEditable(false);
		
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
		pane.add(new Label("Medications: "), 0, 4);
		pane.add(medications, 1, 4);
		pane.add(new Label("Health History: "), 0, 5);
		pane.add(history, 1, 5);
		pane.add(new Label("Notes: "), 0, 6);
		pane.add(notes, 1, 6);
		pane.add(viewPatient, 1,7);
		
	    GridPane.setHalignment(viewPatient, HPos.RIGHT);
	    
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