package client;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage extends Application 
{
	private TextField un = new TextField();
	private TextField pw = new TextField();
	ObservableList<String> userType = 
			FXCollections.observableArrayList(
					"Patient",
					"Doctor",
					"Receptionist",
					"Administrator"
					);
	private ComboBox<String> usertype = new ComboBox<String>(userType);
	private Button signIn = new Button("Sign In");
	
	@Override
	
	public void start (Stage primaryStage)
	{
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.setAlignment(Pos.CENTER);
		pane.add(new Label("Username: "), 0, 0);
		pane.add(un, 1, 0);
		pane.add(new Label("Password: "), 0, 1);
		pane.add(pw, 1, 1);
		pane.add(new Label("User Type: "), 0, 2);
		pane.add(usertype, 1, 2);
		pane.add(signIn, 1, 5);
	    GridPane.setHalignment(signIn, HPos.RIGHT);
	    
	   /* 
	    * BackgroundImage myBI= new BackgroundImage(new Image("https://cdn1.imggmi.com/uploads/2019/11/23/a5dfc21978b80f30e973c097f47a6f26-full.jpg",600,400,false,true),
	    *        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
	    *         new BackgroundSize(1.0, 1.0, true, true, false, false));
	    * pane.setBackground(new Background(myBI));
	    */
	    
	    Scene scene = new Scene(pane, 600, 400);
		primaryStage.setTitle("Sign In");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}	
			
}
