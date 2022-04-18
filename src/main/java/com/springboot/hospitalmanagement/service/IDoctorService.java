package com.springboot.hospitalmanagement.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.springboot.hospitalmanagement.model.Doctor;

public interface IDoctorService {

	List<Doctor> getDoctors();
	
	Optional<Doctor> getDoctorById(long id);

	void updateDoctor(Doctor doctor);

	void addDoctor(String name, String spec, Date joiningDate, boolean isDone);

	void deleteDoctor(long id);
	
	void saveDoctor(Doctor doctor);

}