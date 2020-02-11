package com.nit.vehicle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.vehicle.model.VehicleOwnerAddress;
import com.nit.vehicle.model.VehicleOwnerDetails;
import com.nit.vehicle.repositories.VehicleOwnerAddressRepository;
import com.nit.vehicle.repositories.VehicleOwnerDetailsRepository;


@Service
public class VehicleOwnerAddressService {

	
	 @Autowired
	 private VehicleOwnerAddressRepository vehicleOwnerAddressRepository;
	 
	  @Autowired
	 private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;
	 
	 
	 public VehicleOwnerAddress saveVehicleOwnerAddress(VehicleOwnerAddress vehicleOwnerAddress)
	 {
		/*
		 * int id=1; Optional<VehicleOwnerDetails> optional =
		 * vehicleOwnerDetailsRepository.findById(id); if(optional.isPresent()) {
		 * 
		 * VehicleOwnerDetails vehilceOwnerDetails= optional.get();
		 * vehicleOwnerAddress.setVehicleOwnerDetails(vehilceOwnerDetails);
		 * 
		 * return vehicleOwnerAddressRepository.save(vehicleOwnerAddress); }
		 * 
		 * return new VehicleOwnerAddress();
		 * 
		 */	     
		 
		   return   vehicleOwnerAddressRepository.save(vehicleOwnerAddress);
		
	 }
	 
	 
	 public VehicleOwnerAddress getVehicleOwnderAddressById(Integer id)
	 {
	    Optional<VehicleOwnerAddress> optional= vehicleOwnerAddressRepository.findById(id);
		 
	    if(optional.isPresent())
	    {
	    	 return optional.get();
	    }
	    	//do some exceptional handling here
	    
	    return new VehicleOwnerAddress();
	    
	 }
	 
	 
	 
}
