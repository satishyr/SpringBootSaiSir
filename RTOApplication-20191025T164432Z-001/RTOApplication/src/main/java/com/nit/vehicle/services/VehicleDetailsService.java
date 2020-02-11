package com.nit.vehicle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.vehicle.model.VehicleDetails;
import com.nit.vehicle.repositories.VehicleDetailsRepository;

@Service
public class VehicleDetailsService {

	
	       @Autowired
	    private VehicleDetailsRepository vehicleDetailsRepository;
	       
	       
	       public VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails)
	       {
                     return  vehicleDetailsRepository.save(vehicleDetails);	    	   
	       }
	       
	       
	       public VehicleDetails getVehicleDetailsById(Integer id)
	       {
	    	 Optional<VehicleDetails> optional= vehicleDetailsRepository.findById(id);
   
	    	   if(optional.isPresent())
	    	   {
	    		   return optional.get();
	    	   }
	       //do some exceptional handling 
	    	   
	            return new VehicleDetails();
	       
	       }
	       
	       
}
