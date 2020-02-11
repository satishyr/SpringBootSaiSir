package com.nit.vehicle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.vehicle.model.VehicleOwnerDetails;
import com.nit.vehicle.repositories.VehicleOwnerDetailsRepository;

@Service
public class VehicleOwnerDetailsService {

	    @Autowired
	   private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;
	    
	    
	    public VehicleOwnerDetails saveVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails)
	    {
	    	  return  vehicleOwnerDetailsRepository.save(vehicleOwnerDetails);
	    }
	    
	    
	    public VehicleOwnerDetails getVehicleOwnerDetailsById(Integer id)
	    {
	    Optional<VehicleOwnerDetails> optional
	                          =	vehicleOwnerDetailsRepository.findById(id);
	    if(optional.isPresent())
	    {
	    	  return optional.get();
	    }
	    
	    //here you will do some exceptional handling 
	    return new VehicleOwnerDetails();
	    //List<VehicleOwnerDetails> vehicleOwnerDetailsList=  vehicleOwnerDetailsRepository.findAll();
	    	
	    }
	    
}
