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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="VEHICLE_OWNER_ADDRESS_DTLS")
public class VehicleOwnerAddress {

	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	                 generator = "address_id_generator")
	@SequenceGenerator(name = "address_id_generator",
	                   initialValue = 1,
	                    allocationSize = 1,
	                    sequenceName = "ADRS_ID_SEQ")
	private Integer aid;
   
	 @Column(name="hno")
	 @NotNull(message =  "must not be null")
	 @NotEmpty(message = "must not be empty")
	private String houseNo;
	
	 @Column(name="street_name")
	 @NotNull(message = "must not be null")
	 @NotEmpty(message = "please enter street name")
	private String streetName;
	
	 @Column(name="city")
	 @NotNull(message = "city name must not be null")
	 @NotEmpty(message ="city name must not be empty")
	private String city;
	
	 @Column(name="zipcode")
	 @NotNull(message ="zip code must not be null")
	 @NotEmpty(message = "zip code must not be empty ")
	 @Size(max = 6, min=6)
	  private String  zipCode;

	  @Column(name="create_date")
	  @Temporal(value=TemporalType.DATE)
	  //@NotEmpty(message="created date must not be empty")
	  private Date createDate;
	 
	  
	   @Column(name="update_date")
	   @Temporal(value=TemporalType.DATE)
	//   @NotEmpty(message="updated date must not empty")
	  private Date updateDate;
	  
	 
	
	  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JoinColumn(name="vehicle_owner_id",
	  referencedColumnName ="vehicle_owner_id") 
	  // @JoinColumn(name="vehicle_owner_id")  
	   private  VehicleOwnerDetails vehicleOwnerDetails;



	public VehicleOwnerAddress() {
		super();
	}



	public Integer getAid() {
		return aid;
	}



	public void setAid(Integer aid) {
		this.aid = aid;
	}



	public String getHouseNo() {
		return houseNo;
	}



	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}



	public String getStreetName() {
		return streetName;
	}



	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
		return "VehicleOwnerAddress [aid=" + aid + ", houseNo=" + houseNo + ", streetName=" + streetName + ", city="
				+ city + ", zipCode=" + zipCode + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", vehicleOwnerDetails=" + vehicleOwnerDetails + "]";
	}



	public VehicleOwnerAddress(Integer aid) {
		super();
		this.aid = aid;
	}


	  
	  
		 }


           

      

