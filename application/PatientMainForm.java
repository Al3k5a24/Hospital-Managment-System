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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

public class PatientMainForm implements Initializable {

	 @FXML
	    private Label EDP_ID;

	    @FXML
	    private Label EDP_address;

	    @FXML
	    private Label EDP_gender;

	    @FXML
	    private Label EDP_label;

	    @FXML
	    private Line EDP_line;

	    @FXML
	    private Label EDP_mobile;

	    @FXML
	    private Label EDP_name;

	    @FXML
	    private AnchorPane EDP_pane;

	    @FXML
	    private Label EDP_password;

	    @FXML
	    private ImageView EDP_picture1;

	    @FXML
	    private ImageView EDP_picture2;

	    @FXML
	    private Label EDP_status;
	
	@FXML
	private AnchorPane PF_pane;
	
	@FXML
	private Label P_ID;
	
	@FXML
	private Label P_name;
	
	@FXML
	private Label P_mobile;
	
	@FXML
	private Label P_date;
	
	@FXML
	private AnchorPane APPS_pane;
	
	@FXML
	private Line APPS_line;
	
	@FXML
	private Label APPS_label;
	
	@FXML
	private Label APPS_name;
	
	@FXML
	private Label APPS_gender;
	
	@FXML
	private Label APPS_address;
	
	@FXML 
	private Label APPS_contact;
	
	@FXML
	private Label APPS_description;
	
	@FXML
	private Label APPS_doctor;
	
	@FXML
	private Label APPS_spec;
	
	@FXML
	private Label APPS_schedule;
	
	
	@FXML 
	private AnchorPane APD_pane;
	
	@FXML 
	private Line APD_line;
	
	@FXML
	private Label APD_label;
	
	@FXML
	private Label APD_description;
	
	@FXML
	private Label APD_doctor;
	
	@FXML
	private Label APD_schedule;
	
	@FXML
	private AnchorPane YDI_pane;
	
	@FXML 
	private Label YDI_label;
	
	@FXML
	private ImageView YDI_picture;
	
	@FXML 
	private Label YDI_name;
	
	@FXML 
	private Label YDI_spec;
	
	@FXML 
	private Label YDI_email;
	
	@FXML 
	private Label YDI_mobile;

	@FXML
	private AnchorPane P_pane;

	@FXML
	private Line P_line;

	@FXML
	private Label P_label;

	@FXML
	private AnchorPane A_pane;

	@FXML
	private Line A_line;

	@FXML
	private Label A_label;

	@FXML
	private AnchorPane Appointment_form;

	@FXML
	private Button appd_book_btn;

	@FXML
	private Button appointment_btn;

	@FXML
	private DatePicker appointment_details_schedule;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_appID;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_description;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_diagnosis;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_doctor;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_schedule;

	@FXML
	private TableColumn<AppointmentData, String> appointment_col_treatment;

	@FXML
	private TextField appointment_details_description;

	@FXML
	private ComboBox<String> appointment_details_docbox;

	@FXML
	private TextField appointment_details_docname;

	@FXML
	private TableView<AppointmentData> appointment_tableview;

	@FXML
	private TextField appointments_Address;

	@FXML
	private TextField appointments_Gender;

	@FXML
	private TextField appointments_Name;

	@FXML
	private TextField appointments_contact;

	@FXML
	private TextField appointments_description;

	@FXML
	private TextField appointments_schedule;

	@FXML
	private TextField appointments_doctor;

	@FXML
	private TextField appointments_spec;

	@FXML
	private Button book_btn;

	@FXML
	private Button clear_btn;

	@FXML
	private Label current_form;

	@FXML
	private Button dashboard_btn;

	@FXML
	private AnchorPane dashboard_form;

	@FXML
	private Button dashboard_logoutBTN;

	@FXML
	private Label date_time;

	@FXML
	private Button doctor_btn;

	@FXML
	private Label doctor_label_contact;

	@FXML
	private Label doctor_label_doctorName;

	@FXML
	private Label doctor_label_email;

	@FXML
	private Label doctor_label_specialization;

	@FXML
	private Circle doctor_profilePicture;

	@FXML
	private AnchorPane doctors_form;

	@FXML
	private AnchorPane main_form;

	@FXML
	private Label nav_id;

	@FXML
	private Button patientEdit_ImportPicture;

	@FXML
	private TextField patientEdit_address;

	@FXML
	private TextField patientEdit_contact;

	@FXML
	private TextField patientEdit_fullname;

	@FXML
	private ComboBox<String> patientEdit_gender;

	@FXML
	private Label patientEdit_label_contact;

	@FXML
	private Label patientEdit_label_datecreated;

	@FXML
	private Label patientEdit_label_name;

	@FXML
	private Label patientEdit_label_patientID;

	@FXML
	private TextField patientEdit_password;

	@FXML
	private TextField patientEdit_patientID;

	@FXML
	private Circle patientEdit_profilePicture;

	@FXML
	private ComboBox<String> patientEdit_status;

	@FXML
	private Button patientEdit_update;

	@FXML
	private TableColumn<PatientData, String> patient_col_datein;

	@FXML
	private TableColumn<PatientData, String> patient_col_datedischarged;

	@FXML
	private TableColumn<PatientData, String> patient_col_description;

	@FXML
	private TableColumn<PatientData, String> patient_col_diagnosis;

	@FXML
	private TableColumn<PatientData, String> patient_col_treatment;

	@FXML
	private TableView<PatientData> patient_tableview;

	@FXML
	private Button profile_settings_btn;

	@FXML
	private AnchorPane profilesettings_form;

	@FXML
	private Circle top_profile;

	@FXML
	private Label top_username;

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
	}

	private final AlertMessage alert = new AlertMessage();

	public void displayPatientID() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM patient where patient_id=?";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Data.patient_id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				nav_id.setText(resultSet.getString("patient_id"));
				String tempUsername = resultSet.getString("full_name");
				tempUsername = tempUsername.substring(0, 1).toUpperCase() + tempUsername.substring(1);
				top_username.setText(tempUsername);

				String imagePath = resultSet.getString("image");
				if (imagePath != null && !imagePath.isEmpty()) {
					Image image = new Image("file:" + imagePath);
					top_profile.setFill(new ImagePattern(image));
				}
			} else {
				System.out.println("Pacijent nije pronađen u bazi!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchForm(ActionEvent event) throws ClassNotFoundException, SQLException {
		if (event.getSource() == dashboard_btn) {
			dashboard_form.setVisible(true);
			dashboard_form.setDisable(false);
			FadeInPatientDashboard();
			PatientShowData();
			PatientGetData();
			appointmentShowData();
			appointmentGetData();
			Appointment_form.setVisible(false);
			Appointment_form.setDisable(true);
			profilesettings_form.setVisible(false);
			profilesettings_form.setDisable(true);
		} else if (event.getSource() == doctor_btn) {
			dashboard_form.setVisible(false);
			dashboard_form.setDisable(true);
			Appointment_form.setVisible(false);
			Appointment_form.setDisable(true);
			profilesettings_form.setVisible(false);
			profilesettings_form.setDisable(true);
		} else if (event.getSource() == appointment_btn) {
			dashboard_form.setVisible(false);
			dashboard_form.setDisable(true);
			Appointment_form.setVisible(true);
			Appointment_form.setDisable(false);
			FadeInPatientAppointments();
			profilesettings_form.setVisible(false);
			profilesettings_form.setDisable(true);
		} else if (event.getSource() == profile_settings_btn) {
			dashboard_form.setVisible(false);
			dashboard_form.setDisable(true);
			Appointment_form.setVisible(false);
			Appointment_form.setDisable(true);
			profilesettings_form.setVisible(true);
			profilesettings_form.setDisable(false);
			displayPatientProfile();
			FadeInProfileSettings();
			displayPatientID();
			displayPatientProfile();
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

	public ObservableList<PatientData> PatientGetData() throws ClassNotFoundException, SQLException {
		ObservableList<PatientData> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM patient WHERE patient_id=?";

		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Data.patient_id);
			resultSet = preparedStatement.executeQuery();

//	           Integer appointmentID, String name, String gender, String description, String diagnosis , String treatment,Long mobileNumber,
//				Date date, Date dateModify, Date dateDelete, String status

			while (resultSet.next()) {
				PatientData appdata = new PatientData(resultSet.getString("description"),
						resultSet.getString("diagnosis"), resultSet.getString("treatment"), resultSet.getDate("date"));

				listData.add(appdata);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Greška pri učitavanju podataka pacijenta: " + e.getMessage());
		}
		return listData;
	}

	public ObservableList<PatientData> patientListGetData;

	public void PatientShowData() throws ClassNotFoundException, SQLException {
		patientListGetData = PatientGetData();

		patient_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
		patient_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
		patient_col_treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
		patient_col_datein.setCellValueFactory(new PropertyValueFactory<>("date"));

		patient_tableview.setItems(patientListGetData);
		patient_tableview.refresh();
	}

	public ObservableList<AppointmentData> appointmentGetData() throws ClassNotFoundException, SQLException {
		ObservableList<AppointmentData> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM appointment WHERE patient_id=?";

		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Data.patient_id);
			resultSet = preparedStatement.executeQuery();

//	            Integer appointmentID, String description, String diagnosis, String treatment,
//				String doctorID, Date schedule

			while (resultSet.next()) {
				AppointmentData appdata = new AppointmentData(resultSet.getInt("appointment_id"),
						resultSet.getString("description"), resultSet.getString("diagnosis"),
						resultSet.getString("treatment"), resultSet.getString("doctor"), resultSet.getDate("schedule"));

				listData.add(appdata);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Greška pri učitavanju podataka pacijenta: " + e.getMessage());
		}
		return listData;
	}

	public ObservableList<AppointmentData> appointmentList;

	public void appointmentShowData() throws ClassNotFoundException, SQLException {
		appointmentList = appointmentGetData();

		appointment_col_appID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
		appointment_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
		appointment_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
		appointment_col_treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
		appointment_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
		appointment_col_schedule.setCellValueFactory(new PropertyValueFactory<>("schedule"));

		appointment_tableview.setItems(appointmentList);
		appointment_tableview.refresh();
	}

	public void displayDoctorInformation() throws ClassNotFoundException, SQLException {
		String sql = "Select * from doctor,patient where patient.doctor=doctor.full_name;";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				doctor_label_doctorName.setText(resultSet.getString("full_name"));
				doctor_label_specialization.setText(resultSet.getString("specialized"));
				doctor_label_email.setText(resultSet.getString("email"));
				doctor_label_contact.setText(resultSet.getString("phone_number"));
				String imagePath = resultSet.getString("image");
				if (imagePath != null && !imagePath.isEmpty()) {
					Image image = new Image("file:" + imagePath);
					doctor_profilePicture.setFill(new ImagePattern(image));
				}
			}
		} catch (Exception e) {

		}
	}

	public void displayPatientInformation() throws ClassNotFoundException, SQLException {
		String sql = "Select * from patient where patient_id=?";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Data.patient_id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				appointments_Name.setText(resultSet.getString("full_name"));
				appointments_Gender.setText(resultSet.getString("gender"));
				appointments_Address.setText(resultSet.getString("address"));
				appointments_contact.setText(resultSet.getString("phone_number"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadDoctorIDs() throws ClassNotFoundException, SQLException {
		String sql = "SELECT doctor_id FROM doctor";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			List<String> doctorIDs = new ArrayList<>();

			while (resultSet.next()) {
				doctorIDs.add(resultSet.getString("doctor_id"));
			}

			ObservableList<String> listData = FXCollections.observableArrayList(doctorIDs);
			appointment_details_docbox.setItems(listData);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void patientConfirmBtn() throws ClassNotFoundException, SQLException {
		String sql = "Select * from doctor where doctor_id=?";
		connect();

		preparedStatement = connect.prepareStatement(sql);
		preparedStatement.setString(1, appointment_details_docbox.getSelectionModel().getSelectedItem());
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			appointments_description.setText(appointment_details_description.getText());
			appointments_doctor.setText(resultSet.getString("full_name"));
			appointments_spec.setText(resultSet.getString("specialized"));
			appointments_schedule.setText(String.valueOf(appointment_details_schedule.getValue()));
		}
	}

	public void patientClearBtn() {

		if (alert.confirmationMessage("Are you sure that you want to clear all fields?")) {
			appointments_description.clear();
			appointments_doctor.clear();
			appointments_spec.clear();
			appointments_schedule.clear();
			appointment_details_description.clear();
			appointment_details_schedule.setValue(null);
			appointment_details_docbox.getSelectionModel().clearSelection();
		}
	}

	public void patientBookBtn() throws ClassNotFoundException, SQLException {
		if (appointments_description.getText().isEmpty() || appointment_details_docbox.getSelectionModel().isEmpty()
				|| appointment_details_schedule.getValue() == null
				|| appointment_details_description.getText().isEmpty() || appointments_doctor.getText().isEmpty()
				|| appointments_spec.getText().isEmpty() || appointments_schedule.getText().isEmpty()) {

			alert.errorMessage("Please fill all blank fields!");
			return;
		}

		connect();

		String sql = "SELECT MAX(appointment_id) AS max_id FROM appointment";
		preparedStatement = connect.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();

		int tempID = 1;

		if (resultSet.next() && resultSet.getInt("max_id") > 0) {
			tempID = resultSet.getInt("max_id") + 1;
		}

		System.out.println("Novi ID: " + tempID);

		String insertData = "INSERT INTO appointment(appointment_id, patient_id, name, gender, "
				+ "description, mobile_number, address, date, doctor, specialized, schedule , status ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";

		preparedStatement = connect.prepareStatement(insertData);

		preparedStatement.setInt(1, tempID);
		preparedStatement.setString(2, nav_id.getText());
		preparedStatement.setString(3, appointments_Name.getText());
		preparedStatement.setString(4, appointments_Gender.getText());
		preparedStatement.setString(5, appointments_description.getText());
		preparedStatement.setString(6, appointments_contact.getText());
		preparedStatement.setString(7, appointments_Address.getText());

		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		preparedStatement.setDate(8, sqlDate);

		preparedStatement.setString(9, appointment_details_docbox.getSelectionModel().getSelectedItem());
		preparedStatement.setString(10, appointments_spec.getText());
		preparedStatement.setDate(11, java.sql.Date.valueOf(appointment_details_schedule.getValue()));
		preparedStatement.setString(12, "Active");

		int insertedRow = preparedStatement.executeUpdate();

		if (insertedRow > 0) {
			alert.successMessage("Successfully booked!");
		} else {
			alert.errorMessage("Something went wrong!");
		}
	}

	public void displayPatientProfile() throws ClassNotFoundException, SQLException {
		String sql = "Select * from patient where patient_id=?";
		connect();

		preparedStatement = connect.prepareStatement(sql);
		preparedStatement.setString(1, patientEdit_patientID.getText());
		resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			patientEdit_label_patientID.setText(resultSet.getString("patient_id"));
			patientEdit_label_name.setText(resultSet.getString("full_name"));
			patientEdit_label_contact.setText(resultSet.getString("phone_number"));
			patientEdit_label_datecreated.setText(String.valueOf(resultSet.getDate("date")));
			String imagePath = resultSet.getString("image");
			if (imagePath != null && !imagePath.isEmpty()) {
				Image image = new Image("file:" + imagePath);
				patientEdit_profilePicture.setFill(new ImagePattern(image));
			}
		}
	}

	@FXML
	public void profileChangeProfile() {
		FileChooser open = new FileChooser();
		open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*.png", "*.jpg", "*.jpeg"));

		// Provera da li dugme postoji
		if (patientEdit_ImportPicture == null) {
			System.out.println("ERROR: settings_ImportPicture je null! Proverite FXML fajl i @FXML anotaciju.");
			return;
		}

		// Provera da li scena postoji
		if (patientEdit_ImportPicture.getScene() == null) {
			System.out.println("ERROR: settings_ImportPicture.getScene() je null! GUI možda još nije učitan.");
			return;
		}

		File file = open.showOpenDialog(patientEdit_ImportPicture.getScene().getWindow());

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
		if (patientEdit_ImportPicture == null) {
			System.out.println("ERROR: settings_picture je null! Proverite fx:id u FXML fajlu.");
			return;
		}

		patientEdit_profilePicture.setFill(new ImagePattern(image));
		System.out.println("Slika je uspešno postavljena.");
	}

	private void patientGenderList() {
		List<String> listG = new ArrayList<>();
		for (String data : Data.gender) {
			listG.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listG);
		patientEdit_gender.setItems(listData);
	}

	private void patientStatus() {
		List<String> listS = new ArrayList<>();
		for (String data : Data.status) {
			listS.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listS);
		patientEdit_status.setItems(listData);
	}

	public void profileDisplayFields() throws ClassNotFoundException, SQLException {
		String sql = "Select * from patient where patient_id=?";
		connect();
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, nav_id.getText());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				patientEdit_patientID.setText(resultSet.getString("patient_id"));
				patientEdit_fullname.setText(resultSet.getString("full_name"));
				patientEdit_address.setText(resultSet.getString("address"));
				patientEdit_gender.getSelectionModel().select(resultSet.getString("gender"));
				patientEdit_status.getSelectionModel().select(resultSet.getString("status"));
				patientEdit_contact.setText(resultSet.getString("phone_number"));
				patientEdit_password.setText(resultSet.getString("password"));
				displayPatientProfile();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateProfile() throws ClassNotFoundException, SQLException {
		if (patientEdit_patientID.getText().isEmpty() || patientEdit_fullname.getText().isEmpty()
				|| patientEdit_address.getText().isEmpty() || patientEdit_gender.getSelectionModel().isEmpty()
				|| patientEdit_status.getSelectionModel().isEmpty() || patientEdit_contact.getText().isEmpty()
				|| patientEdit_password.getText().isEmpty()) {
			alert.errorMessage("Please fill all blank fields!");
		} else {

			String selectData = "Select * from patient where patient_id=?";
			connect();
			try {
				preparedStatement = connect.prepareStatement(selectData);
				preparedStatement.setString(1, nav_id.getText());
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					String updateData = "Update patient set patient_id = ?, full_name = ? , address = ? , gender = ? , status = ? , phone_number = ? , password = ? , date_modify = ? , image = ? where patient_id=?";
					preparedStatement = connect.prepareStatement(updateData);
					preparedStatement.setString(1, patientEdit_patientID.getText());
					preparedStatement.setString(2, patientEdit_fullname.getText());
					preparedStatement.setString(3, patientEdit_address.getText());
					preparedStatement.setString(4, patientEdit_gender.getSelectionModel().getSelectedItem());
					preparedStatement.setString(5, patientEdit_status.getSelectionModel().getSelectedItem());
					preparedStatement.setString(6, patientEdit_contact.getText());
					preparedStatement.setString(7, patientEdit_password.getText());

					String existingImagePath = resultSet.getString("image"); // Postojeća putanja slike u bazi
					String path; // Finalna putanja slike

					// Nova putanja slike (uvek postavljamo novu putanju)
					java.nio.file.Path destinationPath = Paths.get(
							"C:\\Users\\Win10\\Desktop\\Java\\JavaFx\\HospitalManagment\\src\\application\\ProfilneSlikeStorage\\PatientForm\\");

					// Kreiraj direktorijum ako ne postoji
					java.nio.file.Path targetDir = destinationPath.getParent();
					if (!Files.exists(targetDir)) {
						try {
							Files.createDirectories(targetDir);
						} catch (IOException e) {
							e.printStackTrace();
							alert.errorMessage("Error creating directories: " + e.getMessage());
							return;
						}
					}

					// Provera da li je korisnik odabrao novu sliku
					if (Data.path != null && !Data.path.isEmpty()) {
						java.nio.file.Path sourcePath = Paths.get(Data.path);

						// Proveri da li fajl postoji pre kopiranja
						if (!Files.exists(sourcePath)) {
							alert.errorMessage("Selected image does not exist: " + Data.path);
							return;
						}

						// Pokušaj kopiranja nove slike
						try {
							Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e) {
							e.printStackTrace();
							alert.errorMessage("Error while copying the image: " + e.getMessage());
							return;
						}

						// Postavljamo novu putanju slike u bazu
						path = destinationPath.toAbsolutePath().toString();
					} else {
						// Ako korisnik nije odabrao novu sliku, koristi postojeću
						if (existingImagePath != null && !existingImagePath.isEmpty()) {
							path = existingImagePath;
						} else {
							alert.errorMessage("No image selected or available.");
							return;
						}
					}

					Date date = new Date();
					java.sql.Date sqldate = new java.sql.Date(date.getTime());
					preparedStatement.setDate(8, sqldate);

					preparedStatement.setString(9, path);

					preparedStatement.setString(10, nav_id.getText());

					int updatedRow = preparedStatement.executeUpdate();
					if (updatedRow > 0) {
						alert.successMessage("Successfully updated!");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
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

				dashboard_logoutBTN.getScene().getWindow().hide();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void FadeInPatientAppointments() {
		
		APD_pane.setOpacity(0);
		APD_line.setOpacity(0);
		APD_label.setOpacity(0);
		APD_description.setOpacity(0);
		APD_doctor.setOpacity(0);
		APD_schedule.setOpacity(0);
		appointment_details_description.setOpacity(0);
		appointment_details_docbox.setOpacity(0);
		appointment_details_schedule.setOpacity(0);
		appd_book_btn.setOpacity(0);
		clear_btn.setOpacity(0);

		
		APPS_pane.setOpacity(0);
		APPS_line.setOpacity(0);
		APPS_label.setOpacity(0);
		APPS_name.setOpacity(0);
		APPS_gender.setOpacity(0);
		APPS_address.setOpacity(0);
		APPS_contact.setOpacity(0);
		APPS_description.setOpacity(0);
		APPS_doctor.setOpacity(0);
		APPS_spec.setOpacity(0);
		APPS_schedule.setOpacity(0);
		book_btn.setOpacity(0);
		appointments_Name.setOpacity(0);
		appointments_Gender.setOpacity(0);
		appointments_Address.setOpacity(0);
		appointments_contact.setOpacity(0);
		appointments_description.setOpacity(0);
		appointments_doctor.setOpacity(0);
		appointments_spec.setOpacity(0);
		appointments_schedule.setOpacity(0);
		
		
		
		

		FadeTransition fadeAPDPane = new FadeTransition(Duration.seconds(1.5), APD_pane);
		fadeAPDPane.setFromValue(0);
		fadeAPDPane.setToValue(1);

		PauseTransition delay1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPDLine = new FadeTransition(Duration.seconds(0.5), APD_line);
		fadeAPDLine.setFromValue(0);
		fadeAPDLine.setToValue(1);

		PauseTransition delay2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPDlabel = new FadeTransition(Duration.seconds(0.5), APD_label);
		fadeAPDlabel.setFromValue(0);
		fadeAPDlabel.setToValue(1);

		PauseTransition delay3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPDlabelDesc = new FadeTransition(Duration.seconds(0.5), APD_description);
		fadeAPDlabelDesc.setFromValue(0);
		fadeAPDlabelDesc.setToValue(1);

		PauseTransition delay4 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPDtextDesc = new FadeTransition(Duration.seconds(0.5), appointment_details_description);
		fadeAPDtextDesc.setFromValue(0);
		fadeAPDtextDesc.setToValue(1);
		
		
		PauseTransition delay5 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPDlabelDoctor = new FadeTransition(Duration.seconds(0.5), APD_doctor);
		fadeAPDlabelDoctor.setFromValue(0);
		fadeAPDlabelDoctor.setToValue(1);

		PauseTransition delay6 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPDtextDoctor = new FadeTransition(Duration.seconds(0.5), appointment_details_docbox);
		fadeAPDtextDoctor.setFromValue(0);
		fadeAPDtextDoctor.setToValue(1);
		
		PauseTransition delay7 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPDlabelSchedule = new FadeTransition(Duration.seconds(0.5), APD_schedule);
		fadeAPDlabelSchedule.setFromValue(0);
		fadeAPDlabelSchedule.setToValue(1);

		PauseTransition delay8 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPDtextSchedule = new FadeTransition(Duration.seconds(0.5), appointment_details_schedule);
		fadeAPDtextSchedule.setFromValue(0);
		fadeAPDtextSchedule.setToValue(1);
		
		PauseTransition delay9 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPDButtonConfirm = new FadeTransition(Duration.seconds(0.5), appd_book_btn);
		fadeAPDButtonConfirm.setFromValue(0);
		fadeAPDButtonConfirm.setToValue(1);

		PauseTransition delay10 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPDButtonClear = new FadeTransition(Duration.seconds(0.5), clear_btn);
		fadeAPDButtonClear.setFromValue(0);
		fadeAPDButtonClear.setToValue(1);
		
		
		
		
		FadeTransition fadeAPPSPane = new FadeTransition(Duration.seconds(1.5), APPS_pane);
		fadeAPPSPane.setFromValue(0);
		fadeAPPSPane.setToValue(1);

		PauseTransition Delay1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSLine = new FadeTransition(Duration.seconds(0.5), APPS_line);
		fadeAPPSLine.setFromValue(0);
		fadeAPPSLine.setToValue(1);

		PauseTransition Delay2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabel = new FadeTransition(Duration.seconds(0.5), APPS_label);
		fadeAPPSlabel.setFromValue(0);
		fadeAPPSlabel.setToValue(1);

		PauseTransition Delay3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelName = new FadeTransition(Duration.seconds(0.5), APPS_name);
		fadeAPPSlabelName.setFromValue(0);
		fadeAPPSlabelName.setToValue(1);

		PauseTransition Delay4 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextName = new FadeTransition(Duration.seconds(0.5), appointments_Name);
		fadeAPPStextName.setFromValue(0);
		fadeAPPStextName.setToValue(1);
		
		PauseTransition Delay5 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelGender = new FadeTransition(Duration.seconds(0.5), APPS_gender);
		fadeAPPSlabelGender.setFromValue(0);
		fadeAPPSlabelGender.setToValue(1);

		PauseTransition Delay6 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextGender = new FadeTransition(Duration.seconds(0.5), appointments_Gender);
		fadeAPPStextGender.setFromValue(0);
		fadeAPPStextGender.setToValue(1);

		PauseTransition Delay7 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelAddress = new FadeTransition(Duration.seconds(0.5), APPS_address);
		fadeAPPSlabelAddress.setFromValue(0);
		fadeAPPSlabelAddress.setToValue(1);

		PauseTransition Delay8 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextAddress = new FadeTransition(Duration.seconds(0.5), appointments_Address);
		fadeAPPStextAddress.setFromValue(0);
		fadeAPPStextAddress.setToValue(1);
		
		PauseTransition Delay9 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelContact = new FadeTransition(Duration.seconds(0.5), APPS_contact);
		fadeAPPSlabelContact.setFromValue(0);
		fadeAPPSlabelContact.setToValue(1);

		PauseTransition Delay10 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextContact = new FadeTransition(Duration.seconds(0.5), appointments_contact);
		fadeAPPStextContact.setFromValue(0);
		fadeAPPStextContact.setToValue(1);
		
		PauseTransition Delay11 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelDesc = new FadeTransition(Duration.seconds(0.5), APPS_description);
		fadeAPPSlabelDesc.setFromValue(0);
		fadeAPPSlabelDesc.setToValue(1);

		PauseTransition Delay12 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextDesc = new FadeTransition(Duration.seconds(0.5), appointments_description);
		fadeAPPStextDesc.setFromValue(0);
		fadeAPPStextDesc.setToValue(1);
		
		PauseTransition Delay13 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelDoctor = new FadeTransition(Duration.seconds(0.5), APPS_doctor);
		fadeAPPSlabelDoctor.setFromValue(0);
		fadeAPPSlabelDoctor.setToValue(1);

		PauseTransition Delay14 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextDoctor = new FadeTransition(Duration.seconds(0.5), appointments_doctor);
		fadeAPPStextDoctor.setFromValue(0);
		fadeAPPStextDoctor.setToValue(1);
		
		PauseTransition Delay15 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelSpec = new FadeTransition(Duration.seconds(0.5), APPS_spec);
		fadeAPPSlabelSpec.setFromValue(0);
		fadeAPPSlabelSpec.setToValue(1);

		PauseTransition Delay16 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextSpec = new FadeTransition(Duration.seconds(0.5), appointments_spec);
		fadeAPPStextSpec.setFromValue(0);
		fadeAPPStextSpec.setToValue(1);
		
		PauseTransition Delay17 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAPPSlabelSchedule = new FadeTransition(Duration.seconds(0.5), APPS_schedule);
		fadeAPPSlabelSchedule.setFromValue(0);
		fadeAPPSlabelSchedule.setToValue(1);

		PauseTransition Delay18 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPStextSchedule = new FadeTransition(Duration.seconds(0.5), appointments_schedule);
		fadeAPPStextSchedule.setFromValue(0);
		fadeAPPStextSchedule.setToValue(1);
		
        PauseTransition Delay19 = new PauseTransition(Duration.seconds(0.2));
		
		FadeTransition fadeAPPSButton = new FadeTransition(Duration.seconds(0.5), book_btn);
		fadeAPPSButton.setFromValue(0);
		fadeAPPSButton.setToValue(1);

		// Redosled animacija sa kašnjenjima
		SequentialTransition sequentialTransition = new SequentialTransition(
				fadeAPDPane,delay1,fadeAPDLine,delay2,fadeAPDlabel,delay3,fadeAPDlabelDesc,delay4,fadeAPDtextDesc,
				delay5,fadeAPDlabelDoctor,delay6,fadeAPDtextDoctor,delay7,fadeAPDlabelSchedule,delay8,fadeAPDtextSchedule,
				delay9,fadeAPDButtonConfirm,delay10,fadeAPDButtonClear,fadeAPPSPane,Delay1,fadeAPPSLine,Delay2,
				fadeAPPSlabel,Delay3,fadeAPPSlabelName,Delay4,fadeAPPStextName,Delay5,fadeAPPSlabelGender,Delay6,fadeAPPStextGender,
				Delay7,fadeAPPSlabelAddress,Delay8,fadeAPPStextAddress,Delay9,fadeAPPSlabelContact,Delay10,fadeAPPStextContact,
				Delay11,fadeAPPSlabelDesc,Delay12,fadeAPPStextDesc,Delay13,fadeAPPSlabelDoctor,Delay14,fadeAPPStextDoctor,
				Delay15,fadeAPPSlabelSpec,Delay16,fadeAPPStextSpec,Delay17,fadeAPPSlabelSchedule,Delay18,fadeAPPStextSchedule,Delay19,fadeAPPSButton
				
				);

		// Pokretanje animacije
		sequentialTransition.play();
	}
	
	public void FadeInPatientDashboard() {
		P_pane.setOpacity(0);
		P_line.setOpacity(0);
		P_label.setOpacity(0);
		patient_tableview.setOpacity(0);

		A_pane.setOpacity(0);
		A_line.setOpacity(0);
		A_label.setOpacity(0);
		appointment_tableview.setOpacity(0);
		
		YDI_pane.setOpacity(0);
		YDI_label.setOpacity(0);
		YDI_picture.setOpacity(0);
		YDI_name.setOpacity(0);
		YDI_spec.setOpacity(0);
		YDI_email.setOpacity(0);
		YDI_mobile.setOpacity(0);
		doctor_label_doctorName.setOpacity(0);
		doctor_label_specialization.setOpacity(0);
		doctor_label_email.setOpacity(0);
		doctor_label_contact.setOpacity(0);

		FadeTransition fadePPane = new FadeTransition(Duration.seconds(1.5), P_pane);
		fadePPane.setFromValue(0);
		fadePPane.setToValue(1);

		PauseTransition delay1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePLine = new FadeTransition(Duration.seconds(0.5), P_line);
		fadePLine.setFromValue(0);
		fadePLine.setToValue(1);

		PauseTransition delay2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePlabel = new FadeTransition(Duration.seconds(0.5), P_label);
		fadePlabel.setFromValue(0);
		fadePlabel.setToValue(1);

		PauseTransition delay3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePtabel = new FadeTransition(Duration.seconds(0.5), patient_tableview);
		fadePtabel.setFromValue(0);
		fadePtabel.setToValue(1);

		PauseTransition delay4 = new PauseTransition(Duration.seconds(0.2));

		
		
		
		FadeTransition fadeAPane = new FadeTransition(Duration.seconds(1.5), A_pane);
		fadeAPane.setFromValue(0);
		fadeAPane.setToValue(1);

		PauseTransition Delay1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeALine = new FadeTransition(Duration.seconds(0.5), A_line);
		fadeALine.setFromValue(0);
		fadeALine.setToValue(1);

		PauseTransition Delay2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAlabel = new FadeTransition(Duration.seconds(0.5), A_label);
		fadeAlabel.setFromValue(0);
		fadeAlabel.setToValue(1);

		PauseTransition Delay3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeAtabel = new FadeTransition(Duration.seconds(0.5), appointment_tableview);
		fadeAtabel.setFromValue(0);
		fadeAtabel.setToValue(1);
		
		
		
		FadeTransition fadeYDIPane = new FadeTransition(Duration.seconds(1.5), YDI_pane);
		fadeYDIPane.setFromValue(0);
		fadeYDIPane.setToValue(1);

		PauseTransition DelayYDI1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDIProfile = new FadeTransition(Duration.seconds(0.5), doctor_profilePicture);
		fadeYDIProfile.setFromValue(0);
		fadeYDIProfile.setToValue(1);

		PauseTransition DelayYDI2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDIlabel = new FadeTransition(Duration.seconds(0.5), YDI_label);
		fadeYDIlabel.setFromValue(0);
		fadeYDIlabel.setToValue(1);

		FadeTransition fadeYDIpricture = new FadeTransition(Duration.seconds(0.5), YDI_picture);
		fadeYDIpricture.setFromValue(0);
		fadeYDIpricture.setToValue(1);
		
		PauseTransition DelayYDI3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDIName = new FadeTransition(Duration.seconds(0.5), YDI_name);
		fadeYDIName.setFromValue(0);
		fadeYDIName.setToValue(1);

		PauseTransition DelayYDI4 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDINamedisplay = new FadeTransition(Duration.seconds(0.5), doctor_label_doctorName);
		fadeYDINamedisplay.setFromValue(0);
		fadeYDINamedisplay.setToValue(1);
		
		PauseTransition DelayYDI5 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDISpec = new FadeTransition(Duration.seconds(0.5), YDI_spec);
		fadeYDISpec.setFromValue(0);
		fadeYDISpec.setToValue(1);

		PauseTransition DelayYDI6 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDISpecdisplay = new FadeTransition(Duration.seconds(0.5), doctor_label_specialization);
		fadeYDISpecdisplay.setFromValue(0);
		fadeYDISpecdisplay.setToValue(1);
		
		PauseTransition DelayYDI7 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDIEmail = new FadeTransition(Duration.seconds(0.5), YDI_email);
		fadeYDIEmail.setFromValue(0);
		fadeYDIEmail.setToValue(1);

		PauseTransition DelayYDI8 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDIEmaildisplay = new FadeTransition(Duration.seconds(0.5), doctor_label_email);
		fadeYDIEmaildisplay.setFromValue(0);
		fadeYDIEmaildisplay.setToValue(1);
		
		PauseTransition DelayYDI9 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDIMobile = new FadeTransition(Duration.seconds(0.5), YDI_mobile);
		fadeYDIMobile.setFromValue(0);
		fadeYDIMobile.setToValue(1);

		PauseTransition DelayYDI10 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeYDIMobiledisplay = new FadeTransition(Duration.seconds(0.5), doctor_label_contact);
		fadeYDIMobiledisplay.setFromValue(0);
		fadeYDIMobiledisplay.setToValue(1);

		// Redosled animacija sa kašnjenjima
		SequentialTransition sequentialTransition = new SequentialTransition(fadePPane, delay1, fadePLine, delay2,
				fadePlabel, delay3, fadePtabel, delay4, fadeAPane, Delay1, fadeALine, Delay2, fadeAlabel, Delay3,
				fadeAtabel,fadeYDIPane,DelayYDI1,fadeYDIProfile,DelayYDI2,fadeYDIlabel,fadeYDIpricture,
				DelayYDI3,fadeYDIName,DelayYDI4,fadeYDINamedisplay,DelayYDI5,fadeYDISpec,DelayYDI6,fadeYDISpecdisplay,
				DelayYDI7,fadeYDIEmail,DelayYDI8,fadeYDIEmaildisplay,DelayYDI9,fadeYDIMobile,DelayYDI10,fadeYDIMobiledisplay
				
				);

		// Pokretanje animacije
		sequentialTransition.play();
	}
	
	public void FadeInProfileSettings(){
		PF_pane.setOpacity(0);
		patientEdit_profilePicture.setOpacity(0);
		patientEdit_ImportPicture.setOpacity(0);
		P_ID.setOpacity(0);
		patientEdit_label_patientID.setOpacity(0);
		P_name.setOpacity(0);
		YDI_mobile.setOpacity(0);
		patientEdit_label_name.setOpacity(0);
		P_mobile.setOpacity(0);
		patientEdit_label_contact.setOpacity(0);
		P_date.setOpacity(0);
		patientEdit_label_datecreated.setOpacity(0);
		
		
		
		EDP_ID.setOpacity(0);
		EDP_address.setOpacity(0);
		EDP_gender.setOpacity(0);
		EDP_label.setOpacity(0);
		EDP_line.setOpacity(0);
		EDP_mobile.setOpacity(0);
		EDP_name.setOpacity(0);
		EDP_pane.setOpacity(0);
		EDP_password.setOpacity(0);
		EDP_picture1.setOpacity(0);
		EDP_picture2.setOpacity(0);
		EDP_status.setOpacity(0);
		patientEdit_patientID.setOpacity(0);
		patientEdit_fullname.setOpacity(0);
		patientEdit_address.setOpacity(0);
		patientEdit_gender.setOpacity(0);
		patientEdit_contact.setOpacity(0);
		patientEdit_status.setOpacity(0);
		patientEdit_password.setOpacity(0);
		patientEdit_update.setOpacity(0);

		FadeTransition fadePFPane = new FadeTransition(Duration.seconds(1.5), PF_pane);
		fadePFPane.setFromValue(0);
		fadePFPane.setToValue(1);

		PauseTransition delay1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFpicture = new FadeTransition(Duration.seconds(0.5), patientEdit_profilePicture);
		fadePFpicture.setFromValue(0);
		fadePFpicture.setToValue(1);

		PauseTransition delay2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFimportbtn = new FadeTransition(Duration.seconds(0.5), patientEdit_ImportPicture);
		fadePFimportbtn.setFromValue(0);
		fadePFimportbtn.setToValue(1);

		PauseTransition delay3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFlabelID = new FadeTransition(Duration.seconds(0.5), P_ID);
		fadePFlabelID.setFromValue(0);
		fadePFlabelID.setToValue(1);
		
		PauseTransition delay4 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFdisplayID = new FadeTransition(Duration.seconds(0.5), patientEdit_label_patientID);
		fadePFdisplayID.setFromValue(0);
		fadePFdisplayID.setToValue(1);

		PauseTransition delay5 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFlabelName = new FadeTransition(Duration.seconds(0.5), P_name);
		fadePFlabelName.setFromValue(0);
		fadePFlabelName.setToValue(1);
		
		PauseTransition delay6 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFdisplayName = new FadeTransition(Duration.seconds(0.5), patientEdit_label_name);
		fadePFdisplayName.setFromValue(0);
		fadePFdisplayName.setToValue(1);
		
		PauseTransition delay7 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFlabelMobile = new FadeTransition(Duration.seconds(0.5), P_mobile);
		fadePFlabelMobile.setFromValue(0);
		fadePFlabelMobile.setToValue(1);
		
		PauseTransition delay8 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFdisplayMobile = new FadeTransition(Duration.seconds(0.5), patientEdit_label_contact);
		fadePFdisplayMobile.setFromValue(0);
		fadePFdisplayMobile.setToValue(1);
		
		PauseTransition delay9 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFlabelDate = new FadeTransition(Duration.seconds(0.5), P_date);
		fadePFlabelDate.setFromValue(0);
		fadePFlabelDate.setToValue(1);
		
		PauseTransition delay10 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadePFdisplayDate = new FadeTransition(Duration.seconds(0.5), patientEdit_label_datecreated);
		fadePFdisplayDate.setFromValue(0);
		fadePFdisplayDate.setToValue(1);
		
		
		
		FadeTransition fadeEDPPane = new FadeTransition(Duration.seconds(1.5), EDP_pane);
		fadeEDPPane.setFromValue(0);
		fadeEDPPane.setToValue(1);

		PauseTransition Delay1 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPline = new FadeTransition(Duration.seconds(0.5), EDP_line);
		fadeEDPline.setFromValue(0);
		fadeEDPline.setToValue(1);

		PauseTransition Delay2 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabel = new FadeTransition(Duration.seconds(0.5), EDP_label);
		fadeEDPlabel.setFromValue(0);
		fadeEDPlabel.setToValue(1);

		FadeTransition fadeEDPpicture1 = new FadeTransition(Duration.seconds(0.5), EDP_picture1);
		fadeEDPpicture1.setFromValue(0);
		fadeEDPpicture1.setToValue(1);
		
		PauseTransition Delay3 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPdisplayID = new FadeTransition(Duration.seconds(0.5), patientEdit_label_patientID);
		fadeEDPdisplayID.setFromValue(0);
		fadeEDPdisplayID.setToValue(1);
		
		PauseTransition Delay4 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabelID = new FadeTransition(Duration.seconds(0.5), EDP_ID);
		fadeEDPlabelID.setFromValue(0);
		fadeEDPlabelID.setToValue(1);

		PauseTransition Delay5 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPtextID = new FadeTransition(Duration.seconds(0.5), patientEdit_patientID);
		fadeEDPtextID.setFromValue(0);
		fadeEDPtextID.setToValue(1);
		
		PauseTransition Delay6 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabelname = new FadeTransition(Duration.seconds(0.5), EDP_name);
		fadeEDPlabelname.setFromValue(0);
		fadeEDPlabelname.setToValue(1);

		PauseTransition Delay7 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPtextname = new FadeTransition(Duration.seconds(0.5), patientEdit_fullname);
		fadeEDPtextname.setFromValue(0);
		fadeEDPtextname.setToValue(1);
		
		PauseTransition Delay8 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabeladdress = new FadeTransition(Duration.seconds(0.5), EDP_address);
		fadeEDPlabeladdress.setFromValue(0);
		fadeEDPlabeladdress.setToValue(1);

		PauseTransition Delay9 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPtextaddress = new FadeTransition(Duration.seconds(0.5), patientEdit_address);
		fadeEDPtextaddress.setFromValue(0);
		fadeEDPtextaddress.setToValue(1);
		
		PauseTransition Delay10 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabelgender = new FadeTransition(Duration.seconds(0.5), EDP_gender);
		fadeEDPlabelgender.setFromValue(0);
		fadeEDPlabelgender.setToValue(1);

		PauseTransition Delay11 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPtextgender = new FadeTransition(Duration.seconds(0.5), patientEdit_gender);
		fadeEDPtextgender.setFromValue(0);
		fadeEDPtextgender.setToValue(1);
		
		PauseTransition Delay12 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabelmobile = new FadeTransition(Duration.seconds(0.5), EDP_mobile);
		fadeEDPlabelmobile.setFromValue(0);
		fadeEDPlabelmobile.setToValue(1);

		PauseTransition Delay13 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPtextmobile = new FadeTransition(Duration.seconds(0.5), patientEdit_contact);
		fadeEDPtextmobile.setFromValue(0);
		fadeEDPtextmobile.setToValue(1);
		
		PauseTransition Delay14 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabelstatus = new FadeTransition(Duration.seconds(0.5), EDP_status);
		fadeEDPlabelstatus.setFromValue(0);
		fadeEDPlabelstatus.setToValue(1);

		PauseTransition Delay15 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPtextstatus = new FadeTransition(Duration.seconds(0.5), patientEdit_status);
		fadeEDPtextstatus.setFromValue(0);
		fadeEDPtextstatus.setToValue(1);
		
		PauseTransition Delay16 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPlabelpassword = new FadeTransition(Duration.seconds(0.5), EDP_password);
		fadeEDPlabelpassword.setFromValue(0);
		fadeEDPlabelpassword.setToValue(1);

		PauseTransition Delay17 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPtextpasswrod = new FadeTransition(Duration.seconds(0.5), patientEdit_password);
		fadeEDPtextpasswrod.setFromValue(0);
		fadeEDPtextpasswrod.setToValue(1);
		
		PauseTransition Delay18 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPpicture2 = new FadeTransition(Duration.seconds(0.5), EDP_picture2);
		fadeEDPpicture2.setFromValue(0);
		fadeEDPpicture2.setToValue(0.2);

		PauseTransition Delay19 = new PauseTransition(Duration.seconds(0.2));

		FadeTransition fadeEDPbutton = new FadeTransition(Duration.seconds(0.5), patientEdit_update);
		fadeEDPbutton.setFromValue(0);
		fadeEDPbutton.setToValue(1);
		
		SequentialTransition sequentialTransition = new SequentialTransition(
				fadePFPane,delay1,fadePFpicture,delay2,fadePFimportbtn,delay3,fadePFlabelID,delay4,fadePFdisplayID,
				delay5,fadePFlabelName,delay6,fadePFdisplayName,delay7,fadePFlabelMobile,delay8,fadePFdisplayMobile,
				delay9,fadePFlabelDate,delay10,fadePFdisplayDate,fadeEDPPane,Delay1,fadeEDPline,Delay2,fadeEDPlabel,
				fadeEDPpicture1,Delay3,fadeEDPdisplayID,Delay4,fadeEDPlabelID,Delay5,fadeEDPtextID,
				Delay6,fadeEDPlabelname,Delay7,fadeEDPtextname,Delay8,fadeEDPlabeladdress,Delay9,fadeEDPtextaddress,
				Delay10,fadeEDPlabelgender,Delay11,fadeEDPtextgender,Delay12,fadeEDPlabelmobile,Delay13,fadeEDPtextmobile,
				Delay14,fadeEDPlabelstatus,Delay15,fadeEDPtextstatus,Delay16,fadeEDPlabelpassword,Delay17,fadeEDPtextpasswrod,
				Delay18,fadeEDPpicture2,Delay19,fadeEDPbutton
				);
		
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
	
	public void buttons() {
		appd_book_btn.setOnMouseEntered(event -> enlargeButton(appd_book_btn));
		appd_book_btn.setOnMouseExited(event -> resetButtonSize(appd_book_btn));

		clear_btn.setOnMouseEntered(event -> enlargeButton(clear_btn));
		clear_btn.setOnMouseExited(event -> resetButtonSize(clear_btn));

		book_btn.setOnMouseEntered(event -> enlargeButton(book_btn));
		book_btn.setOnMouseExited(event -> resetButtonSize(book_btn));
		
		patientEdit_update.setOnMouseEntered(event -> enlargeButton(patientEdit_update));
		patientEdit_update.setOnMouseExited(event -> resetButtonSize(patientEdit_update));

		patientEdit_ImportPicture.setOnMouseEntered(event -> enlargeButton(patientEdit_ImportPicture));
		patientEdit_ImportPicture.setOnMouseExited(event -> resetButtonSize(patientEdit_ImportPicture));

		dashboard_logoutBTN.setOnMouseEntered(event -> enlargeButton(dashboard_logoutBTN));
		dashboard_logoutBTN.setOnMouseExited(event -> resetButtonSize(dashboard_logoutBTN));
		
		dashboard_btn.setOnMouseEntered(event -> enlargeButton(dashboard_btn));
		dashboard_btn.setOnMouseExited(event -> resetButtonSize(dashboard_btn));

		appointment_btn.setOnMouseEntered(event -> enlargeButton(appointment_btn));
		appointment_btn.setOnMouseExited(event -> resetButtonSize(appointment_btn));

		profile_settings_btn.setOnMouseEntered(event -> enlargeButton(profile_settings_btn));
		profile_settings_btn.setOnMouseExited(event -> resetButtonSize(profile_settings_btn));
	}
	
	
	public void fields() {
		appointment_details_description.setOnMouseEntered(event -> enlargeTextField(appointment_details_description));
		appointment_details_description.setOnMouseExited(event -> resetTextFieldSize(appointment_details_description));
		
		appointment_details_docbox.setOnMouseEntered(event -> enlargeCB(appointment_details_docbox));
		appointment_details_docbox.setOnMouseExited(event -> resetCB(appointment_details_docbox));
		
		appointment_details_schedule.setOnMouseEntered(event -> enlargeDatePicker(appointment_details_schedule));
		appointment_details_schedule.setOnMouseExited(event -> resetDatePicker(appointment_details_schedule));
		
		
		
		patientEdit_patientID.setOnMouseEntered(event -> enlargeTextField(patientEdit_patientID));
		patientEdit_patientID.setOnMouseExited(event -> resetTextFieldSize(patientEdit_patientID));
		
		patientEdit_fullname.setOnMouseEntered(event -> enlargeTextField(patientEdit_fullname));
		patientEdit_fullname.setOnMouseExited(event -> resetTextFieldSize(patientEdit_fullname));
		
		patientEdit_address.setOnMouseEntered(event -> enlargeTextField(patientEdit_address));
		patientEdit_address.setOnMouseExited(event -> resetTextFieldSize(patientEdit_address));
		
		patientEdit_contact.setOnMouseEntered(event -> enlargeTextField(patientEdit_contact));
		patientEdit_contact.setOnMouseExited(event -> resetTextFieldSize(patientEdit_contact));
		
		patientEdit_password.setOnMouseEntered(event -> enlargeTextField(patientEdit_password));
		patientEdit_password.setOnMouseExited(event -> resetTextFieldSize(patientEdit_password));
		
		patientEdit_gender.setOnMouseEntered(event -> enlargeCB(patientEdit_gender));
		patientEdit_gender.setOnMouseExited(event -> resetCB(patientEdit_gender));
		
		patientEdit_status.setOnMouseEntered(event -> enlargeCB(patientEdit_status));
		patientEdit_status.setOnMouseExited(event -> resetCB(patientEdit_status));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		runTime();
		FadeInPatientDashboard();
		buttons();
		fields();
		try {
			displayPatientID();
			PatientShowData();
			PatientGetData();
			appointmentShowData();
			appointmentGetData();
			displayDoctorInformation();
			displayPatientInformation();
			loadDoctorIDs();
			displayPatientProfile();
			profileDisplayFields();
			patientStatus();
			patientGenderList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
