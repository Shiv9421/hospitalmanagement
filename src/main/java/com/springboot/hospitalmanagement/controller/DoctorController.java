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
import com.springboot.hospitalmanagement.service.IAppointmentService;
import com.springboot.hospitalmanagement.service.IDoctorService;


@Controller
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-doctors", method = RequestMethod.GET)
	public String showDoctors(ModelMap model) {
		
		model.put("doctors", doctorService.getDoctors());
		// model.put("todos", service.retrieveTodos(name));
		return "list-doctors";
	}

	

	@RequestMapping(value = "/add-doctor", method = RequestMethod.GET)
	public String showAddDoctorPage(ModelMap model) {
		model.addAttribute("doctor", new Doctor());
		return "doctor";
	}

	@RequestMapping(value = "/delete-doctor", method = RequestMethod.GET)
	public String deleteDoctor(@RequestParam long id) {
		doctorService.deleteDoctor(id);
		// service.deleteTodo(id);
		return "redirect:/list-doctors";
	}

	@RequestMapping(value = "/update-doctor", method = RequestMethod.GET)
	public String showUpdateDoctorPage(@RequestParam long id, ModelMap model) {
		Doctor doctor = doctorService.getDoctorById(id).get();
		model.put("doctor", doctor);
		return "doctor";
	}

	@RequestMapping(value = "/update-doctor", method = RequestMethod.POST)
	public String updateDoctor(ModelMap model, @Valid Doctor doctor, BindingResult result) {

		if (result.hasErrors()) {
			return "doctor";
		}

		
		doctorService.updateDoctor(doctor);
		return "redirect:/list-doctors";
	}

	@RequestMapping(value = "/add-doctor", method = RequestMethod.POST)
	public String addDoctor(ModelMap model, @Valid Doctor doctor, BindingResult result) {

		if (result.hasErrors()) {
			return "doctor";
		}

		
		doctorService.saveDoctor(doctor);
		return "redirect:/list-doctors";
	}
	
	@RequestMapping(value = "/get-appointments", method = RequestMethod.GET)
	public String getAppointments(@RequestParam long id, ModelMap model) {
		Doctor doctor = doctorService.getDoctorById(id).get();
		List<Appointment> appointments = appointmentService.findByDoctorName(doctor.getDoctorName());
		System.out.println(appointments);
		model.put("appointments", appointments);
		// service.deleteTodo(id);
		return "list-appointments";
	}
	
	

	
}
