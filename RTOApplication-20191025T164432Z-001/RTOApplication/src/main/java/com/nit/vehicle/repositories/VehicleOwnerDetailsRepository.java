package com.nit.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.vehicle.model.VehicleOwnerDetails;
import java.lang.Integer;
import java.util.List;


@Repository
public interface VehicleOwnerDetailsRepository   extends JpaRepository<VehicleOwnerDetails, Integer> {

	
	   VehicleOwnerDetails findByOwnerId(Integer ownerid);
}
