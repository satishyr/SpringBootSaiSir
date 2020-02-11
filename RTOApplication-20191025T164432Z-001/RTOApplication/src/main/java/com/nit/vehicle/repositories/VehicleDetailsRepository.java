package com.nit.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.vehicle.model.VehicleDetails;
import com.nit.vehicle.model.VehicleOwnerDetails;
import java.util.List;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer> {


	  VehicleDetails findByVehicleOwnerDetails(VehicleOwnerDetails vehicleownerdetails);
}
