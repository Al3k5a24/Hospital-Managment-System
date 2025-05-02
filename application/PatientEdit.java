package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

public class PatientEdit implements Initializable{

    @FXML
    private StackPane edit_patient;

    @FXML
    private Button patientEdit_cancel;

    @FXML
    private Button patientEdit_confirm;

    @FXML
    private TextArea patientEdit_description;

    @FXML
    private ComboBox<String> patientEdit_gender;

    @FXML
    private TextField patientEdit_name;

    @FXML
    private TextField patientEdit_number;

    @FXML
    private TextField patientEdit_patientID;

    @FXML
    private ComboBox<String> patientEdit_status;
    
    private final AlertMessage alert=new AlertMessage();
    
    public void cancelBtn() {
    	if(alert.confirmationMessage("Are you sure that you want to undo changes?")) {
    		patientEdit_cancel.getScene().getWindow().hide();
    	}
    }
    
    public void GenderList() {
    	List<String> listG=new ArrayList<>();
    	for(String data:Data.gender) {
    		listG.add(data);
    	}
    	
    	ObservableList listData=FXCollections.observableArrayList(listG);
    	patientEdit_gender.setItems(listData);
    }
    
    public void DoctortStatusList() {
    	List<String> listS=new ArrayList<>();
    	for(String data:Data.status) {
    		listS.add(data);
    	}
    	
    	ObservableList listData=FXCollections.observableArrayList(listS);
    	patientEdit_status.setItems(listData);
    }
    
    private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
	}

    public void setText() {
    	patientEdit_patientID.setText(String.valueOf(Data.temp_patientID));
    	patientEdit_patientID.setDisable(true);
    	patientEdit_name.setText(String.valueOf( Data.temp_name));
    	patientEdit_number.setText(String.valueOf(Data.temp_number));
    	patientEdit_description.setText(String.valueOf(Data.temp_description));
    	patientEdit_gender.getSelectionModel().select(String.valueOf(Data.temp_gender));
    	patientEdit_status.getSelectionModel().select(String.valueOf(Data.temp_status));
    }
    
    @FXML
    public void updateBtn() throws ClassNotFoundException, SQLException {
        // Provjera jesu li sva polja popunjena
        if (patientEdit_patientID.getText().isEmpty() || 
        	patientEdit_name.getText().isEmpty() || 
        	patientEdit_gender.getSelectionModel().isEmpty() || 
            patientEdit_number.getText().isEmpty() ||
            patientEdit_description.getText().isEmpty() ||
            patientEdit_status.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please fill all blank fields!");
            return; // Prekini izvršavanje ako su polja prazna
        }

        try {
            connect(); // Poveži se na bazu podataka
            
            // Provjeri postoji li doktor sa danim ID-om
            String checkQuery = "SELECT * FROM patient WHERE patient_id = ?";
            preparedStatement = connect.prepareStatement(checkQuery);
            preparedStatement.setString(1, patientEdit_patientID.getText());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (alert.confirmationMessage("Are you sure you want to UPDATE Doctor ID: " + patientEdit_patientID.getText() + " ?")) {
                    // Ažuriranje podataka
                    String updateQuery = "UPDATE patient SET full_name = ?, gender = ?, phone_number = ?, description = ? , date_modify = ?, status = ? WHERE patient_id = ?";
                    preparedStatement = connect.prepareStatement(updateQuery);
                    preparedStatement.setString(1, patientEdit_name.getText());
                    preparedStatement.setString(2, patientEdit_gender.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(3, patientEdit_number.getText());
                    preparedStatement.setString(4, patientEdit_description.getText());
                    preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));
                    preparedStatement.setString(6, patientEdit_status.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(7, patientEdit_patientID.getText());

                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        alert.successMessage("Successfully updated Patient ID: " + patientEdit_patientID.getText());
                    } else {
                        alert.errorMessage("Update failed!");
                    }
                }
            } else {
                alert.errorMessage("Patient not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            alert.errorMessage("An error occurred: " + e.getMessage());
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
		patientEdit_confirm.setOnMouseEntered(event -> enlargeButton(patientEdit_confirm));
		patientEdit_confirm.setOnMouseExited(event -> resetButtonSize(patientEdit_confirm));
		
		patientEdit_cancel.setOnMouseEntered(event -> enlargeButton(patientEdit_cancel));
		patientEdit_cancel.setOnMouseExited(event -> resetButtonSize(patientEdit_cancel));
	}
	
	public void Fields() {
		patientEdit_patientID.setOnMouseEntered(event -> enlargeTextField(patientEdit_patientID));
		patientEdit_patientID.setOnMouseExited(event -> resetTextFieldSize(patientEdit_patientID));
		 
		patientEdit_name.setOnMouseEntered(event -> enlargeTextField(patientEdit_name));
		patientEdit_name.setOnMouseExited(event -> resetTextFieldSize(patientEdit_name));
		
		patientEdit_number.setOnMouseEntered(event -> enlargeTextField(patientEdit_number));
		patientEdit_number.setOnMouseExited(event -> resetTextFieldSize(patientEdit_number));
		
		patientEdit_description.setOnMouseEntered(event -> enlargeTextArea(patientEdit_description));
		patientEdit_description.setOnMouseExited(event -> resetTextAreaSize(patientEdit_description));
		
		patientEdit_gender.setOnMouseEntered(event -> enlargeCB(patientEdit_gender));
		patientEdit_gender.setOnMouseExited(event -> resetCB(patientEdit_gender));
		
		patientEdit_status.setOnMouseEntered(event -> enlargeCB(patientEdit_status));
		patientEdit_status.setOnMouseExited(event -> resetCB(patientEdit_status));
		
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setText();
		GenderList();
		DoctortStatusList();
		Fields();
		Buttons();
	}
    
    

}
