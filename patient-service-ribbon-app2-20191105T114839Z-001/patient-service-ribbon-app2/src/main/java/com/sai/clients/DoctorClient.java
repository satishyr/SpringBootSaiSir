package com.sai.clients;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sai.entities.Doctor;

@Component
public class DoctorClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	public Doctor fetchDoctorDetails(String doctorName) throws Exception{
		return restTemplate.getForObject(new URI("http://DoctorService/doctor?name="+doctorName),Doctor.class);
	}

}
