package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppointmentsOfDay extends Application
{
	private PreparedStatement preparedStatement;
	private TextField date = new TextField();
	private Label lblStatus = new Label();
	@Override
	
	public void start(Stage primaryStage)
	{
		
		initializeDB();
		
		Button ShowAppointments = new Button("Show Appointments");
	    HBox hBox = new HBox(5);
	    hBox.getChildren().addAll(new Label("Date (YYYY-MM-DD): "), date, 
	      (ShowAppointments));

	    VBox vBox = new VBox(10);
	    vBox.getChildren().addAll(hBox, lblStatus);
	     
	    date.setPrefColumnCount(6);
	    ShowAppointments.setOnAction(e -> showAppointments());
/*
        TableView<Appointment> appTable = new TableView<>();
        TableColumn<Appointment, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Appointment, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Appointment, String> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("appointment_time"));

        appTable.getColumns().addAll(firstNameCol, lastNameCol, timeCol);

      //  appTable.getItems().addAll(dataAccessor.getPersonList());
*/
        //BorderPane root = new BorderPane();
       // root.setCenter(appTable);
        Scene scene = new Scene(vBox, 600, 400);
        primaryStage.setTitle("Appointments");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	private void initializeDB() {    
		  try {
		      Class.forName("com.mysql.jdbc.Driver");      // Load the JDBC driver
		       // Establish a connection
		      Connection connection = DriverManager.getConnection
		        ("jdbc:mysql://localhost/MedicalClient", "test_user", "password");
		      System.out.println("Database connected");
		      String queryString = "select first_name, " +
		        "last_name from Appointments, Patients, Users " +
		        "where Appointments.appointment_date = ? and Appointments.patient_id = Patients.patient_id " 
		        + "and Patients.user_id = Users.user_id";
		      preparedStatement = connection.prepareStatement(queryString);    
			  }
		    catch (Exception ex) {  ex.printStackTrace();  }  }
	
	private void showAppointments() {
	    String dt = date.getText();
	    try { preparedStatement.setString(1, dt);
	       ResultSet rset = preparedStatement.executeQuery();

	      if (rset.next()) {
	        String firstName = rset.getString(1);
	        String lastName = rset.getString(2);
	        //String appointment_time = rset.getString(3);


	        // Display result in a label
	        lblStatus.setText(firstName + " " + lastName + "\n");// +  appointment_time + "\n");
	      } else {
	        lblStatus.setText("Not found");
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
