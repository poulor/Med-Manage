package client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Login extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Circle circle = new Circle();
		Pane pane = new Pane();
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.widthProperty().divide(2));
		
		
		circle.setStroke(Color.YELLOW);
		circle.setFill(Color.FIREBRICK);
		circle.setRadius(150.0f);
		
		
		pane.getChildren().add(circle);
		
		Scene scene = new Scene(pane,500,500);
		primaryStage.setTitle("CIRCLE");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);

	}

}