package application;

import java.util.Date;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CheckOutPayment implements Initializable {

	@FXML
	private Label checkout_PatDate;
	
	@FXML
	private Button count_btn;

	@FXML
	private DatePicker checkout_PatDatePicker;

	@FXML
	private DatePicker checkout_PatDatePicker2;

	@FXML
	private Label checkout_PatDoctor;

	@FXML
	private ComboBox<String> checkOut_converter;

	@FXML
	private Label checkout_PatID;

	@FXML
	private Label checkout_PatName;

	@FXML
	private Label checkout_PatPrice;

	@FXML
	private Button checkout_PayBtn;

	@FXML
	private Label checkout_TotalDays;

	@FXML
	private Circle checkout_profilepicture;

	private final AlertMessage alert = new AlertMessage();

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
	}

	public void SetText() throws ClassNotFoundException, SQLException {
		String sql = "Select * from patient where patient_id=?";
		connect();

		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, Data.temp_patientID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				checkout_PatID.setText(resultSet.getString("patient_id"));
				checkout_PatName.setText(resultSet.getString("full_name"));
				checkout_PatDoctor.setText(resultSet.getString("doctor"));
				String imagePath = resultSet.getString("image");

				if (imagePath != null && !imagePath.isEmpty()) {
					File file = new File(imagePath);
					if (file.exists()) {
						Image image = new Image(file.toURI().toString(), 316, 124, false, true);
						checkout_profilepicture.setFill(new ImagePattern(image));
					} else {
						System.out.println("Slika ne postoji na putanji: " + imagePath);
					}
				} else {
					System.out.println("Pacijent nema profilnu sliku.");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PaymentConversion() {
		List<String> listS = new ArrayList<>();
		for (String data : Data.price) {
			listS.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listS);
		checkOut_converter.setItems(listData);
	}

	@FXML
	private void calculateDaysBetween() {

		Double price;

		try {
			LocalDate firstDate = checkout_PatDatePicker2.getValue();

			LocalDate secondDate = checkout_PatDatePicker.getValue();

			if (secondDate != null) {
				long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);

				checkout_TotalDays.setText(" " + daysBetween + " day(s)");

				String selectedCurrency = (String) checkOut_converter.getSelectionModel().getSelectedItem(); // Dobija
																												// selektovanu
																												// valutu

				if ("$".equals(selectedCurrency)) {
					price = 24.53;
					checkout_PatPrice.setText(" " + (daysBetween * price) + " $");
				} else if ("€".equals(selectedCurrency)) {
					price = 22.5;
					checkout_PatPrice.setText(" " + (daysBetween * price) + " €");
				} else {
					checkout_PatPrice.setText("Izabrati valutu!");
				}
			} else {
				checkout_TotalDays.setText("Izaberite datum u DatePicker-u!");
			}
		} catch (Exception e) {
			checkout_TotalDays.setText("Greška pri unosu datuma!");
			e.printStackTrace();
		}
	}
	
	public void insertDataPay() throws ClassNotFoundException, SQLException {
	    String sql = "INSERT INTO payment(patient_id, total_days, total_price, date, date_checkout, doctor) VALUES(?,?,?,?,?,?)";
	    connect();
	    
	    try {
	        preparedStatement = connect.prepareStatement(sql);
	        
	        // Postavljanje parametara za SQL upit
	        preparedStatement.setString(1, checkout_PatID.getText());
	        preparedStatement.setString(2, checkout_TotalDays.getText());
	        preparedStatement.setString(3, checkout_PatPrice.getText());

	        Date date = new Date();
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	        preparedStatement.setDate(4, sqlDate);

	        LocalDate localDate = checkout_PatDatePicker.getValue();
	        java.sql.Date sqlDatePicker = java.sql.Date.valueOf(localDate);
	        preparedStatement.setDate(5, sqlDatePicker);

	        preparedStatement.setString(6, checkout_PatDoctor.getText());

	        // Izvršavanje upita
	        int update = preparedStatement.executeUpdate();
	        
	        if (update > 0) {
	            alert.successMessage("Payment data inserted successfully!");
	        } else {
	            alert.errorMessage("Failed to insert payment data!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Zatvori resurse u finally bloku
	        if (preparedStatement != null) preparedStatement.close();
	        if (connect != null) connect.close();
	    }
	}

	public void payBtn() throws ClassNotFoundException, SQLException {
	    if (checkout_PatID.getText().isEmpty() ||
	        checkout_PatName.getText().isEmpty() || 
	        checkout_PatDoctor.getText().isEmpty() || 
	        checkout_PatDatePicker2.getValue() == null ||
	        checkout_PatDatePicker.getValue() == null ||
	        checkout_TotalDays.getText().isEmpty() ||
	        checkout_PatPrice.getText().isEmpty()) {
	        
	        alert.errorMessage("Please fill all blank fields!");
	    } else {
	        String sql = "SELECT * FROM patient WHERE patient_id=?";
	        connect();
	        
	        try {
	            preparedStatement = connect.prepareStatement(sql);
	            preparedStatement.setString(1, checkout_PatID.getText());
	            resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                String deletePatient = "UPDATE patient SET date_delete=?,status_payment=? WHERE patient_id=?";
	                preparedStatement = connect.prepareStatement(deletePatient);

	                Date date = new Date();
	                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

	                preparedStatement.setDate(1, sqlDate);
	                preparedStatement.setString(2,"Paid");
	                preparedStatement.setString(3, checkout_PatID.getText());

	                int deletedPatient = preparedStatement.executeUpdate();
	                
	                if (deletedPatient > 0) {
	                    // Pozovi insertDataPay() nakon što je pacijent izbrisan
	                    insertDataPay();
	                    alert.successMessage("Patient has paid: " + checkout_PatPrice.getText() + " ");
	                    checkout_PayBtn.getScene().getWindow().hide();
	                } else {
	                    alert.errorMessage("Something went wrong!");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Zatvori resurse
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connect != null) connect.close();
	        }
	    }
	}
	
//	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
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
	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(130), button);
	    scaleTransition.setToX(1.10);  // Povećaj za 10% u širinu
	    scaleTransition.setToY(1.10);  // Povećaj za 10% u visinu
	    scaleTransition.play();
	}

	private void resetButtonSize(Button button) {
	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(130), button);
	    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
	    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
	    scaleTransition.play();
	}
	
	private void enlargeCB(ComboBox<String> cb) {
	    // Animacija za povećanje TextField-a
	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(130), cb);
	    scaleTransition.setToX(1.075);  // Povećaj TextField za 7% u širinu
	    scaleTransition.setToY(1.075);  // Povećaj TextField za 7% u visinu
	    scaleTransition.play();
	}


	private void resetCB(ComboBox<String> cb) {
	    // Animacija za vraćanje TextField-a na originalnu veličinu
	    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(130), cb);
	    scaleTransition.setToX(1);  // Vraćanje na originalnu širinu
	    scaleTransition.setToY(1);  // Vraćanje na originalnu visinu
	    scaleTransition.play();
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		PaymentConversion();
		
		checkout_PayBtn.setOnMouseEntered(event -> enlargeButton(checkout_PayBtn));
		checkout_PayBtn.setOnMouseExited(event -> resetButtonSize(checkout_PayBtn));
		
		count_btn.setOnMouseEntered(event -> enlargeButton(count_btn));
		count_btn.setOnMouseExited(event -> resetButtonSize(count_btn));
		
		checkout_PatDatePicker2.setOnMouseEntered(event -> enlargeDatePicker(checkout_PatDatePicker2));
		checkout_PatDatePicker2.setOnMouseExited(event -> resetDatePicker(checkout_PatDatePicker2));
		
		checkout_PatDatePicker.setOnMouseEntered(event -> enlargeDatePicker(checkout_PatDatePicker));
		checkout_PatDatePicker.setOnMouseExited(event -> resetDatePicker(checkout_PatDatePicker));
		 
		checkOut_converter.setOnMouseEntered(event -> enlargeCB(checkOut_converter));
		checkOut_converter.setOnMouseExited(event -> resetCB(checkOut_converter));
		
		try {
			SetText();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
