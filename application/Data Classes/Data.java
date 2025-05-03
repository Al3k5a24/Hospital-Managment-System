package application;

import java.sql.Date;

public class Data {

	public static String admin_id;
	public static String admin_username;
	
	public static String doctor_id;
	public static String doctor_username;
	
	public static String patient_id;
	
	public static String[] price= {"$","€"};
	
	public static String[] gender={"Male","Female","Others"};
	
	public static String[] status= {"Active","Inactive","Confirm"};
	
	public static String[] adminStatus= {"Active","Inactive",};
	
	public static String[] doctorStatus={"Confirm","not Confirm"};
	
	public static String[] specialization= {"Pediatrician","Neurosurgeon","Cardiologist","Oncologist","Dermatologist","Endocrinologist","Plastic Surgeon"};
	
	public static String path;
	public static String AdminPath;
	
	public static Integer temp_patientID;
	public static String temp_name;
	public static String temp_gender;
	public static Long temp_number;
	public static String temp_address;
	public static String temp_status;
	public static String temp_description;
	public static String temp_image;
	
	
	public static Integer temp_doctorID;
	public static String temp_doctorname;
	public static String temp_doctorgender;
	public static String temp_doctorspecialization;
	public static Long temp_doctornumber;
	public static String temp_doctoraddress;
	public static String temp_doctorstatus;
	public static String temp_doctoremail;
	
	public static Integer temp_appID;
	public static String temp_appName;
	public static String temp_appGender;
	public static String temp_appDescription;
	public static String temp_appDiagnosis;
	public static String temp_appTreatment;
	public static Long temp_appContact;
	public static String temp_appStatus;
	public static Date temp_scheduled;
	public static String temp_appDoctorID;
	public static String temp_appDoctorSpecialization;
	
	public static String temp_checkoutID;
	
}
