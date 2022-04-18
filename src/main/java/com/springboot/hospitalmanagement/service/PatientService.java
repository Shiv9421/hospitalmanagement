package com.springboot.hospitalmanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hospitalmanagement.model.Patient;
import com.springboot.hospitalmanagement.repository.PatientRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patient> getPatientById(long id) {
		return patientRepository.findById(id);
	}

	@Override
	public void updatePatient(Patient patient) {
		patientRepository.save(patient);
	}

	@Override
	public void addPatient(String name, String address, String mobileNumber) {
		patientRepository.save(new Patient(name, address, mobileNumber));
	}

	@Override
	public void deletePatient(long id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			patientRepository.delete(patient.get());
		}
	}

	@Override
	public void savePatient(Patient patient) {
		patientRepository.save(patient);
	}
}