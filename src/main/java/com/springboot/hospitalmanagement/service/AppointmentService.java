package com.springboot.hospitalmanagement.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.hospitalmanagement.model.Appointment;
import com.springboot.hospitalmanagement.model.Doctor;
import com.springboot.hospitalmanagement.repository.AppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService{
		
		@Autowired
		private AppointmentRepository bookAppointment;
		
		
		@Override
		public List<Appointment> listAll(){
			List<Appointment> upcomingAppointments = new ArrayList<Appointment>();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();  
		    System.out.println(formatter.format(date));  
			for (Appointment a : bookAppointment.findAll()) {
				
				System.out.println("id: " + a.getId() + "date: " + formatter.format(a.getDate()));
				if ((a.getConfirmed()==null || !a.getConfirmed().contentEquals("Done")) && (a.getDate().after(date) || a.getDate().equals(date))) {
					upcomingAppointments.add(a);
				}
			}
			return upcomingAppointments;
					
		}
		
		@Override
		public void save(Appointment appointment) {
			bookAppointment.save(appointment);
		}
		
		@Override
		public void delete(long id) {
			bookAppointment.deleteById(id);
		}
		
		@Override
		public Optional<Appointment> findById(long id) {
			return bookAppointment.findById(id);
			
		}
		@Override
		public List<Appointment> findByPatientName(String patientName)
		{
			return bookAppointment.findByPatientName(patientName);
		}
		@Override
		public List<Appointment> findByDoctorName(String doctorName)
		{
			return bookAppointment.findByDoctorName(doctorName);
		}

		@Override
		public int setConfirmation(String confirmation, long id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int setPrescription(String confirmation, long id) {
			// TODO Auto-generated method stub
			return 0;
		}

		
		@Override
		public void updateAppointment(Appointment appointment) {
			bookAppointment.save(appointment);
		}
		
}

