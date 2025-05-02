package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class EditButtonForm implements Initializable{

	    @FXML
	    private TextArea patientedit_address;

	    @FXML
	    private Button patientedit_confirm;

	    @FXML
	    private ComboBox<String> patientedit_gender;

	    @FXML
	    private TextField patientedit_name;

	    @FXML
	    private TextField patientedit_number;

	    @FXML
	    private TextField patientedit_patientID;

	    @FXML
	    private ComboBox<String> patientedit_status;
	
	    private Connection connect = null;
		private Statement statement = null;
		private PreparedStatement preparedStatement = null;
		private ResultSet resultSet = null;
		
		private final AlertMessage alert=new AlertMessage();

		public void connect() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
		}

	    public void setText() {
	    	patientedit_patientID.setText(String.valueOf(Data.temp_patientID));
	    	patientedit_name.setText(String.valueOf(Data.temp_name));
	    	patientedit_number.setText(String.valueOf(Data.temp_number));
	    	patientedit_address.setText(String.valueOf(Data.temp_address));
	    	patientedit_status.getSelectionModel().select(String.valueOf(Data.temp_status));
	    	patientedit_gender.getSelectionModel().select(String.valueOf(Data.temp_gender));
	    }
	    
	    private void patientGenderList() {
	    	List<String> listG=new ArrayList<>();
	    	for(String data:Data.gender) {
	    		listG.add(data);
	    	}
	    	
	    	ObservableList listData=FXCollections.observableArrayList(listG);
	    	patientedit_gender.setItems(listData);
	    }
	    
	    private void patientStatusList() {
	    	List<String> listS=new ArrayList<>();
	    	for(String data:Data.status) {
	    		listS.add(data);
	    	}
	    	
	    	ObservableList listData=FXCollections.observableArrayList(listS);
	    	patientedit_status.setItems(listData);
	    }
	    
	    	public void updateBtn() {
	    	    // Provjera jesu li sva polja popunjena
	    	    if (patientedit_patientID.getText().isEmpty() || 
	    	        patientedit_name.getText().isEmpty() || 
	    	        patientedit_gender.getSelectionModel().isEmpty() || 
	    	        patientedit_number.getText().isEmpty() || 
	    	        patientedit_address.getText().isEmpty() || 
	    	        patientedit_status.getSelectionModel().isEmpty()) {
	    	        alert.errorMessage("Please fill all blank fields!");
	    	        return; // Prekini izvršavanje ako su polja prazna
	    	    }

	    	    try {
	    	        connect(); // Poveži se na bazu podataka

	    	        // Provjeri postoji li pacijent s danim ID-om
	    	        String checkQuery = "SELECT * FROM patient WHERE patient_id = ?";
	    	        preparedStatement = connect.prepareStatement(checkQuery);
	    	        preparedStatement.setString(1, patientedit_patientID.getText());
	    	        resultSet = preparedStatement.executeQuery();

	    	        if (resultSet.next()) {
	    	        	if (alert.confirmationMessage("Are you sure you want to UPDATE Appointment ID: " + patientedit_patientID.getText() + " ?")) {
	    	            // Ažuriraj podatke pacijenta
	    	            String updateQuery = "UPDATE patient SET full_name = ?, gender = ?, phone_number = ?, address = ?, date_modify = ?, status = ?,patient_id=? WHERE patient_id = ?";
	    	            preparedStatement = connect.prepareStatement(updateQuery);
	    	            preparedStatement.setString(1, patientedit_name.getText());
	    	            preparedStatement.setString(2, patientedit_gender.getSelectionModel().getSelectedItem());
	    	            preparedStatement.setString(3, patientedit_number.getText());
	    	            preparedStatement.setString(4, patientedit_address.getText());
	    	            preparedStatement.setDate(5, new java.sql.Date(new Date().getTime())); // Trenutni datum
	    	            preparedStatement.setString(6, patientedit_status.getSelectionModel().getSelectedItem());
	    	            preparedStatement.setString(7, patientedit_patientID.getText());
	    	            preparedStatement.setString(8,patientedit_patientID.getText());

	    	            int rowsUpdated = preparedStatement.executeUpdate();
	    	            if (rowsUpdated > 0) {
	    	                alert.successMessage("Successfully updated!");
	    	            } else {
	    	                alert.errorMessage("Update failed!");
	    	            }
	    	        }} else {
	    	            alert.errorMessage("Patient not found!");
	    	        }
	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	        alert.errorMessage("An error occurred: " + e.getMessage());
	    	    } finally {
	    	        // Zatvori resurse
	    	        try {
	    	            if (resultSet != null) resultSet.close();
	    	            if (preparedStatement != null) preparedStatement.close();
	    	            if (connect != null) connect.close();
	    	        } catch (Exception e) {
	    	            e.printStackTrace();
	    	        }
	    	    }
	    	}
	    	
	    	private void enlargeButton(Button button) {
	    	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), button);
	    	    scaleTransition.setToX(1.10);  // Povećaj za 10% u širinu
	    	    scaleTransition.setToY(1.10);  // Povećaj za 10% u visinu
	    	    scaleTransition.play();
	    	}

	    	private void resetButtonSize(Button button) {
	    	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), button);
	    	    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
	    	    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
	    	    scaleTransition.play();
	    	}
	    	
	    	private void enlargeCB(ComboBox<String> cb) {
	    	    // Animacija za povećanje TextField-a
	    	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), cb);
	    	    scaleTransition.setToX(1.075);  // Povećaj TextField za 7% u širinu
	    	    scaleTransition.setToY(1.075);  // Povećaj TextField za 7% u visinu
	    	    scaleTransition.play();
	    	}

	    	private void enlargeTextField(TextField textField) {
	    	    // Animacija za povećanje TextField-a
	    	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), textField);
	    	    scaleTransition.setToX(1.07);  // Povećaj TextField za 7% u širinu
	    	    scaleTransition.setToY(1.07);  // Povećaj TextField za 7% u visinu
	    	    scaleTransition.play();
	    	}

	    	private void resetTextFieldSize(TextField textField) {
	    	    // Animacija za vraćanje TextField-a na originalnu veličinu
	    	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), textField);
	    	    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
	    	    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
	    	    scaleTransition.play();

	    	}

	    	private void resetCB(ComboBox<String> cb) {
	    	    // Animacija za vraćanje TextField-a na originalnu veličinu
	    	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), cb);
	    	    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
	    	    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
	    	    scaleTransition.play();
	    	}
	    	
	    	private void enlargeTextArea(TextArea ta) {
	    		// Animacija za povećanje TextField-a
	    		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), ta);
	    		scaleTransition.setToX(1.07); // Povećaj TextField za 7% u širinu
	    		scaleTransition.setToY(1.07); // Povećaj TextField za 7% u visinu
	    		scaleTransition.play();
	    	}

	    	private void resetTextAreaSize(TextArea ta) {
	    		// Animacija za vraćanje TextField-a na originalnu veličinu
	    		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), ta);
	    		scaleTransition.setToX(1); // Vraćanje na originalnu širinu
	    		scaleTransition.setToY(1); // Vraćanje na originalnu visinu
	    		scaleTransition.play();
	    	}
	    	
	    	public void Buttons() {
	    		patientedit_confirm.setOnMouseEntered(event -> enlargeButton(patientedit_confirm));
	    		patientedit_confirm.setOnMouseExited(event -> resetButtonSize(patientedit_confirm));
			
			}
			
			public void Fields() {
				patientedit_name.setOnMouseEntered(event -> enlargeTextField(patientedit_name));
				patientedit_name.setOnMouseExited(event -> resetTextFieldSize(patientedit_name));
				 
				patientedit_number.setOnMouseEntered(event -> enlargeTextField(patientedit_number));
				patientedit_number.setOnMouseExited(event -> resetTextFieldSize(patientedit_number));
				
				patientedit_address.setOnMouseEntered(event -> enlargeTextArea(patientedit_address));
				patientedit_address.setOnMouseExited(event -> resetTextAreaSize(patientedit_address));
				
				patientedit_gender.setOnMouseEntered(event -> enlargeCB(patientedit_gender));
				patientedit_gender.setOnMouseExited(event -> resetCB(patientedit_gender));
				
				patientedit_status.setOnMouseEntered(event -> enlargeCB(patientedit_status));
				patientedit_status.setOnMouseExited(event -> resetCB(patientedit_status));
				
			}
	    	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setText();
		patientStatusList();
		patientGenderList();
		Buttons();
		Fields();
	}

}
