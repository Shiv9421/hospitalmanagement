package com.springboot.hospitalmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.hospitalmanagement.model.Appointment;
import com.springboot.hospitalmanagement.model.Doctor;
import com.springboot.hospitalmanagement.service.DoctorService;
import com.springboot.hospitalmanagement.service.IAppointmentService;
import com.springboot.hospitalmanagement.service.IDoctorService;
import com.springboot.hospitalmanagement.service.IPatientService;
import com.springboot.hospitalmanagement.service.PatientService;

@Controller
public class AppointmentController {

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
    private IPatientService patientService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-appointments", method = RequestMethod.GET)
	public String showAppointments(ModelMap model) {
		
		model.put("appointments", appointmentService.listAll());
		// model.put("todos", service.retrieveTodos(name));
		return "list-appointments";
	}

	

	@RequestMapping(value = "/add-appointment", method = RequestMethod.GET)
	public String showAddAppointmentPage(ModelMap model) {
		
		
        model.put("doctorList", doctorService.getDoctors());
        model.put("patientList", patientService.getPatients());
        model.addAttribute("appointment", new Appointment());
		return "appointment";
	}

	@RequestMapping(value = "/delete-appointment", method = RequestMethod.GET)
	public String deleteAppointment(@RequestParam int id) {
		appointmentService.delete(id);
		// service.deleteTodo(id);
		return "redirect:/list-appointments";
	}

	

	@RequestMapping(value = "/add-appointment", method = RequestMethod.POST)
	public String addAppointment(ModelMap model, @Valid Appointment appointment, BindingResult result) {

		if (result.hasErrors()) {
			return "appointment";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
	    
		if (appointment.getDate().before(date)) {
			System.out.println("Appointment cannot be added back dated.");
			return "appointment-error";
		}
		System.out.println("appointment details before posting \n" + appointment);
		List<Appointment> appointments = appointmentService.findByDoctorName(appointment.getDoctorName());
		for (Appointment a : appointments) {
			if (appointment.getDate().equals(a.getDate())) {
				System.out.println("Appointment already exists on the same date");
				return "appointment-error";
			}
		}
		appointmentService.save(appointment);
		return "redirect:/list-appointments";
	}
	
	@RequestMapping(value = "/update-appointment", method = RequestMethod.GET)
	public String showUpdateAppointmentPage(@RequestParam long id, ModelMap model) {
		System.out.println("id: " + id);
		Appointment appointment = appointmentService.findById(id).get();
		
		model.put("appointment", appointment);
		return "appointment";
	}

	@RequestMapping(value = "/update-appointment", method = RequestMethod.POST)
	public String updateAppointment(ModelMap model, @Valid Appointment appointment, BindingResult result) {

		if (result.hasErrors()) {
			return "appointment";
		}

		appointment.setConfirmed("Done");
		System.out.println(appointment);
		appointmentService.updateAppointment(appointment);
		return "redirect:/list-appointments";
	}


}
