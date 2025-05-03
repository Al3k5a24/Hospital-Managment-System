package application;

import java.sql.Date;

public class DoctorData {

	private Integer id;
	private Integer doctor_id;
	private String password;
	private String full_name;
	private Long mobileNumber;
	private String email;
	private String gender;
	private String address;
	private String image;
	private String specialized;
	private Date date;
	private Date dateModify;
	private Date dateDelete;
	private String status;
	
	// Konstruktor koji koristi samo osnovne podatke
	public DoctorData(Integer doctor_id, String full_name,String gender, String email, Long mobileNumber,  String address, String specialized, String status) {
	    this.doctor_id = doctor_id;
	    this.full_name = full_name;
	    this.gender = gender;
	    this.email = email;
	    this.mobileNumber = mobileNumber;
	    this.address = address;
	    this.specialized = specialized;
	    this.status = status;
	}

	public DoctorData(Integer id, Integer doctorID, String password, String fullName, Long mobileNumber, String gender,
			String address, String image, String specialized, Date date, Date dateModify, Date dateDelete,
			String status) {
		super();
		this.id = id;
		this.doctor_id = doctor_id;
		this.password = password;
		this.full_name = full_name;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.address = address;
		this.image = image;
		this.specialized = specialized;
		this.date = date;
		this.dateModify = dateModify;
		this.dateDelete = dateDelete;
		this.status = status;
	}
	
	public DoctorData(Integer doctor_id, String full_name, String specialized, String status) {
		super();
		this.doctor_id = doctor_id;
		this.full_name = full_name;
		this.specialized = specialized;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
