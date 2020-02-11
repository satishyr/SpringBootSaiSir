package com.nit.vehicle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.app.constants.AppConstant;
import com.nit.vehicle.model.VehicleReview;
import com.nit.vehicle.services.VehicleReviewService;

@Controller
@RequestMapping("/reviewform")
public class VehicleReviewController {

	
	  @Autowired
	private VehicleReviewService vehicleReviewService;
	
	    
	      @RequestMapping(value="/review" , method = RequestMethod.GET)
	   public String reviewForm(Model model, @RequestParam("oid") Integer ownerId)
	   {
		   
	    	 Integer id= vehicleReviewService.setOwnderId(ownerId);
	    	 System.out.println(id);
	    	 
	    	 VehicleReview  vehicleReview= vehicleReviewService.getVehicleReviewObject();
	    	 
	    	  model.addAttribute("vehicleReview", vehicleReview);
	    	  
		   return AppConstant.VEHICLE_REVIEW_FORM;
	   }
	  
}
