package com.nit.vehicle.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.vehicle.model.VehicleCompleteDetails;
import com.nit.vehicle.model.VehicleReview;
import com.nit.vehicle.rest.services.VehicleRestService;

@RestController
@RequestMapping("/restvehicle")
public class VehicleRestController {

	   @Autowired
	  private VehicleRestService vehicleRestService;
	
	      @RequestMapping("/regno")
	public  VehicleCompleteDetails  getAllDetailOfVehicle(@RequestParam("id") String regNo)
	{ 
	    	  
	    	   
	    	  
	    	return  vehicleRestService.getCompleteDetails(regNo);
		
	}
	
	
}
