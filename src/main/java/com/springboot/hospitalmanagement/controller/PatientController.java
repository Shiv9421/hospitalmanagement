package com.springboot.hospitalmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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
import com.springboot.hospitalmanagement.model.Patient;
import com.springboot.hospitalmanagement.service.IAppointmentService;
import com.springboot.hospitalmanagement.service.IDoctorService;
import com.springboot.hospitalmanagement.service.IPatientService;


@Controller
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@Autowired
	private IAppointmentService appointmentService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-patients", method = RequestMethod.GET)
	public String showPatients(ModelMap model) {
		
		model.put("patients", patientService.getPatients());
		// model.put("todos", service.retrieveTodos(name));
		return "list-patients";
	}

	

	@RequestMapping(value = "/add-patient", method = RequestMethod.GET)
	public String showAddPatientsPage(ModelMap model) {
		model.addAttribute("patient", new Patient());
		return "patient";
	}

	@RequestMapping(value = "/delete-patient", method = RequestMethod.GET)
	public String deletePatient(@RequestParam long id) {
		patientService.deletePatient(id);
		// service.deleteTodo(id);
		return "redirect:/list-patients";
	}

	@RequestMapping(value = "/update-patient", method = RequestMethod.GET)
	public String showUpdatePatientPage(@RequestParam long id, ModelMap model) {
		Patient patient = patientService.getPatientById(id).get();
		model.put("patient", patient);
		return "patient";
	}

	@RequestMapping(value = "/update-patient", method = RequestMethod.POST)
	public String updatePatient(ModelMap model, @Valid Patient patient, BindingResult result) {

		if (result.hasErrors()) {
			return "patient";
		}

		
		patientService.updatePatient(patient);
		return "redirect:/list-patient";
	}

	@RequestMapping(value = "/add-patient", method = RequestMethod.POST)
	public String addPatient(ModelMap model, @Valid Patient patient, BindingResult result) {

		if (result.hasErrors()) {
			return "patient";
		}

		
		patientService.savePatient(patient);
		return "redirect:/list-patients";
	}
	

	@RequestMapping(value = "/check-appointments", method = RequestMethod.GET)
	public String getAppointments(@RequestParam long id, ModelMap model) {
		Patient patient = patientService.getPatientById(id).get();
		List<Appointment> appointments = appointmentService.findByPatientName(patient.getPatientName());
		System.out.println(appointments);
		model.put("appointments", appointments);
		// service.deleteTodo(id);
		return "list-appointments";
	}
	
}
