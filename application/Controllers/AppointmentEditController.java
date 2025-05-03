package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class AppointmentEditController implements Initializable{

	@FXML
    private TextField appEdit_appID;

    @FXML
    private TextArea appEdit_description;

    @FXML
    private TextArea appEdit_diagnosis;

    @FXML
    private ComboBox<String> appEdit_doctor;

    @FXML
    private ComboBox<String> appEdit_gender;

    @FXML
    private TextField appEdit_name;

    @FXML
    private TextField appEdit_number;

    @FXML
    private ComboBox<String> appEdit_specialization;

    @FXML
    private ComboBox<String> appEdit_status;

    @FXML
    private TextArea appEdit_treatment;

    @FXML
    private StackPane edit_appointment;

    @FXML
    private Button patientEdit_cancel;

    @FXML
    private Button patientEdit_confirm;
    
private final AlertMessage alert=new AlertMessage();
    
    @FXML
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
    	appEdit_gender.setItems(listData);
    }
    
    public void AppointmentStatusList() {
    	List<String> listS=new ArrayList<>();
    	for(String data:Data.status) {
    		listS.add(data);
    	}
    	
    	ObservableList listData=FXCollections.observableArrayList(listS);
    	appEdit_status.setItems(listData);
    }
    
    private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
	}
	
	public void DoctorList() throws ClassNotFoundException, SQLException {
		String sql="Select * from doctor where delete_status is NULL";
		
		connect();
		
		try {
			preparedStatement=connect.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			ObservableList listData=FXCollections.observableArrayList();
			while(resultSet.next()) {
				listData.add(resultSet.getString("doctor_id"));
			}
			appEdit_doctor.setItems(listData);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DoctorSpecializationList() throws ClassNotFoundException, SQLException {
		String sql="Select specialized from doctor where delete_status is NULL and doctor_id=?";
		
		connect();
		
		try {
			preparedStatement=connect.prepareStatement(sql);
			preparedStatement.setString(1,appEdit_doctor.getSelectionModel().getSelectedItem());
			resultSet=preparedStatement.executeQuery();
			ObservableList listData=FXCollections.observableArrayList();
			while(resultSet.next()) {
				listData.add(resultSet.getString("specialized"));
			}
			appEdit_specialization.setItems(listData);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

    public void setText() {
    	appEdit_appID.setText(String.valueOf(Data.temp_appID));
    	appEdit_appID.setDisable(true);
    	appEdit_name.setText(String.valueOf( Data.temp_appName));
    	appEdit_number.setText(String.valueOf(Data.temp_appContact));
    	appEdit_description.setText(String.valueOf(Data.temp_appDescription));
    	appEdit_diagnosis.setText(String.valueOf(Data.temp_appDiagnosis));
    	appEdit_treatment.setText(String.valueOf(Data.temp_appTreatment));
    	appEdit_gender.getSelectionModel().select(String.valueOf(Data.temp_appGender));
    	appEdit_status.getSelectionModel().select(String.valueOf(Data.temp_appStatus));
    	appEdit_doctor.getSelectionModel().select(String.valueOf(Data.temp_appDoctorID));
    	appEdit_specialization.getSelectionModel().select(String.valueOf(Data.temp_appDoctorSpecialization));

    }

    @FXML
    public void updateBtn() throws ClassNotFoundException, SQLException {
        // Provjera jesu li sva polja popunjena
        if (appEdit_appID.getText().isEmpty() || 
        	appEdit_name.getText().isEmpty() || 
        	appEdit_gender.getSelectionModel().isEmpty() || 
        	appEdit_number.getText().isEmpty() ||
        	appEdit_description.getText().isEmpty() ||
        	appEdit_diagnosis.getText().isEmpty() ||
        	appEdit_treatment.getText().isEmpty() ||
        	appEdit_status.getSelectionModel().isEmpty()) {
            alert.errorMessage("Please fill all blank fields!");
            return; // Prekini izvršavanje ako su polja prazna
        }

        try {
            connect(); // Poveži se na bazu podataka
            
            // Provjeri postoji li doktor sa danim ID-om
            String checkQuery = "SELECT * FROM appointment WHERE appointment_id = ?";
            preparedStatement = connect.prepareStatement(checkQuery);
            preparedStatement.setString(1, appEdit_appID.getText());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (alert.confirmationMessage("Are you sure you want to UPDATE Doctor ID: " + appEdit_appID.getText() + " ?")) {
                    // Ažuriranje podataka
                    String updateQuery = "UPDATE appointment SET name = ?, gender = ?, mobile_number = ?, description = ? , diagnosis = ? ,"
                    		+ " treatment = ? , date_modify = ?, status = ? , doctor = ? , specialized = ? WHERE appointment_id = ?";
                    preparedStatement = connect.prepareStatement(updateQuery);
                    preparedStatement.setString(1, appEdit_name.getText());
                    preparedStatement.setString(2, appEdit_gender.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(3, appEdit_number.getText());
                    preparedStatement.setString(4, appEdit_description.getText());
                    preparedStatement.setString(5, appEdit_diagnosis.getText());
                    preparedStatement.setString(6, appEdit_treatment.getText());
                    preparedStatement.setDate(7, new java.sql.Date(new Date().getTime()));
                    preparedStatement.setString(8, appEdit_status.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(9, appEdit_doctor.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(10, appEdit_specialization.getSelectionModel().getSelectedItem());
                    preparedStatement.setString(11, appEdit_appID.getText());

                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        alert.successMessage("Successfully updated Appointment ID: " + appEdit_appID.getText());
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
		appEdit_name.setOnMouseEntered(event -> enlargeTextField(appEdit_name));
		appEdit_name.setOnMouseExited(event -> resetTextFieldSize(appEdit_name));
		 
		appEdit_number.setOnMouseEntered(event -> enlargeTextField(appEdit_number));
		appEdit_number.setOnMouseExited(event -> resetTextFieldSize(appEdit_number));
		
		appEdit_diagnosis.setOnMouseEntered(event -> enlargeTextArea(appEdit_diagnosis));
		appEdit_diagnosis.setOnMouseExited(event -> resetTextAreaSize(appEdit_diagnosis));
		
		appEdit_treatment.setOnMouseEntered(event -> enlargeTextArea(appEdit_treatment));
		appEdit_treatment.setOnMouseExited(event -> resetTextAreaSize(appEdit_treatment));
		
		appEdit_description.setOnMouseEntered(event -> enlargeTextArea(appEdit_description));
		appEdit_description.setOnMouseExited(event -> resetTextAreaSize(appEdit_description));
		
		appEdit_doctor.setOnMouseEntered(event -> enlargeCB(appEdit_doctor));
		appEdit_doctor.setOnMouseExited(event -> resetCB(appEdit_doctor));
		
		appEdit_specialization.setOnMouseEntered(event -> enlargeCB(appEdit_specialization));
		appEdit_specialization.setOnMouseExited(event -> resetCB(appEdit_specialization));
		
		appEdit_status.setOnMouseEntered(event -> enlargeCB(appEdit_status));
		appEdit_status.setOnMouseExited(event -> resetCB(appEdit_status));
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GenderList();
		AppointmentStatusList();
		setText();
		Fields();
		Buttons();
		try {
			DoctorList();
			DoctorSpecializationList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
}