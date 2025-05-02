package application;

import java.util.Date;

public class PaymentData {
 
	private Integer id;
	private Integer patient_id;
	private String total_days;
	private String total_price;
	private Date date;
	private Date date_checkout;
	
	public PaymentData(Integer id, Integer patient_id, String total_days, String total_price, Date date,
			Date date_checkout) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.total_days = total_days;
		this.total_price = total_price;
		this.date = date;
		this.date_checkout = date_checkout;
	}

	public PaymentData(Date date, Date date_checkout) {
		super();
		this.date = date;
		this.date_checkout = date_checkout;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public String getTotal_days() {
		return total_days;
	}

	public void setTotal_days(String total_days) {
		this.total_days = total_days;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate_checkout() {
		return date_checkout;
	}

	public void setDate_checkout(Date date_checkout) {
		this.date_checkout = date_checkout;
	}

}
