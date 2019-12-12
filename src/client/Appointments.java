package client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class Appointments extends Application
{
	private PreparedStatement preparedStatement;
	private TextField dt = new TextField();
	private Button btShowApp = new Button("Show Appointments");
	private Label status = new Label();
	
	@Override
	
	public void start (Stage primaryStage)
	{
		initializeDB();
		
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("Date: "), dt, (btShowApp));

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(hBox, status);

		dt.setPrefColumnCount(6);
		btShowApp.setOnAction(e -> showApp());
		

		Scene scene = new Scene(vBox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Appointments");
		primaryStage.show();
	}
	private void initializeDB() {    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");      // Load the JDBC driver
			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/MedicalClient", "root", "J@m3$41!");
			System.out.println("Database connected");
			String queryString = "select dat" + " from appointments " +
					"where dat = ?";
		
			// Create a statement
			preparedStatement = connection.prepareStatement(queryString);    
		}
		catch (Exception ex) {  ex.printStackTrace();  }  }
	private void showApp() {
		String appDate = dt.getText();
		try { preparedStatement.setString(1, appDate);
		ResultSet rset = preparedStatement.executeQuery();

		if (rset.next()) {
			String firstName = rset.getString(1);
			String lastName = rset.getString(1);
			

			// Display result in a label
			status.setText(firstName + " " + 
					" " + lastName + " " + dt);
		} else {
			status.setText("Not found");
		}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			}
	}
		
	public static void main(String[] args)
	{
		launch(args);
	}
}


