package com.springboot.hospitalmanagement.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.springboot.hospitalmanagement.model.Patient;

public interface IPatientService {

	List<Patient> getPatients();

	Optional<Patient> getPatientById(long id);

	void updatePatient(Patient patient);

	void addPatient(String name, String address, String mobileNumber);

	void deletePatient(long id);
	
	void savePatient(Patient patient);

}