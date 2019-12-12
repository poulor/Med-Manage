package client;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DoctorFirstPage extends Application 
{
	private Button existingPatient = new Button("Existing Patient");
	private Button appointments = new Button("Appointments of the day");
	
	@Override
	
	public void start (Stage primaryStage)
	{
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
		pane.add(existingPatient, 0, 0);
		pane.add(appointments, 0, 1);
		
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Doctor");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
