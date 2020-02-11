package com.nit.vehicle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nit.app.constants.AppConstant;
import com.nit.vehicle.model.VehicleOwnerAddress;
import com.nit.vehicle.model.VehicleOwnerDetails;
import com.nit.vehicle.services.VehicleOwnerDetailsService;

@Controller
@RequestMapping("/vehicleownerdetails")
public class VehicleOwnerDetailsController {

	    
	    @Autowired
	   private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	    
	      
	    //@GetMapping("/vehicleownerdetails")
	      @RequestMapping(value="/vehicleownerdetails", method = RequestMethod.GET)
	    public String loadVehicleOwnerDetailsForm(
	    		 Model model)
	    {
	    	VehicleOwnerDetails vehicleOwnerDetails = new VehicleOwnerDetails();
	    	model.addAttribute("vehicleOwnerDetails", vehicleOwnerDetails);
	    	
	    	 return AppConstant.VEHICLE_OWNER_DETAILS;
	    }
	    
	      @RequestMapping(value="/vehicleownerdetails", method=RequestMethod.POST)
	      public String saveVehicleOwnerDetails( Model model, @ModelAttribute("vehicleOwnerDetails") VehicleOwnerDetails vehicleOwnerDetails)
	      {
	    VehicleOwnerDetails vod=	
	    		vehicleOwnerDetailsService.saveVehicleOwnerDetails(vehicleOwnerDetails);
	    
	           Integer ownerId=  vod.getOwnerId();
	    	  System.out.println(vod);
	    	  
	    	      // vod.getOwnerId()
	    	  
	    	    System.out.println(ownerId);
	    	     
	    	         model.addAttribute("ownerId", ownerId);
	    	  VehicleOwnerAddress  vehicleOwnerAddress = new VehicleOwnerAddress();
	    	  model.addAttribute("vehicleOwnerAddress", vehicleOwnerAddress);
	    	  
	    	  return AppConstant.VEHICLE_OWNER_ADDRESS;
	    	  
	      }
}
