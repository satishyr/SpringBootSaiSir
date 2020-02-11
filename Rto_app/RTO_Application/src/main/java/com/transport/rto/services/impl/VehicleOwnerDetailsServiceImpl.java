package com.transport.rto.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.rto.entity.VehicleOwnerDtlsEntity;
import com.transport.rto.model.VehicleOwnerDetails;
import com.transport.rto.repositories.VhclOwnerDtlsRepository;
import com.transport.rto.services.VehicleOwnerDetailsService;
/**
 * this is used to provide implementation for  VehicleOwnerDetailsService 
 * to perform bussiness operation on VehicleOwnerDetails 
 * @author Rituraj
 *
 */
@Service
public class VehicleOwnerDetailsServiceImpl implements VehicleOwnerDetailsService {	
	/**
	 * inject VhclOwnerDtlsRepository object to store data in database
	 */
	@Autowired
	private VhclOwnerDtlsRepository dtls;
	/**
	 * this method is used to store VehicleOwnerDetails data in database with help of repositories
	 */
	@Override
	public Integer saveOwnerAddr(VehicleOwnerDetails details) {
		System.out.println(details);
		VehicleOwnerDtlsEntity dtlsEntity=new VehicleOwnerDtlsEntity();
		BeanUtils.copyProperties(details, dtlsEntity);
		System.out.println(dtlsEntity);
			
		VehicleOwnerDtlsEntity entity = dtls.save(dtlsEntity);
		return entity.getVhclOwnerid();
	}
	/**
	 * this is used to fetch VehicleOwnerDetails based on his primary key value
	 */
	@Override
	public VehicleOwnerDetails findById(Integer id) {
		VehicleOwnerDetails details=new VehicleOwnerDetails();
		Optional<VehicleOwnerDtlsEntity> ownrDtls = dtls.findById(id);
		if(ownrDtls.isPresent()) {
			VehicleOwnerDtlsEntity dtlsEntity = ownrDtls.get();
			BeanUtils.copyProperties(dtlsEntity, details);
			return details;
		}
		else {
		return details;
		}
	}
	
}
