package com.sai.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.services.PatientService;

@RestController
public class PatientResource {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/patient")
	public String fetchDoctorDetails(@RequestParam("pname") String patientName,@RequestParam("dname")String doctorName) {
		return patientService.bookAppointment(patientName,doctorName);
	}

}
