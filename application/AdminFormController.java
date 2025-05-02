package application;

import java.io.File;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;

public class AdminFormController implements Initializable{
	
	@FXML
    private Label settings_profile_ID;

    @FXML
    private Label settings_profile_date;

    @FXML
    private Label settings_profile_email;

    @FXML
    private Label settings_profile_name;

    @FXML
    private AnchorPane settings_profile_pane;
    
    @FXML
    private Label edit_ID;

    @FXML
    private Label edit_email;

    @FXML
    private Label edit_fullname;

    @FXML
    private Label edit_gender;

    @FXML
    private Label edit_label;

    @FXML
    private Line edit_line;

    @FXML
    private ImageView edit_picture1;

    @FXML
    private ImageView edit_picture2;

    @FXML
    private Label edit_status;

    @FXML
    private Label edit_username;
    
    @FXML
    private AnchorPane edit_pane;
	
    @FXML
    private Label payment_profile_ID;

    @FXML
    private Label payment_profile_date;

    @FXML
    private Label payment_profile_doctor;

    @FXML
    private Label payment_profile_name;

    @FXML
    private AnchorPane payment_profile_pane;

    @FXML
    private Label payment_table_label;

    @FXML
    private Line payment_table_line;

    @FXML
    private AnchorPane payment_table_pane;

    @FXML
    private AnchorPane bottom_pane;

    @FXML
    private AnchorPane bottom_pane1;

    @FXML
    private AnchorPane bottom_pane2;

    @FXML
    private AnchorPane bottom_pane3;
    
    @FXML
    private AnchorPane upper_pane;

	 @FXML
	    private AnchorPane Appointment_form;

	    @FXML
	    private AnchorPane Patient_form;
	    
	    @FXML
	    private AnchorPane profilesettings_form;

	    @FXML
	    private Button appointment_btn;
	    
	    @FXML
	    private Label appointment_table_label;

	    @FXML
	    private Line appointment_table_line;

	    @FXML
	    private AnchorPane appointment_table_pane;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_action;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_contact;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_date;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_datedelete;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_datemodify;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_description;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_gender;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_id;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_name;

	    @FXML
	    private TableColumn<AppointmentData,String> appointment_col_status;

	    @FXML
	    private TableView<AppointmentData> appointment_tableview;

	    @FXML
	    private Label current_form;
	    
	    @FXML
	    private Label dashboard_AD_count;
	    
	    @FXML
	    private Label dashboard_TP_count;
	    
	    @FXML
	    private Label dashboard_AP_count;
	    
	    @FXML
	    private Label dashboard_TA_count;

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
	    private TableColumn<DoctorData,String> dashboard_col_docID;

	    @FXML
	    private TableColumn<DoctorData,String> dashboard_col_name;

	    @FXML
	    private TableColumn<DoctorData,String> dashboard_col_spec;

	    @FXML
	    private TableColumn<DoctorData,String> dashboard_col_status;

	    @FXML
	    private AnchorPane dashboard_form;

	    @FXML
	    private TableView<DoctorData> dashboard_tableview;

	    @FXML
	    private Label date_time;

	    @FXML
	    private Button doctor_btn;
	    
	    @FXML
	    private Label doctor_table_label;

	    @FXML
	    private Line doctor_table_line;

	    @FXML
	    private AnchorPane doctor_table_pane;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_action;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_address;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_contact;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_docID;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_email;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_gender;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_name;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_spec;

	    @FXML
	    private TableColumn<DoctorData,String> doctor_col_status;

	    @FXML
	    private TableView<DoctorData> doctor_tableview;

	    @FXML
	    private AnchorPane doctors_form;

	    @FXML
	    private AnchorPane main_form;

	    @FXML
	    private Label nav_id;

	    @FXML
	    private Label nav_username;

	    @FXML
	    private Button patient_btn;
	    
	    @FXML
	    private Label patient_table_label;

	    @FXML
	    private Line patient_table_line;

	    @FXML
	    private AnchorPane patient_table_pane;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_actieon;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_contact;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_date;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_datedelete;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_datemodify;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_description;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_gender;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_name;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_patientID;

	    @FXML
	    private TableColumn<PatientData,String> patient_col_status;

	    @FXML
	    private TableView<PatientData> patient_tableview;

	    @FXML
	    private Button payment_btn;

	    @FXML
	    private Button profile_settings_btn;
	    
	    @FXML
	    private Button dashboard_logoutBTN;

	    @FXML
	    private Circle top_profile;

	    @FXML
	    private Label top_username;
	    
	    @FXML
	    private Button adminEdit_ImportPicture;

	    @FXML
	    private TextField adminEdit_Username;

	    @FXML
	    private TextField adminEdit_adminID;

	    @FXML
	    private TextField adminEdit_email;

	    @FXML
	    private TextField adminEdit_fullname;

	    @FXML
	    private Label adminEdit_label_adminID;

	    @FXML
	    private Label adminEdit_label_datecreated;

	    @FXML
	    private Label adminEdit_label_email;

	    @FXML
	    private Label adminEdit_label_fullname;

	    @FXML
	    private Circle adminEdit_profilePicture;

	    @FXML
	    private ComboBox<String> adminEdit_status;
	    
	    @FXML
	    private ComboBox<String> adminEdit_gender;

	    @FXML
	    private Button adminEdit_update;

	    @FXML
	    private Button payment_checkout;

	    @FXML
	    private TableColumn<PatientData,String> payment_col_Gender;

	    @FXML
	    private TableColumn<PatientData,String> payment_col_date;

	    @FXML
	    private TableColumn<PatientData,String> payment_col_diagnosis;

	    @FXML
	    private TableColumn<PatientData,String> payment_col_doctor;

	    @FXML
	    private TableColumn<PatientData,String> payment_col_name;

	    @FXML
	    private TableColumn<PatientData,String> payment_col_patID;

	    @FXML
	    private AnchorPane payment_form;

	    @FXML
	    private Label payment_label_date;

	    @FXML
	    private Label payment_label_doctor;

	    @FXML
	    private Label payment_label_fullname;

	    @FXML
	    private Label payment_label_patID;

	    @FXML
	    private Circle payment_patientpicture;

	    @FXML
	    private TableView<PatientData> payment_tableview;

		
		private final AlertMessage alert=new AlertMessage();
	    
	    @FXML
	    public void switchForm(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	if(event.getSource()==dashboard_btn) {
	    		dashboard_form.setVisible(true);
	    		dashboard_form.setDisable(false);
	    		FadeInDashboard();
				DashoboardDoctorShowData();
				DashboardDoctorGetData();
	    		doctors_form.setVisible(false);
	    		doctors_form.setDisable(true);
	    		Patient_form.setVisible(false);
	    		Patient_form.setDisable(true);
	    		Appointment_form.setVisible(false);
	    		Appointment_form.setDisable(true);
	    		profilesettings_form.setVisible(false);
	    		profilesettings_form.setDisable(true);
	    		payment_form.setVisible(false);
	    		payment_form.setDisable(true);
	    	}
	    	else if(event.getSource()==doctor_btn) {
	    		dashboard_form.setVisible(false);
	    		dashboard_form.setDisable(true);
	    		doctors_form.setVisible(true);
	    		doctors_form.setDisable(false);
			    FadeInDoctor();
	    		//dinamicki prikaz podataka u tabeli
	    		DoctorShowData();
				actionButtons();
	    		Patient_form.setVisible(false);
	    		Patient_form.setDisable(true);
	    		Appointment_form.setVisible(false);
	    		Appointment_form.setDisable(true);
	    		profilesettings_form.setVisible(false);
	    		profilesettings_form.setDisable(true);
	    		payment_form.setVisible(false);
	    		payment_form.setDisable(true);
	    	}else if(event.getSource()==patient_btn) {
	    		dashboard_form.setVisible(false);
	    		dashboard_form.setDisable(true);
	    		doctors_form.setVisible(false);
	    		doctors_form.setDisable(true);
	    		Patient_form.setVisible(true);
	    		Patient_form.setDisable(false);
	    		FadeInPatient();
	    		displayPatientData();
	    		actionButtonsPatient();
	    		Appointment_form.setVisible(false);
	    		Appointment_form.setDisable(true);
	    		profilesettings_form.setVisible(false);
	    		profilesettings_form.setDisable(true);
	    		payment_form.setVisible(false);
	    		payment_form.setDisable(true);
	    	}else if(event.getSource()==appointment_btn) {
	    		dashboard_form.setVisible(false);
	    		dashboard_form.setDisable(true);
	    		doctors_form.setVisible(false);
	    		doctors_form.setDisable(true);
	    		Patient_form.setVisible(false);
	    		Patient_form.setDisable(true);
	    		Appointment_form.setVisible(true);
	    		Appointment_form.setDisable(false);
	    		AppointmentShowData();
	    		actionButtonsAppointments();
	    		FadeInAppointment();
	    		profilesettings_form.setVisible(false);
	    		profilesettings_form.setDisable(true);
	    		payment_form.setVisible(false);
	    		payment_form.setDisable(true);
	    	}else if(event.getSource()==profile_settings_btn) {
	    		dashboard_form.setVisible(false);
	    		dashboard_form.setDisable(true);
	    		doctors_form.setVisible(false);
	    		doctors_form.setDisable(true);
	    		Patient_form.setVisible(false);
	    		Patient_form.setDisable(true);
	    		Appointment_form.setVisible(false);
	    		Appointment_form.setDisable(true);
	    		profilesettings_form.setVisible(true);
	    		profilesettings_form.setDisable(false);
	    		setFieldText();
				SetLabelText();
				displayProfilePictures();
				 FadeInAdminEdit();
				payment_form.setVisible(false);
	    		payment_form.setDisable(true);
	    	}else if(event.getSource()==payment_btn) {
	    		dashboard_form.setVisible(false);
	    		dashboard_form.setDisable(true);
	    		doctors_form.setVisible(false);
	    		doctors_form.setDisable(true);
	    		Patient_form.setVisible(false);
	    		Patient_form.setDisable(true);
	    		Appointment_form.setVisible(false);
	    		Appointment_form.setDisable(true);
	    		profilesettings_form.setVisible(false);
	    		profilesettings_form.setDisable(true);
	    		payment_form.setVisible(true);
	    		payment_form.setDisable(false);
	    		PatientPaymentGetData();
	    		PatientPaymentShowData();
	    		paymentSelect();
	    		FadeInPayment();
	    		
	    	}
	    }
	    
	    private Connection connect = null;
		private Statement statement = null;
		private PreparedStatement preparedStatement = null;
		private ResultSet resultSet = null;

		public void connect() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
		}
	    
	    public void displayAdminIDUsername() throws ClassNotFoundException, SQLException
	    {
	    	String sql="Select * from admin where username='"+ Data.admin_username+"'";
	    	connect();
	    	
	    	try {
	    		preparedStatement = connect.prepareStatement(sql);
	    		resultSet = preparedStatement.executeQuery();
	    		
	    		if(resultSet.next()) {
	    			nav_id.setText(resultSet.getString("admin_id"));
	    			String tempUsername=resultSet.getString("username");
	    			//prvo svolo username-a pretvara u veliko slovo
	    			tempUsername=tempUsername.substring(0,1).toUpperCase()+tempUsername.substring(1);
	    			nav_username.setText(tempUsername);
	    			top_username.setText(tempUsername);
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    
	    //datum i vreme
	    public void runTime() {
	        new Thread() {
	            public void run() {
	                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	                while(true) {
	                try {
	                        Thread.sleep(1000);} // 1000 ms = 1s
	                        catch(Exception e) {
	                            e.printStackTrace();
	                        }
	                        Platform.runLater(() -> {
	                            date_time.setText(format.format(new Date()));
	                        });
	                }
	            }
	            }.start();
	    }
	    
	    public ObservableList<DoctorData> DoctorGetData() throws ClassNotFoundException, SQLException {
	        ObservableList<DoctorData> listData = FXCollections.observableArrayList();
	        String sql = "SELECT * FROM doctor WHERE delete_status IS NULL";
	        
	        connect();
	        
	        try {
	            preparedStatement = connect.prepareStatement(sql);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                DoctorData appdata = new DoctorData(
	                    resultSet.getInt("doctor_id"),
	                    resultSet.getString("full_name"),
	                    resultSet.getString("gender"),
	                    resultSet.getString("email"),
	                    resultSet.getLong("phone_number"),
	                    resultSet.getString("address"),
	                    resultSet.getString("specialized"),
	                    resultSet.getString("status")
	                );

	                listData.add(appdata);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println("Greška pri učitavanju podataka lekara: " + e.getMessage());
	        } 
	        return listData;
	    }

	    public ObservableList<DoctorData> DoctorListData;

	    public void DoctorShowData() throws ClassNotFoundException, SQLException {
	        DoctorListData = DoctorGetData();
	        
	        doctor_col_docID.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
	        doctor_col_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
	        doctor_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
	        doctor_col_contact.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
	        doctor_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
	        doctor_col_spec.setCellValueFactory(new PropertyValueFactory<>("specialized"));
	        doctor_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
	        doctor_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
	        
	        doctor_tableview.setItems(DoctorListData);
	        doctor_tableview.refresh();
	    }

	 // Ažuriranje podataka unutar ćelija tabele doctor
	    public void actionButtons() throws ClassNotFoundException, SQLException {
	        connect(); // Povezivanje sa bazom
	        DoctorListData = DoctorGetData(); // Dobavljanje podataka

	        Callback<TableColumn<DoctorData, String>, TableCell<DoctorData, String>> cellFactory =
	            (TableColumn<DoctorData, String> param) -> new TableCell<>() {

	                @Override
	                protected void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);

	                    if (empty || getTableRow() == null || getTableRow().getItem() == null) {
	                        setGraphic(null);
	                        setText(null);
	                    } else {
	                        // Kreiranje dugmadi
	                        Button editbtn = new Button("Edit");
	                        Button removebtn = new Button("Delete");

	                        // CSS
	                        editbtn.getStyleClass().add("table-button");
	                        removebtn.getStyleClass().add("table-button");

	                        // Dobavljanje podataka reda
	                        DoctorData pData = getTableRow().getItem();

	                        // Akcija za "Edit"
	                        editbtn.setOnAction((ActionEvent event) -> {
	                            if (pData != null) {
	                                System.out.println("Edit clicked for Doctor ID: " + pData.getDoctor_id());

	                                // Ispravka - Pravilno postavljanje podataka u Data.temp_* promenljive
	                                Data.temp_doctorID = pData.getDoctor_id();
	                                Data.temp_doctorname = pData.getFull_name();
	                                Data.temp_doctornumber = pData.getMobileNumber();
	                                Data.temp_doctoremail = pData.getEmail();  // <-- ISPRAVLJENO
	                                Data.temp_doctoraddress = pData.getAddress();
	                                Data.temp_doctorstatus = pData.getStatus();
	                                Data.temp_doctorgender = pData.getGender();
	                                Data.temp_doctorspecialization = pData.getSpecialized();

	                                try {
										DoctorListData = DoctorGetData();
									} catch (ClassNotFoundException | SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}  // Ponovo učitajte podatke
                                    doctor_tableview.setItems(DoctorListData);  // Ažurirajte tabelu sa novim podacima
	                                try {
	                                    Parent root = FXMLLoader.load(getClass().getResource("DoctorEdit.fxml"));
	                                    Stage stage = new Stage();
	                                    stage.setTitle("Hospital Management System | Edit Doctor");
	                                    stage.setScene(new Scene(root));
	                                    stage.show();
	                                    stage.setResizable(false);
	                                } catch (IOException e) {
	                                    e.printStackTrace();
	                                }
	                            }
	                        });

	                        // Akcija za "Delete"
	                        removebtn.setOnAction((ActionEvent event) -> {
	                            if (pData != null) {
	                                try {
	                                    String deleteData = "UPDATE doctor SET delete_status=? WHERE doctor_id=?";
	                                    preparedStatement = connect.prepareStatement(deleteData);

	                                    Date date = new Date();
	                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	                                    if (alert.confirmationMessage("Are you sure you want to delete doctor ID: " + pData.getDoctor_id() + "?")) {
	                                        preparedStatement.setDate(1, sqlDate);
	                                        preparedStatement.setInt(2, pData.getDoctor_id());
	                                        int rowsAffected = preparedStatement.executeUpdate();

	                                        if (rowsAffected > 0) {
	                                            // Osvežavanje podataka
	                                            DoctorListData = DoctorGetData();  // Ponovo učitajte podatke
	                                            doctor_tableview.setItems(DoctorListData);  // Ažurirajte tabelu sa novim podacima
	                                            doctor_tableview.refresh(); // Osvježavanje tabele
	                                            alert.successMessage("You successfully deleted doctor ID: " + pData.getDoctor_id());
	                                        } else {
	                                            alert.errorMessage("Failed to delete doctor ID: " + pData.getDoctor_id());
	                                        }
	                                    }
	                                } catch (SQLException e) {
	                                    alert.errorMessage("Database error: " + e.getMessage());
	                                    e.printStackTrace();
	                                } catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
	                            }
	                        });

	                        // Postavljanje dugmadi u HBox
	                        HBox manageBtn = new HBox(editbtn, removebtn);
	                        manageBtn.setAlignment(Pos.CENTER);
	                        manageBtn.setSpacing(5);

	                        setGraphic(manageBtn);
	                        setText(null);
	                    }
	                }
	            };

	        // Postavljanje cellFactory na odgovarajuću kolonu
	        doctor_col_action.setCellFactory(cellFactory);

	        // Provera da li ima podataka pre nego što se postavi u tabelu
	        if (DoctorListData.isEmpty()) {
	            System.out.println("Tabela je prazna, dugmad se neće prikazati!");
	        }

	        doctor_tableview.setItems(DoctorListData);
	        doctor_tableview.setTableMenuButtonVisible(false);
	        doctor_tableview.refresh(); // Osvježavanje tabele
	    }

	    
	    public ObservableList<PatientData> getPatientRecord() throws ClassNotFoundException, SQLException {
			ObservableList<PatientData> listData = FXCollections.observableArrayList();

			try {
				// Povezivanje sa bazom
				connect();
				if (connect == null) {
					System.out.println("Database connection failed!");
					return listData;
				}

				// Priprema SQL upita
				String selectData = "SELECT * FROM patient WHERE date_delete IS NULL";
				preparedStatement = connect.prepareStatement(selectData);
				resultSet = preparedStatement.executeQuery();

				// Dodavanje podataka u listu
				while (resultSet.next()) {
					PatientData pdata = new PatientData(resultSet.getInt("id"), resultSet.getInt("patient_id"),
							resultSet.getString("full_name"),resultSet.getString("gender"),resultSet.getLong("phone_number"),
							resultSet.getString("description"),
							resultSet.getString("address"), resultSet.getDate("date"), resultSet.getDate("date_modify"),
							resultSet.getDate("date_delete"),resultSet.getString("status"));
					listData.add(pdata);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return listData;
		}

	    private ObservableList<PatientData> patientRecordData;

		public void displayPatientData() throws ClassNotFoundException, SQLException {
			patientRecordData = getPatientRecord();
			System.out.println("Broj učitanih pacijenata: " + patientRecordData.size());

			patient_col_patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
			patient_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
			patient_col_contact.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
			patient_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
			patient_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
			patient_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
			patient_col_datemodify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
			patient_col_datedelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
			patient_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
			
			
			patient_tableview.setItems(patientRecordData);
		}
		
		// Ažuriranje podataka unutar ćelija tabele
	    public void actionButtonsPatient() throws ClassNotFoundException, SQLException {
	        connect(); // Povezivanje sa bazom
	        patientRecordData = getPatientRecord(); // Dobavljanje podataka

	        Callback<TableColumn<PatientData, String>, TableCell<PatientData, String>> cellFactory =
	            (TableColumn<PatientData, String> param) -> new TableCell<>() {

	                @Override
	                protected void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);

	                    if (empty || getTableRow() == null || getTableRow().getItem() == null) {
	                        setGraphic(null);
	                        setText(null);
	                    } else {
	                        // Kreiranje dugmadi
	                        Button editbtn = new Button("Edit");
	                        Button removebtn = new Button("Delete");

	                        // CSS
	                        editbtn.getStyleClass().add("table-button");
	                        removebtn.getStyleClass().add("table-button");

	                        // Dobavljanje podataka reda
	                        PatientData pData = getTableRow().getItem();

	                        // Akcija za "Edit"
	                        editbtn.setOnAction((ActionEvent event) -> {
	                            if (pData != null) {
	                                System.out.println("Edit clicked for Patient ID: " + pData.getPatientID());                            	
	                                
	                                // Ispravka - Pravilno postavljanje podataka u Data.temp_* promenljive
	                                Data.temp_patientID = pData.getPatientID();
	                                Data.temp_name = pData.getFullName();
	                                Data.temp_number = pData.getMobileNumber();
	                                Data.temp_address = pData.getAddress();
	                                Data.temp_status = pData.getStatus();
	                                Data.temp_gender = pData.getGender();
	                                Data.temp_description=pData.getDescription();

	                                try {
	                                	patientRecordData = getPatientRecord();
									} catch (ClassNotFoundException | SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}  // Ponovo učitajte podatke
	                                
	                                patient_tableview.setItems(patientRecordData);  // Ažurirajte tabelu sa novim podacima
	                                try {
	                                    Parent root = FXMLLoader.load(getClass().getResource("PatientEdit.fxml"));
	                                    Stage stage = new Stage();
	                                    stage.setTitle("Hospital Management System | Edit Patient");
	                                    stage.setScene(new Scene(root));
	                                    stage.show();
	                                    stage.setResizable(false);
	                                } catch (IOException e) {
	                                    e.printStackTrace();
	                                }
	                            }
	                        });

	                        // Akcija za "Delete"
	                        removebtn.setOnAction((ActionEvent event) -> {
	                            if (pData != null) {
	                                try {
	                                    String deleteData = "UPDATE patient SET date_delete=? WHERE patient_id=?";
	                                    preparedStatement = connect.prepareStatement(deleteData);

	                                    Date date = new Date();
	                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	                                    if (alert.confirmationMessage("Are you sure you want to delete doctor ID: " + pData.getPatientID() + "?")) {
	                                        preparedStatement.setDate(1, sqlDate);
	                                        preparedStatement.setInt(2, pData.getPatientID());
	                                        int rowsAffected = preparedStatement.executeUpdate();

	                                        if (rowsAffected > 0) {
	                                            // Osvežavanje podataka
	                                        	patientRecordData = getPatientRecord();  // Ponovo učitajte podatke
	                                        	patient_tableview.setItems(patientRecordData);  // Ažurirajte tabelu sa novim podacima
	                                        	patient_tableview.refresh(); // Osvježavanje tabele
	                                            alert.successMessage("You successfully deleted patient ID: " + pData.getPatientID());
	                                        } else {
	                                            alert.errorMessage("Failed to delete patient ID: " + pData.getPatientID());
	                                        }
	                                    }
	                                } catch (SQLException e) {
	                                    alert.errorMessage("Database error: " + e.getMessage());
	                                    e.printStackTrace();
	                                } catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
	                            }
	                        });

	                        // Postavljanje dugmadi u HBox
	                        HBox manageBtn = new HBox(editbtn, removebtn);
	                        manageBtn.setAlignment(Pos.CENTER);
	                        manageBtn.setSpacing(5);

	                        setGraphic(manageBtn);
	                        setText(null);
	                    }
	                }
	            };

	        // Postavljanje cellFactory na odgovarajuću kolonu
	           patient_col_actieon.setCellFactory(cellFactory);

	        // Provera da li ima podataka pre nego što se postavi u tabelu
	        if (patientRecordData.isEmpty()) {
	            System.out.println("Tabela je prazna, dugmad se neće prikazati!");
	        }

	        patient_tableview.setItems(patientRecordData);
	        patient_tableview.setTableMenuButtonVisible(false);
	        patient_tableview.refresh(); // Osvježavanje tabele
	    }
	    
	    
	    public ObservableList<AppointmentData> appointmentGetData() throws ClassNotFoundException, SQLException {
	        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();
	        String sql = "SELECT * FROM appointment WHERE date_delete IS NULL";
	        
	        connect();
	        
	        try {
	            preparedStatement = connect.prepareStatement(sql);
	            resultSet = preparedStatement.executeQuery();

//	           Integer appointmentID, String name, String gender, String description, String diagnosis , String treatment,Long mobileNumber,
//				Date date, Date dateModify, Date dateDelete, String status
	            
	            while (resultSet.next()) {
	                AppointmentData appdata = new AppointmentData(
	                    resultSet.getInt("appointment_id"),
	                    resultSet.getString("name"),
	                    resultSet.getString("gender"),
	                    resultSet.getString("description"),
	                    resultSet.getString("diagnosis"),
	                    resultSet.getString("treatment"),
	                    resultSet.getLong("mobile_number"),
	                    resultSet.getDate("date"),
	                    resultSet.getDate("date_modify"),
	                    resultSet.getDate("date_delete"),
	                    resultSet.getString("status"),
	                    resultSet.getString("doctor"),
	                    resultSet.getString("specialized"));

	                listData.add(appdata);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println("Greška pri učitavanju podataka lekara: " + e.getMessage());
	        } 
	        return listData;
	    }

	    public ObservableList<AppointmentData> AppointmentListData;

	    public void AppointmentShowData() throws ClassNotFoundException, SQLException {
	    	AppointmentListData = appointmentGetData();
	        
	    	appointment_col_id.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
	    	appointment_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
	    	appointment_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
	    	appointment_col_contact.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
	    	appointment_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
	    	appointment_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	    	appointment_col_datemodify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
	    	appointment_col_datedelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
	    	appointment_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
	        
	        appointment_tableview.setItems(AppointmentListData);
	        appointment_tableview.refresh();
	    }
	    
	 // Ažuriranje podataka unutar ćelija tabele
	    public void actionButtonsAppointments() throws ClassNotFoundException, SQLException {
	        connect(); // Povezivanje sa bazom
	        AppointmentListData = appointmentGetData(); // Dobavljanje podataka

	        Callback<TableColumn<AppointmentData, String>, TableCell<AppointmentData, String>> cellFactory =
	            (TableColumn<AppointmentData, String> param) -> new TableCell<>() {

	                @Override
	                protected void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);

	                    if (empty || getTableRow() == null || getTableRow().getItem() == null) {
	                        setGraphic(null);
	                        setText(null);
	                    } else {
	                        // Kreiranje dugmadi
	                        Button editbtn = new Button("Edit");
	                        Button removebtn = new Button("Delete");

	                        // CSS
	                        editbtn.getStyleClass().add("table-button");
	                        removebtn.getStyleClass().add("table-button");

	                        // Dobavljanje podataka reda
	                        AppointmentData pData = getTableRow().getItem();

	                        // Akcija za "Edit"
	                        editbtn.setOnAction((ActionEvent event) -> {
	                            if (pData != null) {
	                            	
	                                // Postavljanje temp vrednosti
	                                Data.temp_appID = pData.getAppointmentID();
	                                Data.temp_appName = pData.getName();
	                                Data.temp_appContact = pData.getMobileNumber();
	                                Data.temp_appStatus = pData.getStatus();
	                                Data.temp_appGender = pData.getGender();
	                                Data.temp_appDescription = pData.getDescription();
	                                Data.temp_appTreatment = pData.getTreatment();
	                                Data.temp_appDiagnosis = pData.getDiagnosis();
	                                Data.temp_appDoctorID=pData.getDoctorID();
	                                Data.temp_appDoctorSpecialization=pData.getSpecialized();


	                                try {
	                                	AppointmentListData = appointmentGetData();
									} catch (ClassNotFoundException | SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}  // Ponovo učitajte podatke
	                                
	                                appointment_tableview.setItems(AppointmentListData);  // Ažurirajte tabelu sa novim podacima
	                                try {
	                                    Parent root = FXMLLoader.load(getClass().getResource("AppointmentEdit.fxml"));
	                                    Stage stage = new Stage();
	                                    stage.setTitle("Hospital Management System | Edit Appointment");
	                                    stage.setScene(new Scene(root));
	                                    stage.show();
	                                    stage.setResizable(false);
	                                } catch (IOException e) {
	                                    e.printStackTrace();
	                                }
	                            }
	                        });

	                        // Akcija za "Delete"
	                        removebtn.setOnAction((ActionEvent event) -> {
	                            if (pData != null) {
	                                try {
	                                    String deleteData = "UPDATE appointment SET date_delete=? WHERE appointment_id=?";
	                                    preparedStatement = connect.prepareStatement(deleteData);

	                                    Date date = new Date();
	                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	                                    if (alert.confirmationMessage("Are you sure you want to delete Appointment ID: " + pData.getAppointmentID() + "?")) {
	                                        preparedStatement.setDate(1, sqlDate);
	                                        preparedStatement.setInt(2, pData.getAppointmentID());
	                                        int rowsAffected = preparedStatement.executeUpdate();

	                                        if (rowsAffected > 0) {
	                                            // Osvežavanje podataka
	                                        	appointment_tableview.setItems(AppointmentListData);
	                                	        appointment_tableview.setTableMenuButtonVisible(false);
	                                	        appointment_tableview.refresh(); // Osvježavanje tabele
	                                            alert.successMessage("You successfully deleted appointment ID: " + pData.getAppointmentID());
	                                        } else {
	                                            alert.errorMessage("Failed to delete appointment ID: " + pData.getAppointmentID());
	                                        }
	                                    }
	                                } catch (SQLException e) {
	                                    alert.errorMessage("Database error: " + e.getMessage());
	                                    e.printStackTrace();
	                                }
	                            }
	                        });

	                        // Postavljanje dugmadi u HBox
	                        HBox manageBtn = new HBox(editbtn, removebtn);
	                        manageBtn.setAlignment(Pos.CENTER);
	                        manageBtn.setSpacing(5);

	                        setGraphic(manageBtn);
	                        setText(null);
	                    }
	                }
	            };

	        // Postavljanje cellFactory na odgovarajuću kolonu
	            appointment_col_action.setCellFactory(cellFactory);

	        // Provera da li ima podataka pre nego što se postavi u tabelu
	        if (AppointmentListData.isEmpty()) {
	            System.out.println("Tabela je prazna, dugmad se neće prikazati!");
	        }

	        appointment_tableview.setItems(AppointmentListData);
	        appointment_tableview.setTableMenuButtonVisible(false);
	        appointment_tableview.refresh(); // Osvježavanje tabele
	    }
	    
	    public void setFieldText() throws ClassNotFoundException, SQLException {
	        String sql = "SELECT * FROM admin WHERE admin_id = ?";
	        connect();
	        
	        try {
	            preparedStatement = connect.prepareStatement(sql);
	            preparedStatement.setString(1, nav_id.getText());
	            resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                adminEdit_adminID.setText(resultSet.getString("admin_id"));
	                adminEdit_Username.setText(resultSet.getString("username"));
	                adminEdit_fullname.setText(resultSet.getString("full_name"));
	                adminEdit_email.setText(resultSet.getString("email"));

	                // Provera i inicijalizacija ComboBox-a pre selektovanja
	                if (adminEdit_gender != null) {
	                    if (adminEdit_gender.getItems().isEmpty()) {
	                        adminEdit_gender.setItems(FXCollections.observableArrayList("Male", "Female" , "Other"));
	                    }
	                    adminEdit_gender.getSelectionModel().select(resultSet.getString("gender"));
	                }

	                if (adminEdit_status != null) {
	                    if (adminEdit_status.getItems().isEmpty()) {
	                        adminEdit_status.setItems(FXCollections.observableArrayList("Active", "Inactive"));
	                    }
	                    adminEdit_status.getSelectionModel().select(resultSet.getString("status"));
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public void AdminGenderList() {
	    	List<String> listS=new ArrayList<>();
	    	for(String data:Data.gender) {
	    		listS.add(data);
	    	}
	    	
	    	ObservableList listData=FXCollections.observableArrayList(listS);
	    	adminEdit_gender.setItems(listData);
	    }
	    
	    public void AdminStatusList() {
	    	List<String> listS=new ArrayList<>();
	    	for(String data:Data.adminStatus) {
	    		listS.add(data);
	    	}
	    	
	    	ObservableList listData=FXCollections.observableArrayList(listS);
	    	adminEdit_status.setItems(listData);
	    }
	    
	    public void SetLabelText() throws ClassNotFoundException, SQLException {
	    	adminEdit_label_adminID.setText(adminEdit_adminID.getText());
	    	adminEdit_label_email.setText(adminEdit_email.getText());
	    	adminEdit_label_fullname.setText(adminEdit_fullname.getText());
	    	String sql="Select date from admin where admin_id=?";
	    	connect();
	    	
	    	try {
	    		preparedStatement = connect.prepareStatement(sql);
	    		preparedStatement.setString(1,nav_id.getText());
	    		resultSet = preparedStatement.executeQuery();
	    		if(resultSet.next()) {
	    			adminEdit_label_datecreated.setText(resultSet.getString("date"));
	    		}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    @FXML
	    public void profileChangeProfile() {
	        FileChooser open = new FileChooser();
	        open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*.png", "*.jpg", "*.jpeg"));

	        // Provera da li dugme postoji
	        if (adminEdit_ImportPicture == null) {
	            System.out.println("ERROR: settings_ImportPicture je null! Proverite FXML fajl i @FXML anotaciju.");
	            return;
	        }

	        // Provera da li scena postoji
	        if (adminEdit_ImportPicture.getScene() == null) {
	            System.out.println("ERROR: settings_ImportPicture.getScene() je null! GUI možda još nije učitan.");
	            return;
	        }

	        File file = open.showOpenDialog(adminEdit_ImportPicture.getScene().getWindow());

	        if (file == null) {
	            System.out.println("Nije izabrana nijedna slika.");
	            return;
	        }

	        System.out.println("Izabrana slika: " + file.getAbsolutePath());
	        Data.path = file.getAbsolutePath();

	        Image image = new Image(file.toURI().toString(), 155, 130, false, true);

	        if (image.isError()) {
	            System.out.println("ERROR: Problem pri učitavanju slike.");
	            return;
	        }

	        // Provera da li settings_picture postoji
	        if (adminEdit_profilePicture == null) {
	            System.out.println("ERROR: settings_picture je null! Proverite fx:id u FXML fajlu.");
	            return;
	        }

	        adminEdit_profilePicture.setFill(new ImagePattern(image));
	        System.out.println("Slika je uspešno postavljena.");
	    }
	    
	    private Image image;
	    
	  //prikazivanje slika
	    public void displayProfilePictures() throws ClassNotFoundException, SQLException {
	    	
	    	connect();
	    	String sql="Select * from admin where admin_id=?";
			
			String path1="";
			String path2="";
				try {
					preparedStatement = connect.prepareStatement(sql);
					preparedStatement.setString(1,nav_id.getText());
					resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) {
						path1="File:"+resultSet.getString("image");
						path2="File:"+resultSet.getString("image");
						
						if(resultSet.getString("image")!=null) {
							image=new Image(path1,798,21,false,true);
							top_profile.setFill(new ImagePattern(image));
							
							image=new Image(path2,155,130,false,true);
							adminEdit_profilePicture.setFill(new ImagePattern(image));
						}
					}
				}catch(Exception e) {
					
				}
	    	
	    }
	    
	    public void updateDataAdmin() throws SQLException, ClassNotFoundException {
	    	if(adminEdit_adminID.getText().isEmpty() ||
	    	adminEdit_Username.getText().isEmpty() ||
	    	adminEdit_fullname.getText().isEmpty() ||
	    	adminEdit_gender.getSelectionModel().isEmpty() ||
	    	adminEdit_email.getText().isEmpty() ||
			adminEdit_status.getSelectionModel().isEmpty()) {
	    		alert.errorMessage("Please fill all blank fields!");
	    	}else {
	    		
	    		try {
	    		connect();
	        	String sql="Select * from admin where admin_id=?";
	    		preparedStatement = connect.prepareStatement(sql);
	    		preparedStatement.setString(1,nav_id.getText());
	    		resultSet = preparedStatement.executeQuery();
	    		if(resultSet.next()) {
	    			String updateData = "UPDATE admin SET admin_id = ?, username = ? ,full_name = ?, email = ?, gender = ?, image = ? , status = ? WHERE admin_id = ?";
	    			preparedStatement = connect.prepareStatement(updateData);
	    			preparedStatement.setString(1, adminEdit_adminID.getText());
	    			preparedStatement.setString(2, adminEdit_Username.getText());
	    			preparedStatement.setString(5, adminEdit_gender.getSelectionModel().getSelectedItem());
	    			preparedStatement.setString(3, adminEdit_fullname.getText());
	    			preparedStatement.setString(4, adminEdit_email.getText());
	    			
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
	                java.nio.file.Path targetDir = Paths.get("C:\\Users\\Win10\\Desktop\\Java\\JavaFx\\HospitalManagment\\src\\application\\ProfilneSlikeStorage\\AdminForm\\");
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
	                    java.nio.file.Path copy = Paths.get("C:\\Users\\Win10\\Desktop\\Java\\JavaFx\\HospitalManagment\\src\\application\\ProfilneSlikeStorage\\AdminForm\\" + adminEdit_adminID.getText() + ".jpg");

	                    try {
	                        Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                        alert.errorMessage("Error while copying the image: " + e.getMessage());
	                        return;
	                    }
	                    path = copy.toAbsolutePath().toString();
	                }
	    			preparedStatement.setString(6,path);
	    			preparedStatement.setString(7, adminEdit_status.getSelectionModel().getSelectedItem());
	    			preparedStatement.setString(8, nav_id.getText());

	    			int rowsUpdated = preparedStatement.executeUpdate();
	    			if (rowsUpdated > 0) {
	    			    alert.successMessage("Successfully updated!");
	    			} else {
	    			    alert.errorMessage("Update failed!");
	    			}
	    			
	    		}
	    		}catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	    public ObservableList<PatientData> PatientPaymentGetData() throws ClassNotFoundException, SQLException {
	        ObservableList<PatientData> listData = FXCollections.observableArrayList();
	        String sql = "SELECT * FROM patient WHERE date_delete IS NULL and status_payment IS NULL";
	        
	        connect();
	        
	        try {
	            preparedStatement = connect.prepareStatement(sql);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                PatientData appdata = new PatientData(
	                    resultSet.getInt("patient_id"),
	                    resultSet.getString("full_name"),
	                    resultSet.getString("gender"),
	                    resultSet.getString("diagnosis"),
	                    resultSet.getString("doctor"),
	                    resultSet.getDate("date")
	                );

	                listData.add(appdata);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println("Greška pri učitavanju podataka pacijenta: " + e.getMessage());
	        } 
	        return listData;
	    }

	    public ObservableList<PatientData> PatientListData;

	    public void PatientPaymentShowData() throws ClassNotFoundException, SQLException {
	    	PatientListData = PatientPaymentGetData();
	        
	    	payment_col_patID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
	    	payment_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
	        payment_col_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
	        payment_col_diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
	        payment_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
	        payment_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	        
	        payment_tableview.setItems(PatientListData);
	        payment_tableview.refresh();
	    }
	    
	    public void paymentSelect() throws ClassNotFoundException, SQLException {
	        // Dobijanje selektovanog reda iz TableView-a
	        PatientData appData = payment_tableview.getSelectionModel().getSelectedItem();
	        int num = payment_tableview.getSelectionModel().getSelectedIndex();

	        // Provera da li je nešto selektovano
	        if (appData == null || num < 0) {
	            return;
	        }

	        // Postavljanje podataka u label-e (izbegavanje potencijalnog null-a)
	        payment_label_patID.setText(appData.getPatientID() != null ? String.valueOf(appData.getPatientID()) : "N/A");
	        payment_label_fullname.setText(appData.getFullName() != null ? appData.getFullName() : "N/A");
	        payment_label_doctor.setText(appData.getDoctor() != null ? appData.getDoctor() : "N/A");
	        payment_label_date.setText(appData.getDate() != null ? String.valueOf(appData.getDate()) : "N/A");
	        
        	Data.temp_patientID=appData.getPatientID();
        	Data.temp_image=appData.getImage();
        	
	        String sql="Select image from patient where patient_id=?";
	        connect();
	        
	        try {
	        	preparedStatement = connect.prepareStatement(sql);
	    		preparedStatement.setString(1,payment_label_patID.getText());
	    		resultSet = preparedStatement.executeQuery();
	    		if (resultSet.next()) {
	                String imagePath = resultSet.getString("image");
	                if (imagePath != null && !imagePath.isEmpty()) {
	                    Image image = new Image("file:" + imagePath);
	                    payment_patientpicture.setFill(new ImagePattern(image));
	                }
	            }
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }

	    public void checkoutBtn() throws ClassNotFoundException, SQLException, IOException {

	    	Parent root=FXMLLoader.load(getClass().getResource("CheckOutPatient.fxml"));
        	Stage stage=new Stage();
        	stage.setTitle("Hospital Managment System | Check out Patient");
        	stage.setScene(new Scene(root));
        	stage.show();
        	stage.setResizable(false);
	    }
	    
	  //chart za broj pacijenata
	    public void dashboardNDD() throws ClassNotFoundException, SQLException {
	        dashboard_chart_PD.getData().clear();

	        String sql = "SELECT COUNT(id) AS count_value, date FROM doctor WHERE status = 'Confirm' GROUP BY date ORDER BY date ASC LIMIT 8;";

	        connect();

	        try {
	            XYChart.Series chart = new XYChart.Series<>();
	            preparedStatement = connect.prepareStatement(sql);
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
	            if (preparedStatement != null) preparedStatement.close();
	            if (resultSet != null) resultSet.close();
	            if (connect != null) connect.close();
	        }
	    }
	    
	  //chart za broj termine
	    public void dashboardNPD() throws ClassNotFoundException, SQLException {
	    	dashboard_chart_PD.getData().clear();

	        String sql = "SELECT COUNT(id) AS count_value, date FROM patient WHERE status is not NULL GROUP BY date ORDER BY date ASC LIMIT 8";

	        connect();

	        try {
	            XYChart.Series chart = new XYChart.Series<>();
	            preparedStatement = connect.prepareStatement(sql);
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
	            if (preparedStatement != null) preparedStatement.close();
	            if (resultSet != null) resultSet.close();
	            if (connect != null) connect.close();
	        }
	    }

	  //prebrojava broj neaktivnih pacijenata
	    public void dashboardAD() {
	    	Data.doctor_username=nav_username.getText();
	    	String sql="Select count(id) from doctor where status='Confirm'";
	    	try {
	    		connect();
	    		preparedStatement = connect.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				int getIP=0;
				if(resultSet.next()) {
					getIP=resultSet.getInt("count(id)");
				}
				dashboard_AD_count.setText(String.valueOf(getIP));
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	  //prebrojava ukupan broj pacijenata
	    public void dashboardTP() {
	    	Data.doctor_username=nav_username.getText();
	    	String sql="Select count(id) from patient";
	    	try {
	    		connect();
	    		preparedStatement = connect.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				int getIP=0;
				if(resultSet.next()) {
					getIP=resultSet.getInt("count(id)");
				}
				dashboard_TP_count.setText(String.valueOf(getIP));
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void dashboardAP() {
	    	Data.doctor_username=nav_username.getText();
	    	String sql="Select count(id) from patient where status='Active'";
	    	try {
	    		connect();
	    		preparedStatement = connect.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				int getIP=0;
				if(resultSet.next()) {
					getIP=resultSet.getInt("count(id)");
				}
				dashboard_AP_count.setText(String.valueOf(getIP));
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void dashboardTA() {
	    	Data.doctor_username=nav_username.getText();
	    	String sql="Select count(id) from appointment";
	    	try {
	    		connect();
	    		preparedStatement = connect.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				int getIP=0;
				if(resultSet.next()) {
					getIP=resultSet.getInt("count(id)");
				}
				dashboard_TA_count.setText(String.valueOf(getIP));
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public ObservableList<DoctorData> DashboardDoctorGetData() throws ClassNotFoundException, SQLException {
	        ObservableList<DoctorData> listData = FXCollections.observableArrayList();
	        String sql = "SELECT * FROM doctor WHERE delete_status IS NULL";
	        
	        connect();
	        
	        try {
	            preparedStatement = connect.prepareStatement(sql);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                DoctorData appdata = new DoctorData(
	                    resultSet.getInt("doctor_id"),
	                    resultSet.getString("full_name"),
	                    resultSet.getString("specialized"),
	                    resultSet.getString("status")
	                );

	                listData.add(appdata);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println("Greška pri učitavanju podataka lekara: " + e.getMessage());
	        } 
	        return listData;
	    }

	    public ObservableList<DoctorData> DashboardDoctorListData;

	    public void DashoboardDoctorShowData() throws ClassNotFoundException, SQLException {
	    	DashboardDoctorListData = DashboardDoctorGetData();
	        
	        dashboard_col_docID.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
	        dashboard_col_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
	        dashboard_col_spec.setCellValueFactory(new PropertyValueFactory<>("specialized"));
	        dashboard_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
	        
	        dashboard_tableview.setItems(DashboardDoctorListData);
	        dashboard_tableview.refresh();
	    }
	    
	    public void logoutBtn() {
	        try {
	            if (alert.confirmationMessage("Are you sure you want to logout?")) {

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
	    
	    public void FadeInDashboard() {

	    	dashboard_AD.setOpacity(0);
			dashboard_TP.setOpacity(0);
			dashboard_AP.setOpacity(0);
			dashboard_TA.setOpacity(0);
	        // Postavljanje opacity na 0 na početku
	       upper_pane.setOpacity(0);
	        bottom_pane.setOpacity(0);
	        bottom_pane1.setOpacity(0);
	        bottom_pane2.setOpacity(0);
	        bottom_pane3.setOpacity(0);
	    	
	    	// Fade animacija za mainPane1
            FadeTransition fadeMain1 = new FadeTransition(Duration.seconds(1.7), upper_pane);
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
            SequentialTransition sequentialTransition = new SequentialTransition(
                    fadeMain1,delayBeforeupper1,fademainupper1,delayBeforeupper2,fademainupper2,
                    delayBeforeupper3,fademainupper3,delayBeforeupper4,fademainupper4,
                    fadeMain2, delayBeforeInner1, fadeInner1,
                    delayBeforeInner2, fadeInner2, delayBeforeInner3, fadeInner3
            );

            // Pokretanje animacije
            sequentialTransition.play();
        }
	    
	    public void FadeInButtons() {

	        // Postavljanje opacity na 0 na početku
	    	dashboard_btn.setOpacity(0);
	    	doctor_btn.setOpacity(0);
	    	patient_btn.setOpacity(0);
	    	appointment_btn.setOpacity(0);
	    	payment_btn.setOpacity(0);
	    	profile_settings_btn.setOpacity(0);
	    	
            FadeTransition fadeMain1 = new FadeTransition(Duration.seconds(1.1), dashboard_btn);
            fadeMain1.setFromValue(0);
            fadeMain1.setToValue(1);

            PauseTransition delayBeforeInner = new PauseTransition(Duration.seconds(1));

            FadeTransition fadeMain2 = new FadeTransition(Duration.seconds(0.5), doctor_btn);
            fadeMain2.setFromValue(0);
            fadeMain2.setToValue(1);

            PauseTransition delayBeforeInner1 = new PauseTransition(Duration.seconds(0.4));

            FadeTransition fadeInner1 = new FadeTransition(Duration.seconds(0.3), patient_btn);
            fadeInner1.setFromValue(0);
            fadeInner1.setToValue(1);

            PauseTransition delayBeforeInner2 = new PauseTransition(Duration.seconds(0.6));

            FadeTransition fadeInner2 = new FadeTransition(Duration.seconds(0.3), appointment_btn);
            fadeInner2.setFromValue(0);
            fadeInner2.setToValue(1);

            PauseTransition delayBeforeInner3 = new PauseTransition(Duration.seconds(0.8));

            FadeTransition fadeInner3 = new FadeTransition(Duration.seconds(0.3), payment_btn);
            fadeInner3.setFromValue(0);
            fadeInner3.setToValue(1);
            
            PauseTransition delayBeforeInner4 = new PauseTransition(Duration.seconds(1));

            FadeTransition fadeInner4 = new FadeTransition(Duration.seconds(0.3), profile_settings_btn);
            fadeInner4.setFromValue(0);
            fadeInner4.setToValue(1);

            SequentialTransition sequentialTransition = new SequentialTransition(
                    fadeMain1, delayBeforeInner , fadeMain2, delayBeforeInner1, fadeInner1,
                    delayBeforeInner2, fadeInner2, delayBeforeInner3, fadeInner3 , delayBeforeInner4 , fadeInner4
            );

            sequentialTransition.play();
	    }
	    
	    public void FadeInDoctor() {

	        // Postavljanje opacity na 0 na početku
	       doctor_table_pane.setOpacity(0);
	       doctor_table_line.setOpacity(0);
	       doctor_table_label.setOpacity(0);
	       doctor_tableview.setOpacity(0);
	    	
	    	// Fade animacija za mainPane1
            FadeTransition fadeMain1 = new FadeTransition(Duration.seconds(1.7), doctor_table_pane);
            fadeMain1.setFromValue(0);
            fadeMain1.setToValue(1);


            // Fade animacija za mainPane2
            FadeTransition fadeMain2 = new FadeTransition(Duration.seconds(0.7), doctor_table_line);
            fadeMain2.setFromValue(0);
            fadeMain2.setToValue(1);

            // Kašnjenje pre innerPane1
            PauseTransition delayBeforeInner1 = new PauseTransition(Duration.seconds(0.3));

            // Fade animacija za innerPane1
            FadeTransition fadeInner1 = new FadeTransition(Duration.seconds(0.5), doctor_table_label);
            fadeInner1.setFromValue(0);
            fadeInner1.setToValue(1);

            // Kašnjenje pre innerPane2
            PauseTransition delayBeforeInner2 = new PauseTransition(Duration.seconds(0.5));

            // Fade animacija za innerPane2
            FadeTransition fadeInner2 = new FadeTransition(Duration.seconds(0.5), doctor_tableview);
            fadeInner2.setFromValue(0);
            fadeInner2.setToValue(1);

            // Redosled animacija sa kašnjenjima
            SequentialTransition sequentialTransition = new SequentialTransition(
                    fadeMain1, fadeMain2, delayBeforeInner1, fadeInner1,
                    delayBeforeInner2, fadeInner2
            );

            // Pokretanje animacije
            sequentialTransition.play();
        }
	    
	    public void FadeInPatient() {

	        // Postavljanje opacity na 0 na početku
	       patient_table_pane.setOpacity(0);
	       patient_table_line.setOpacity(0);
	       patient_table_label.setOpacity(0);
	       patient_tableview.setOpacity(0);
	    	
	    	// Fade animacija za mainPane1
            FadeTransition fadeMain1 = new FadeTransition(Duration.seconds(1.7), patient_table_pane);
            fadeMain1.setFromValue(0);
            fadeMain1.setToValue(1);


            // Fade animacija za mainPane2
            FadeTransition fadeMain2 = new FadeTransition(Duration.seconds(0.7), patient_table_line);
            fadeMain2.setFromValue(0);
            fadeMain2.setToValue(1);

            // Kašnjenje pre innerPane1
            PauseTransition delayBeforeInner1 = new PauseTransition(Duration.seconds(0.3));

            // Fade animacija za innerPane1
            FadeTransition fadeInner1 = new FadeTransition(Duration.seconds(0.5), patient_table_label);
            fadeInner1.setFromValue(0);
            fadeInner1.setToValue(1);

            // Kašnjenje pre innerPane2
            PauseTransition delayBeforeInner2 = new PauseTransition(Duration.seconds(0.5));

            // Fade animacija za innerPane2
            FadeTransition fadeInner2 = new FadeTransition(Duration.seconds(0.5), patient_tableview);
            fadeInner2.setFromValue(0);
            fadeInner2.setToValue(1);

            // Redosled animacija sa kašnjenjima
            SequentialTransition sequentialTransition = new SequentialTransition(
                    fadeMain1, fadeMain2, delayBeforeInner1, fadeInner1,
                    delayBeforeInner2, fadeInner2
            );

            // Pokretanje animacije
            sequentialTransition.play();
	    }
	    
	    public void FadeInAppointment() {

	        // Postavljanje opacity na 0 na početku
	       appointment_table_pane.setOpacity(0);
	       appointment_table_line.setOpacity(0);
	       appointment_table_label.setOpacity(0);
	       appointment_tableview.setOpacity(0);
	    	
	    	// Fade animacija za mainPane1
            FadeTransition fadeMain1 = new FadeTransition(Duration.seconds(1.7), appointment_table_pane);
            fadeMain1.setFromValue(0);
            fadeMain1.setToValue(1);


            // Fade animacija za mainPane2
            FadeTransition fadeMain2 = new FadeTransition(Duration.seconds(0.7), appointment_table_line);
            fadeMain2.setFromValue(0);
            fadeMain2.setToValue(1);

            // Kašnjenje pre innerPane1
            PauseTransition delayBeforeInner1 = new PauseTransition(Duration.seconds(0.3));

            // Fade animacija za innerPane1
            FadeTransition fadeInner1 = new FadeTransition(Duration.seconds(0.5), appointment_table_label);
            fadeInner1.setFromValue(0);
            fadeInner1.setToValue(1);

            // Kašnjenje pre innerPane2
            PauseTransition delayBeforeInner2 = new PauseTransition(Duration.seconds(0.5));

            // Fade animacija za innerPane2
            FadeTransition fadeInner2 = new FadeTransition(Duration.seconds(0.5), appointment_tableview);
            fadeInner2.setFromValue(0);
            fadeInner2.setToValue(1);

            // Redosled animacija sa kašnjenjima
            SequentialTransition sequentialTransition = new SequentialTransition(
                    fadeMain1, fadeMain2, delayBeforeInner1, fadeInner1,
                    delayBeforeInner2, fadeInner2
            );

            // Pokretanje animacije
            sequentialTransition.play();
	    }
	    
	    public void FadeInPayment() {
	    	// Initial opacity settings
	    	payment_table_pane.setOpacity(0);
	    	payment_table_line.setOpacity(0);
	    	payment_table_label.setOpacity(0);
	    	payment_tableview.setOpacity(0);
	    	payment_profile_pane.setOpacity(0);
	    	payment_patientpicture.setOpacity(0);
	    	payment_profile_ID.setOpacity(0);
	    	payment_label_patID.setOpacity(0);
	    	payment_profile_name.setOpacity(0);
	    	payment_label_fullname.setOpacity(0);
	    	payment_profile_doctor.setOpacity(0);
	    	payment_label_doctor.setOpacity(0);
	    	payment_profile_date.setOpacity(0);
	    	payment_label_date.setOpacity(0);
	    	payment_checkout.setOpacity(0);

	    	// Define transitions for each UI element
	    	FadeTransition tablepane = new FadeTransition(Duration.seconds(1), payment_table_pane);
	    	tablepane.setFromValue(0);
	    	tablepane.setToValue(1);

	    	FadeTransition tableline = new FadeTransition(Duration.seconds(0.7), payment_table_line);
	    	tableline.setFromValue(0);
	    	tableline.setToValue(1);

	    	PauseTransition delay_for_table = new PauseTransition(Duration.seconds(0.3));

	    	FadeTransition profilepane = new FadeTransition(Duration.seconds(1), payment_profile_pane);
	    	profilepane.setFromValue(0);
	    	profilepane.setToValue(1);

	    	FadeTransition profilepicture = new FadeTransition(Duration.seconds(0.7), payment_patientpicture);
	    	profilepicture.setFromValue(0);
	    	profilepicture.setToValue(1);

	    	PauseTransition delay_for_profile = new PauseTransition(Duration.seconds(0.3));

	    	// Fade animation for table label
	    	FadeTransition tablelabel = new FadeTransition(Duration.seconds(0.5), payment_table_label);
	    	tablelabel.setFromValue(0);
	    	tablelabel.setToValue(1);

	    	// Delay before innerPane2
	    	PauseTransition delay_for_table2 = new PauseTransition(Duration.seconds(0.5));

	    	// Fade animation for tableview
	    	FadeTransition tabletableview = new FadeTransition(Duration.seconds(0.5), payment_tableview);
	    	tabletableview.setFromValue(0);
	    	tabletableview.setToValue(1);

	    	PauseTransition delay_for_profile_label = new PauseTransition(Duration.seconds(0.3));

	    	// Fade transitions for profile labels
	    	FadeTransition profilelabelID = new FadeTransition(Duration.seconds(0.3), payment_profile_ID);
	    	profilelabelID.setFromValue(0);
	    	profilelabelID.setToValue(1);

	    	FadeTransition profilelabelID2 = new FadeTransition(Duration.seconds(0.3), payment_label_patID);
	    	profilelabelID2.setFromValue(0);
	    	profilelabelID2.setToValue(1);

	    	PauseTransition delay_for_profile_label2 = new PauseTransition(Duration.seconds(0.3));

	    	FadeTransition profilelabelName = new FadeTransition(Duration.seconds(0.3), payment_profile_name);
	    	profilelabelName.setFromValue(0);
	    	profilelabelName.setToValue(1);

	    	FadeTransition profilelabelName2 = new FadeTransition(Duration.seconds(0.3), payment_label_fullname);
	    	profilelabelName2.setFromValue(0);
	    	profilelabelName2.setToValue(1);

	    	// Fade transitions for doctor and date labels
	    	FadeTransition profilelabelDoctor = new FadeTransition(Duration.seconds(0.3), payment_profile_doctor);
	    	profilelabelDoctor.setFromValue(0);
	    	profilelabelDoctor.setToValue(1);

	    	FadeTransition profilelabelDoctor2 = new FadeTransition(Duration.seconds(0.3), payment_label_doctor);
	    	profilelabelDoctor2.setFromValue(0);
	    	profilelabelDoctor2.setToValue(1);

	    	PauseTransition delay_for_profile_label3 = new PauseTransition(Duration.seconds(0.3));

	    	FadeTransition profilelabelDate = new FadeTransition(Duration.seconds(0.3), payment_profile_date);
	    	profilelabelDate.setFromValue(0);
	    	profilelabelDate.setToValue(1);

	    	FadeTransition profilelabelDate2 = new FadeTransition(Duration.seconds(0.3), payment_label_date);
	    	profilelabelDate2.setFromValue(0);
	    	profilelabelDate2.setToValue(1);
	    	
	    	PauseTransition delay_for_profile_label4 = new PauseTransition(Duration.seconds(0.3));

	    	FadeTransition profilelabelbutton = new FadeTransition(Duration.seconds(0.5), payment_checkout);
	    	profilelabelbutton.setFromValue(0);
	    	profilelabelbutton.setToValue(1);

	    	// Now update the SequentialTransition to include the doctor and date transitions
	    	SequentialTransition sequentialTransition = new SequentialTransition(
	    	    tablepane, 
	    	    tableline, 
	    	    delay_for_table, 
	    	    profilepane, 
	    	    profilepicture, 
	    	    delay_for_profile, 
	    	    tablelabel, 
	    	    delay_for_table2, 
	    	    tabletableview, 
	    	    delay_for_profile_label, 
	    	    profilelabelID, 
	    	    profilelabelID2, 
	    	    delay_for_profile_label2, 
	    	    profilelabelName, 
	    	    profilelabelName2,
	    	    delay_for_profile_label3, 
	    	    profilelabelDoctor, 
	    	    profilelabelDoctor2, 
	    	    profilelabelDate, 
	    	    profilelabelDate2,
	    	    delay_for_profile_label4,
	    	    profilelabelbutton
	    	);

	    	// Start the animation sequence
	    	sequentialTransition.play();
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
	    
	    public void FadeInAdminEdit() {
	    	    // Set initial opacity to 0 for all elements
	    	    settings_profile_pane.setOpacity(0); // Levi pane
	    	    edit_pane.setOpacity(0); // Desni pane
	    	    adminEdit_profilePicture.setOpacity(0); // Circle
	    	    edit_line.setOpacity(0); // Line
	    	    edit_label.setOpacity(0); // Label na desnom
	    	    adminEdit_ImportPicture.setOpacity(0); // Import dugme na levom
	    	    edit_picture1.setOpacity(0); // Slika pored label na levom
	    	    settings_profile_ID.setOpacity(0); // Ostali elementi...
	    	    settings_profile_date.setOpacity(0);
	    	    settings_profile_email.setOpacity(0);
	    	    settings_profile_name.setOpacity(0);
	    	    edit_ID.setOpacity(0);
	    	    edit_email.setOpacity(0);
	    	    edit_fullname.setOpacity(0);
	    	    edit_gender.setOpacity(0);
	    	    edit_picture2.setOpacity(0);
	    	    edit_status.setOpacity(0);
	    	    edit_username.setOpacity(0);
	    	    adminEdit_Username.setOpacity(0);
	    	    adminEdit_adminID.setOpacity(0);
	    	    adminEdit_email.setOpacity(0);
	    	    adminEdit_fullname.setOpacity(0);
	    	    adminEdit_label_adminID.setOpacity(0);
	    	    adminEdit_label_datecreated.setOpacity(0);
	    	    adminEdit_label_email.setOpacity(0);
	    	    adminEdit_label_fullname.setOpacity(0);
	    	    adminEdit_status.setOpacity(0);
	    	    adminEdit_gender.setOpacity(0);
	    	    adminEdit_update.setOpacity(0);

	    	    // Define transitions for each UI element in the desired order
	    	    FadeTransition settingsProfilePaneFade = new FadeTransition(Duration.seconds(0.7), settings_profile_pane); // Levi pane
	    	    settingsProfilePaneFade.setFromValue(0);
	    	    settingsProfilePaneFade.setToValue(1);

	    	    FadeTransition editPaneFade = new FadeTransition(Duration.seconds(0.7), edit_pane); // Desni pane
	    	    editPaneFade.setFromValue(0);
	    	    editPaneFade.setToValue(1);

	    	    FadeTransition adminEditProfilePictureFade = new FadeTransition(Duration.seconds(0.5), adminEdit_profilePicture); // Circle
	    	    adminEditProfilePictureFade.setFromValue(0);
	    	    adminEditProfilePictureFade.setToValue(1);

	    	    FadeTransition editLineFade = new FadeTransition(Duration.seconds(0.5), edit_line); // Line
	    	    editLineFade.setFromValue(0);
	    	    editLineFade.setToValue(1);

	    	    FadeTransition editLabelFade = new FadeTransition(Duration.seconds(0.5), edit_label); // Label na desnom
	    	    editLabelFade.setFromValue(0);
	    	    editLabelFade.setToValue(1);

	    	    FadeTransition adminEditImportPictureFade = new FadeTransition(Duration.seconds(0.5), adminEdit_ImportPicture); // Import dugme na levom
	    	    adminEditImportPictureFade.setFromValue(0);
	    	    adminEditImportPictureFade.setToValue(1);

	    	    FadeTransition editPicture1Fade = new FadeTransition(Duration.seconds(0.5), edit_picture1); // Slika pored label na levom
	    	    editPicture1Fade.setFromValue(0);
	    	    editPicture1Fade.setToValue(1);

	    	    // Ostali elementi...
	    	    FadeTransition settingsProfileIDFade = new FadeTransition(Duration.seconds(0.5), settings_profile_ID);
	    	    settingsProfileIDFade.setFromValue(0);
	    	    settingsProfileIDFade.setToValue(1);

	    	    FadeTransition settingsProfileDateFade = new FadeTransition(Duration.seconds(0.5), settings_profile_date);
	    	    settingsProfileDateFade.setFromValue(0);
	    	    settingsProfileDateFade.setToValue(1);

	    	    FadeTransition settingsProfileEmailFade = new FadeTransition(Duration.seconds(0.5), settings_profile_email);
	    	    settingsProfileEmailFade.setFromValue(0);
	    	    settingsProfileEmailFade.setToValue(1);

	    	    FadeTransition settingsProfileNameFade = new FadeTransition(Duration.seconds(0.5), settings_profile_name);
	    	    settingsProfileNameFade.setFromValue(0);
	    	    settingsProfileNameFade.setToValue(1);

	    	    FadeTransition editIDFade = new FadeTransition(Duration.seconds(0.5), edit_ID);
	    	    editIDFade.setFromValue(0);
	    	    editIDFade.setToValue(1);

	    	    FadeTransition editEmailFade = new FadeTransition(Duration.seconds(0.5), edit_email);
	    	    editEmailFade.setFromValue(0);
	    	    editEmailFade.setToValue(1);

	    	    FadeTransition editFullnameFade = new FadeTransition(Duration.seconds(0.5), edit_fullname);
	    	    editFullnameFade.setFromValue(0);
	    	    editFullnameFade.setToValue(1);

	    	    FadeTransition editGenderFade = new FadeTransition(Duration.seconds(0.5), edit_gender);
	    	    editGenderFade.setFromValue(0);
	    	    editGenderFade.setToValue(1);

	    	    FadeTransition editPicture2Fade = new FadeTransition(Duration.seconds(0.5), edit_picture2);
	    	    editPicture2Fade.setFromValue(0);
	    	    editPicture2Fade.setToValue(0.2);

	    	    FadeTransition editStatusFade = new FadeTransition(Duration.seconds(0.5), edit_status);
	    	    editStatusFade.setFromValue(0);
	    	    editStatusFade.setToValue(1);

	    	    FadeTransition editUsernameFade = new FadeTransition(Duration.seconds(0.5), edit_username);
	    	    editUsernameFade.setFromValue(0);
	    	    editUsernameFade.setToValue(1);

	    	    FadeTransition adminEditUsernameFade = new FadeTransition(Duration.seconds(0.5), adminEdit_Username);
	    	    adminEditUsernameFade.setFromValue(0);
	    	    adminEditUsernameFade.setToValue(1);

	    	    FadeTransition adminEditAdminIDFade = new FadeTransition(Duration.seconds(0.5), adminEdit_adminID);
	    	    adminEditAdminIDFade.setFromValue(0);
	    	    adminEditAdminIDFade.setToValue(1);

	    	    FadeTransition adminEditEmailFade = new FadeTransition(Duration.seconds(0.5), adminEdit_email);
	    	    adminEditEmailFade.setFromValue(0);
	    	    adminEditEmailFade.setToValue(1);

	    	    FadeTransition adminEditFullnameFade = new FadeTransition(Duration.seconds(0.5), adminEdit_fullname);
	    	    adminEditFullnameFade.setFromValue(0);
	    	    adminEditFullnameFade.setToValue(1);

	    	    FadeTransition adminEditLabelAdminIDFade = new FadeTransition(Duration.seconds(0.5), adminEdit_label_adminID);
	    	    adminEditLabelAdminIDFade.setFromValue(0);
	    	    adminEditLabelAdminIDFade.setToValue(1);

	    	    FadeTransition adminEditLabelDateCreatedFade = new FadeTransition(Duration.seconds(0.5), adminEdit_label_datecreated);
	    	    adminEditLabelDateCreatedFade.setFromValue(0);
	    	    adminEditLabelDateCreatedFade.setToValue(1);

	    	    FadeTransition adminEditLabelEmailFade = new FadeTransition(Duration.seconds(0.5), adminEdit_label_email);
	    	    adminEditLabelEmailFade.setFromValue(0);
	    	    adminEditLabelEmailFade.setToValue(1);

	    	    FadeTransition adminEditLabelFullnameFade = new FadeTransition(Duration.seconds(0.5), adminEdit_label_fullname);
	    	    adminEditLabelFullnameFade.setFromValue(0);
	    	    adminEditLabelFullnameFade.setToValue(1);

	    	    FadeTransition adminEditStatusFade = new FadeTransition(Duration.seconds(0.5), adminEdit_status);
	    	    adminEditStatusFade.setFromValue(0);
	    	    adminEditStatusFade.setToValue(1);

	    	    FadeTransition adminEditGenderFade = new FadeTransition(Duration.seconds(0.5), adminEdit_gender);
	    	    adminEditGenderFade.setFromValue(0);
	    	    adminEditGenderFade.setToValue(1);

	    	    FadeTransition adminEditUpdateFade = new FadeTransition(Duration.seconds(0.5), adminEdit_update);
	    	    adminEditUpdateFade.setFromValue(0);
	    	    adminEditUpdateFade.setToValue(1);

	    	    // Create a SequentialTransition to play the animations one after the other with delays
	    	    SequentialTransition sequentialTransition = new SequentialTransition(
	    	        settingsProfilePaneFade, // Levi pane
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        editPaneFade, // Desni pane
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        adminEditProfilePictureFade, // Circle
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        editLineFade, // Line
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        editLabelFade, // Label na desnom
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        editPicture1Fade, // Slika pored label na levom
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        adminEditImportPictureFade, // Import dugme na levom
	    	        new PauseTransition(Duration.seconds(0.3)),

	    	        settingsProfileIDFade, // Ostali elementi...
	    	        
	    	        adminEditLabelAdminIDFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        

	    	        
	    	        settingsProfileEmailFade,
	    	         
	    	        adminEditLabelEmailFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        
	    	        settingsProfileNameFade,
	    	        
	    	        adminEditLabelFullnameFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        
	    	        
	    	        settingsProfileDateFade,
	    	        
	    	        adminEditLabelDateCreatedFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        
	    	        editIDFade,
	    	        
	    	        adminEditAdminIDFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        
	    	        editUsernameFade,
	    	        
	    	        adminEditUsernameFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        
	    	        editFullnameFade,
	    	        
	    	        adminEditFullnameFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        
	    	        editGenderFade,
	    	        
	    	        adminEditGenderFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        

	    	        editEmailFade,
	    	        
	    	        adminEditEmailFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	        
	    	        
	    	        editStatusFade,
	    	        
	    	        adminEditStatusFade,
	    	        new PauseTransition(Duration.seconds(0.3)),
	    	     
	    	        editPicture2Fade, 
	    	        
	    	        adminEditUpdateFade
	    	    );

	    	    // Start the animation sequence
	    	    sequentialTransition.play();
	    
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
	

		private void resetCB(ComboBox<String> cb) {
		    // Animacija za vraćanje TextField-a na originalnu veličinu
		    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(120), cb);
		    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
		    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
		    scaleTransition.play();
		}
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	        runTime();
			AdminStatusList();
			AdminGenderList();
			 
//			 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			 
		     FadeInDashboard();
		     FadeInButtons();

			 dashboard_btn.setOnMouseEntered(event -> enlargeButton(dashboard_btn));
			 dashboard_btn.setOnMouseExited(event -> resetButtonSize(dashboard_btn));
			 
			 doctor_btn.setOnMouseEntered(event -> enlargeButton(doctor_btn));
			 doctor_btn.setOnMouseExited(event -> resetButtonSize(doctor_btn));
			 
			 patient_btn.setOnMouseEntered(event -> enlargeButton(patient_btn));
			 patient_btn.setOnMouseExited(event -> resetButtonSize(patient_btn));
			 
			 appointment_btn.setOnMouseEntered(event -> enlargeButton(appointment_btn));
			 appointment_btn.setOnMouseExited(event -> resetButtonSize(appointment_btn));
			 
			 payment_btn.setOnMouseEntered(event -> enlargeButton(payment_btn));
			 payment_btn.setOnMouseExited(event -> resetButtonSize(payment_btn));
			 
			 profile_settings_btn.setOnMouseEntered(event -> enlargeButton(profile_settings_btn));
			 profile_settings_btn.setOnMouseExited(event -> resetButtonSize(profile_settings_btn));
			 
			 dashboard_logoutBTN.setOnMouseEntered(event -> enlargeButton(dashboard_logoutBTN));
			 dashboard_logoutBTN.setOnMouseExited(event -> resetButtonSize(dashboard_logoutBTN));
			 
			 adminEdit_ImportPicture.setOnMouseEntered(event -> enlargeButton(adminEdit_ImportPicture));
			 adminEdit_ImportPicture.setOnMouseExited(event -> resetButtonSize(adminEdit_ImportPicture));
			 
			 adminEdit_update.setOnMouseEntered(event -> enlargeButton(adminEdit_update));
			 adminEdit_update.setOnMouseExited(event -> resetButtonSize(adminEdit_update));
			 
			 adminEdit_adminID.setOnMouseEntered(event -> enlargeTextField(adminEdit_adminID));
			 adminEdit_adminID.setOnMouseExited(event -> resetTextFieldSize(adminEdit_adminID));
			 
			 adminEdit_Username.setOnMouseEntered(event -> enlargeTextField(adminEdit_Username));
			 adminEdit_Username.setOnMouseExited(event -> resetTextFieldSize(adminEdit_Username));
			 
			 adminEdit_fullname.setOnMouseEntered(event -> enlargeTextField(adminEdit_fullname));
			 adminEdit_fullname.setOnMouseExited(event -> resetTextFieldSize(adminEdit_fullname));
			 
			 adminEdit_email.setOnMouseEntered(event -> enlargeTextField(adminEdit_email));
			 adminEdit_email.setOnMouseExited(event -> resetTextFieldSize(adminEdit_email));
			 
			 adminEdit_gender.setOnMouseEntered(event -> enlargeCB(adminEdit_gender));
			 adminEdit_gender.setOnMouseExited(event -> resetCB(adminEdit_gender));
			 
			 adminEdit_status.setOnMouseEntered(event -> enlargeCB(adminEdit_status));
			 adminEdit_status.setOnMouseExited(event -> resetCB(adminEdit_status));
			 
			 payment_checkout.setOnMouseEntered(event -> enlargeButton(payment_checkout));
			 payment_checkout.setOnMouseExited(event -> resetButtonSize(payment_checkout));
//			 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	        try {
				displayAdminIDUsername();
				DoctorShowData();
				actionButtons();
				displayPatientData();
				getPatientRecord();
				actionButtonsPatient();
				AppointmentShowData();
				actionButtonsAppointments();
				 setFieldText();
				 SetLabelText();
				 PatientPaymentGetData();
		    	PatientPaymentShowData();
				 displayProfilePictures();
				 dashboardNDD();
				 dashboardNPD();
				 dashboardAD();
				 dashboardTP();
				 dashboardAP();
				 dashboardTA();
				 DashoboardDoctorShowData();
				 DashboardDoctorGetData();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
