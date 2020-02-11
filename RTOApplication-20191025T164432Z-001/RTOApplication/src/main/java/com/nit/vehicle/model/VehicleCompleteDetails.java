package com.nit.vehicle.model;

public class VehicleCompleteDetails {

	
	private VehicleOwnerDetails vehicleOwnerDetails;
	
	private VehicleOwnerAddress vehicleOwnerAddress;
	
	private VehicleDetails vehicleDetails;
	
	private VehicleRegistration vehicleRegistration;

	public VehicleCompleteDetails() {
		super();
	}

	public VehicleOwnerDetails getVehicleOwnerDetails() {
		return vehicleOwnerDetails;
	}

	public void setVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails) {
		this.vehicleOwnerDetails = vehicleOwnerDetails;
	}

	public VehicleOwnerAddress getVehicleOwnerAddress() {
		return vehicleOwnerAddress;
	}

	public void setVehicleOwnerAddress(VehicleOwnerAddress vehicleOwnerAddress) {
		this.vehicleOwnerAddress = vehicleOwnerAddress;
	}

	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public VehicleRegistration getVehicleRegistration() {
		return vehicleRegistration;
	}

	public void setVehicleRegistration(VehicleRegistration vehicleRegistration) {
		this.vehicleRegistration = vehicleRegistration;
	}

	@Override
	public String toString() {
		return "VehicleCompleteDetails [vehicleOwnerDetails=" + vehicleOwnerDetails + ", vehicleOwnerAddress="
				+ vehicleOwnerAddress + ", vehicleDetails=" + vehicleDetails + ", vehicleRegistration="
				+ vehicleRegistration + "]";
	}
	
	
	
}
