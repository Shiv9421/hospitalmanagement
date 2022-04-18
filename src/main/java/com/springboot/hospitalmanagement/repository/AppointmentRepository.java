package com.springboot.hospitalmanagement.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.hospitalmanagement.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
	
	
	List<Appointment> findByDoctorName(String doctorName);
	
	
	List<Appointment> findByPatientName(String patientName);
	
}
