package com.sai.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.entities.Doctor;
import com.sai.services.DoctorService;

@RestController
public class DoctorResource {

	@Autowired
	DoctorService doctorService;
	
	public Doctor getDoctorByName(@RequestParam("name") String name) {
		return doctorService.fetchDoctorByName(name);
	}
	
}
