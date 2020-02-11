package com.transport.rto.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.rto.constants.AppConstant;
import com.transport.rto.model.VehicleOwnerAddress;
import com.transport.rto.services.VehicleOwnerAddressService;
/**
 * this Controller is used to handle request which comes for Address related UI 
 * 
 * @author Rituraj
 *
 */
@Controller
public class VehicleOwnerAddressController {

	
	/**
	 * inject service to send the data and get data from database
	 */
	@Autowired
	private VehicleOwnerAddressService service;
	
	/**
	 * this method is used to redirect once user registration successfully 
	 * to redirect to summary related controller to populate the data 
	 * 
	 * @param address
	 * @param ownerkey
	 * @return String 
	 */
	@RequestMapping(value="/saveAddr",method=RequestMethod.POST)
	public String saveAddr(@ModelAttribute("ownerAddr") VehicleOwnerAddress address,@RequestParam("ownerKey") Integer ownerkey) {
		 String regNumber = service.saveOwnerAddr(address, ownerkey);
		return AppConstant.REDIRECT_VEHICLE_SUMMARY+regNumber;
	}
				
} 