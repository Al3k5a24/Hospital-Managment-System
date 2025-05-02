package application;

import java.io.File;
import java.io.IOException;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Arrays;
import javafx.scene.chart.XYChart;
import java.sql.SQLException;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class DoctorFormController implements Initializable {

	@FXML
	private AnchorPane EPS_pane;
	
	@FXML
	private Line EPS_line;
	
	@FXML
	private Label EPS_label;
	
	@FXML
	private ImageView EPS_picture1;
	
	@FXML
	private ImageView EPS_picture2;
	
	@FXML
	private Label EPS_ID;
	
	@FXML
	private Label EPS_name;
	
	@FXML
	private Label EPS_email;
	
	@FXML
	private Label EPS_gender;
	
	@FXML
	private Label EPS_number;

	@FXML
	private Label EPS_address;
	
	@FXML
	private Label EPS_specialization;
	
	@FXML
	private Label EPS_status;
	
	@FXML
	private AnchorPane PS_pane;
	
	@FXML
	private Label PS_ID;
	
	@FXML
	private Label PS_name;
	
	@FXML
	private Label PS_email;
	
	@FXML
	private Label PS_datecreated;
	
	@FXML
	private Label PS_datemodify;
	
	@FXML 
	private Label APP_label_ID;
	
	@FXML 
	private Label APP_label_Name;
	
	@FXML 
	private Label APP_label_gender;
	
	@FXML 
	private Label APP_label_number;
	
	@FXML 
	private Label APP_label_description;
	
	@FXML 
	private Label APP_label_diagnosis;
	
	@FXML 
	private Label APP_label_treatment;
	
	@FXML 
	private Label APP_label_address;
	
	@FXML 
	private Label APP_label_status;
	
	@FXML  
	private Label APP_label_schedule;
	
	@FXML
	private AnchorPane APP_bottom_pane;
	
	@FXML
	private AnchorPane APP_pane;

	@FXML
	private Line APP_line;

	@FXML
	private Label APP_label;

	@FXML
	private Line PIC_line;

	@FXML
	private Label PIC_label;

	@FXML
	private Label PIC_name;

	@FXML
	private Label PIC_gender;

	@FXML
	private Label PIC_number;

	@FXML
	private Label PIC_address;

	@FXML
	private ImageView PIC_image;

	@FXML
	private AnchorPane PIC_pane;

	@FXML
	private Line PI_line;

	@FXML
	private Label PI_label;

	@FXML
	private Label PI_patID;

	@FXML
	private Label PI_name;

	@FXML
	private Label PI_gender;

	@FXML
	private Label PI_number;

	@FXML
	private Label PI_password;

	@FXML
	private Label PI_address;

	@FXML
	private AnchorPane PI_pane;

	@FXML
	private Line PA_line;

	@FXML
	private Label PA_label;

	@FXML
	private Label PA_patID;

	@FXML
	private Label PA_password;

	@FXML
	private Label PA_date;

	@FXML
	private AnchorPane PA_pane;

	@FXML
	private ImageView PA_picture;

	@FXML
	private AnchorPane upper_pane;

	@FXML
	private AnchorPane bottom_pane;

	@FXML
	private AnchorPane bottom_pane1;

	@FXML
	private AnchorPane bottom_pane2;

	@FXML
	private AnchorPane bottom_pane3;

	@FXML
	private AnchorPane Appointment_form;

	@FXML
	private AnchorPane Patients_form;

	@FXML
	private TextField appointment_address;

	@FXML
	private TextField appointment_appID;

	@FXML
	private Button appointment_btn;

	@FXML
	private Button logoutBtn;

	@FXML
	private Button appointment_clearbtn;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_contact;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_date;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_datedelete;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_datemodify;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_description;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_gender;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_id;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_name;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_status;

	@FXML
	private Button appointment_deletebtn;

	@FXML
	private TextField appointment_description;

	@FXML
	private TextField appointment_diagnosis;

	@FXML
	private ComboBox<String> appointment_gender;

	@FXML
	private Button appointment_insertbtn;

	@FXML
	private TextField appointment_mobile;

	@FXML
	private TextField appointment_name;

	@FXML
	private DatePicker appointment_schedule;

	@FXML
	private ComboBox<String> appointment_status;

	@FXML
	private TableView<AppointmentData> appointment_tableview;

	@FXML
	private TextField appointment_treatment;

	@FXML
	private Button appointment_updatebtn;

	@FXML
	private Label current_form;

	@FXML
	private AnchorPane dashboard_AD;

	@FXML
	private AnchorPane dashboard_AP;

	@FXML
	private AnchorPane dashboard_TA;

	@FXML
	private AnchorPane dashboard_TP;

	@FXML
	private Button dashboard_btn;

	@FXML
	private BarChart<?, ?> dashboard_chart_DD;

	@FXML
	private AreaChart<?, ?> dashboard_chart_PD;

	@FXML
	private TableColumn<AppointmentData, String> dashboard_col_appID;

	@FXML
	private TableColumn<AppointmentData, String> dashboard_col_name;

	@FXML
	private TableColumn<AppointmentData, String> dashboard_col_description;

	@FXML
	private TableColumn<AppointmentData, String> dashboard_col_date;

	@FXML
	private TableColumn<AppointmentData, String> dashboard_col_status;

	@FXML
	private AnchorPane dashboard_form;

	@FXML
	private TableView<AppointmentData> dashboard_tableview;

	@FXML
	private Label date_time;

	@FXML
	private TextField editprofile_address;

	@FXML
	private TextField editprofile_doctorID;

	@FXML
	private TextField editprofile_email;

	@FXML
	private ComboBox<String> editprofile_gender;

	@FXML
	private TextField editprofile_name;

	@FXML
	private TextField editprofile_number;

	@FXML
	private ComboBox<String> editprofile_specialization;

	@FXML
	private ComboBox<String> editprofile_status;

	@FXML
	private Button editprofile_updatebtn;

	@FXML
	private AnchorPane main_form;

	@FXML
	private Label nav_id;

	@FXML
	private Label nav_username;

	@FXML
	private Button patientform_PA_addbtn;

	@FXML
	private Label patientform_PA_adress;

	@FXML
	private Label patientform_PA_contact;

	@FXML
	private Label patientform_PA_datecreated;

	@FXML
	private Label patientform_PA_password;

	@FXML
	private Label patientform_PA_patientID;

	@FXML
	private Label patientform_PA_patientgender;

	@FXML
	private Label patientform_PA_patientname;

	@FXML
	private Button patientform_PA_recordbtn;

	@FXML
	private TextArea patientform_adress;

	@FXML
	private Button patientform_confirm;

	@FXML
	private ComboBox<String> patientform_gender;

	@FXML
	private TextField patientform_patientID;

	@FXML
	private TextField patientform_patientcontact;

	@FXML
	private TextField patientform_patientname;

	@FXML
	private TextField patientform_patientpassword;

	@FXML
	private Button patients_btn;

	@FXML
	private Button profile_settings_btn;

	@FXML
	private AnchorPane profile_settings_form;

	@FXML
	private Label settings_address;

	@FXML
	private Label settings_datecreated;

	@FXML
	private Label settings_doctorID;

	@FXML
	private Label settings_datemodify;

	@FXML
	private Label settings_name;

	@FXML
	private Circle settings_picture;

	@FXML
	private Circle top_profile;

	@FXML
	private Label top_username;

	@FXML
	private Button settings_ImportPicture;
	@FXML
	private Label dashboard_AP_count;

	@FXML
	private Label dashboard_IP_count;

	@FXML
	private Label dashboard_TA_count;

	@FXML
	private Label dashboard_TP_count;

	@FXML
	public void switchForm(ActionEvent event) {

		if (event.getSource() == dashboard_btn) {
			dashboard_form.setVisible(true);
			dashboard_form.setDisable(false);
			FadeInDashboard();
			Patients_form.setVisible(false);
			Patients_form.setDisable(true);
			Appointment_form.setVisible(false);
			Appointment_form.setDisable(true);
			profile_settings_form.setVisible(false);
			profile_settings_form.setDisable(true);
		} else if (event.getSource() == patients_btn) {
			dashboard_form.setVisible(false);
			dashboard_form.setDisable(true);
			Patients_form.setVisible(true);
			Patients_form.setDisable(false);
			FadeInPatientAdd();
			Appointment_form.setVisible(false);
			Appointment_form.setDisable(true);
			profile_settings_form.setVisible(false);
			profile_settings_form.setDisable(true);
		} else if (event.getSource() == appointment_btn) {
			dashboard_form.setVisible(false);
			dashboard_form.setDisable(true);
			Patients_form.setVisible(false);
			Patients_form.setDisable(true);
			Appointment_form.setVisible(true);
			Appointment_form.setDisable(false);
			FadeInAppointment();
			profile_settings_form.setVisible(false);
			profile_settings_form.setDisable(true);
		} else if (event.getSource() == profile_settings_btn) {
			profile_settings_form.setVisible(true);
			profile_settings_form.setDisable(false);
			FadeInProfileEdit();
			dashboard_form.setVisible(false);
			dashboard_form.setDisable(true);
			Patients_form.setVisible(false);
			Patients_form.setDisable(true);
			Appointment_form.setVisible(false);
			Appointment_form.setDisable(true);
		}
	}

	private final AlertMessage alert = new AlertMessage();

	private void patientGenderList() {
		List<String> listG = new ArrayList<>();
		for (String data : Data.gender) {
			listG.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listG);
		patientform_gender.setItems(listData);
		editprofile_gender.setItems(listData);
	}

	private Image image;

	private void doctorSpecialization() {
		List<String> listS = new ArrayList<>();
		for (String data : Data.specialization) {
			listS.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listS);
		editprofile_specialization.setItems(listData);
	}

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
	}

	public ObservableList<AppointmentData> appointmentGetData() throws ClassNotFoundException, SQLException {
		ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

		String sql = "SELECT * FROM appointment WHERE date_delete IS NULL";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			AppointmentData appdata;

			while (resultSet.next()) {

				appdata = new AppointmentData(resultSet.getInt("appointment_id"), resultSet.getString("name"),
						resultSet.getString("gender"), resultSet.getLong("mobile_number"),
						resultSet.getString("description"), resultSet.getString("diagnosis"),
						resultSet.getString("treatment"), resultSet.getString("address"), resultSet.getDate("date"),
						resultSet.getDate("date_modify"), resultSet.getDate("date_delete"),
						resultSet.getString("status"), resultSet.getDate("date_modify"));
				listData.add(appdata);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listData;
	}

	public ObservableList<AppointmentData> appointmentListData;

	public void appointmentShowData() throws ClassNotFoundException, SQLException {
		appointmentListData = appointmentGetData();
		appointment_col_id.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
		appointment_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		appointment_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		appointment_col_contact.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
		appointment_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
		appointment_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		appointment_col_datemodify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
		appointment_col_datedelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
		appointment_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

		appointment_tableview.setItems(appointmentListData);
	}

	@FXML
	public void appointmentSelect() {

		AppointmentData appData = appointment_tableview.getSelectionModel().getSelectedItem();
		int num = appointment_tableview.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1)
			return;

		appointment_appID.setText("" + appData.getAppointmentID());
		appointment_name.setText(appData.getName());
		appointment_gender.getSelectionModel().select(appointment_gender.getItems().indexOf(appData.getGender()));
		appointment_mobile.setText("" + appData.getMobileNumber());
		appointment_description.setText(appData.getDescription());
		appointment_diagnosis.setText(appData.getDiagnosis());
		appointment_treatment.setText(appData.getTreatment());
		appointment_address.setText(appData.getAddress());
		appointment_status.getSelectionModel().select(appointment_status.getItems().indexOf(appData.getStatus()));

	}

	public void appointmentGenderList() {
		List<String> listG = new ArrayList<>();
		for (String data : Data.gender) {
			listG.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listG);
		appointment_gender.setItems(listData);
	}

	public void appointmentStatusList() {
		List<String> listS = new ArrayList<>();
		for (String data : Data.status) {
			listS.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listS);
		appointment_status.setItems(listData);
	}

	public void doctoredtiStatus() {
		List<String> listS = new ArrayList<>();
		for (String data : Data.doctorStatus) {
			listS.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listS);
		editprofile_status.setItems(listData);
	}

	public void displayDoctorIDUsername() throws ClassNotFoundException, SQLException {

		String sql = "Select * from doctor where doctor_id='" + Data.doctor_id + "'";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				nav_id.setText(Data.doctor_id);
				String tempUsername = resultSet.getString("full_name");
				// prvo svolo username-a pretvara u veliko slovo
				tempUsername = tempUsername.substring(0, 1).toUpperCase() + tempUsername.substring(1);
				nav_username.setText(tempUsername);
				top_username.setText(tempUsername);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// datum i vreme
	public void runTime() {
		new Thread() {
			public void run() {
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
				while (true) {
					try {
						Thread.sleep(1000);
					} // 1000 ms = 1s
					catch (Exception e) {
						e.printStackTrace();
					}
					Platform.runLater(() -> {
						date_time.setText(format.format(new Date()));
					});
				}
			}
		}.start();
	}

	@FXML
	public void appointmentInsertBtn() throws ClassNotFoundException, SQLException {

		appointment_insertbtn.setOnAction(event -> {
			// Provera da li su sva polja popunjena
			if (appointment_appID.getText().trim().isEmpty() || appointment_name.getText().trim().isEmpty()
					|| appointment_mobile.getText().trim().isEmpty()
					|| appointment_description.getText().trim().isEmpty()
					|| appointment_address.getText().trim().isEmpty()
					|| appointment_gender.getSelectionModel().getSelectedItem() == null
					|| appointment_status.getSelectionModel().getSelectedItem() == null
					|| appointment_schedule.getValue() == null) {

				alert.errorMessage("Please fill all blank fields!");
				return;
			}else {

			try {
				connect();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Otvaramo konekciju samo jednom

			try {
				// 1. Provera da li već postoji unet ID
				String checkAppointment = "SELECT * FROM appointment WHERE appointment_id = ?";
				preparedStatement = connect.prepareStatement(checkAppointment);
				preparedStatement.setString(1, appointment_appID.getText());
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					alert.errorMessage("Appointment ID " + appointment_appID.getText() + " is already taken!");
					return;
				}

				// 2. Provera specijalizacije doktora
				String getSpecialized = null;
				if (Data.doctor_id != null && !Data.doctor_id.trim().isEmpty()) {
					String getDoctorData = "SELECT specialized FROM doctor WHERE doctor_id = ?";
					preparedStatement = connect.prepareStatement(getDoctorData);
					preparedStatement.setString(1, Data.doctor_id);
					resultSet = preparedStatement.executeQuery();

					if (resultSet.next()) {
						getSpecialized = resultSet.getString("specialized");
					} else {
						alert.errorMessage("Doctor ID not found!");
						return;
					}
				} else {
					alert.errorMessage("Invalid doctor ID!");
					return;
				}

				// 3. Ubacivanje podataka u bazu
				String insertData = "INSERT INTO appointment(appointment_id, name, gender, description, diagnosis, treatment, mobile_number, address, date, status, doctor, specialized, schedule) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				preparedStatement = connect.prepareStatement(insertData);
				preparedStatement.setString(1, appointment_appID.getText());
				preparedStatement.setString(2, appointment_name.getText());
				preparedStatement.setString(3, appointment_gender.getSelectionModel().getSelectedItem().toString());
				preparedStatement.setString(4, appointment_description.getText());
				preparedStatement.setString(5, appointment_diagnosis.getText());
				preparedStatement.setString(6, appointment_treatment.getText());
				preparedStatement.setString(7, appointment_mobile.getText());
				preparedStatement.setString(8, appointment_address.getText());

				java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
				preparedStatement.setDate(9, sqlDate);
				preparedStatement.setString(10, appointment_status.getSelectionModel().getSelectedItem().toString());
				preparedStatement.setString(11, Data.doctor_id);
				preparedStatement.setString(12, getSpecialized);
				preparedStatement.setString(13, appointment_schedule.getValue().toString());

				int rowsInserted = preparedStatement.executeUpdate();

				if (rowsInserted > 0) {
					appointmentShowData();
					appointmentAppointmentID();
					appointmentClear();
					alert.successMessage("Successfully added!");
				} else {
					alert.errorMessage("Failed to add appointment.");
				}

			} catch (Exception e) {
				e.printStackTrace();
				alert.errorMessage("An error occurred while inserting the appointment.");
			}
			}
		});
	}

	@FXML
	public void appointmentClear() {
		appointment_name.clear();
		appointment_gender.getSelectionModel().clearSelection();
		appointment_mobile.clear();
		appointment_description.clear();
		appointment_diagnosis.clear();
		appointment_treatment.clear();
		appointment_address.clear();
		appointment_status.getSelectionModel().clearSelection();
		appointment_schedule.setValue(null);
	}

	@FXML
	public void appointmentUpdate() throws ClassNotFoundException, SQLException {
		appointment_updatebtn.setOnAction(event -> {
			java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

			// Provera da li su sva polja popunjena
			if (appointment_appID.getText().trim().isEmpty() || appointment_name.getText().trim().isEmpty()
					|| appointment_mobile.getText().trim().isEmpty()
					|| appointment_description.getText().trim().isEmpty()
					|| appointment_address.getText().trim().isEmpty()
					|| appointment_gender.getSelectionModel().getSelectedItem() == null
					|| appointment_status.getSelectionModel().getSelectedItem() == null
					|| appointment_schedule.getValue() == null) {

				alert.errorMessage("Please fill all blank fields!");
				return; // Prekid funkcije ako su neka polja prazna
			}else {

			String updateData = "UPDATE appointment SET name=?, gender=?, mobile_number=?, "
					+ "description=?, address=?, status=?, schedule=?, date_modify=? " + "WHERE appointment_id=?";
			try {
				connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// Provera da li korisnik potvrđuje ažuriranje
				if (alert.confirmationMessage(
						"Are you sure you want to UPDATE Appointment ID: " + appointment_appID.getText() + " ?")) {
					preparedStatement = connect.prepareStatement(updateData);
					preparedStatement.setString(1, appointment_name.getText());
					preparedStatement.setString(2, appointment_gender.getSelectionModel().getSelectedItem().toString());
					preparedStatement.setString(3, appointment_mobile.getText());
					preparedStatement.setString(4, appointment_description.getText());
					preparedStatement.setString(5, appointment_address.getText());
					preparedStatement.setString(6, appointment_status.getSelectionModel().getSelectedItem().toString());
					preparedStatement.setString(7, appointment_schedule.getValue().toString());
					preparedStatement.setDate(8, sqlDate);
					preparedStatement.setString(9, appointment_appID.getText()); // WHERE condition

					int rowsUpdated = preparedStatement.executeUpdate();

					if (rowsUpdated > 0) {
						appointmentShowData();
						appointmentAppointmentID();
						appointmentClear();
						alert.successMessage("Successfully Updated!");
					} else {
						alert.errorMessage("No appointment found with the given ID.");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				alert.errorMessage("An error occurred while updating the appointment.");
			} 
			}
		});
	}

	@FXML
	public void appointmentDelete() throws ClassNotFoundException, SQLException {
			if (appointment_appID.getText().isEmpty() || appointment_name.getText().isEmpty()) {
				alert.errorMessage("Please select an appointment first!");
				return; // Prekida izvršenje ako polje nije popunjeno
			}else {

			String updateData = "UPDATE appointment SET date_delete = ? WHERE appointment_id = ?";
			try {
				connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

			try {
				if (alert.confirmationMessage(
						"Are you sure you want to DELETE Appointment ID: " + appointment_appID.getText() + "?")) {
					preparedStatement = connect.prepareStatement(updateData);
					preparedStatement.setDate(1, sqlDate);
					preparedStatement.setString(2, appointment_appID.getText());

					int rowsUpdated = preparedStatement.executeUpdate();

					if (rowsUpdated > 0) {
						appointmentShowData();
						appointmentAppointmentID();
						appointmentClear();
						alert.successMessage("Appointment marked as deleted.");
					} else {
						alert.errorMessage("No appointment found with the given ID.");
					}
				} else {
					alert.errorMessage("Deletion canceled.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				alert.errorMessage("An error occurred while deleting the appointment.");
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
					if (connect != null)
						connect.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			}
	}

	@FXML
	public void patientConfirm() {
		if (patientform_patientID.getText().trim().isEmpty() || patientform_patientname.getText().trim().isEmpty()
				|| patientform_patientcontact.getText().trim().isEmpty()
				|| patientform_patientpassword.getText().trim().isEmpty()
				|| patientform_adress.getText().trim().isEmpty()
				|| patientform_gender.getSelectionModel().getSelectedItem() == null) {

			alert.errorMessage("Please fill all blank fields!");
			return; // Prekid funkcije ako su neka polja prazna
		} else {
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			patientform_PA_patientID.setText(patientform_patientID.getText());
			patientform_PA_password.setText(patientform_patientpassword.getText());
			patientform_PA_patientname.setText(patientform_patientname.getText());
			patientform_PA_patientgender.setText((String) patientform_gender.getSelectionModel().getSelectedItem());
			patientform_PA_contact.setText(patientform_patientcontact.getText());
			patientform_PA_adress.setText(patientform_adress.getText());
			patientform_PA_datecreated.setText(String.valueOf(sqlDate));
			;

			patientConfirmclear();
		}

	}

	public void patientConfirmclear() {
		patientform_patientID.clear();
		patientform_patientname.clear();
		patientform_patientcontact.clear();
		patientform_patientpassword.clear();
		patientform_adress.clear();
		patientform_gender.setSelectionModel(null);
		;
	}

	@FXML
	public void patientAdd() throws ClassNotFoundException, SQLException {
		if (patientform_PA_patientID.getText().trim().isEmpty() || patientform_PA_password.getText().trim().isEmpty()
				|| patientform_PA_patientname.getText().trim().isEmpty()
				|| patientform_PA_contact.getText().trim().isEmpty() || patientform_PA_adress.getText().trim().isEmpty()
				|| patientform_PA_datecreated.getText().trim().isEmpty()) {

			alert.errorMessage("Something went wrong");
			return; // Prekid funkcije ako su neka polja prazna
		} else {
			connect();

			String doctorname = "";
			String doctorspecialized = "";

			String checkdoctor = ("Select * from doctor where doctor_id='" + nav_id.getText() + "'");
			preparedStatement = connect.prepareStatement(checkdoctor);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				doctorname = resultSet.getString("full_name");
				doctorspecialized = resultSet.getString("specialized");

				if (doctorspecialized == "" || doctorspecialized == null) {
					doctorspecialized = "N/A";
				}
			}

			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			String checkPatientID = "Select * from patient where patient_id=?";
			preparedStatement = connect.prepareStatement(checkPatientID);
			preparedStatement.setString(1, patientform_PA_patientID.getText().trim());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				alert.errorMessage(patientform_PA_patientID.getText() + " already exists!");
			} else {
				String insertData = "INSERT INTO patient(patient_id, full_name, password, phone_number, "
						+ "address, image, description, diagnosis, treatment, doctor, "
						+ "specialized, date, status, gender) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ?)";

				preparedStatement = connect.prepareStatement(insertData);
				preparedStatement.setString(1, patientform_PA_patientID.getText());
				preparedStatement.setString(2, patientform_PA_patientname.getText());
				preparedStatement.setString(3, patientform_PA_password.getText());
				preparedStatement.setString(4, patientform_PA_contact.getText());
				preparedStatement.setString(5, patientform_PA_adress.getText());
				preparedStatement.setString(6, ""); // Image - Ako nema slike
				preparedStatement.setString(7, ""); // Description
				preparedStatement.setString(8, ""); // Diagnosis
				preparedStatement.setString(9, ""); // Treatment
				preparedStatement.setString(10, nav_username.getText()); // Doctor
				preparedStatement.setString(11, doctorspecialized); // Specialized
				preparedStatement.setDate(12, sqlDate);
				preparedStatement.setString(13, "Confirm");
				preparedStatement.setString(14, patientform_PA_patientgender.getText());

				preparedStatement.executeUpdate();

				alert.successMessage("Successfully inserted data!");

				patientAddclear();
			}

			try {
				if (connect == null) {
					alert.errorMessage("Database connection failed!");
					return;
				}

			} catch (Exception e) {
				alert.errorMessage("Database error: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public void patientAddclear() {
		patientform_PA_patientID.setText(null);
		patientform_PA_password.setText(null);
		patientform_PA_datecreated.setText(null);
		patientform_PA_patientname.setText(null);
		patientform_PA_patientgender.setText(null);
		patientform_PA_contact.setText(null);
		patientform_PA_adress.setText(null);
	}

	@FXML
	public void patientRecord() {
		try {
			String username = nav_username.getText();
			if (username == null || username.isEmpty()) {
				System.out.println("Doctor username is null or empty!");
				return; // Prekidamo ako nema ID-a
			}

			Data.doctor_username = username;
			System.out.println("Doctor username postavljen: " + username);

			Parent root = FXMLLoader.load(getClass().getResource("RecordPage.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Hospital Management System | Doctor Portal");
			stage.setScene(new Scene(root));
			stage.show();

			// patientform_PA_recordbtn.getScene().getWindow().hide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// izbegava dupliranje ID-a
	private Integer appointmentID;

	public void appointmentGetAppointmentID() throws ClassNotFoundException, SQLException {
		String sql = "Select MAX(appointment_id) from appointment";
		connect();

		int tempappID = 0;

		try {
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				tempappID = resultSet.getInt("MAX(appointment_id)");
			}

			if (tempappID == 0) {
				tempappID += 1;
			} else {
				tempappID += 1;
			}

			appointmentID = tempappID;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void appointmentAppointmentID() throws ClassNotFoundException, SQLException {
		appointmentGetAppointmentID();
		appointment_appID.setText("" + appointmentID);
		appointment_appID.setDisable(true);
	}

	public void DoctorEditSetText() {
		try {
			connect();
			String sql = "Select * from doctor where doctor_id=?";
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, nav_id.getText());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				settings_doctorID.setText(resultSet.getString("doctor_id"));
				settings_name.setText(resultSet.getString("full_name"));
				settings_address.setText(resultSet.getString("email"));
				settings_datecreated.setText(resultSet.getString("date"));

				if (settings_datemodify.getText().isEmpty() || settings_datemodify == null) {
					settings_datemodify.setText("Not updated recently");
				} else {
					settings_datemodify.setText(resultSet.getString("modify_date"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void EditDoctorSettext() {
		try {
			connect();
			String sql = "Select * from doctor where doctor_id=?";
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, nav_id.getText());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				editprofile_doctorID.setText(resultSet.getString("doctor_id"));
				editprofile_name.setText(resultSet.getString("full_name"));
				editprofile_email.setText(resultSet.getString("email"));
				editprofile_gender.getSelectionModel().select(resultSet.getString("gender"));
				editprofile_number.setText(resultSet.getString("phone_number"));
				editprofile_address.setText(resultSet.getString("address"));
				editprofile_specialization.getSelectionModel().select(resultSet.getString("specialized"));
				editprofile_status.getSelectionModel().select(resultSet.getString("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// importovanje profilnih slika
	@FXML
	public void profileChangeProfile() {
		FileChooser open = new FileChooser();
		open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*.png", "*.jpg", "*.jpeg"));

		// Provera da li dugme postoji
		if (settings_ImportPicture == null) {
			System.out.println("ERROR: settings_ImportPicture je null! Proverite FXML fajl i @FXML anotaciju.");
			return;
		}

		// Provera da li scena postoji
		if (settings_ImportPicture.getScene() == null) {
			System.out.println("ERROR: settings_ImportPicture.getScene() je null! GUI možda još nije učitan.");
			return;
		}

		File file = open.showOpenDialog(settings_ImportPicture.getScene().getWindow());

		if (file == null) {
			System.out.println("Nije izabrana nijedna slika.");
			return;
		}

		System.out.println("Izabrana slika: " + file.getAbsolutePath());
		Data.path = file.getAbsolutePath();

		Image image = new Image(file.toURI().toString(), 156, 114, false, true);

		if (image.isError()) {
			System.out.println("ERROR: Problem pri učitavanju slike.");
			return;
		}

		// Provera da li settings_picture postoji
		if (settings_picture == null) {
			System.out.println("ERROR: settings_picture je null! Proverite fx:id u FXML fajlu.");
			return;
		}

		settings_picture.setFill(new ImagePattern(image));
		System.out.println("Slika je uspešno postavljena.");
	}

	public void updateDataDoctor() throws SQLException, ClassNotFoundException {
		if (editprofile_doctorID.getText().isEmpty() || editprofile_name.getText().isEmpty()
				|| editprofile_email.getText().isEmpty() || editprofile_gender.getSelectionModel().isEmpty()
				|| editprofile_number.getText().isEmpty() || editprofile_address.getText().isEmpty()
				|| editprofile_specialization.getSelectionModel().isEmpty()
				|| editprofile_status.getSelectionModel().isEmpty()) {
			alert.errorMessage("Please fill all blank fields!");
		} else {
			Data.doctor_id = nav_id.getText();
			editprofile_doctorID.setDisable(true);
			try {
				connect();
				String sql = "Select * from doctor where doctor_id=?";
				preparedStatement = connect.prepareStatement(sql);
				preparedStatement.setString(1, nav_id.getText());
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					String updateData = "UPDATE doctor SET full_name = ?, email = ?, gender = ?, phone_number = ?, address = ?, image = ? , specialized = ?, modify_date = ?, status = ?, doctor_id = ? WHERE doctor_id = ?";
					preparedStatement = connect.prepareStatement(updateData);

					preparedStatement.setString(1, editprofile_name.getText());
					preparedStatement.setString(2, editprofile_email.getText());
					preparedStatement.setString(3, editprofile_gender.getSelectionModel().getSelectedItem());
					preparedStatement.setString(4, editprofile_number.getText());
					preparedStatement.setString(5, editprofile_address.getText());

					// Ako slika nije promenjena, zadrži postojeću
					String path = null;
					String existingImagePath = resultSet.getString("image"); // Postojeća putanja slike u bazi
					if (Data.path != null && !Data.path.isEmpty()) {
						// Ako je korisnik odabrao novu sliku, kopiraj je
						path = Data.path;
					} else if (existingImagePath != null && !existingImagePath.isEmpty()) {
						// Ako nije selektovana nova slika, zadrži postojeću
						path = existingImagePath;
					} else {
						alert.errorMessage("No image selected or available.");
						return;
					}

					// Kreiraj direktorijum ako ne postoji
					java.nio.file.Path targetDir = Paths.get(
							"C:\\Users\\Win10\\Desktop\\Java\\JavaFx\\HospitalManagment\\src\\application\\ProfilneSlikeStorage\\DoctorForm\\");
					if (!Files.exists(targetDir)) {
						try {
							Files.createDirectories(targetDir);
						} catch (IOException e) {
							e.printStackTrace();
							alert.errorMessage("Error creating directories: " + e.getMessage());
							return;
						}
					}

					// Ako je slika nova, kopiraj je
					if (Data.path != null && !Data.path.isEmpty()) {
						path = path.replace("\\", "\\\\");
						java.nio.file.Path transfer = Paths.get(path);
						java.nio.file.Path copy = Paths.get(
								"C:\\Users\\Win10\\Desktop\\Java\\JavaFx\\HospitalManagment\\src\\application\\ProfilneSlikeStorage\\DoctorForm\\"
										+ editprofile_doctorID.getText() + ".jpg");

						try {
							Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e) {
							e.printStackTrace();
							alert.errorMessage("Error while copying the image: " + e.getMessage());
							return;
						}
						path = copy.toAbsolutePath().toString();
					}
					preparedStatement.setString(6, path);

					preparedStatement.setString(7, editprofile_specialization.getSelectionModel().getSelectedItem());
					preparedStatement.setDate(8, new java.sql.Date(new Date().getTime()));
					preparedStatement.setString(9, editprofile_status.getSelectionModel().getSelectedItem());
					preparedStatement.setString(10, editprofile_doctorID.getText());
					preparedStatement.setString(11, Data.doctor_id);

					int rowsUpdated = preparedStatement.executeUpdate();
					if (rowsUpdated > 0) {
						alert.successMessage("Successfully updated!");
					} else {
						alert.errorMessage("Update failed!");
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// prikazivanje slika
	public void displayProfilePictures() throws ClassNotFoundException, SQLException {

		connect();
		String sql = "Select * from doctor where doctor_id=?";

		String path1 = "";
		String path2 = "";
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, nav_id.getText());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				path1 = "File:" + resultSet.getString("image");
				path2 = "File:" + resultSet.getString("image");

				if (resultSet.getString("image") != null) {
					image = new Image(path1, 798, 21, false, true);
					top_profile.setFill(new ImagePattern(image));

					image = new Image(path2, 156, 114, false, true);
					settings_picture.setFill(new ImagePattern(image));
				}
			}
		} catch (Exception e) {

		}

	}

	// prebrojava broj neaktivnih pacijenata
	public void dashboardIP() {
		Data.doctor_username = nav_username.getText();
		String sql = "Select count(id) from patient where status='Inactive' and doctor=?";
		try {
			connect();
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, nav_username.getText());
			resultSet = preparedStatement.executeQuery();
			int getIP = 0;
			if (resultSet.next()) {
				getIP = resultSet.getInt("count(id)");
			}
			dashboard_IP_count.setText(String.valueOf(getIP));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// prebrojava ukupan broj pacijenata
	public void dashboardTP() {
		Data.doctor_username = nav_username.getText();
		String sql = "Select count(id) from patient where doctor=?";
		try {
			connect();
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, nav_username.getText());
			resultSet = preparedStatement.executeQuery();
			int getIP = 0;
			if (resultSet.next()) {
				getIP = resultSet.getInt("count(id)");
			}
			dashboard_TP_count.setText(String.valueOf(getIP));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// prebrojava broj aktivnih pacijenata
	public void dashboardAP() {
		Data.doctor_username = nav_username.getText();
		String sql = "Select count(id) from patient where doctor=? and status='Active'";
		try {
			connect();
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, nav_username.getText());
			resultSet = preparedStatement.executeQuery();
			int getIP = 0;
			if (resultSet.next()) {
				getIP = resultSet.getInt("count(id)");
			}
			dashboard_AP_count.setText(String.valueOf(getIP));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// prebrojava ukupan broj zakazanih termina
	public void dashboardTA() {
		Data.doctor_username = nav_username.getText();
		String sql = "Select count(id) from appointment";
		try {
			connect();
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			int getIP = 0;
			if (resultSet.next()) {
				getIP = resultSet.getInt("count(id)");
			}
			dashboard_TA_count.setText(String.valueOf(getIP));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// dashboard tabela za termine
	public ObservableList<AppointmentData> DashboardappointmentGetData() throws ClassNotFoundException, SQLException {
		ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

		String sql = "SELECT * FROM appointment WHERE date_delete IS NULL";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			AppointmentData appdata;

			while (resultSet.next()) {

				appdata = new AppointmentData(resultSet.getInt("appointment_id"), resultSet.getString("name"),
						resultSet.getString("description"), resultSet.getDate("date"), resultSet.getString("status"));
				listData.add(appdata);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listData;
	}

	private ObservableList<AppointmentData> DashboardList;

	public void DashboardappointmentShowData() throws ClassNotFoundException, SQLException {
		DashboardList = DashboardappointmentGetData();
		dashboard_col_appID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
		dashboard_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		dashboard_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
		dashboard_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		dashboard_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

		dashboard_tableview.setItems(DashboardList);
	}

	// chart za broj pacijenata
	public void dashboardNOP() throws ClassNotFoundException, SQLException {
		dashboard_chart_PD.getData().clear();

		String sql = "SELECT COUNT(id) AS count_value, date FROM patient WHERE status='Active' AND doctor=? GROUP BY date ORDER BY date ASC LIMIT 8";

		Data.doctor_username = nav_username.getText();
		connect();

		try {
			XYChart.Series chart = new XYChart.Series<>();
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Data.doctor_username);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Integer count = resultSet.getInt("count_value");
				String date = resultSet.getString("date");
				chart.getData().add(new XYChart.Data(date, count));
			}

			dashboard_chart_PD.getData().add(chart);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (resultSet != null)
				resultSet.close();
			if (connect != null)
				connect.close();
		}
	}

	// chart za broj termine
	public void dashboardNOA() throws ClassNotFoundException, SQLException {
		dashboard_chart_DD.getData().clear();

		String sql = "SELECT COUNT(id) AS count_value, date FROM appointment WHERE doctor=? GROUP BY date ORDER BY date ASC LIMIT 8";

		Data.doctor_id = nav_id.getText();
		connect();

		try {
			XYChart.Series chart = new XYChart.Series<>();
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Data.doctor_id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Integer count = resultSet.getInt("count_value");
				String date = resultSet.getString("date");
				chart.getData().add(new XYChart.Data(date, count));
			}

			dashboard_chart_DD.getData().add(chart);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (resultSet != null)
				resultSet.close();
			if (connect != null)
				connect.close();
		}
	}

	public void logoutBtn() {
		try {
			if (alert.confirmationMessage("Are you sure you want to logout?")) {
				Data.doctor_id = "";
				Data.doctor_username = "";

				Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();

				stage.setTitle("Hospital Managment System");

				logoutBtn.getScene().getWindow().hide();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void enlargeButton(Button button) {
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), button);
		scaleTransition.setToX(1.10); // Povećaj za 10% u širinu
		scaleTransition.setToY(1.10); // Povećaj za 10% u visinu
		scaleTransition.play();
	}

	private void resetButtonSize(Button button) {
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), button);
		scaleTransition.setToX(1); // Vraćanje na originalnu širinu
		scaleTransition.setToY(1); // Vraćanje na originalnu visinu
		scaleTransition.play();
	}

	public void FadeInDashboard() {

		// Postavljanje opacity na 0 na početku
		dashboard_AD.setOpacity(0);
		dashboard_TP.setOpacity(0);
		dashboard_AP.setOpacity(0);
		dashboard_TA.setOpacity(0);
		upper_pane.setOpacity(0);
		bottom_pane.setOpacity(0);
		bottom_pane1.setOpacity(0);
		bottom_pane2.setOpacity(0);
		bottom_pane3.setOpacity(0);

		// Fade animacija za mainPane1
		FadeTransition fadeMain1 = new FadeTransition(Duration.seconds(1.5), upper_pane);
		fadeMain1.setFromValue(0);
		fadeMain1.setToValue(1);

		PauseTransition delayBeforeupper1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fademainupper1 = new FadeTransition(Duration.seconds(0.5), dashboard_AD);
		fademainupper1.setFromValue(0);
		fademainupper1.setToValue(1);

		PauseTransition delayBeforeupper2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fademainupper2 = new FadeTransition(Duration.seconds(0.5), dashboard_TP);
		fademainupper2.setFromValue(0);
		fademainupper2.setToValue(1);

		PauseTransition delayBeforeupper3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fademainupper3 = new FadeTransition(Duration.seconds(0.5), dashboard_AP);
		fademainupper3.setFromValue(0);
		fademainupper3.setToValue(1);

		PauseTransition delayBeforeupper4 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fademainupper4 = new FadeTransition(Duration.seconds(0.5), dashboard_TA);
		fademainupper4.setFromValue(0);
		fademainupper4.setToValue(1);

		// Fade animacija za mainPane2
		FadeTransition fadeMain2 = new FadeTransition(Duration.seconds(1), bottom_pane);
		fadeMain2.setFromValue(0);
		fadeMain2.setToValue(1);

		// Kašnjenje pre innerPane1
		PauseTransition delayBeforeInner1 = new PauseTransition(Duration.seconds(0.3));

		// Fade animacija za innerPane1
		FadeTransition fadeInner1 = new FadeTransition(Duration.seconds(0.5), bottom_pane1);
		fadeInner1.setFromValue(0);
		fadeInner1.setToValue(1);

		// Kašnjenje pre innerPane2
		PauseTransition delayBeforeInner2 = new PauseTransition(Duration.seconds(0.5));

		// Fade animacija za innerPane2
		FadeTransition fadeInner2 = new FadeTransition(Duration.seconds(0.5), bottom_pane2);
		fadeInner2.setFromValue(0);
		fadeInner2.setToValue(1);

		// Kašnjenje pre innerPane3
		PauseTransition delayBeforeInner3 = new PauseTransition(Duration.seconds(0.7));

		// Fade animacija za innerPane3
		FadeTransition fadeInner3 = new FadeTransition(Duration.seconds(0.5), bottom_pane3);
		fadeInner3.setFromValue(0);
		fadeInner3.setToValue(1);

		// Redosled animacija sa kašnjenjima
		SequentialTransition sequentialTransition = new SequentialTransition(fadeMain1, delayBeforeupper1,
				fademainupper1, delayBeforeupper2, fademainupper2, delayBeforeupper3, fademainupper3, delayBeforeupper4,
				fademainupper4, fadeMain2, delayBeforeInner1, fadeInner1, delayBeforeInner2, fadeInner2,
				delayBeforeInner3, fadeInner3);

		// Pokretanje animacije
		sequentialTransition.play();
	}

	public void FadeInPatientAdd() {

		// Postavljanje opacity na 0 na početku
		PI_pane.setOpacity(0);
		PI_line.setOpacity(0);
		PI_label.setOpacity(0);
		PI_patID.setOpacity(0);
		patientform_patientID.setOpacity(0);
		PI_name.setOpacity(0);
		patientform_patientname.setOpacity(0);
		PI_gender.setOpacity(0);
		patientform_gender.setOpacity(0);
		PI_number.setOpacity(0);
		patientform_patientcontact.setOpacity(0);
		PI_password.setOpacity(0);
		patientform_patientpassword.setOpacity(0);
		PI_address.setOpacity(0);
		patientform_adress.setOpacity(0);
		patientform_confirm.setOpacity(0);

		PA_line.setOpacity(0);
		PA_label.setOpacity(0);
		PA_patID.setOpacity(0);
		PA_password.setOpacity(0);
		PA_date.setOpacity(0);
		PA_pane.setOpacity(0);
		PA_picture.setOpacity(0);

		PIC_line.setOpacity(0);
		PIC_label.setOpacity(0);
		PIC_name.setOpacity(0);
		PIC_gender.setOpacity(0);
		PIC_number.setOpacity(0);
		PIC_address.setOpacity(0);
		PIC_image.setOpacity(0);
		PIC_pane.setOpacity(0);
		patientform_PA_addbtn.setOpacity(0);
		patientform_PA_recordbtn.setOpacity(0);

		// Fade animacija za mainPane1
		FadeTransition fadeIPpane = new FadeTransition(Duration.seconds(1.5), PI_pane);
		fadeIPpane.setFromValue(0);
		fadeIPpane.setToValue(1);

		PauseTransition delay1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeIPline = new FadeTransition(Duration.seconds(0.5), PI_line);
		fadeIPline.setFromValue(0);
		fadeIPline.setToValue(1);

		PauseTransition delay2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeIPlabel = new FadeTransition(Duration.seconds(0.5), PI_label);
		fadeIPlabel.setFromValue(0);
		fadeIPlabel.setToValue(1);

		PauseTransition delay3 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeIPpatid = new FadeTransition(Duration.seconds(0.3), PI_patID);
		fadeIPpatid.setFromValue(0);
		fadeIPpatid.setToValue(1);

		FadeTransition fadeIPpatidtext = new FadeTransition(Duration.seconds(0.5), patientform_patientID);
		fadeIPpatidtext.setFromValue(0);
		fadeIPpatidtext.setToValue(1);

		PauseTransition delay4 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeIPname = new FadeTransition(Duration.seconds(0.3), PI_name);
		fadeIPname.setFromValue(0);
		fadeIPname.setToValue(1);

		FadeTransition fadeIPnametext = new FadeTransition(Duration.seconds(0.5), patientform_patientname);
		fadeIPnametext.setFromValue(0);
		fadeIPnametext.setToValue(1);

		PauseTransition delay5 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeIPgender = new FadeTransition(Duration.seconds(0.3), PI_gender);
		fadeIPgender.setFromValue(0);
		fadeIPgender.setToValue(1);

		FadeTransition fadeIPgendertext = new FadeTransition(Duration.seconds(0.5), patientform_gender);
		fadeIPgendertext.setFromValue(0);
		fadeIPgendertext.setToValue(1);

		PauseTransition delay6 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeIPnumber = new FadeTransition(Duration.seconds(0.3), PI_number);
		fadeIPnumber.setFromValue(0);
		fadeIPnumber.setToValue(1);

		FadeTransition fadeIPnumbertext = new FadeTransition(Duration.seconds(0.5), patientform_patientcontact);
		fadeIPnumbertext.setFromValue(0);
		fadeIPnumbertext.setToValue(1);

		PauseTransition delay7 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeIPpassword = new FadeTransition(Duration.seconds(0.3), PI_password);
		fadeIPpassword.setFromValue(0);
		fadeIPpassword.setToValue(1);

		FadeTransition fadeIPpasswordtext = new FadeTransition(Duration.seconds(0.5), patientform_patientpassword);
		fadeIPpasswordtext.setFromValue(0);
		fadeIPpasswordtext.setToValue(1);

		PauseTransition delay8 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeIPaddress = new FadeTransition(Duration.seconds(0.3), PI_address);
		fadeIPaddress.setFromValue(0);
		fadeIPaddress.setToValue(1);

		FadeTransition fadeIPaddresstext = new FadeTransition(Duration.seconds(0.5), patientform_adress);
		fadeIPaddresstext.setFromValue(0);
		fadeIPaddresstext.setToValue(1);

		PauseTransition delay9 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeIPConfirmbtn = new FadeTransition(Duration.seconds(0.3), patientform_confirm);
		fadeIPConfirmbtn.setFromValue(0);
		fadeIPConfirmbtn.setToValue(1);

		FadeTransition fadeAPpane = new FadeTransition(Duration.seconds(1.5), PA_pane);
		fadeAPpane.setFromValue(0);
		fadeAPpane.setToValue(1);

		PauseTransition delayAP1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPline = new FadeTransition(Duration.seconds(0.5), PA_line);
		fadeAPline.setFromValue(0);
		fadeAPline.setToValue(1);

		PauseTransition delayAP2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPlabel = new FadeTransition(Duration.seconds(0.5), PA_label);
		fadeAPlabel.setFromValue(0);
		fadeAPlabel.setToValue(1);

		PauseTransition delayAP3 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeAPpatid = new FadeTransition(Duration.seconds(0.3), PA_patID);
		fadeAPpatid.setFromValue(0);
		fadeAPpatid.setToValue(1);

		PauseTransition delayAP4 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeAPpassword = new FadeTransition(Duration.seconds(0.3), PA_password);
		fadeAPpassword.setFromValue(0);
		fadeAPpassword.setToValue(1);

		PauseTransition delayAP5 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeAPdate = new FadeTransition(Duration.seconds(0.3), PA_date);
		fadeAPdate.setFromValue(0);
		fadeAPdate.setToValue(1);

		PauseTransition delayAP6 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadeAPpicture = new FadeTransition(Duration.seconds(0.3), PA_picture);
		fadeAPpicture.setFromValue(0);
		fadeAPpicture.setToValue(0.3);

		FadeTransition fadePICpane = new FadeTransition(Duration.seconds(1.5), PIC_pane);
		fadePICpane.setFromValue(0);
		fadePICpane.setToValue(1);

		PauseTransition delayPIC1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePICline = new FadeTransition(Duration.seconds(0.5), PIC_line);
		fadePICline.setFromValue(0);
		fadePICline.setToValue(1);

		PauseTransition delayPIC2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePIClabel = new FadeTransition(Duration.seconds(0.5), PIC_label);
		fadePIClabel.setFromValue(0);
		fadePIClabel.setToValue(1);

		PauseTransition delayPIC3 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadePICpatid = new FadeTransition(Duration.seconds(0.3), PIC_name);
		fadePICpatid.setFromValue(0);
		fadePICpatid.setToValue(1);

		PauseTransition delayPIC4 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadePICpassword = new FadeTransition(Duration.seconds(0.3), PIC_gender);
		fadePICpassword.setFromValue(0);
		fadePICpassword.setToValue(1);

		PauseTransition delayPIC5 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadePICdate = new FadeTransition(Duration.seconds(0.3), PIC_number);
		fadePICdate.setFromValue(0);
		fadePICdate.setToValue(1);

		PauseTransition delayPIC6 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadePICaddress = new FadeTransition(Duration.seconds(0.3), PIC_address);
		fadePICaddress.setFromValue(0);
		fadePICaddress.setToValue(1);

		PauseTransition delayPIC7 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadePICpicture = new FadeTransition(Duration.seconds(0.3), PIC_image);
		fadePICpicture.setFromValue(0);
		fadePICpicture.setToValue(0.3);

		PauseTransition delayPIC8 = new PauseTransition(Duration.seconds(0.3));

		FadeTransition fadePICbutton1 = new FadeTransition(Duration.seconds(0.3), patientform_PA_addbtn);
		fadePICbutton1.setFromValue(0);
		fadePICbutton1.setToValue(1);

		FadeTransition fadePICbutton2 = new FadeTransition(Duration.seconds(0.3), patientform_PA_recordbtn);
		fadePICbutton2.setFromValue(0);
		fadePICbutton2.setToValue(1);

		// Redosled animacija sa kašnjenjima
		SequentialTransition sequentialTransition = new SequentialTransition(fadeIPpane, delay1, fadeIPline, delay2,
				fadeIPlabel, delay3, fadeIPpatid, fadeIPpatidtext, delay4, fadeIPname, fadeIPnametext, delay5,
				fadeIPgender, fadeIPgendertext, delay6, fadeIPnumber, fadeIPnumbertext, delay7, fadeIPpassword,
				fadeIPpasswordtext, delay8, fadeIPaddress, fadeIPaddresstext, delay9, fadeIPConfirmbtn, fadeAPpane,
				delayAP1, fadeAPline, delayAP2, fadeAPlabel, delayAP3, fadeAPpatid, delayAP4, fadeAPpassword, delayAP5,
				fadeAPdate, delayAP6, fadeAPpicture, fadePICpane, delayPIC1, fadePICline, fadePIClabel, delayPIC2,
				fadePICpatid, delayPIC3, fadePICpassword, delayPIC5, fadePICdate, delayPIC6, fadePICaddress, delayPIC7,
				fadePICpicture, delayPIC8, fadePICbutton1, fadePICbutton2);

		// Pokretanje animacije
		sequentialTransition.play();
	}

	public void FadeInButtons() {

		// Postavljanje opacity na 0 na početku
		dashboard_btn.setOpacity(0);
		patients_btn.setOpacity(0);
		appointment_btn.setOpacity(0);
		profile_settings_btn.setOpacity(0);

		FadeTransition fadeMain1 = new FadeTransition(Duration.seconds(1.1), dashboard_btn);
		fadeMain1.setFromValue(0);
		fadeMain1.setToValue(1);

		PauseTransition delayBeforeInner = new PauseTransition(Duration.seconds(1));

		FadeTransition fadeInner1 = new FadeTransition(Duration.seconds(0.3), patients_btn);
		fadeInner1.setFromValue(0);
		fadeInner1.setToValue(1);

		PauseTransition delayBeforeInner2 = new PauseTransition(Duration.seconds(0.6));

		FadeTransition fadeInner2 = new FadeTransition(Duration.seconds(0.3), appointment_btn);
		fadeInner2.setFromValue(0);
		fadeInner2.setToValue(1);

		PauseTransition delayBeforeInner3 = new PauseTransition(Duration.seconds(0.8));

		FadeTransition fadeInner4 = new FadeTransition(Duration.seconds(0.3), profile_settings_btn);
		fadeInner4.setFromValue(0);
		fadeInner4.setToValue(1);

		SequentialTransition sequentialTransition = new SequentialTransition(fadeMain1, delayBeforeInner, fadeInner1,
				delayBeforeInner2, fadeInner2, delayBeforeInner3, fadeInner4);

		sequentialTransition.play();
	}

	private void enlargeTextField(TextField textField) {
		// Animacija za povećanje TextField-a
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), textField);
		scaleTransition.setToX(1.07); // Povećaj TextField za 7% u širinu
		scaleTransition.setToY(1.07); // Povećaj TextField za 7% u visinu
		scaleTransition.play();
	}

	private void resetTextFieldSize(TextField textField) {
		// Animacija za vraćanje TextField-a na originalnu veličinu
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), textField);
		scaleTransition.setToX(1); // Vraćanje na originalnu širinu
		scaleTransition.setToY(1); // Vraćanje na originalnu visinu
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

	private void enlargeCB(ComboBox<String> cb) {
		// Animacija za povećanje TextField-a
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), cb);
		scaleTransition.setToX(1.075); // Povećaj TextField za 7% u širinu
		scaleTransition.setToY(1.075); // Povećaj TextField za 7% u visinu
		scaleTransition.play();
	}

	private void resetCB(ComboBox<String> cb) {
		// Animacija za vraćanje TextField-a na originalnu veličinu
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), cb);
		scaleTransition.setToX(1); // Vraćanje na originalnu širinu
		scaleTransition.setToY(1); // Vraćanje na originalnu visinu
		scaleTransition.play();
	}
	
	private void enlargeDatePicker(DatePicker dp) {
	    // Animacija za povećanje TextField-a
	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(130), dp);
	    scaleTransition.setToX(1.07);  // Povećaj TextField za 7% u širinu
	    scaleTransition.setToY(1.07);  // Povećaj TextField za 7% u visinu
	    scaleTransition.play();
	}

	private void resetDatePicker(DatePicker dp) {
	    // Animacija za vraćanje TextField-a na originalnu veličinu
	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(130), dp);
	    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
	    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
	    scaleTransition.play();
	}

	public void buttonAnimation() {
		dashboard_btn.setOnMouseEntered(event -> enlargeButton(dashboard_btn));
		dashboard_btn.setOnMouseExited(event -> resetButtonSize(dashboard_btn));

		patients_btn.setOnMouseEntered(event -> enlargeButton(patients_btn));
		patients_btn.setOnMouseExited(event -> resetButtonSize(patients_btn));

		appointment_btn.setOnMouseEntered(event -> enlargeButton(appointment_btn));
		appointment_btn.setOnMouseExited(event -> resetButtonSize(appointment_btn));

		profile_settings_btn.setOnMouseEntered(event -> enlargeButton(profile_settings_btn));
		profile_settings_btn.setOnMouseExited(event -> resetButtonSize(profile_settings_btn));

		logoutBtn.setOnMouseEntered(event -> enlargeButton(logoutBtn));
		logoutBtn.setOnMouseExited(event -> resetButtonSize(logoutBtn));

		patientform_confirm.setOnMouseEntered(event -> enlargeButton(patientform_confirm));
		patientform_confirm.setOnMouseExited(event -> resetButtonSize(patientform_confirm));

		patientform_PA_addbtn.setOnMouseEntered(event -> enlargeButton(patientform_PA_addbtn));
		patientform_PA_addbtn.setOnMouseExited(event -> resetButtonSize(patientform_PA_addbtn));

		patientform_PA_recordbtn.setOnMouseEntered(event -> enlargeButton(patientform_PA_recordbtn));
		patientform_PA_recordbtn.setOnMouseExited(event -> resetButtonSize(patientform_PA_recordbtn));
		
		
		appointment_insertbtn.setOnMouseEntered(event -> enlargeButton(appointment_insertbtn));
		appointment_insertbtn.setOnMouseExited(event -> resetButtonSize(appointment_insertbtn));

		appointment_updatebtn.setOnMouseEntered(event -> enlargeButton(appointment_updatebtn));
		appointment_updatebtn.setOnMouseExited(event -> resetButtonSize(appointment_updatebtn));

		appointment_clearbtn.setOnMouseEntered(event -> enlargeButton(appointment_clearbtn));
		appointment_clearbtn.setOnMouseExited(event -> resetButtonSize(appointment_clearbtn));

		appointment_deletebtn.setOnMouseEntered(event -> enlargeButton(appointment_deletebtn));
		appointment_deletebtn.setOnMouseExited(event -> resetButtonSize(appointment_deletebtn));
		
		editprofile_updatebtn.setOnMouseEntered(event -> enlargeButton(editprofile_updatebtn));
		editprofile_updatebtn.setOnMouseExited(event -> resetButtonSize(editprofile_updatebtn));

		settings_ImportPicture.setOnMouseEntered(event -> enlargeButton(settings_ImportPicture));
		settings_ImportPicture.setOnMouseExited(event -> resetButtonSize(settings_ImportPicture));
	}

	public void fields() {
		patientform_patientID.setOnMouseEntered(event -> enlargeTextField(patientform_patientID));
		patientform_patientID.setOnMouseExited(event -> resetTextFieldSize(patientform_patientID));

		patientform_patientname.setOnMouseEntered(event -> enlargeTextField(patientform_patientname));
		patientform_patientname.setOnMouseExited(event -> resetTextFieldSize(patientform_patientname));

		patientform_patientcontact.setOnMouseEntered(event -> enlargeTextField(patientform_patientcontact));
		patientform_patientcontact.setOnMouseExited(event -> resetTextFieldSize(patientform_patientcontact));

		patientform_gender.setOnMouseEntered(event -> enlargeCB(patientform_gender));
		patientform_gender.setOnMouseExited(event -> resetCB(patientform_gender));

		patientform_patientcontact.setOnMouseEntered(event -> enlargeTextField(patientform_patientcontact));
		patientform_patientcontact.setOnMouseExited(event -> resetTextFieldSize(patientform_patientcontact));

		patientform_patientpassword.setOnMouseEntered(event -> enlargeTextField(patientform_patientpassword));
		patientform_patientpassword.setOnMouseExited(event -> resetTextFieldSize(patientform_patientpassword));

		patientform_adress.setOnMouseEntered(event -> enlargeTextArea(patientform_adress));
		patientform_adress.setOnMouseExited(event -> resetTextAreaSize(patientform_adress));
		
		
		
		appointment_appID.setOnMouseEntered(event -> enlargeTextField(appointment_appID));
		appointment_appID.setOnMouseExited(event -> resetTextFieldSize(appointment_appID));

		appointment_name.setOnMouseEntered(event -> enlargeTextField(appointment_name));
		appointment_name.setOnMouseExited(event -> resetTextFieldSize(appointment_name));

		appointment_mobile.setOnMouseEntered(event -> enlargeTextField(appointment_mobile));
		appointment_mobile.setOnMouseExited(event -> resetTextFieldSize(appointment_mobile));

		appointment_gender.setOnMouseEntered(event -> enlargeCB(appointment_gender));
		appointment_gender.setOnMouseExited(event -> resetCB(appointment_gender));

		appointment_description.setOnMouseEntered(event -> enlargeTextField(appointment_description));
		appointment_description.setOnMouseExited(event -> resetTextFieldSize(appointment_description));

		appointment_diagnosis.setOnMouseEntered(event -> enlargeTextField(appointment_diagnosis));
		appointment_diagnosis.setOnMouseExited(event -> resetTextFieldSize(appointment_diagnosis));

		appointment_treatment.setOnMouseEntered(event -> enlargeTextField(appointment_treatment));
		appointment_treatment.setOnMouseExited(event -> resetTextFieldSize(appointment_treatment));
		
		appointment_address.setOnMouseEntered(event -> enlargeTextField(appointment_address));
		appointment_address.setOnMouseExited(event -> resetTextFieldSize(appointment_address));
		
		appointment_status.setOnMouseEntered(event -> enlargeCB(appointment_status));
		appointment_status.setOnMouseExited(event -> resetCB(appointment_status));
		
		appointment_schedule.setOnMouseEntered(event -> enlargeDatePicker(appointment_schedule));
		appointment_schedule.setOnMouseExited(event -> resetDatePicker(appointment_schedule));
		
		
		editprofile_doctorID.setOnMouseEntered(event -> enlargeTextField(editprofile_doctorID));
		editprofile_doctorID.setOnMouseExited(event -> resetTextFieldSize(editprofile_doctorID));
		
		editprofile_name.setOnMouseEntered(event -> enlargeTextField(editprofile_name));
		editprofile_name.setOnMouseExited(event -> resetTextFieldSize(editprofile_name));
		
		editprofile_email.setOnMouseEntered(event -> enlargeTextField(editprofile_email));
		editprofile_email.setOnMouseExited(event -> resetTextFieldSize(editprofile_email));
		
		editprofile_gender.setOnMouseEntered(event -> enlargeCB(editprofile_gender));
		editprofile_gender.setOnMouseExited(event -> resetCB(editprofile_gender));
		
		editprofile_number.setOnMouseEntered(event -> enlargeTextField(editprofile_number));
		editprofile_number.setOnMouseExited(event -> resetTextFieldSize(editprofile_number));
		
		editprofile_address.setOnMouseEntered(event -> enlargeTextField(editprofile_address));
		editprofile_address.setOnMouseExited(event -> resetTextFieldSize(editprofile_address));
		
		editprofile_specialization.setOnMouseEntered(event -> enlargeCB(editprofile_specialization));
		editprofile_specialization.setOnMouseExited(event -> resetCB(editprofile_specialization));
		
		editprofile_status.setOnMouseEntered(event -> enlargeCB(editprofile_status));
		editprofile_status.setOnMouseExited(event -> resetCB(editprofile_status));
	}

	public void FadeInAppointment() {
		// Postavljanje opacity na 0 na početku
		APP_pane.setOpacity(0);
		APP_line.setOpacity(0);
		APP_label.setOpacity(0);
		appointment_tableview.setOpacity(0);
		
		
		APP_label_ID.setOpacity(0);
		APP_label_Name.setOpacity(0);
		APP_label_gender.setOpacity(0);
		APP_label_number.setOpacity(0);
		APP_label_description.setOpacity(0);
		APP_label_diagnosis.setOpacity(0);
		APP_label_treatment.setOpacity(0);
		APP_label_address.setOpacity(0);
		APP_label_status.setOpacity(0);
		APP_label_schedule.setOpacity(0);
		APP_bottom_pane.setOpacity(0);
		appointment_insertbtn.setOpacity(0);
		appointment_updatebtn.setOpacity(0);
		appointment_clearbtn.setOpacity(0);
		appointment_deletebtn.setOpacity(0);
		appointment_appID.setOpacity(0);
		appointment_name.setOpacity(0);
		appointment_gender.setOpacity(0);
		appointment_mobile.setOpacity(0);
		appointment_description.setOpacity(0);
		appointment_diagnosis.setOpacity(0);
		appointment_treatment.setOpacity(0);
		appointment_address.setOpacity(0);
		appointment_status.setOpacity(0);
		appointment_schedule.setOpacity(0);
		
		// fadeUpper,delayBeforeupper1,fadeUpperLine,delayBeforeupper2,fadeUpperLabel,delayBeforeupper3,fadeUpperTabel
		FadeTransition fadeUpper = new FadeTransition(Duration.seconds(1.5), APP_pane);
		fadeUpper.setFromValue(0);
		fadeUpper.setToValue(1);

		PauseTransition delayBeforeupper1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeUpperLine = new FadeTransition(Duration.seconds(0.5), APP_line);
		fadeUpperLine.setFromValue(0);
		fadeUpperLine.setToValue(1);

		PauseTransition delayBeforeupper2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeUpperLabel = new FadeTransition(Duration.seconds(0.5), APP_label);
		fadeUpperLabel.setFromValue(0);
		fadeUpperLabel.setToValue(1);

		PauseTransition delayBeforeupper3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeUpperTabel = new FadeTransition(Duration.seconds(0.5), appointment_tableview);
		fadeUpperTabel.setFromValue(0);
		fadeUpperTabel.setToValue(1);


		FadeTransition fadeBottom = new FadeTransition(Duration.seconds(1.5), APP_bottom_pane);
		fadeBottom.setFromValue(0);
		fadeBottom.setToValue(1);

		PauseTransition delayBefore1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomID = new FadeTransition(Duration.seconds(0.5), APP_label_ID);
		fadeBottomID.setFromValue(0);
		fadeBottomID.setToValue(1);

		PauseTransition delayBefore2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldID = new FadeTransition(Duration.seconds(0.5), appointment_appID);
		fadeBottomTextFieldID.setFromValue(0);
		fadeBottomTextFieldID.setToValue(1);
		
		PauseTransition delayBefore3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomName = new FadeTransition(Duration.seconds(0.5), APP_label_Name);
		fadeBottomName.setFromValue(0);
		fadeBottomName.setToValue(1);

		PauseTransition delayBefore4 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldName = new FadeTransition(Duration.seconds(0.5), appointment_name);
		fadeBottomTextFieldName.setFromValue(0);
		fadeBottomTextFieldName.setToValue(1);
		
		PauseTransition delayBefore5 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomGender = new FadeTransition(Duration.seconds(0.5), APP_label_gender);
		fadeBottomGender.setFromValue(0);
		fadeBottomGender.setToValue(1);

		PauseTransition delayBefore6 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldGender = new FadeTransition(Duration.seconds(0.5), appointment_gender);
		fadeBottomTextFieldGender.setFromValue(0);
		fadeBottomTextFieldGender.setToValue(1);
		
		PauseTransition delayBefore7 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomMobile = new FadeTransition(Duration.seconds(0.5), APP_label_number);
		fadeBottomMobile.setFromValue(0);
		fadeBottomMobile.setToValue(1);

		PauseTransition delayBefore8 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldMobile = new FadeTransition(Duration.seconds(0.5), appointment_mobile);
		fadeBottomTextFieldMobile.setFromValue(0);
		fadeBottomTextFieldMobile.setToValue(1);
		
		PauseTransition delayBefore9 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomDescription = new FadeTransition(Duration.seconds(0.5), APP_label_description);
		fadeBottomDescription.setFromValue(0);
		fadeBottomDescription.setToValue(1);

		PauseTransition delayBefore10 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldDescription = new FadeTransition(Duration.seconds(0.5), appointment_description);
		fadeBottomTextFieldDescription.setFromValue(0);
		fadeBottomTextFieldDescription.setToValue(1);
		
		PauseTransition delayBefore11 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomDiagnosis = new FadeTransition(Duration.seconds(0.5), APP_label_diagnosis);
		fadeBottomDiagnosis.setFromValue(0);
		fadeBottomDiagnosis.setToValue(1);

		PauseTransition delayBefore12 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldDiagnosis = new FadeTransition(Duration.seconds(0.5), appointment_diagnosis);
		fadeBottomTextFieldDiagnosis.setFromValue(0);
		fadeBottomTextFieldDiagnosis.setToValue(1);
		
		PauseTransition delayBefore13 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTreatment = new FadeTransition(Duration.seconds(0.5), APP_label_treatment);
		fadeBottomTreatment.setFromValue(0);
		fadeBottomTreatment.setToValue(1);

		PauseTransition delayBefore14 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldTreatment = new FadeTransition(Duration.seconds(0.5), appointment_treatment);
		fadeBottomTextFieldTreatment.setFromValue(0);
		fadeBottomTextFieldTreatment.setToValue(1);
		
		PauseTransition delayBefore15 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomAddress = new FadeTransition(Duration.seconds(0.5), APP_label_address);
		fadeBottomAddress.setFromValue(0);
		fadeBottomAddress.setToValue(1);

		PauseTransition delayBefore16 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldAddress = new FadeTransition(Duration.seconds(0.5), appointment_address);
		fadeBottomTextFieldAddress.setFromValue(0);
		fadeBottomTextFieldAddress.setToValue(1);
		
		PauseTransition delayBefore17 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomStatus = new FadeTransition(Duration.seconds(0.5), APP_label_status);
		fadeBottomStatus.setFromValue(0);
		fadeBottomStatus.setToValue(1);

		PauseTransition delayBefore18 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldStatus = new FadeTransition(Duration.seconds(0.5), appointment_status);
		fadeBottomTextFieldStatus.setFromValue(0);
		fadeBottomTextFieldStatus.setToValue(1);
		
		PauseTransition delayBefore19 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomSchedule = new FadeTransition(Duration.seconds(0.5), APP_label_schedule);
		fadeBottomSchedule.setFromValue(0);
		fadeBottomSchedule.setToValue(1);

		PauseTransition delayBefore20 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeBottomTextFieldSchedule = new FadeTransition(Duration.seconds(0.5), appointment_schedule);
		fadeBottomTextFieldSchedule.setFromValue(0);
		fadeBottomTextFieldSchedule.setToValue(1);
		
		PauseTransition delayBefore21 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeButtonInsert = new FadeTransition(Duration.seconds(0.5), appointment_insertbtn);
		fadeButtonInsert.setFromValue(0);
		fadeButtonInsert.setToValue(1);

		PauseTransition delayBefore22 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeButtonUpdate = new FadeTransition(Duration.seconds(0.5), appointment_updatebtn);
		fadeButtonUpdate.setFromValue(0);
		fadeButtonUpdate.setToValue(1);
		
		PauseTransition delayBefore23 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeButtonClear = new FadeTransition(Duration.seconds(0.5), appointment_clearbtn);
		fadeButtonClear.setFromValue(0);
		fadeButtonClear.setToValue(1);

		PauseTransition delayBefore24 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeButtonDelete = new FadeTransition(Duration.seconds(0.5), appointment_deletebtn);
		fadeButtonDelete.setFromValue(0);
		fadeButtonDelete.setToValue(1);
		

		// Redosled animacija sa kašnjenjima
		SequentialTransition sequentialTransition = new SequentialTransition(
				fadeUpper,delayBeforeupper1,fadeUpperLine,delayBeforeupper2,fadeUpperLabel,delayBeforeupper3,fadeUpperTabel,
				fadeBottom,delayBefore1,fadeBottomID,delayBefore2,fadeBottomTextFieldID,delayBefore3,fadeBottomName,delayBefore4,fadeBottomTextFieldName,
				delayBefore5,fadeBottomGender,delayBefore6,fadeBottomTextFieldGender,delayBefore7,fadeBottomMobile,delayBefore8,fadeBottomTextFieldMobile,
				delayBefore9,fadeBottomDescription,delayBefore10,fadeBottomTextFieldDescription,delayBefore11,fadeBottomDiagnosis,delayBefore12,fadeBottomTextFieldDiagnosis,
				delayBefore13,fadeBottomTreatment,delayBefore14,fadeBottomTextFieldTreatment,delayBefore15,fadeBottomAddress,delayBefore16,fadeBottomTextFieldAddress,
				delayBefore17,fadeBottomStatus,delayBefore18,fadeBottomTextFieldStatus,delayBefore19,fadeBottomSchedule,delayBefore20,fadeBottomTextFieldSchedule,
				delayBefore21,fadeButtonInsert,delayBefore22,fadeButtonUpdate,delayBefore23,fadeButtonClear,delayBefore24,fadeButtonDelete
				
				
				);

		// Pokretanje animacije
		sequentialTransition.play();
	}
	
	

	public void FadeInProfileEdit() {
		PS_pane.setOpacity(0);
		settings_picture.setOpacity(0);
		settings_ImportPicture.setOpacity(0);
		PS_ID.setOpacity(0);
		settings_doctorID.setOpacity(0);
		PS_name.setOpacity(0);
		settings_name.setOpacity(0);
		PS_email.setOpacity(0);
		settings_address.setOpacity(0);
		PS_datecreated.setOpacity(0);
		settings_datecreated.setOpacity(0);
		PS_datemodify.setOpacity(0);
		settings_datemodify.setOpacity(0);
			
		
		
		EPS_pane.setOpacity(0);
		EPS_line.setOpacity(0);
		EPS_label.setOpacity(0);
		EPS_picture1.setOpacity(0);
		EPS_picture2.setOpacity(0);
		EPS_ID.setOpacity(0);
		EPS_name.setOpacity(0);
		EPS_email.setOpacity(0);
		EPS_gender.setOpacity(0);
		EPS_number.setOpacity(0);
		EPS_address.setOpacity(0);
		EPS_specialization.setOpacity(0);
		EPS_status.setOpacity(0);
		editprofile_doctorID.setOpacity(0);
		editprofile_name.setOpacity(0);
		editprofile_email.setOpacity(0);
		editprofile_gender.setOpacity(0);
		editprofile_number.setOpacity(0);
		editprofile_address.setOpacity(0);
		editprofile_specialization.setOpacity(0);
		editprofile_status.setOpacity(0);
		editprofile_updatebtn.setOpacity(0);
		EPS_picture2.setOpacity(0);
				
				FadeTransition fadePSPane = new FadeTransition(Duration.seconds(1.5), PS_pane);
				fadePSPane.setFromValue(0);
				fadePSPane.setToValue(1);

				PauseTransition delay1 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSPicture = new FadeTransition(Duration.seconds(0.5), settings_picture);
				fadePSPicture.setFromValue(0);
				fadePSPicture.setToValue(1);

				PauseTransition delay2 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSButton = new FadeTransition(Duration.seconds(0.5), settings_ImportPicture);
				fadePSButton.setFromValue(0);
				fadePSButton.setToValue(1);

				PauseTransition delay3 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSID = new FadeTransition(Duration.seconds(0.5), PS_ID);
				fadePSID.setFromValue(0);
				fadePSID.setToValue(1);

				PauseTransition delay4 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSIDdisplay = new FadeTransition(Duration.seconds(0.5), settings_doctorID);
				fadePSIDdisplay.setFromValue(0);
				fadePSIDdisplay.setToValue(1);

				PauseTransition delay5 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSName = new FadeTransition(Duration.seconds(0.5), PS_name);
				fadePSName.setFromValue(0);
				fadePSName.setToValue(1);

				PauseTransition delay6 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSNamedisplay = new FadeTransition(Duration.seconds(0.5), settings_name);
				fadePSNamedisplay.setFromValue(0);
				fadePSNamedisplay.setToValue(1);
				
				PauseTransition delay7 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSEmail = new FadeTransition(Duration.seconds(0.5), PS_email);
				fadePSEmail.setFromValue(0);
				fadePSEmail.setToValue(1);

				PauseTransition delay8 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSEmaildisplay = new FadeTransition(Duration.seconds(0.5), settings_address);
				fadePSEmaildisplay.setFromValue(0);
				fadePSEmaildisplay.setToValue(1);
				
				PauseTransition delay9 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSdate = new FadeTransition(Duration.seconds(0.5), PS_datecreated);
				fadePSdate.setFromValue(0);
				fadePSdate.setToValue(1);

				PauseTransition delay10 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition FadePSdatedisplay = new FadeTransition(Duration.seconds(0.5), settings_datecreated);
				FadePSdatedisplay.setFromValue(0);
				FadePSdatedisplay.setToValue(1);
				
				PauseTransition delay11 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadePSdatemodify = new FadeTransition(Duration.seconds(0.5), PS_datemodify);
				fadePSdatemodify.setFromValue(0);
				fadePSdatemodify.setToValue(1);

				PauseTransition delay12 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition FadePSdatemodifydisplay = new FadeTransition(Duration.seconds(0.5), settings_datemodify);
				FadePSdatemodifydisplay.setFromValue(0);
				FadePSdatemodifydisplay.setToValue(1);

				
				
				
				FadeTransition fadeEPSPane = new FadeTransition(Duration.seconds(1.5), EPS_pane);
				fadeEPSPane.setFromValue(0);
				fadeEPSPane.setToValue(1);

				PauseTransition Delay1 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSLine = new FadeTransition(Duration.seconds(0.5), EPS_line);
				fadeEPSLine.setFromValue(0);
				fadeEPSLine.setToValue(1);

				FadeTransition fadeEPSLabel = new FadeTransition(Duration.seconds(0.5), EPS_label);
				fadeEPSLabel.setFromValue(0);
				fadeEPSLabel.setToValue(1);
				
				FadeTransition fadeEPSPicture = new FadeTransition(Duration.seconds(0.5), EPS_picture1);
				fadeEPSPicture.setFromValue(0);
				fadeEPSPicture.setToValue(1);
				
				PauseTransition Delay2 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSID = new FadeTransition(Duration.seconds(0.5), EPS_ID);
				fadeEPSID.setFromValue(0);
				fadeEPSID.setToValue(1);
				
				PauseTransition Delay3 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSIDtextfield = new FadeTransition(Duration.seconds(0.5), editprofile_doctorID);
				fadeEPSIDtextfield.setFromValue(0);
				fadeEPSIDtextfield.setToValue(1);
				
				PauseTransition Delay4 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSname = new FadeTransition(Duration.seconds(0.5), EPS_name);
				fadeEPSname.setFromValue(0);
				fadeEPSname.setToValue(1);
				
				PauseTransition Delay5 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSnametextfield = new FadeTransition(Duration.seconds(0.5), editprofile_name);
				fadeEPSnametextfield.setFromValue(0);
				fadeEPSnametextfield.setToValue(1);
				
				PauseTransition Delay6 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSemail = new FadeTransition(Duration.seconds(0.5), EPS_email);
				fadeEPSemail.setFromValue(0);
				fadeEPSemail.setToValue(1);
				
				PauseTransition Delay7 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSemailtextfield = new FadeTransition(Duration.seconds(0.5), editprofile_email);
				fadeEPSemailtextfield.setFromValue(0);
				fadeEPSemailtextfield.setToValue(1);
				
				PauseTransition Delay8 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSgender = new FadeTransition(Duration.seconds(0.5), EPS_gender);
				fadeEPSgender.setFromValue(0);
				fadeEPSgender.setToValue(1);
				
				PauseTransition Delay9 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSgendertextfield = new FadeTransition(Duration.seconds(0.5), editprofile_gender);
				fadeEPSgendertextfield.setFromValue(0);
				fadeEPSgendertextfield.setToValue(1);
				
				PauseTransition Delay10 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSmobile = new FadeTransition(Duration.seconds(0.5), EPS_number);
				fadeEPSmobile.setFromValue(0);
				fadeEPSmobile.setToValue(1);
				
				PauseTransition Delay11 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSmobiletextfield = new FadeTransition(Duration.seconds(0.5), editprofile_number);
				fadeEPSmobiletextfield.setFromValue(0);
				fadeEPSmobiletextfield.setToValue(1);
				
				PauseTransition Delay12 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSaddress = new FadeTransition(Duration.seconds(0.5), EPS_address);
				fadeEPSaddress.setFromValue(0);
				fadeEPSaddress.setToValue(1);
				
				PauseTransition Delay13 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSaddresstextfield = new FadeTransition(Duration.seconds(0.5), editprofile_address);
				fadeEPSaddresstextfield.setFromValue(0);
				fadeEPSaddresstextfield.setToValue(1);
				
				PauseTransition Delay14 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSspec = new FadeTransition(Duration.seconds(0.5), EPS_specialization);
				fadeEPSspec.setFromValue(0);
				fadeEPSspec.setToValue(1);
				
				PauseTransition Delay15 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSspectextfield = new FadeTransition(Duration.seconds(0.5), editprofile_specialization);
				fadeEPSspectextfield.setFromValue(0);
				fadeEPSspectextfield.setToValue(1);
				
				PauseTransition Delay16 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSstatus = new FadeTransition(Duration.seconds(0.5), EPS_status);
				fadeEPSstatus.setFromValue(0);
				fadeEPSstatus.setToValue(1);
				
				PauseTransition Delay17 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSstatustextfield = new FadeTransition(Duration.seconds(0.5), editprofile_status);
				fadeEPSstatustextfield.setFromValue(0);
				fadeEPSstatustextfield.setToValue(1);
				
				PauseTransition Delay18 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSPicture2 = new FadeTransition(Duration.seconds(0.5), EPS_picture2);
				fadeEPSPicture2.setFromValue(0);
				fadeEPSPicture2.setToValue(0.2);
				
				
				PauseTransition Delay19 = new PauseTransition(Duration.seconds(0.2));

				FadeTransition fadeEPSupdatebtn = new FadeTransition(Duration.seconds(0.5), editprofile_updatebtn);
				fadeEPSupdatebtn.setFromValue(0);
				fadeEPSupdatebtn.setToValue(1);
				
				// Redosled animacija sa kašnjenjima
				SequentialTransition sequentialTransition = new SequentialTransition(
						fadePSPane,delay1,fadePSPicture,delay2,fadePSButton,delay3,fadePSID,delay4,fadePSIDdisplay,delay5,
						fadePSName,delay6,fadePSNamedisplay,delay7,fadePSEmail,delay8,fadePSEmaildisplay,delay9,
						fadePSdate,delay10,FadePSdatedisplay,delay11,fadePSdatemodify,delay12,FadePSdatemodifydisplay,
						fadeEPSPane,Delay1,fadeEPSLine,fadeEPSLabel,fadeEPSPicture,Delay2,fadeEPSID,Delay3,fadeEPSIDtextfield,
						Delay4,fadeEPSname,Delay5,fadeEPSnametextfield,Delay6,fadeEPSemail,Delay7,fadeEPSemailtextfield,
						Delay8,fadeEPSgender,Delay9,fadeEPSgendertextfield,Delay10,fadeEPSmobile,Delay11,fadeEPSmobiletextfield,
						Delay12,fadeEPSaddress,Delay13,fadeEPSaddresstextfield,Delay14,fadeEPSspec,Delay15,fadeEPSspectextfield,
						Delay16,fadeEPSstatus,Delay17,fadeEPSstatustextfield,Delay18,fadeEPSPicture2,Delay19,fadeEPSupdatebtn
						
						);

				// Pokretanje animacije
				sequentialTransition.play();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		fields();
		buttonAnimation();
		FadeInDashboard();
		FadeInButtons();
		runTime();
		try {
			appointmentShowData();
			appointmentAppointmentID();
			displayDoctorIDUsername();
			appointmentUpdate();
			displayProfilePictures();
			DashboardappointmentShowData();
			dashboardNOP();
			dashboardNOA();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardIP();
		dashboardTP();
		dashboardAP();
		dashboardTA();
		appointmentGenderList();
		appointmentStatusList();
		patientGenderList();
		doctorSpecialization();
		DoctorEditSetText();
		doctoredtiStatus();
		EditDoctorSettext();
	}
}
