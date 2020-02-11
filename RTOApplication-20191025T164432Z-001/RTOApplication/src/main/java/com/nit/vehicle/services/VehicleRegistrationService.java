package com.nit.vehicle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.vehicle.model.VehicleRegistration;
import com.nit.vehicle.repositories.VehicleRegistrationRepository;

@Service
public class VehicleRegistrationService {

	   @Autowired
	 private VehicleRegistrationRepository vehicleRepository;
	   
	   
	   
	   public VehicleRegistration saveRegistrationNumber(VehicleRegistration regno)
	   {
		   return vehicleRepository.save(regno);
	   }
	   
	   
	   public VehicleRegistration getDetailsOfVehicleRegistration(Integer id)
	   {
		    Optional<VehicleRegistration> optional =  vehicleRepository.findById(id);
	       
		      if(optional.isPresent())
		      {
		    	  return optional.get();
		      }
		      
		      //do some exceptional handlign 
		      return new VehicleRegistration();
		      
		    	  
	   
	   }
}
