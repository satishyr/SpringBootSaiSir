package com.transport.rto.resource.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.transport.rto.model.VehicleDetails;
import com.transport.rto.model.VehicleOwnerAddress;
import com.transport.rto.model.VehicleOwnerDetails;
import com.transport.rto.model.VehicleRegistrationDtls;
import com.transport.rto.resource.binding.VehicleSummary;
import com.transport.rto.resource.services.VehicleSummaryServices;
import com.transport.rto.services.VchlRegistrationDetailsService;
import com.transport.rto.services.VehicleDetailsService;
import com.transport.rto.services.VehicleOwnerAddressService;
import com.transport.rto.services.VehicleOwnerDetailsService;
/**
 * 
 * This is the implementation for Rest Service provide service to rest resource
 * @author Rituraj
 *
 */
@Service
public class VechileSummaryServiceImpl implements VehicleSummaryServices{

	/**
	 * Autowiring or inject the  vhclRegservice to get  registration details 
	 */
	@Autowired
	private VchlRegistrationDetailsService  vhclRegservice;
	
	/**
	 * Autowiring or inject the  vhclDetailService to get vehicle Details 
	 */
	@Autowired
	private VehicleDetailsService  vhclDetailService;
	/**
	 * Autowiring or inject the  vhclOwnerDtls to get vehicle Owner details 
	 */
	@Autowired
	private VehicleOwnerDetailsService vhclOwnerDtls;
	/**
	 * Autowiring or inject the  vhclAddrDts to get vehicle Owner Address details
	 */
	@Autowired
	private VehicleOwnerAddressService vhclAddrDts;
	
	/**
	 * Overide that service class method to other four model service and collect all data
	 * and set in the Vehicle summary class 
	 */
	@Override
	public VehicleSummary findVehicleDetails(String regNum) {
		VehicleSummary summary=new VehicleSummary();
		VehicleRegistrationDtls vechicleData = vhclRegservice.findbyRegNum(regNum);
		Integer vhclOwnerid = vechicleData.getDtlsEntity().getVhclOwnerid();
		VehicleDetails vehicleDetails = vhclDetailService.findVehicleByOwnerId(vhclOwnerid);
		VehicleOwnerDetails ownerDetails = vhclOwnerDtls.findById(vhclOwnerid);
		VehicleOwnerAddress address = vhclAddrDts.findAddrbyOwnerId(vhclOwnerid);
		
		summary.setOwnerDetails(ownerDetails);
		summary.setVhclDtls(vehicleDetails);
		summary.setOwnerAddr(address);
		summary.setRegDlts(vechicleData);
		
		return summary;
	}
	
	
	
}
