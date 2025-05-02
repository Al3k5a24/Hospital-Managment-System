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
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

public class DoctorEitForm implements Initializable{

	@FXML
    private TextArea doctoredit_address;

    @FXML
    private Button doctoredit_confirm;
    
    @FXML
    private Button doctoredit_importpicture;

    @FXML
    private TextField doctoredit_doctorID;

    @FXML
    private TextField doctoredit_doctorName;

    @FXML
    private TextField doctoredit_email;

    @FXML
    private ComboBox<String> doctoredit_gender;

    @FXML
    private TextField doctoredit_number;

    @FXML
    private ComboBox<String> doctoredit_specialization;

    @FXML
    private ComboBox<String> doctoredit_status;
    
    @FXML
    private Circle editdoctor_picture;

    @FXML
    private StackPane edit_doctor;
    
    @FXML
    private Button doctoredit_cancel;
    
    private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private final AlertMessage alert=new AlertMessage();

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
	}
	
	private void DoctorSpecialization() {
    	List<String> listS=new ArrayList<>();
    	for(String data:Data.specialization) {
    		listS.add(data);
    	}
    	
    	ObservableList listData=FXCollections.observableArrayList(listS);
    	doctoredit_specialization.setItems(listData);
    }
	
	 public void DoctorGenderList() {
	    	List<String> listG=new ArrayList<>();
	    	for(String data:Data.gender) {
	    		listG.add(data);
	    	}
	    	
	    	ObservableList listData=FXCollections.observableArrayList(listG);
	    	doctoredit_gender.setItems(listData);
	    }
	    
	    public void DoctortStatusList() {
	    	List<String> listS=new ArrayList<>();
	    	for(String data:Data.doctorStatus) {
	    		listS.add(data);
	    	}
	    	
	    	ObservableList listData=FXCollections.observableArrayList(listS);
	    	doctoredit_status.setItems(listData);
	    }
	    
	    @FXML
	    public void cancelBtn() {
	    	if(alert.confirmationMessage("Are you sure that you want to undo changes?")) {
	    		doctoredit_cancel.getScene().getWindow().hide();
	    	}
	    }
	    
	    public void setText() {
	    	doctoredit_doctorID.setText(String.valueOf(Data.temp_doctorID));
	    	doctoredit_doctorID.setDisable(true);
	    	doctoredit_doctorName.setText(String.valueOf( Data.temp_doctorname));
	    	doctoredit_number.setText(String.valueOf(Data.temp_doctornumber));
	    	doctoredit_address.setText(String.valueOf(Data.temp_doctoraddress));
	    	doctoredit_email.setText(Data.temp_doctoremail);
	    	doctoredit_status.getSelectionModel().select(String.valueOf(Data.temp_doctorstatus));
	    	doctoredit_gender.getSelectionModel().select(String.valueOf(Data.temp_doctorgender));
	    	doctoredit_specialization.getSelectionModel().select(String.valueOf(Data.temp_doctorspecialization));
	    }

	    private Image image;
	    public void displayDoctorData() throws ClassNotFoundException, SQLException { 
	        String sql = "SELECT * FROM doctor WHERE doctor_id = ?";
	        connect();  // Povezivanje na bazu podataka
	        
	        try {
	            preparedStatement = connect.prepareStatement(sql);
	            preparedStatement.setString(1, doctoredit_doctorID.getText());
	            resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                doctoredit_doctorName.setText(resultSet.getString("full_name")); 
	                doctoredit_gender.getSelectionModel().select(resultSet.getString("gender"));
	                doctoredit_number.setText(resultSet.getString("phone_number")); 
	                doctoredit_email.setText(resultSet.getString("email")); 
	                doctoredit_address.setText(resultSet.getString("address")); 
	                doctoredit_specialization.getSelectionModel().select(resultSet.getString("specialized"));
	                doctoredit_status.getSelectionModel().select(resultSet.getString("status"));
	                
	                // Kreiraj putanju do slike
	                String imagePath = resultSet.getString("image");
	                if (imagePath != null && !imagePath.isEmpty()) {
	                    // Ako putanja postoji, postavljamo sliku
	                    File imageFile = new File(imagePath);
	                    if (imageFile.exists()) {
	                        image = new Image(imageFile.toURI().toString(), 156, 114, false, true);
	                        editdoctor_picture.setFill(new ImagePattern(image));
	                    } else {
	                        alert.errorMessage("Image file not found at path: " + imagePath);
	                    }
	                } else {
	                    alert.errorMessage("Image path is null or empty.");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            alert.errorMessage("An error occurred: " + e.getMessage());
	        }
	    }

	    
	    public void updateBtn() throws ClassNotFoundException, SQLException {
	        // Provjera jesu li sva polja popunjena
	        if (doctoredit_doctorID.getText().isEmpty() || 
	            doctoredit_doctorName.getText().isEmpty() || 
	            doctoredit_gender.getSelectionModel().isEmpty() || 
	            doctoredit_number.getText().isEmpty() ||
	            doctoredit_email.getText().isEmpty() ||
	            doctoredit_address.getText().isEmpty() || 
	            doctoredit_specialization.getSelectionModel().isEmpty() || 
	            doctoredit_status.getSelectionModel().isEmpty()) {
	            alert.errorMessage("Please fill all blank fields!");
	            return; // Prekini izvršavanje ako su polja prazna
	        }

	        try {
	            connect(); // Poveži se na bazu podataka
	            
	            // Provjeri postoji li doktor sa danim ID-om
	            String checkQuery = "SELECT * FROM doctor WHERE doctor_id = ?";
	            preparedStatement = connect.prepareStatement(checkQuery);
	            preparedStatement.setString(1, doctoredit_doctorID.getText());
	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                if (alert.confirmationMessage("Are you sure you want to UPDATE Doctor ID: " + doctoredit_doctorID.getText() + " ?")) {
	                    // Ažuriranje podataka
	                    String updateQuery = "UPDATE doctor SET full_name = ?, email = ?, gender = ?, phone_number = ?, specialized = ?, address = ?, modify_date = ?, status = ?, image = ? WHERE doctor_id = ?";
	                    preparedStatement = connect.prepareStatement(updateQuery);
	                    preparedStatement.setString(1, doctoredit_doctorName.getText());
	                    preparedStatement.setString(2, doctoredit_email.getText());
	                    preparedStatement.setString(3, doctoredit_gender.getSelectionModel().getSelectedItem());
	                    preparedStatement.setString(4, doctoredit_number.getText());
	                    preparedStatement.setString(5, doctoredit_specialization.getSelectionModel().getSelectedItem());
	                    preparedStatement.setString(6, doctoredit_address.getText());
	                    preparedStatement.setDate(7, new java.sql.Date(new Date().getTime()));
	                    preparedStatement.setString(8, doctoredit_status.getSelectionModel().getSelectedItem());

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
	                    java.nio.file.Path targetDir = Paths.get("C:\\Users\\Win10\\Desktop\\Java\\JavaFx\\HospitalManagment\\src\\application\\ProfilneSlikeStorage\\DoctorForm\\");
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
	                        java.nio.file.Path copy = Paths.get("C:\\Users\\Win10\\Desktop\\Java\\JavaFx\\HospitalManagment\\src\\application\\ProfilneSlikeStorage\\DoctorForm\\" + doctoredit_doctorID.getText() + ".jpg");

	                        try {
	                            Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                            alert.errorMessage("Error while copying the image: " + e.getMessage());
	                            return;
	                        }
	                        path = copy.toAbsolutePath().toString();
	                    }

	                    // Postavljanje putanje slike u bazi
	                    preparedStatement.setString(9, path);
	                    preparedStatement.setString(10, doctoredit_doctorID.getText());

	                    int rowsUpdated = preparedStatement.executeUpdate();
	                    if (rowsUpdated > 0) {
	                        alert.successMessage("Successfully updated Doctor ID: " + doctoredit_doctorID.getText());
	                    } else {
	                        alert.errorMessage("Update failed!");
	                    }
	                }
	            } else {
	                alert.errorMessage("Doctor not found!");
	            }
                displayDoctorData();

	        } catch (Exception e) {
	            e.printStackTrace();
	            alert.errorMessage("An error occurred: " + e.getMessage());
	        }
	    }

	    
	   
	    
	  //importovanje profilnih slika
	    public void profileChangeProfile() {
	    	
	    	FileChooser open=new FileChooser();
	    	open.getExtensionFilters().add(new ExtensionFilter("Open Image","*png","*jpg","*jpeg"));
	    	
	    	File file=open.showOpenDialog(doctoredit_importpicture.getScene().getWindow());
	    	
	    	if(file!=null) {
	    		Data.path=file.getAbsolutePath();
	    		image=new Image(file.toURI().toString(),156,114,false,true);
	    		editdoctor_picture.setFill(new ImagePattern(image));
	    	}
	    }
	    
	    public void displayProfilePictures() throws ClassNotFoundException, SQLException {
	    	
	    	connect();
	    	String sql="Select * from doctor where doctor_id=?";
			
			String path1="";
				try {
					preparedStatement = connect.prepareStatement(sql);
					preparedStatement.setString(1,doctoredit_doctorID.getText());
					resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) {
						path1="File:"+resultSet.getString("image");
						
						if(resultSet.getString("image")!=null) {
							image=new Image(path1,211,167,false,true);
							editdoctor_picture.setFill(new ImagePattern(image));
						}
					}
				}catch(Exception e) {
					
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
			doctoredit_importpicture.setOnMouseEntered(event -> enlargeButton(doctoredit_importpicture));
			doctoredit_importpicture.setOnMouseExited(event -> resetButtonSize(doctoredit_importpicture));
			
			doctoredit_confirm.setOnMouseEntered(event -> enlargeButton(doctoredit_confirm));
			doctoredit_confirm.setOnMouseExited(event -> resetButtonSize(doctoredit_confirm));
			
			doctoredit_cancel.setOnMouseEntered(event -> enlargeButton(doctoredit_cancel));
			doctoredit_cancel.setOnMouseExited(event -> resetButtonSize(doctoredit_cancel));
		}
		
		public void Fields() {
			doctoredit_doctorID.setOnMouseEntered(event -> enlargeTextField(doctoredit_doctorID));
			doctoredit_doctorID.setOnMouseExited(event -> resetTextFieldSize(doctoredit_doctorID));
			 
			doctoredit_doctorName.setOnMouseEntered(event -> enlargeTextField(doctoredit_doctorName));
			doctoredit_doctorName.setOnMouseExited(event -> resetTextFieldSize(doctoredit_doctorName));
			
			doctoredit_number.setOnMouseEntered(event -> enlargeTextField(doctoredit_number));
			doctoredit_number.setOnMouseExited(event -> resetTextFieldSize(doctoredit_number));
			
			doctoredit_email.setOnMouseEntered(event -> enlargeTextField(doctoredit_email));
			doctoredit_email.setOnMouseExited(event -> resetTextFieldSize(doctoredit_email));
			
			doctoredit_address.setOnMouseEntered(event -> enlargeTextArea(doctoredit_address));
			doctoredit_address.setOnMouseExited(event -> resetTextAreaSize(doctoredit_address));
			
			doctoredit_gender.setOnMouseEntered(event -> enlargeCB(doctoredit_gender));
			doctoredit_gender.setOnMouseExited(event -> resetCB(doctoredit_gender));
			
			doctoredit_specialization.setOnMouseEntered(event -> enlargeCB(doctoredit_specialization));
			doctoredit_specialization.setOnMouseExited(event -> resetCB(doctoredit_specialization));
			
			doctoredit_status.setOnMouseEntered(event -> enlargeCB(doctoredit_status));
			doctoredit_status.setOnMouseExited(event -> resetCB(doctoredit_status));
		}
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			DoctorSpecialization();
			DoctorGenderList();
			DoctortStatusList();
			setText();
			Fields();
			Buttons();
			try {
				displayProfilePictures();
				displayDoctorData();
				displayDoctorData();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
