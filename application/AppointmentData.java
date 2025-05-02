package application;

import java.sql.Date;

public class AppointmentData {

	private Integer appointmentID;
	private Integer patientID;
	private String name;
	private String gender;
	private String description;
	private String diagnosis;
	private String treatment;
	private Long mobileNumber;
	private String address;
	private Date date;
	private Date dateModify;
	private Date dateDelete;
	private String status;
	private String doctorID;
	private String specialized;
	private Date schedule;

	public AppointmentData(Integer appointmentID,String name,String gender,
			Long mobileNumber,String description,String diagnosis,String treatment,
			String address,Date date,Date dateModify,
			Date dateDelete,String status,Date schedule) {		
		this.appointmentID=appointmentID;
		this.name=name;
		this.gender=gender;
		this.mobileNumber=mobileNumber;
		this.description=description;
		this.diagnosis=diagnosis;
		this.treatment=treatment;
		this.address=address;
		this.date=date;
		this.dateModify=dateModify;
		this.dateDelete=dateDelete;
		this.status=status;
		this.schedule=schedule;
	}
	
	public AppointmentData(Integer appointmentID,String name,String description,Date date,String status) {
		this.appointmentID=appointmentID;
		this.name=name;
		this.description=description;
		this.date=date;
		this.status=status;
	}

	public AppointmentData(Integer appointmentID, String name, String gender, String description, String diagnosis , String treatment,Long mobileNumber,
			Date date, Date dateModify, Date dateDelete, String status,String doctorID, String specialized ) { 
		super();
		this.appointmentID = appointmentID;
		this.name = name;
		this.gender = gender;
		this.description = description;
		this.diagnosis=diagnosis;
		this.treatment=treatment;
		this.mobileNumber = mobileNumber;
		this.date = date;
		this.dateModify = dateModify;
		this.dateDelete = dateDelete;
		this.status = status;
		this.doctorID=doctorID;
		this.specialized=specialized;
	}

	public AppointmentData(Integer appointmentID, String description, String diagnosis, String treatment,
			String doctorID, Date schedule) {
		super();
		this.appointmentID = appointmentID;
		this.description = description;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.doctorID = doctorID;
		this.schedule = schedule;
	}
	
	public Integer getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(Integer appointmentID) {
		this.appointmentID = appointmentID;
	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateModify() {
		return dateModify;
	}

	public void setDateModify(Date dateModify) {
		this.dateModify = dateModify;
	}

	public Date getDateDelete() {
		return dateDelete;
	}

	public void setDateDelete(Date dateDelete) {
		this.dateDelete = dateDelete;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}

	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
	
}
