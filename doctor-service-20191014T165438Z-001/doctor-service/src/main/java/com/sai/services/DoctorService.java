package com.sai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.entities.Doctor;
import com.sai.repositories.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	public Doctor fetchDoctorByName(String name) {
		Optional<Doctor> optionalDoct = doctorRepository.findByName(name);
		
		if(optionalDoct.isPresent()) {
			return optionalDoct.get();
		} else {
			return null;
		}
		
	}
	
}
