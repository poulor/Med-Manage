package client;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Doctor_View_Patient_Front_End extends Application{
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		 
		 Rectangle rect = new Rectangle(200, 200, Color.RED);
		 ScrollPane s1 = new ScrollPane();
		 s1.setPrefSize(120, 120);
		 s1.setContent(rect);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
