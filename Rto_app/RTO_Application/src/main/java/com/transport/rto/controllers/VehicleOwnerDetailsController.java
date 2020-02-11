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
import com.transport.rto.model.VehicleOwnerDetails;
import com.transport.rto.services.VehicleOwnerDetailsService;
/**
 * this Controller is used to handle request comes for  VehicleOwnerDetails related Ui
 * 
 * @author Rituraj
 *
 */
@Controller
public class VehicleOwnerDetailsController {
	/**
	 * inject VehicleOwnerDetails service to perform business operation 
	 */
	@Autowired
	private VehicleOwnerDetailsService service;
	
	/**
	 * this is used to populate the initial form when the first request comes in our application
	 * with binding object 
	 * 
	 * @param model
	 * @return String 
	 */
	@RequestMapping("/getForm")
	public String getForm(Model model) {
		VehicleOwnerDetails ownerdetails=new VehicleOwnerDetails();
		model.addAttribute(AppConstant.MODEL_ATTR_KEY_OWNER_DTLS, ownerdetails);
		return AppConstant.LOGICAL_OWNER_DTLS_VIEW;
	}
	
	/**
	 * this method is used to capture the data from VehicleOwnerDetails UI and send that data to service
	 * layer and from that store data in database and we get primary key 
	 * 
	 * @param ownerDtls
	 * @param ownerid
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/saveDtls",method =RequestMethod.POST)
	public String saveOwnerDtls(@ModelAttribute("vehicleOwnerDtls") VehicleOwnerDetails ownerDtls
			,@RequestParam("ownerId") Integer ownerid,Model model) {
			if(ownerid!=null && ownerid>0) {
				ownerDtls.setVhclOwnerid(ownerid);
			}
			VehicleDetails  details=new VehicleDetails();
			System.out.println(ownerDtls);
			Integer vehicleOwnerKey = service.saveOwnerAddr(ownerDtls);
			model.addAttribute(AppConstant.MODEL_ATTR_KEY_FOR_OWNER_PK, vehicleOwnerKey);
			model.addAttribute(AppConstant.MODEL_ATTR_KEY_VEHICLE_DTLS, details);
		return AppConstant.LOGICAL_VEHICLE_DTLS_VIEW;
	}
	/**
	 * This method is used to show VehicleOwnerDetails UI with Data when user 
	 * click on previous hyperlink
	 * @param ownKey
	 * @param model
	 * @return String 
	 */
	@RequestMapping("/prevToOwnerDtls")
	public String getVhclOwnerData(@RequestParam("ownkey") Integer ownKey,Model model) {
		VehicleOwnerDetails ownerdetails=service.findById(ownKey);		
		model.addAttribute(AppConstant.MODEL_ATTR_KEY_OWNER_DTLS, ownerdetails);
		return AppConstant.LOGICAL_OWNER_DTLS_VIEW;
	}
}	