package com.springboot.hospitalmanagement.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.springboot.hospitalmanagement.model.Appointment;
import com.springboot.hospitalmanagement.model.Doctor;

public interface IAppointmentService {
	public List<Appointment> listAll();
	
	public void save(Appointment appointment) ;
	
	public void delete(long id);
	
	public int setConfirmation(String confirmation, long id);
	
	public int setPrescription(String confirmation, long id);
	
	public Optional<Appointment> findById(long id);
	
	public List<Appointment> findByPatientName(String patientName);
	
	public List<Appointment> findByDoctorName(String doctorName);
	
	
	
	public void updateAppointment(Appointment appointment);
}