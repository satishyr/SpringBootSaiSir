package com.sai.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sai.entities.Doctor;

@FeignClient("DoctorService")
public interface DoctorClient {
	
	@GetMapping("/doctor")
	public Doctor fetchDoctorDetails(@RequestParam("name") String name);

}
