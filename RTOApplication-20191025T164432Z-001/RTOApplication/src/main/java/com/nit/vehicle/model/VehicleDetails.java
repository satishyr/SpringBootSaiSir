package com.nit.vehicle.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="VEHICLE_DTLS")
public class VehicleDetails {

	
	   @Id
	   @Column(name="vehicle_dtl_id")
	   @GeneratedValue(strategy = GenerationType.SEQUENCE,
	                     generator = "vehicle_dtl_id_generator")
	   @SequenceGenerator(name="vehicle_dtl_id_generator",
	                      initialValue = 1,
	                       allocationSize = 1,
	                       sequenceName = "VHCL_DTL_ID_SEQ")
	  private Integer vid;
	  
	    
	   @Column(name="vehicle_type")
	   @NotEmpty(message = "please select your vehicle type")
	  private  String vehicleType;
	  
	    @Column(name= "mfg_year")
	    @NotEmpty(message= "enter vehicle manufacturing year")
	  private String  manufacturingYear;
	  
	    @Column(name="vehicle_brand")
	    @NotEmpty(message="enter brand of vehicle")
	  private String  vehicleBrand;
	    
	    @Column(name="create_dt")
		 // @NotEmpty(message = "select your created date ")
		  private Date createDate;

		  @Column(name="update_dt")
		  //@NotEmpty(message= "select your updated date")
		  private Date updateDate;

	    
	
	  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JoinColumn(name="vehicle_owner_id" , 
	  referencedColumnName ="vehicle_owner_id") 
	     // @JoinColumn(name="vehicle_owner_id")
	      private VehicleOwnerDetails vehicleOwnerDetails;



	public VehicleDetails() {
		super();
	}



	public Integer getVid() {
		return vid;
	}



	public void setVid(Integer vid) {
		this.vid = vid;
	}



	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public String getManufacturingYear() {
		return manufacturingYear;
	}



	public void setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}



	public String getVehicleBrand() {
		return vehicleBrand;
	}



	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
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
		return "VehicleDetails [vid=" + vid + ", vehicleType=" + vehicleType + ", manufacturingYear="
				+ manufacturingYear + ", vehicleBrand=" + vehicleBrand + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", vehicleOwnerDetails=" + vehicleOwnerDetails + "]";
	}



	public VehicleDetails(Integer vid) {
		super();
		this.vid = vid;
	}


	  
}
