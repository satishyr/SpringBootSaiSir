package com.transport.rto.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.rto.constants.AppConstant;
import com.transport.rto.mail.sender.MailSenderUtil;
import com.transport.rto.model.VehicleDetails;
import com.transport.rto.model.VehicleOwnerAddress;
import com.transport.rto.model.VehicleOwnerDetails;
import com.transport.rto.model.VehicleRegistrationDtls;
import com.transport.rto.properties.AppProperties;
import com.transport.rto.services.VchlRegistrationDetailsService;
import com.transport.rto.services.VehicleDetailsService;
import com.transport.rto.services.VehicleOwnerAddressService;
import com.transport.rto.services.VehicleOwnerDetailsService;
/**
 * this Controller is used to handle request for VehicleSummary
 * after filling all form we need show the summary page 
 * with all data
 * @author Rituraj
 *
 */
@Controller
public class VehicleSummaryController {
	/**
	 * inject VchlRegistrationDetailsService for fetching registration related data 
	 */
	@Autowired
	private VchlRegistrationDetailsService  vhclRegservice;
	/**
	 * inject VehicleDetailsService for fetching vehicle Details related data
	 */
	@Autowired
	private VehicleDetailsService  vhclDetailService;
	/**
	 * inject VehicleOwnerDetailsService for fetching vehicleowner dtls related data
	 */
	@Autowired
	private VehicleOwnerDetailsService vhclOwnerDtls;
	/**
	 * inject VehicleOwnerAddressService for fetching vehicleOwnerAddrress related data
	 */
	@Autowired
	private VehicleOwnerAddressService vhclAddrDts;
	/**
	 * inject AppProperties to fetch msg which is available in cache  
	 */
	@Autowired
	private AppProperties props;
	/**
	 * this is used to send all data in with successful registration page and show all data in
	 * tabular format in UI and  
	 * @param regNum
	 * @param model
	 * @return String 
	 */
	/**
	 * inject mail object for sending mail
	 */
	@Autowired
	private MailSenderUtil mailSender;
	
	
	@RequestMapping("/summary")
	public String getAllDetails(@RequestParam("regNum") String regNum,Model model) throws MessagingException {
			VehicleRegistrationDtls vechicleData = vhclRegservice.findbyRegNum(regNum);
				Integer vhclOwnerid = vechicleData.getDtlsEntity().getVhclOwnerid();
				VehicleDetails vehicleDetails = vhclDetailService.findVehicleByOwnerId(vhclOwnerid);
				VehicleOwnerDetails ownerDetails = vhclOwnerDtls.findById(vhclOwnerid);
				VehicleOwnerAddress address = vhclAddrDts.findAddrbyOwnerId(vhclOwnerid);
				
				boolean sendMail = mailSender.sendMail(ownerDetails.getEmail(),address.getCity(),vechicleData.getVehicleRegNumber(),vehicleDetails.getVehicleType());
				
				System.out.println("mail Sending Status===================>"+sendMail);
				String msg = props.getMessages().get(AppConstant.MODEL_ATTR_SUCC_MSG);
				model.addAttribute(AppConstant.MODEL_ATTR_SUCC_MSG_KEY, msg);
				model.addAttribute(AppConstant.MODEL_ATTR_KEY_OWNER_ADDR_DTLS,address);
				model.addAttribute(AppConstant.MODEL_ATTR_KEY_OWNER_DTLS, ownerDetails);
				model.addAttribute(AppConstant.MODEL_ATTR_KEY_VCHL_REG_SUMMARY, vechicleData);
				model.addAttribute(AppConstant.MODEL_ATTR_KEY_VEHICLE_DTLS,vehicleDetails);
		return AppConstant.LOGICAL_VHCL_SUMMARY_VIEW;
	}
}
