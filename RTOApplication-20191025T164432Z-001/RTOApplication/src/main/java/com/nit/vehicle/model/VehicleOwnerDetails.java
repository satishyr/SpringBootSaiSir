package com.nit.vehicle.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name="VEHICLE_OWNER_DTS")
@Entity
public class VehicleOwnerDetails {

	
	  @Id
	  @Column(name= "vehicle_owner_id")
	  @GeneratedValue(strategy = GenerationType.SEQUENCE,
	   generator = "vehicle_owner_id_generator")
	  @SequenceGenerator(name="vehicle_owner_id_generator",
	                     initialValue = 1,
	                     allocationSize = 1,
	                     sequenceName = "VHCL_OWNR_ID_SEQ")
	  private Integer ownerId;
	  
	  
	  @Column(name="first_name")
	  @NotEmpty(message="enter your first name")
	  private String firstName;
	  
	  @Column(name="last_name")
	  @NotEmpty(message = "enter your last name")
	  private String lastName;
	  
	  @Column(name="gender")
	 // @NotEmpty(message="gender must not be empty")
	  private String gender;
	  
	  
	  
	  @Column(name="email")
	  @NotNull
	  @Email(message = "enter valid email id")
	  private String email;
	  
	  @Column(name="phno")
	  @NotNull
	  @NotEmpty(message="phone number must not be empty")
	  @Size(min = 10, max = 10)
	  private String phoneNumber;
	  
	  @Column(name="dob")
	  //@NotEmpty(message ="enter your date of birth")
	  @Temporal(value=TemporalType.DATE)
	  private Date dateOfBirth;
	  
	  @Column(name="ssno")
	  @NotEmpty(message ="must not be null")
	  private String  zzn;
	  
	  
	  @Column(name="create_dt")
	  //@NotEmpty(message = "select your created date ")
	  private Date createDate;

	  @Column(name="update_dt")
	  //@NotEmpty(message= "select your updated date")
	  private Date updateDate;

	  
	      @OneToOne(mappedBy = "vehicleOwnerDetails")
	    // @OneToOne(cascade = CascadeType.ALL)
	  private VehicleOwnerAddress vehicleOwnerAddress;
	  
	        @OneToOne(mappedBy = "vehicleOwnerDetails")
	       // @OneToOne(cascade = CascadeType.ALL)
	         private VehicleDetails vehicleDetails;

	        
	        
	        
	         @OneToOne(mappedBy="vehicleOwnerDetails")
	        private VehicleRegistration vehicleRegistration;
	         
	         
			public VehicleOwnerDetails() {
				super();
			}

			public Integer getOwnerId() {
				return ownerId;
			}

			public void setOwnerId(Integer ownerId) {
				this.ownerId = ownerId;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public String getGender() {
				return gender;
			}

			public void setGender(String gender) {
				this.gender = gender;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getPhoneNumber() {
				return phoneNumber;
			}

			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}

			public Date getDateOfBirth() {
				return dateOfBirth;
			}

			public void setDateOfBirth(Date dateOfBirth) {
				this.dateOfBirth = dateOfBirth;
			}

			public String getZzn() {
				return zzn;
			}

			public void setZzn(String zzn) {
				this.zzn = zzn;
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

			@Override
			public String toString() {
				return "VehicleOwnerDetails [ownerId=" + ownerId + ", firstName=" + firstName + ", lastName=" + lastName
						+ ", gender=" + gender + ", email=" + email + ", phoneNumber=" + phoneNumber + ", dateOfBirth="
						+ dateOfBirth + ", zzn=" + zzn + ", createDate=" + createDate + ", updateDate=" + updateDate
						+ "]";
			}


			 
			
	        
	
}
