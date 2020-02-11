package com.sai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.sai.clients.DoctorClient;
import com.sai.entities.Doctor;

@Service
public class PatientService {
	
	@Autowired
	DoctorClient doctorClient;
	
	
	
	public String bookAppointment(String patientName, String doctorName) {
		try {
	    	Doctor doctor = doctorClient.fetchDoctorDetails(doctorName);
	    	return doctor != null ? "Appointment booked" : "Fail to book appointment";
		}catch(Exception e1) { e1.printStackTrace();}
		return null;
	}
	

}
