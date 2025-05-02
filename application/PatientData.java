package application;

import java.sql.Date;

public class PatientData {

	private Integer id;
	private Integer patientID;
	private String password;
	private String fullName;
	private Long mobileNumber;
	private String gender;
	private String address;
	private String image;
	private String description;
	private String diagnosis;
	private String treatment;
	private String doctor;
	private String specialized;
	private Date date;
	private Date dateModify;
	private Date dateDelete;
	private Date date_checkout;
	private String status;
	private Data scheduled;

	public PatientData(Integer id, Integer patientID, String gender, String password, String fullName, Long mobileNumber, String address,
	                   String image, String description, String diagnosis, String treatment, String doctor, String specialized,
	                   Date date, Date dateModify, Date dateDelete, String status) {
	    this.id = id;
	    this.patientID = patientID;
	    this.password = password;
	    this.fullName = fullName;
	    this.mobileNumber = mobileNumber;
	    this.address = address;
	    this.image = image;
	    this.description = description;
	    this.diagnosis = diagnosis;
	    this.treatment = treatment;
	    this.doctor = doctor;
	    this.specialized = specialized;
	    this.date = date;
	    this.dateModify = dateModify;
	    this.dateDelete = dateDelete;
	    this.status = status;
	}
	
	public PatientData(Integer id,Integer patientID, String fullName,String gender, Long mobileNumber, String address, Date date,
			Date dateModify, Date dateDelete, String status) {
		this.id=id;
		this.patientID = patientID;
		this.fullName = fullName;
		this.gender=gender;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.date = date;
		this.dateModify = dateModify;
		this.dateDelete = dateDelete;
		this.status=status;
	}
	
	public PatientData(Integer id,Integer patientID, String fullName, String gender, Long mobileNumber,String description, String address, Date date,
			Date dateModify, Date dateDelete, String status) {
		this.id=id;
		this.patientID = patientID;
		this.fullName = fullName;
		this.gender=gender;
		this.mobileNumber = mobileNumber;
		this.description=description;
		this.address = address;
		this.date = date;
		this.dateModify = dateModify;
		this.dateDelete = dateDelete;
		this.status=status;
	}
	
	public PatientData(Integer patientID, String fullName, String gender, String diagnosis, String doctor, Date date) {
		this.patientID = patientID;
		this.fullName = fullName;
		this.gender = gender;
		this.diagnosis = diagnosis;
		this.doctor = doctor;
		this.date = date;
	}
	
	public PatientData(String description, String diagnosis, String treatment, Date date) {
		super();
		this.description = description;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.date=date;
	}

	public String getFullName() {
	    return fullName;
	}

	public void setFullName(String fullName) {
	    this.fullName = fullName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
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
}
