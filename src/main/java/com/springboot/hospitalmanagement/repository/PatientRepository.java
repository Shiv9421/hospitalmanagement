package com.springboot.hospitalmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalmanagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	List<Patient> findAll();
}
