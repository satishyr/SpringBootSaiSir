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
	
	public Doctor fetchDoctorDetails(String url) throws Exception{
		return restTemplate.getForObject(new URI(url),Doctor.class);
	}

}
