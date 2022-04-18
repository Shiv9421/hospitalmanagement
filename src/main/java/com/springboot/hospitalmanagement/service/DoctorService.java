package com.springboot.hospitalmanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hospitalmanagement.model.Doctor;
import com.springboot.hospitalmanagement.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Optional<Doctor> getDoctorById(long id) {
		return doctorRepository.findById(id);
		
	}

	
	@Override
	public void updateDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	@Override
	public void addDoctor(String name, String spec, Date joiningDate, boolean isDone) {
		doctorRepository.save(new Doctor(name, spec, joiningDate, isDone));
	}

	@Override
	public void deleteDoctor(long id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		if (doctor.isPresent()) {
			doctorRepository.delete(doctor.get());
		}
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	
}