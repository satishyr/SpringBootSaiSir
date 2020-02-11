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
	
	@Autowired
	EurekaClient eurekaClient;
	
	
	public String bookAppointment(String patientName, String doctorName) {
		try {
		String doctorServiceURL = prepareDoctorServiceURL(doctorName);
	    if(doctorServiceURL != null) {
	    	Doctor doctor = doctorClient.fetchDoctorDetails(doctorServiceURL);
	    	return doctor != null ? "Appointment booked" : "Fail to book appointment";
	    }
		}catch(Exception e1) { e1.printStackTrace();}
		return null;
	}
	
	private String prepareDoctorServiceURL(String doctorName) {
		Application application = eurekaClient.getApplication("DoctorService");
		List<InstanceInfo> instanceList = application.getInstances();
		if(!instanceList.isEmpty()) {
			InstanceInfo instanceInfo = instanceList.get(0);
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append("http://");
			urlBuilder.append(instanceInfo.getIPAddr());
			urlBuilder.append(":");
			urlBuilder.append(instanceInfo.getPort());
			urlBuilder.append("/doctor?name=");
			urlBuilder.append(doctorName);
			return urlBuilder.toString();
		}else {
			return null;
		}
	}

}
