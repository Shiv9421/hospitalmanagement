package com.springboot.hospitalmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="appointments")
@DynamicUpdate
public class Appointment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	private String patientName;
	
	private String doctorName;
	
	private Date date;

	private String prescription;
	
	private String confirmed;
	
	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}


	@Override
	public String toString() {
		return "appointment [appointment_id=" + id + ", patientName=" + patientName + ", doctorName="
				+ doctorName + ", date=" + date + ", prescription=" + prescription + "]";
	}

	public Appointment(long appointmentId, String patientName, String doctorName, Date date,
			String prescription,String confirmed) {
		super();
		this.id = appointmentId;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
		this.prescription = prescription;
		this.confirmed=confirmed;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Appointment() {}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}


	
}
