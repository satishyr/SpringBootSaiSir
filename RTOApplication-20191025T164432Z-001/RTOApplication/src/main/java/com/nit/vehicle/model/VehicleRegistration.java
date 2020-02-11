package com.nit.vehicle.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="Vehicle_Reg_dtls")
@Entity
public class VehicleRegistration {

	 @Id
	 @Column(name="vehicle_reg_id")
	 @GeneratedValue(strategy = GenerationType.SEQUENCE,
	                 generator = "vehicle_reg_id_generator")
	 @SequenceGenerator(name = "vehicle_reg_id_generator" ,
	                    initialValue = 1,
	                    allocationSize = 1,
	                    sequenceName = "VHCL_REG_ID_SEQ")
	private Integer vehicleRegId;
	 
	 
	 @Column(name="vehilce_reg_number")
	 private String vehicleRegistrationNumber;
 
	   @Column(name="reg_center")
	  private String regCenter;
	 
	  @Column(name="reg_date")
	 private Date regDate;
	 
	  @Column(name="create_dt")
	 private Date createDate;
	  
	  @Column(name="update_date")
	  private Date updateDate;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="vehicle_owner_id", referencedColumnName = "vehicle_owner_id" )
	  private VehicleOwnerDetails vehicleOwnerDetails;

	public Integer getVehicleRegId() {
		return vehicleRegId;
	}

	public void setVehicleRegId(Integer vehicleRegId) {
		this.vehicleRegId = vehicleRegId;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public String getRegCenter() {
		return regCenter;
	}

	public void setRegCenter(String regCenter) {
		this.regCenter = regCenter;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public VehicleOwnerDetails getVehicleOwnerDetails() {
		return vehicleOwnerDetails;
	}

	public void setVehicleOwnerDetails(VehicleOwnerDetails vehicleOwnerDetails) {
		this.vehicleOwnerDetails = vehicleOwnerDetails;
	}

	@Override
	public String toString() {
		return "VehicleRegistration [vehicleRegId=" + vehicleRegId + ", vehicleRegistrationNumber="
				+ vehicleRegistrationNumber + ", regCenter=" + regCenter + ", regDate=" + regDate + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", vehicleOwnerDetails=" + vehicleOwnerDetails + "]";
	}
	 
		 
}
