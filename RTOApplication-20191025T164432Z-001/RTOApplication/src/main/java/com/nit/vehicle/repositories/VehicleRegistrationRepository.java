package com.nit.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.vehicle.model.VehicleRegistration;
import java.lang.String;
import java.util.List;

@Repository
public interface VehicleRegistrationRepository extends JpaRepository<VehicleRegistration, Integer> {

	   VehicleRegistration findByVehicleRegistrationNumber(String vehicleregistrationnumber);
}
