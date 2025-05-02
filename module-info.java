module HospitalManagment {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	requires java.base;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
}
