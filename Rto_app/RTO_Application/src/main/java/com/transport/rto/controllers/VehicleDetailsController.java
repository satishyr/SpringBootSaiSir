package com.transport.rto.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.rto.constants.AppConstant;
import com.transport.rto.model.VehicleDetails;
import com.transport.rto.model.VehicleOwnerAddress;
import com.transport.rto.services.VehicleDetailsService;
/**
 * this Controller use to handle the request which comes from VehicleDetails Ui and 
 * also send the data from VehicleDetails Ui
 * 
 * @author Rituraj
 */
@Controller
public class VehicleDetailsController {
	/**
	 * inject VehicleDetailsService to send data for database
	 */
	@Autowired
	private VehicleDetailsService service;
	
	/**
	 * this method is used to capture the data VehicleDetails Ui and service layer
	 *  to store data in database
	 * @param details
	 * @param ownKey
	 * @param model
	 * @return String 
	 */
	@RequestMapping(value="/saveVehicleDtls",method = RequestMethod.POST)
	public String saveVehicleDetails(@ModelAttribute("vehicleDtls") VehicleDetails details,@RequestParam("ownerKey") Integer ownKey,Model model) {
		VehicleOwnerAddress address=new VehicleOwnerAddress();
		Integer vehicleDetails = service.saveVehicleDetails(details, ownKey);
		
		model.addAttribute(AppConstant.MODEL_ATTR_KEY_FOR_OWNER_PK,ownKey);
		model.addAttribute(AppConstant.MODEL_ATTR_KEY_FOR_VHCL_PK,vehicleDetails);
		model.addAttribute(AppConstant.MODEL_ATTR_KEY_OWNER_ADDR_DTLS, address);
		return AppConstant.LOGICAL_OWNER_ADDR_VIEW;
	}
	
	/**
	 * this method is used to fetch the data from service layer and populate on
	 * UI when user click on previous link  
	 * 
	 * @param dtlsKey
	 * @param ownkey
	 * @param model
	 * @return String
	 */
	@RequestMapping("/prevToVehicleDtls")
	public String getVehicleDtls(@RequestParam("dtlsKey") Integer  dtlsKey,@RequestParam("ownerKey") Integer ownkey,Model model) {
		VehicleDetails vehicleDetails = service.getVehicleDetails(dtlsKey);
		model.addAttribute(AppConstant.MODEL_ATTR_KEY_FOR_OWNER_PK,ownkey);
		model.addAttribute(AppConstant.MODEL_ATTR_KEY_VEHICLE_DTLS,vehicleDetails);
		return AppConstant.LOGICAL_VEHICLE_DTLS_VIEW;
	}
	
}
