package com.nit.vehicle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.vehicle.model.VehicleDetails;
import com.nit.vehicle.model.VehicleOwnerAddress;
import com.nit.vehicle.model.VehicleOwnerDetails;
import com.nit.vehicle.model.VehicleRegistration;
import com.nit.vehicle.model.VehicleReview;
import com.nit.vehicle.repositories.VehicleDetailsRepository;
import com.nit.vehicle.repositories.VehicleOwnerAddressRepository;
import com.nit.vehicle.repositories.VehicleOwnerDetailsRepository;
import com.nit.vehicle.repositories.VehicleRegistrationRepository;

@Service
public class VehicleReviewService {

	         @Autowired
	     private  VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;
	              
	         @Autowired    
	     private VehicleOwnerAddressRepository vehicleOwnerAddressRepository;
	             
	         @Autowired
	     private VehicleDetailsRepository vehicleDetailsRepository;
	               
	         @Autowired
	     private VehicleRegistrationRepository vehicleRegistrationRepository;
	             
	
	     private  Integer ownerId;
	    
	    public Integer setOwnderId( Integer oid)
	    {
	    	 ownerId=oid;
	    	 return ownerId;
	    }
	    
        
	   // private static VehicleReview vehilceReview=null;
	    
	    
	    public VehicleReview getVehicleReviewObject()
	    {
	    	
	       Optional<VehicleOwnerDetails> optional1=	vehicleOwnerDetailsRepository.findById(ownerId);
	         
	       Optional<VehicleOwnerAddress>  optional2 =vehicleOwnerAddressRepository.findById(ownerId);
	    	
	       Optional<VehicleDetails>  optional3    = vehicleDetailsRepository.findById(ownerId);
	       
	       Optional<VehicleRegistration>  optional4= vehicleRegistrationRepository.findById(ownerId);
	    	                   
	    	if(optional1.isPresent() && optional2.isPresent() && optional3.isPresent() && optional4.isPresent())
	    	{
	    		
	    	VehicleOwnerDetails  vod = optional1.get();
	    	VehicleOwnerAddress voadd=  optional2.get();
	        VehicleDetails  vd       =  optional3.get();
	        VehicleRegistration   vr=   optional4.get();
	     
	         VehicleReview vehicleReview= new VehicleReview();
	         
	         
	  vehicleReview.setFirstName(vod.getFirstName()); 
	  vehicleReview.setLastName(vod.getLastName());
	  vehicleReview.setCity(voadd.getCity());
	  vehicleReview.setBrandName(vd.getVehicleBrand());
	  vehicleReview.setSsno(vod.getZzn());
	  vehicleReview.setGender(vod.getGender());
	  vehicleReview.setEmail(vod.getEmail());
	  vehicleReview.setHno(voadd.getHouseNo());
	  vehicleReview.setCity(voadd.getCity());
	  vehicleReview.setZipcode(voadd.getZipCode());
	  vehicleReview.setRegistrationNo(vr.getVehicleRegistrationNumber());
	  vehicleReview.setCreateDate(vr.getCreateDate());
	  vehicleReview.setUpdateDate(vr.getUpdateDate());
	  
	       
	        
	        System.out.println(vehicleReview);
	        
	        
	        return vehicleReview;
	        	
	    	}
	    	
	    	// here write your custom logic to handle exception
	    	 return new VehicleReview();
	    	
	    	
	    	
	    }
	    
	    
	    
}
