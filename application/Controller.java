package application;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable{
	
	@FXML
	private StackPane StartPage;
	
	@FXML
    private ComboBox<String> admin_comboboxuser;

    @FXML
    private AnchorPane admin_loginpage;

    @FXML
    private PasswordField admin_loginpassword;

    @FXML
    private TextField admin_loginusername;

    @FXML
    private CheckBox admin_logshowpass;

    @FXML
    private Hyperlink admin_logswitchform;

    @FXML
    private AnchorPane admin_page;

    @FXML
    private TextField admin_regemail;
    
    @FXML
    private Button admin_logbtn;

    @FXML
    private Button admin_register;

    @FXML
    private AnchorPane admin_registerpage;

    @FXML
    private PasswordField admin_regpassword;

    @FXML
    private CheckBox admin_regshowpass;

    @FXML
    private TextField admin_regshowpassword;

    @FXML
    private Hyperlink admin_regswitch;

    @FXML
    private TextField admin_regusername;

    @FXML
    private TextField admin_showpasslog;

    @FXML
    private AnchorPane doc_regpage;

    @FXML
    private CheckBox doctor_chechshowpass;

    @FXML
    private ComboBox<String> doctor_comboboxlog;

    @FXML
    private TextField doctor_idlogin;

    @FXML
    private TextField doctor_idregister;

    @FXML
    private AnchorPane doctor_login;

    @FXML
    private Button doctor_loginbtn;

    @FXML
    private PasswordField doctor_logpassword;

    @FXML
    private TextField doctor_logshowpass;

    @FXML
    private Hyperlink doctor_logswitchform;

    @FXML
    private AnchorPane doctor_page;

    @FXML
    private PasswordField doctor_passwordreg;

    @FXML
    private TextField doctor_regemail;

    @FXML
    private TextField doctor_regfullname;

    @FXML
    private AnchorPane doctor_register;

    @FXML
    private Button doctor_registerbtn;

    @FXML
    private TextField doctor_regshowpassword;

    @FXML
    private CheckBox doctor_showpassreg;

    @FXML
    private Hyperlink doctor_switchform;

    @FXML
    private CheckBox patient_checkregpass;

    @FXML
    private ComboBox<String> patient_combobox;

    @FXML
    private TextField patient_fullnamereg;

    @FXML
    private TextField patient_idlogin;

    @FXML
    private Button patient_logbtn;

    @FXML
    private CheckBox patient_logcheckbox;

    @FXML
    private AnchorPane patient_login;

    @FXML
    private TextField patient_logshowpass;

    @FXML
    private Hyperlink patient_logswitchform;

    @FXML
    private AnchorPane patient_page;

    @FXML
    private PasswordField patient_passwordlog;

    @FXML
    private TextField patient_patientidreg;

    @FXML
    private TextField patient_regphone;

    @FXML
    private AnchorPane patient_register;

    @FXML
    private Button patient_createaccount;

    @FXML
    private PasswordField patient_regpassword;

    @FXML
    private TextField patient_regshowpassword;

    @FXML
    private Hyperlink patient_regswitchform;

  
    //admin tab
	    private Connection connect = null;
		private Statement statement = null;
		private PreparedStatement preparedStatement = null;
		private ResultSet resultSet = null;

		public void connect() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
		}
		
		@FXML
		public void registershowPassword() {
	    	if(admin_regshowpass.isSelected()) {
	    		admin_regshowpassword.setText(admin_regpassword.getText());
	    		admin_regshowpassword.setVisible(true);
	    		admin_regpassword.setVisible(false);
	    	}else {
	    		admin_regpassword.setText(admin_regshowpassword.getText());
	    		admin_regshowpassword.setVisible(false);
	    		admin_regpassword.setVisible(true);
	    	}
	    }
	    
	  //checkbox za prikazivanje lozinke u login formi
		@FXML
	    public void loginshowPassword() {
	    	if(admin_logshowpass.isSelected()) {
	    		admin_showpasslog.setText(admin_loginpassword.getText());
	    		admin_showpasslog.setVisible(true);
	    		admin_loginpassword.setVisible(false);
	    	}else {
	    		admin_loginpassword.setText(admin_showpasslog.getText());
	    		admin_showpasslog.setVisible(false);
	    		admin_loginpassword.setVisible(true);
	    	}
	    }
		//promena tabova preko hiperlinka
		@FXML
	    public void switchform(ActionEvent event){
	    	if(event.getSource()==admin_logswitchform) {
	    		admin_loginpage.setVisible(false);
	    		admin_registerpage.setVisible(true);
	    	}
	    	
	    	if(event.getSource()==admin_regswitch){
	    		admin_loginpage.setVisible(true);
	    		admin_registerpage.setVisible(false);
	    	}
	    }
		@FXML
		public void initialize() {
	        // Dodavanje opcija u ComboBox
			admin_comboboxuser.getItems().addAll("Doctor Portal", "Patient Portal","Select User");
			doctor_comboboxlog.getItems().addAll("Admin Portal", "Patient Portal","Select User");
			patient_combobox.getItems().addAll("Admin Portal","Doctor Portal","Select User");

	        // Povezivanje opcija sa akcijama
			admin_comboboxuser.setOnAction(event -> comboboxadmin());
			doctor_comboboxlog.setOnAction(event -> comboboxdoctor());
			patient_combobox.setOnAction(event -> comboboxpatient());
	    }
		
		@FXML
	    public void comboboxadmin() {
	        String selectedOption = admin_comboboxuser.getValue();
	        if (selectedOption == null) {
	            selectedOption = "Select User";  // Ili neka druga odgovarajuća vrednost
	        }else {
	        switch (selectedOption) {
	        case "Patient Portal":
	            patient_page.setDisable(false);
	            patient_page.setVisible(true);
	            admin_page.setDisable(true);
	            admin_page.setVisible(false);
	            doctor_page.setDisable(true);
	            doctor_page.setVisible(false);
	            break;
	        case "Doctor Portal":
	            doctor_page.setDisable(false);
	            doctor_page.setVisible(true);
	            admin_page.setDisable(true);
	            admin_page.setVisible(false);
	            patient_page.setDisable(true);
	            patient_page.setVisible(false);
	            break;
	    }
	        if (!"Select User".equals(selectedOption)) {
	        admin_comboboxuser.setValue("Select User");
	        }
	    }
		}
		
		 private void emptyfields() {
			 admin_regusername.clear();
			 admin_regemail.clear();
			 admin_regpassword.clear();
			 admin_loginusername.clear();
			 admin_loginpassword.clear();
			 admin_showpasslog.clear();
			 
			 doctor_regfullname.clear();
			 doctor_regemail.clear();
			 doctor_passwordreg.clear();
			 doctor_idregister.clear();
			 doctor_regshowpassword.clear();
			 doctor_idlogin.clear();
			 doctor_logpassword.clear();
			 doctor_logshowpass.clear();
			}
		
		private AlertMessage alert=new AlertMessage();
		
		@FXML
		public void registerAccount() throws ClassNotFoundException, SQLException {
		    if (admin_regusername.getText().isEmpty() || admin_regemail.getText().isEmpty() || admin_regpassword.getText().isEmpty()) {
		        alert.errorMessage("Please fill all blank fields");
		    } else {
		        // Provera da li je username već zauzet
		        String checkusername = "SELECT * FROM admin WHERE username = ?";
		        connect();

		        try {
		            preparedStatement = connect.prepareStatement(checkusername);
		            preparedStatement.setString(1, admin_regusername.getText());
		            resultSet = preparedStatement.executeQuery();

		            //provera da se lozinke poklapaju,bilo prikazana ili ne
		            String enteredPassword;

					// Provera koje polje je aktivno
					if (admin_loginpassword.isVisible()) {
					    enteredPassword = admin_regpassword.getText();
					} else {
					    enteredPassword = admin_regshowpassword.getText();
					}

		            if (resultSet.next()) {
		                alert.errorMessage(admin_regusername.getText() + " is already taken!");
		                
		                //lozinka mora imati barem 8 karaktera
		            }else if(admin_regpassword.getLength()<=8) {
		            	alert.errorMessage("Password should have at least 8 characters!");
		            }
		            
		            else {
		                // Priprema INSERT upita
		                String insertQuery = "INSERT INTO admin(email, username, password, date) VALUES (?, ?, ?, ?)";
		                preparedStatement = connect.prepareStatement(insertQuery);

		                Date date = new Date();
		                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		                preparedStatement.setString(1, admin_regemail.getText());
		                preparedStatement.setString(2, admin_regusername.getText());
		                preparedStatement.setString(3, enteredPassword);
		                preparedStatement.setDate(4, sqlDate);
		                
		                int rowsInserted = preparedStatement.executeUpdate();
		                if (rowsInserted > 0) {
		                    alert.successMessage("Registered successfully!");
		                }
		                
		                emptyfields();
		                
		                admin_loginpage.setVisible(true);
		                admin_registerpage.setVisible(false);
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (resultSet != null) resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connect != null) connect.close();
		        }
		    }
		}
		
		@FXML
		public void loginAccount() throws ClassNotFoundException, SQLException {
			if(admin_loginusername.getText().isEmpty() || admin_loginpassword.getText().isEmpty()) {
				alert.errorMessage("Incorrect username/password!");
			}else {
				String checkadmin = "SELECT * FROM admin WHERE username = ? AND password = ?";
				connect();
				
				String enteredPassword;

				// Provera koje polje je aktivno
				if (admin_loginpassword.isVisible()) {
				    enteredPassword = admin_loginpassword.getText();
				} else {
				    enteredPassword = admin_showpasslog.getText();
				}
				
				try {
		            preparedStatement = connect.prepareStatement(checkadmin);
		            preparedStatement.setString(1, admin_loginusername.getText());
		            preparedStatement.setString(2,enteredPassword);
		            resultSet = preparedStatement.executeQuery();
		            
		            if(resultSet.next()) {
		            	
		            	Data.admin_username=admin_loginusername.getText();
		            	
		            	alert.successMessage("Login successfully");
		            	Parent root=FXMLLoader.load(getClass().getResource("AdminMainForm.fxml"));
		            	Stage stage=new Stage();
		            	stage.setTitle("Hospital Managment System | Admin Portal");
		            	stage.setScene(new Scene(root));
		            	stage.show();
		            	
		            	admin_logbtn.getScene().getWindow().hide();
		            }else {
				           alert.errorMessage("Incorrect ID/password!");
				        }
		            }catch(Exception e) {
						e.printStackTrace();
			}
				}
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		//doctor tab
		@FXML
	    void registerAccountdoctor(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	if (doctor_idregister.getText().isEmpty() || doctor_regfullname.getText().isEmpty() || 
	    		doctor_regemail.getText().isEmpty() || doctor_passwordreg.getText().isEmpty() || doctor_regshowpassword.getText().isEmpty())
	    	{
		        alert.errorMessage("Please fill all blank fields");
	    	}
	    	else {
	    		String checkdocID="Select * from doctor where doctor_id=?";
	    		connect();
	    		try {
	    			preparedStatement = connect.prepareStatement(checkdocID);
		            preparedStatement.setString(1,doctor_idregister.getText());
		            resultSet = preparedStatement.executeQuery();
		            
		            String enteredPassword;

					// Provera koje polje je aktivno
					if (admin_loginpassword.isVisible()) {
					    enteredPassword = admin_regpassword.getText();
					} else {
					    enteredPassword = doctor_regshowpassword.getText();
					}
		            
		            if (resultSet.next()) {
		                alert.errorMessage(doctor_idregister.getText() + " is already taken!");
		                
		            }
		            
		            //lozinka mora imati barem 8 karaktera
		            else if(doctor_passwordreg.getLength()<=8) {
		            	alert.errorMessage("Password should have at least 8 characters!");
		            } 
		            
		            else {
		                // Priprema INSERT upita
		                String insertQuery = "INSERT INTO doctor(doctor_id,full_name,password,email,date,status) VALUES (?, ?, ?, ?, ?,'not confirm')";
		                preparedStatement = connect.prepareStatement(insertQuery);

		                Date date = new Date();
		                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		                preparedStatement.setString(4, doctor_regemail.getText());
		                preparedStatement.setString(2, doctor_regfullname.getText());
		                preparedStatement.setString(1, doctor_idregister.getText());
		                preparedStatement.setString(3,enteredPassword);
		                preparedStatement.setDate(5, sqlDate);
		                
		                int rowsInserted = preparedStatement.executeUpdate();
		                if (rowsInserted > 0) {
		                    alert.successMessage("Registered successfully!");
		                }
		                
		                emptyfields();
		                
		                doctor_login.setVisible(true);
		                doctor_register.setVisible(false);
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (resultSet != null) resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connect != null) connect.close();
		        }
	    	}
	    }
		
		@FXML
		void loginAccountdoctor(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
			
			if (doctor_idlogin.getText().isEmpty()) {
		        alert.errorMessage("Please fill all blank fields");
		        return;
		    } 
		    
		    connect();
		    
		    try {
		        // 1. Proveravamo da li postoji doktor sa datim ID-jem
		        String checkDoctorExists = "SELECT status FROM doctor WHERE doctor_id = ? AND delete_status IS NULL";
		        preparedStatement = connect.prepareStatement(checkDoctorExists);
		        preparedStatement.setString(1, doctor_idlogin.getText());
		        resultSet = preparedStatement.executeQuery();

		        if (!resultSet.next()) {
		            alert.errorMessage("Doctor ID not found or account deleted!");
		            return;
		        }

		        String status = resultSet.getString("status");

		        // Ako status nije "Confirm", ne dozvoljavamo prijavu
		        if (!"Confirm".equalsIgnoreCase(status)) {
		            alert.errorMessage("Your account needs confirmation from Admin!");
		            return;
		        }else {

			    String enteredPassword = "";
				   
				// Provera koje polje je aktivno
				if (doctor_chechshowpass.isVisible()) {
				    enteredPassword = doctor_logpassword.getText();
				} else if(!doctor_chechshowpass.isVisible()){
				    enteredPassword = doctor_logshowpass.getText();
				}
		        
		        // 2. Ako je status "Confirm", proveravamo lozinku
		        String checkDoctorLogin = "SELECT * FROM doctor WHERE doctor_id = ? AND password = ? AND status = 'Confirm' AND delete_status IS NULL";
		        preparedStatement = connect.prepareStatement(checkDoctorLogin);
		        preparedStatement.setString(1, doctor_idlogin.getText());
		        preparedStatement.setString(2, enteredPassword);
		        resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            Data.doctor_id = doctor_idlogin.getText();

		            alert.successMessage("Login successfully!");

		            Parent root = FXMLLoader.load(getClass().getResource("DoctorMainForm.fxml"));
		            Stage stage = new Stage();
		            stage.setTitle("Hospital Management System | Doctor Portal");
		            stage.setScene(new Scene(root));
		            stage.show();

		            // Zatvaramo trenutni prozor
		            ((Stage) doctor_idlogin.getScene().getWindow()).close();

		        } else {
		            alert.errorMessage("Incorrect ID/password!");
		        }}

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (resultSet != null) resultSet.close();
		        if (preparedStatement != null) preparedStatement.close();
		        if (connect != null) connect.close();
		    }
		}


		
		@FXML
		public void comboboxdoctor() {
		    // Prvo proveri da li je selektovana opcija null
		    String selectedOption = doctor_comboboxlog.getValue();
		    
		    // Ako je selektovana vrednost null, postavi podrazumevanu vrednost
		    if (selectedOption == null) {
		        selectedOption = "Select User";  // Ili neka druga odgovarajuća vrednost
		    }
		    
		    // Nastavi sa logikom
		    switch (selectedOption) {
		        case "Admin Portal":
		            admin_page.setDisable(false);
		            admin_page.setVisible(true);
		            doctor_page.setDisable(true);
		            doctor_page.setVisible(false);
		            patient_page.setDisable(true);
		            patient_page.setVisible(false);
		            break;
		        case "Patient Portal":
		            patient_page.setDisable(false);
		            patient_page.setVisible(true);
		            doctor_page.setDisable(true);
		            doctor_page.setVisible(false);
		            admin_page.setDisable(true);
		            admin_page.setVisible(false);
		            break;
		    }
		    
		    // Ako nije odabrana opcija "Select User", postavi ga na "Select User"
		    if (!"Select User".equals(selectedOption)) {
		        doctor_comboboxlog.setValue("Select User");
		    }
		}
		
		@FXML
	    void loginshowPassworddoctor(ActionEvent event) {
	        if (doctor_chechshowpass.isSelected()) {
	            // Kada je checkbox selektovan, prikazujemo lozinku u tekstualnom polju za prikazivanje
	        	doctor_logshowpass.setText(doctor_logpassword.getText()); 
	            doctor_logshowpass.setVisible(true);
	            doctor_logpassword.setVisible(false);
	            doctor_logpassword.setDisable(true);
	            doctor_logshowpass.setDisable(false);
	        } else {
	        	doctor_logpassword.setText(doctor_logshowpass.getText());
	            // Ako checkbox nije selektovan, skrivate lozinku u prikazu
	        	doctor_logshowpass.setVisible(false);
	        	doctor_logpassword.setDisable(false);
	            doctor_logpassword.setVisible(true);
	            doctor_logshowpass.setDisable(false);
	        }
	    }
		
		@FXML
	    void registershowPassworddoctor(ActionEvent event) {
	    	if(doctor_showpassreg.isSelected()) {
	    		doctor_regshowpassword.setText(doctor_passwordreg.getText());
	    		doctor_regshowpassword.setVisible(true);
	    		doctor_passwordreg.setVisible(false);
	    	}
	    	else {
	    		doctor_passwordreg.setText(doctor_regshowpassword.getText());
	    		doctor_regshowpassword.setVisible(false);
	    		doctor_passwordreg.setVisible(true);
	    	}
	    }
		
		@FXML
	    void switchformdoctor(ActionEvent event) {
	    	if(event.getSource()==doctor_logswitchform) {
	    		doctor_login.setVisible(false);
	    		doctor_register.setVisible(true);
	    	}
	    	
	    	if(event.getSource()==doctor_switchform){
	    		doctor_login.setVisible(true);
	    		doctor_register.setVisible(false);
	    	}
	    }
		
		
		
		
		
		
		//patient tab
		@FXML
	    void loginshowPasswordpatient(ActionEvent event) {
	        if (patient_logcheckbox.isSelected()) {
	            // Kada je checkbox selektovan, prikazujemo lozinku u tekstualnom polju za prikazivanje
	        	patient_logshowpass.setText(patient_passwordlog.getText()); 
	        	patient_logshowpass.setVisible(true);
	            patient_passwordlog.setVisible(false);
	        } else {
	        	patient_passwordlog.setText(patient_logshowpass.getText());
	            // Ako checkbox nije selektovan, skrivate lozinku u prikazu
	        	patient_logshowpass.setVisible(false);
	        	patient_passwordlog.setVisible(true);
	        }
	    }
		
		@FXML
	    void registershowPasswordpatient(ActionEvent event) {
	    	if(patient_checkregpass.isSelected()) {
	    		patient_regshowpassword.setText(patient_regpassword.getText());
	    		patient_regshowpassword.setVisible(true);
	    		patient_regpassword.setVisible(false);
	    	}
	    	else {
	    		patient_regpassword.setText(patient_regshowpassword.getText());
	    		patient_regshowpassword.setVisible(false);
	    		patient_regpassword.setVisible(true);
	    	}
	    }
		
		@FXML
	    void switchformpatient(ActionEvent event) {
	    	if(event.getSource()==patient_logswitchform) {
	    		patient_login.setVisible(false);
	    		patient_register.setVisible(true);
	    	}
	    	
	    	if(event.getSource()==patient_regswitchform){
	    		patient_login.setVisible(true);
	    		patient_register.setVisible(false);
	    	}
	    }
		
		@FXML
	    public void comboboxpatient() {
	        String selectedOption = patient_combobox.getValue();
	        if (selectedOption == null) {
	            selectedOption = "Select User";  // Ili neka druga odgovarajuća vrednost
	        }else {
	        switch (selectedOption) {
	        case "Admin Page":
	            	admin_page.setDisable(false);
	            	admin_page.setVisible(true);
	            	doctor_page.setDisable(true);
	            	doctor_page.setVisible(false);
	            	patient_page.setDisable(true);
	            	patient_page.setVisible(false);
	            	break;
	            	
	        case "Doctor Portal":           		
	            	doctor_page.setDisable(false);
	            	doctor_page.setVisible(true);
	            	admin_page.setDisable(true);
	            	admin_page.setVisible(false);
	            	patient_page.setDisable(true);
	            	patient_page.setVisible(false);
	            	break;
	        }
	        if (!"Select User".equals(selectedOption)) {
	        patient_combobox.setValue("Select User");
	        }
	  }
		}
		
		@FXML
	    void loginAccountpatient(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	if(patient_idlogin.getText().isEmpty() || patient_passwordlog.getText().isEmpty()) {
				alert.errorMessage("Incorrect username/password!");
			}else {
				String checkdoctor = "SELECT * FROM patient WHERE patient_id = ? AND password = ? AND date_delete IS NULL";
				connect();
				
				String enteredPassword;

				// Provera koje polje je aktivno
				if (doctor_chechshowpass.isVisible()) {
				    enteredPassword = patient_passwordlog.getText();
				} else {
				    enteredPassword = patient_logshowpass.getText();
				}
				
				try {
		            preparedStatement = connect.prepareStatement(checkdoctor);
		            preparedStatement.setString(1, patient_idlogin.getText());
		            preparedStatement.setString(2, enteredPassword);
		            resultSet = preparedStatement.executeQuery();
		            
		            if(resultSet.next()) {
		            	
                        Data.patient_id=patient_idlogin.getText();
                        System.out.println(Data.patient_id);
		            	
		            	alert.successMessage("Login successfully");
		            	Parent root=FXMLLoader.load(getClass().getResource("PatientMainForm.fxml"));
		            	Stage stage=new Stage();
		            	stage.setTitle("Hospital Managment System | Patient Portal");
		            	stage.setScene(new Scene(root));
		            	stage.show();
		            	
		            	admin_logbtn.getScene().getWindow().hide();
		            }
		            else {
		            	alert.errorMessage("Incorrect username/password!");
		            }
		            
		        
		            
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		@FXML
	    void registerAccountpatient(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	if (patient_patientidreg.getText().isEmpty() || patient_fullnamereg.getText().isEmpty() || patient_regphone.getText().isEmpty() || patient_regpassword.getText().isEmpty() || patient_regshowpassword.getText().isEmpty())
	    	{
		        alert.errorMessage("Please fill all blank fields");
	    	}
	    	else {
	    		String checkdocID="Select * from patient where patient_id=?";
	    		connect();
	    		try {
	    			preparedStatement = connect.prepareStatement(checkdocID);
		            preparedStatement.setString(1,patient_patientidreg.getText());
		            resultSet = preparedStatement.executeQuery();
		            
		            if(!patient_regshowpassword.isVisible()) {
		            	if(!patient_regshowpassword.getText().equals(patient_regpassword.getText())) {
		            		patient_regshowpassword.setText(patient_regpassword.getText());
		            	}else if(!patient_regpassword.getText().equals(patient_regshowpassword.getText())){
		            		patient_regpassword.setText(patient_regshowpassword.getText());
		            	}
		            	else {
		            		patient_regpassword.clear();
		            		patient_regshowpassword.clear();
		            	}
		            }
		            
		            if (resultSet.next()) {
		                alert.errorMessage(patient_patientidreg.getText() + " is already taken!");
		                
		            }
		            
		            //lozinka mora imati barem 8 karaktera
		            else if(patient_regpassword.getLength()<=8) {
		            	alert.errorMessage("Password should have at least 8 characters!");
		            } 
		            
		            else {
		                // Priprema INSERT upita
		                String insertQuery = "INSERT INTO patient(patient_id,full_name,password,phone_number,date) VALUES (?, ?, ?, ?,?)";
		                preparedStatement = connect.prepareStatement(insertQuery);

		                Date date = new Date();
		                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		                preparedStatement.setString(4, patient_regphone.getText());
		                preparedStatement.setString(2, patient_fullnamereg.getText());
		                preparedStatement.setString(1, patient_patientidreg.getText());
		                preparedStatement.setString(3, patient_regpassword.getText());
		                preparedStatement.setDate(5, sqlDate);
		                
		                int rowsInserted = preparedStatement.executeUpdate();
		                if (rowsInserted > 0) {
		                    alert.successMessage("Registered successfully!");
		                }
		                
		                emptyfields();
		                
		                patient_login.setVisible(true);
		                patient_register.setVisible(false);
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (resultSet != null) resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connect != null) connect.close();
		        }
	    	}
	    }
		
//		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

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
		
		private void enlargeTextField(TextField textField) {
		    // Animacija za povećanje TextField-a
		    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), textField);
		    scaleTransition.setToX(1.07);  // Povećaj TextField za 7% u širinu
		    scaleTransition.setToY(1.07);  // Povećaj TextField za 7% u visinu
		    scaleTransition.play();
		}

		private void resetTextFieldSize(TextField textField) {
		    // Animacija za vraćanje TextField-a na originalnu veličinu
		    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), textField);
		    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
		    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
		    scaleTransition.play();
		}
		
		
		private void enlargeCB(ComboBox<String> cb) {
		    // Animacija za povećanje TextField-a
		    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), cb);
		    scaleTransition.setToX(1.075);  // Povećaj TextField za 7% u širinu
		    scaleTransition.setToY(1.075);  // Povećaj TextField za 7% u visinu
		    scaleTransition.play();
		}
	

		private void resetCB(ComboBox<String> cb) {
		    // Animacija za vraćanje TextField-a na originalnu veličinu
		    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), cb);
		    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
		    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
		    scaleTransition.play();
		}
		
		private void enlargeCBSH(CheckBox cb) {
		    // Animacija za povećanje TextField-a
		    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), cb);
		    scaleTransition.setToX(1.075);  // Povećaj TextField za 7% u širinu
		    scaleTransition.setToY(1.075);  // Povećaj TextField za 7% u visinu
		    scaleTransition.play();
		}

		private void resetCBSH(CheckBox cb) {
		    // Animacija za vraćanje TextField-a na originalnu veličinu
		    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(150), cb);
		    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
		    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
		    scaleTransition.play();
		}

		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			comboboxdoctor();
			initialize();
			comboboxadmin();
			comboboxpatient();

			//doctor login
			doctor_loginbtn.setOnMouseEntered(event -> enlargeButton(doctor_loginbtn));
			doctor_loginbtn.setOnMouseExited(event -> resetButtonSize(doctor_loginbtn));
			
			doctor_idlogin.setOnMouseEntered(event -> enlargeTextField(doctor_idlogin));
		    doctor_idlogin.setOnMouseExited(event -> resetTextFieldSize(doctor_idlogin));
		    
		    doctor_logpassword.setOnMouseEntered(event -> enlargeTextField(doctor_logpassword));
		    doctor_logpassword.setOnMouseExited(event -> resetTextFieldSize(doctor_logpassword));
		    
		    doctor_logshowpass.setOnMouseEntered(event -> enlargeTextField(doctor_logshowpass));
		    doctor_logshowpass.setOnMouseExited(event -> resetTextFieldSize(doctor_logshowpass));
		    
		    doctor_comboboxlog.setOnMouseEntered(event -> enlargeCB(doctor_comboboxlog));
		    doctor_comboboxlog.setOnMouseExited(event -> resetCB(doctor_comboboxlog));
		    
		    doctor_chechshowpass.setOnMouseEntered(event -> enlargeCBSH(doctor_chechshowpass));
		    doctor_chechshowpass.setOnMouseExited(event -> resetCBSH(doctor_chechshowpass));

		    //doctor register
		    doctor_idregister.setOnMouseEntered(event -> enlargeTextField(doctor_idregister));
		    doctor_idregister.setOnMouseExited(event -> resetTextFieldSize(doctor_idregister));
		    
		    doctor_regfullname.setOnMouseEntered(event -> enlargeTextField(doctor_regfullname));
		    doctor_regfullname.setOnMouseExited(event -> resetTextFieldSize(doctor_regfullname));
		    
		    doctor_regemail.setOnMouseEntered(event -> enlargeTextField(doctor_regemail));
		    doctor_regemail.setOnMouseExited(event -> resetTextFieldSize(doctor_regemail));
		    
		    doctor_passwordreg.setOnMouseEntered(event -> enlargeTextField(doctor_passwordreg));
		    doctor_passwordreg.setOnMouseExited(event -> resetTextFieldSize(doctor_passwordreg));
		    
		    doctor_regshowpassword.setOnMouseEntered(event -> enlargeTextField(doctor_regshowpassword));
		    doctor_regshowpassword.setOnMouseExited(event -> resetTextFieldSize(doctor_regshowpassword));
		    
		    doctor_registerbtn.setOnMouseEntered(event -> enlargeButton(doctor_registerbtn));
		    doctor_registerbtn.setOnMouseExited(event -> resetButtonSize(doctor_registerbtn));
		    
		    doctor_showpassreg.setOnMouseEntered(event -> enlargeCBSH(doctor_showpassreg));
		    doctor_showpassreg.setOnMouseExited(event -> resetCBSH(doctor_showpassreg));
		    
		    //admin login
		    admin_logbtn.setOnMouseEntered(event -> enlargeButton(admin_logbtn));
		    admin_logbtn.setOnMouseExited(event -> resetButtonSize(admin_logbtn));
		    
		    admin_loginusername.setOnMouseEntered(event -> enlargeTextField(admin_loginusername));
		    admin_loginusername.setOnMouseExited(event -> resetTextFieldSize(admin_loginusername));
		    
		    admin_loginpassword.setOnMouseEntered(event -> enlargeTextField(admin_loginpassword));
		    admin_loginpassword.setOnMouseExited(event -> resetTextFieldSize(admin_loginpassword));
		    
		    admin_showpasslog.setOnMouseEntered(event -> enlargeTextField(admin_showpasslog));
		    admin_showpasslog.setOnMouseExited(event -> resetTextFieldSize(admin_showpasslog));
		    
		    admin_comboboxuser.setOnMouseEntered(event -> enlargeCB(admin_comboboxuser));
		    admin_comboboxuser.setOnMouseExited(event -> resetCB(admin_comboboxuser));
		    
		    admin_logshowpass.setOnMouseEntered(event -> enlargeCBSH(admin_logshowpass));
		    admin_logshowpass.setOnMouseExited(event -> resetCBSH(admin_logshowpass));
		    
		    //admin register
		    admin_regusername.setOnMouseEntered(event -> enlargeTextField(admin_regusername));
		    admin_regusername.setOnMouseExited(event -> resetTextFieldSize(admin_regusername));
		    
		    admin_regemail.setOnMouseEntered(event -> enlargeTextField(admin_regemail));
		    admin_regemail.setOnMouseExited(event -> resetTextFieldSize(admin_regemail));
		    
		    admin_regpassword.setOnMouseEntered(event -> enlargeTextField(admin_regpassword));
		    admin_regpassword.setOnMouseExited(event -> resetTextFieldSize(admin_regpassword));
		    
		    admin_regshowpassword.setOnMouseEntered(event -> enlargeTextField(admin_regshowpassword));
		    admin_regshowpassword.setOnMouseExited(event -> resetTextFieldSize(admin_regshowpassword));
		    
		    admin_register.setOnMouseEntered(event -> enlargeButton(admin_register));
		    admin_register.setOnMouseExited(event -> resetButtonSize(admin_register));
		    
		    admin_regshowpass.setOnMouseEntered(event -> enlargeCBSH(admin_regshowpass));
		    admin_regshowpass.setOnMouseExited(event -> resetCBSH(admin_regshowpass));
		    
		    //patient login
		    patient_idlogin.setOnMouseEntered(event -> enlargeTextField(patient_idlogin));
		    patient_idlogin.setOnMouseExited(event -> resetTextFieldSize(patient_idlogin));
		    
		    patient_passwordlog.setOnMouseEntered(event -> enlargeTextField(patient_passwordlog));
		    patient_passwordlog.setOnMouseExited(event -> resetTextFieldSize(patient_passwordlog));
		    
		    patient_logshowpass.setOnMouseEntered(event -> enlargeTextField(patient_logshowpass));
		    patient_logshowpass.setOnMouseExited(event -> resetTextFieldSize(patient_logshowpass));
		    
		    patient_combobox.setOnMouseEntered(event -> enlargeCB(patient_combobox));
		    patient_combobox.setOnMouseExited(event -> resetCB(patient_combobox));
		    
		    patient_logcheckbox.setOnMouseEntered(event -> enlargeCBSH(patient_logcheckbox));
		    patient_logcheckbox.setOnMouseExited(event -> resetCBSH(patient_logcheckbox));
		    
		    patient_logbtn.setOnMouseEntered(event -> enlargeButton(patient_logbtn));
		    patient_logbtn.setOnMouseExited(event -> resetButtonSize(patient_logbtn));

		    //patient register
		    patient_patientidreg.setOnMouseEntered(event -> enlargeTextField(patient_patientidreg));
		    patient_patientidreg.setOnMouseExited(event -> resetTextFieldSize(patient_patientidreg));
		    
		    patient_fullnamereg.setOnMouseEntered(event -> enlargeTextField(patient_fullnamereg));
		    patient_fullnamereg.setOnMouseExited(event -> resetTextFieldSize(patient_fullnamereg));
		    
		    patient_regphone.setOnMouseEntered(event -> enlargeTextField(patient_regphone));
		    patient_regphone.setOnMouseExited(event -> resetTextFieldSize(patient_regphone));
		    
		    patient_regpassword.setOnMouseEntered(event -> enlargeTextField(patient_regpassword));
		    patient_regpassword.setOnMouseExited(event -> resetTextFieldSize(patient_regpassword));
		    
		    patient_regshowpassword.setOnMouseEntered(event -> enlargeTextField(patient_regshowpassword));
		    patient_regshowpassword.setOnMouseExited(event -> resetTextFieldSize(patient_regshowpassword));
		    
		    patient_createaccount.setOnMouseEntered(event -> enlargeButton(patient_createaccount));
		    patient_createaccount.setOnMouseExited(event -> resetButtonSize(patient_createaccount));
		    
		    patient_checkregpass.setOnMouseEntered(event -> enlargeCBSH(patient_checkregpass));
		    patient_checkregpass.setOnMouseExited(event -> resetCBSH(patient_checkregpass));
		}

	    
		
}
