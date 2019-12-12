package client;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReceptionistFirstPage extends Application
{
	
	private Button newPatient = new Button("New Patient");
	private Button existingPatient = new Button("Existing Patient");
	private Button appointments = new Button("Appointments");
	//private Button scheduleApp= new Button("Schedule New Appointment");
	
	@Override
	
	public void start (Stage primaryStage)
	{
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
		pane.add(newPatient, 0, 0);
		pane.add(existingPatient, 0, 1);
		pane.add(appointments, 0, 2);
		//pane.add(scheduleApp, 0, 3);
		
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Receptionist");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
