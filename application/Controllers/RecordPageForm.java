package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class RecordPageForm implements Initializable {

	@FXML
	private AnchorPane patient_record;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_action;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_address;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_contact;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_datecreated;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_datedelete;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_datemodify;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_name;

	@FXML
	private TableColumn<PatientData, String> patient_record_col_patientID;
	
	@FXML
	private TableColumn<PatientData, String> patient_record_col_gender;

	@FXML
	private TextField patient_record_search;

	@FXML
	private TableView<PatientData> patientd_record_tableview;
	
	@FXML
	private Button editbtn;
	
	@FXML
	private Button removebtn;

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private final AlertMessage alert=new AlertMessage();

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
	}

	public ObservableList<PatientData> getPatientRecord() throws ClassNotFoundException, SQLException {
		ObservableList<PatientData> listData = FXCollections.observableArrayList();

		try {
			// Prvo proveravamo da li je Data.doctor_username postavljen
			if (Data.doctor_id == null || Data.doctor_id.isEmpty()) {
				System.out.println("Doctor username is null or empty!");
				return listData;
			}

			// Povezivanje sa bazom
			connect();
			if (connect == null) {
				System.out.println("Database connection failed!");
				return listData;
			}

			// Priprema SQL upita
			String selectData = "SELECT * FROM patient WHERE date_delete IS NULL AND doctor = ?";
			preparedStatement = connect.prepareStatement(selectData);
			preparedStatement.setString(1, Data.doctor_username);
			resultSet = preparedStatement.executeQuery();

			// Dodavanje podataka u listu
			while (resultSet.next()) {
				PatientData pdata = new PatientData(resultSet.getInt("id"), resultSet.getInt("patient_id"),
						resultSet.getString("full_name"),resultSet.getString("gender"),resultSet.getLong("phone_number"),
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

		patient_record_col_patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
		patient_record_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		patient_record_col_contact.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
		patient_record_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		patient_record_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
		patient_record_col_datecreated.setCellValueFactory(new PropertyValueFactory<>("date"));
		patient_record_col_datemodify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
		patient_record_col_datedelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));

		patientd_record_tableview.setItems(patientRecordData);
	}
	
	public void searchPatientById() {
	    String searchText = patient_record_search.getText().trim();

	    if (searchText.isEmpty()) {
	        // Ako je polje prazno, prikaži sve pacijente
	        patientd_record_tableview.setItems(patientRecordData);
	        return;
	    }

	    try {
	        int searchId = Integer.parseInt(searchText);

	        // Filtriranje liste pacijenata
	        ObservableList<PatientData> filteredList = patientRecordData.filtered(patient ->
	                patient.getPatientID() == searchId
	        );

	        // Ažuriranje tabele
	        patientd_record_tableview.setItems(filteredList);

	    } catch (NumberFormatException e) {
	        System.out.println("Nepravilan unos ID-a pacijenta!");
	    }
	}

	// Ažuriranje podataka unutar ćelija tabele
	public void actionButtons() throws ClassNotFoundException, SQLException {
	    connect(); // Povezivanje sa bazom
	    patientRecordData = getPatientRecord(); // Dobavljanje podataka

	    Callback<TableColumn<PatientData, String>, TableCell<PatientData, String>> cellFactory = 
	        (TableColumn<PatientData, String> param) -> new TableCell<>() {

	            private final Button editbtn = new Button("Edit");
	            private final Button removebtn = new Button("Delete");
	            private final HBox manageBtn = new HBox(editbtn, removebtn);

	            {
	                // Stilizovanje dugmadi
	                editbtn.getStyleClass().add("table-button");
	                removebtn.getStyleClass().add("table-button");
	                manageBtn.setAlignment(Pos.CENTER);
	                manageBtn.setSpacing(5);
	            }

	            @Override
	            protected void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty || getTableRow() == null || getTableRow().getItem() == null) {
	                    setGraphic(null);
	                } else {
	                    PatientData pData = getTableRow().getItem();

	                    editbtn.setOnAction((ActionEvent event) -> {
	                        if (pData != null) {
	                            System.out.println("Edit clicked for Patient ID: " + pData.getPatientID());

	                            Data.temp_patientID = pData.getPatientID();
	                            Data.temp_name = pData.getFullName();
	                            Data.temp_number = pData.getMobileNumber();
	                            Data.temp_address = pData.getAddress();
	                            Data.temp_status = pData.getStatus();
	                            Data.temp_gender = pData.getGender();

	                            try {
	                                Parent root = FXMLLoader.load(getClass().getResource("RecordEditButton.fxml"));
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

	                    removebtn.setOnAction((ActionEvent event) -> {
	                        if (pData != null) {
	                            try {
	                                String deleteData = "UPDATE patient SET date_delete=? WHERE patient_id=?";
	                                preparedStatement = connect.prepareStatement(deleteData);

	                                Date date = new Date();
	                                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	                                if (alert.confirmationMessage("Are you sure you want to delete patient ID: " + pData.getPatientID() + "?")) {
	                                    preparedStatement.setDate(1, sqlDate);
	                                    preparedStatement.setInt(2, pData.getPatientID());
	                                    preparedStatement.executeUpdate();

	                                    alert.successMessage("You successfully deleted patient ID: " + pData.getPatientID());
	                                    displayPatientData(); // Osvježavanje prikaza podataka
	                                }
	                            } catch (Exception e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    });

	                    setGraphic(manageBtn);
	                }
	            }
	        };

	    // Postavljanje cellFactory na odgovarajuću kolonu
	    patient_record_col_action.setCellFactory(cellFactory);

	    // Provera da li ima podataka pre nego što se postavi u tabelu
	    if (patientRecordData.isEmpty()) {
	        System.out.println("Tabela je prazna, dugmad se neće prikazati!");
	    } else {
	        System.out.println("Tabela sadrži: " + patientRecordData.size() + " pacijenata.");
	    }

	    patientd_record_tableview.setItems(patientRecordData);
	    patientd_record_tableview.setTableMenuButtonVisible(false);
	    patientd_record_tableview.refresh(); // Osvježavanje tabele
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			displayPatientData();
			actionButtons();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
