package com.nit.vehicle.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.vehicle.model.VehicleCompleteDetails;
import com.nit.vehicle.model.VehicleDetails;
import com.nit.vehicle.model.VehicleOwnerAddress;
import com.nit.vehicle.model.VehicleOwnerDetails;
import com.nit.vehicle.model.VehicleRegistration;
import com.nit.vehicle.repositories.VehicleDetailsRepository;
import com.nit.vehicle.repositories.VehicleOwnerAddressRepository;
import com.nit.vehicle.repositories.VehicleOwnerDetailsRepository;
import com.nit.vehicle.repositories.VehicleRegistrationRepository;
import com.nit.vehicle.services.VehicleRegistrationService;

@Service
public class VehicleRestService {

	   @Autowired
    	private VehicleRegistrationService vehicleRegistrationService;
	
	    @Autowired
	   private VehicleRegistrationRepository vehicleRegistrationRepository;
	    
	     @Autowired
	    private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;
	
	       @Autowired
	      private VehicleOwnerAddressRepository vehicleOwnerAddressRepository;
	     
	       @Autowired
	       private VehicleDetailsRepository vehicleDetailsRepository;
	       
	       
	    public  VehicleCompleteDetails getCompleteDetails(String regNo)
	    {
	    	
	    	
	    VehicleRegistration vehicleRegistration=vehicleRegistrationRepository.findByVehicleRegistrationNumber(regNo);
	    	
	    Integer ownerId= vehicleRegistration.getVehicleOwnerDetails().getOwnerId();
	         
	    VehicleOwnerDetails vehicleOwnerDetails=  vehicleOwnerDetailsRepository.findByOwnerId(ownerId);
	         
	    VehicleOwnerAddress vehicleOwnerAddress=   vehicleOwnerAddressRepository.findByVehicleOwnerDetails(vehicleOwnerDetails);
	       
	    VehicleDetails vehicleDetails=   vehicleDetailsRepository.findByVehicleOwnerDetails(vehicleOwnerDetails);
	    
	    
	     VehicleCompleteDetails vehicleCompleteDetails = new VehicleCompleteDetails();
	     
	     vehicleCompleteDetails.setVehicleDetails(vehicleDetails);
	     vehicleCompleteDetails.setVehicleOwnerAddress(vehicleOwnerAddress);
	     vehicleCompleteDetails.setVehicleOwnerDetails(vehicleOwnerDetails);
	     vehicleCompleteDetails.setVehicleRegistration(vehicleRegistration);
	     
	     
	     return vehicleCompleteDetails;
	    
	    
	    }
	    
	
}
