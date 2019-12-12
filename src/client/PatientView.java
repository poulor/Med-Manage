package client;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PatientView extends Application 
{
	
	private Text text = new Text("Hello " + Patient.getFirstName() + Patient.getLastName() + 
			", you have an appointment on "
			+ Appointment.getDate() + " at " + Appointment.getTime()
				); //not sure
	private Button viewInfo = new Button("View Personal Info");
	
	
	
	@Override
	
	public void start(Stage primaryStage)
	{
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
		text.setFont(Font.font("Verdana", 30));
		
		pane.add(text, 0, 0);
		pane.add(viewInfo, 1, 1);
		GridPane.setHalignment(viewInfo, HPos.RIGHT);
		
	
		Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Patient View");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
