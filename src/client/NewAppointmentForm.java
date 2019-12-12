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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewAppointmentForm extends Application
{
	private TextField firstName = new TextField();
	private TextField lastName = new TextField();
	private TextField eMail = new TextField();
	private TextField phone = new TextField();
	private DatePicker dateApp = new DatePicker();
	ObservableList<String> times = 
			FXCollections.observableArrayList(
					"9:00am",
					"9:30am",
					"10:00am",
					"10:30am",
					"11:00am",
					"11:30am",
					"1:00apm",
					"1:30pm",
					"2:00pm",
					"2:30pm",
					"3:00pm",
					"3:30pm",
					"4:00pm",
					"4:30pm"
					);
	private ComboBox timeApp = new ComboBox(times);
	
	private Button newApp = new Button("Create New Appointment");
	
	
	@Override
	
	public void start(Stage primaryStage)
	{
		
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
		pane.add(new Label("First Name: "), 0, 0);
		pane.add(firstName, 1, 0);
		pane.add(new Label("Last Name: "), 0, 1);
		pane.add(lastName, 1, 1);
		pane.add(new Label("Email: "), 0, 2);
		pane.add(eMail, 1, 2);
		pane.add(new Label("Phone#: "), 0, 3);
		pane.add(phone, 1, 3);
		pane.add(new Label("Appointment date: "), 0, 4);
		pane.add(dateApp, 1,4);
		pane.add(new Label("Appointment time: "), 0, 5);
		pane.add(timeApp, 1,5);
		pane.add(newApp, 1, 6);
	    GridPane.setHalignment(newApp, HPos.RIGHT);
	    
	    Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("New Appointment Form");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
