package com.nit.vehicle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.app.constants.AppConstant;
import com.nit.generator.RegistrationNumber;
import com.nit.vehicle.model.VehicleDetails;
import com.nit.vehicle.model.VehicleOwnerDetails;
import com.nit.vehicle.model.VehicleRegistration;
import com.nit.vehicle.services.VehicleDetailsService;
import com.nit.vehicle.services.VehicleOwnerDetailsService;
import com.nit.vehicle.services.VehicleRegistrationService;

@Controller
@RequestMapping("/vehicledetail")
public class VehicleDetailsController {

	
	 @Autowired
	private VehicleDetailsService vehicleDetailsService;
	 
	 @Autowired
	 private VehicleRegistrationService vehicleRegistrationService;
	 
	 @Autowired
	 private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	 
	 @RequestMapping(value ="/savevehicledetails", method= RequestMethod.POST)
	public String saveVehicleDetailsService(Model model, @ModelAttribute("vehicleDetails") VehicleDetails vehicleDetails,
			@RequestParam("ownerId") Integer ownerId)
	{
		
		 
	   VehicleOwnerDetails vod=	 vehicleOwnerDetailsService.getVehicleOwnerDetailsById(ownerId);
		      
	   vehicleDetails.setVehicleOwnerDetails(vod);
		 
		 VehicleDetails vehicleDetails1= vehicleDetailsService.saveVehicleDetails(vehicleDetails);
		 
		 System.out.println(vehicleDetails1);
		 
		 RegistrationNumber registrationNumber= new RegistrationNumber();
		 String rno= registrationNumber.generateRegistrationNumber();
		 System.out.println(rno);  
		 
		 VehicleRegistration vehicleRegistration = new VehicleRegistration();
		     vehicleRegistration.setCreateDate(vod.getCreateDate());
		     vehicleRegistration.setUpdateDate(vod.getUpdateDate());
		     vehicleRegistration.setRegDate(vod.getCreateDate());
		     vehicleRegistration.setRegCenter("California");
		     vehicleRegistration.setVehicleOwnerDetails(vod);
		     
		 vehicleRegistration.setVehicleRegistrationNumber(rno);
		 
		 
		 
		 VehicleRegistration  vr = vehicleRegistrationService.saveRegistrationNumber(vehicleRegistration);
		 
		 System.out.println(vr);
          
		       Integer oid=vr.getVehicleOwnerDetails().getOwnerId();
	     	  
		 
		    model.addAttribute("vr", vr);
		    
		    model.addAttribute("oid", oid);
		    return AppConstant.REGISTRATION_SUCCESS;
	}
	 
	 
	
}
