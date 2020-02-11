package com.nit.vehicle.model;

import java.util.Date;

public class VehicleReview {
 
	private Integer id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String  phoneNumber;
	private  Date  dob;
	private Date createDate;
	private Date updateDate;	
	private String  ssno;
	private String   vehicleType;
	private String  manufacturingYear;
	private String  brandName;
	private String  hno;
	private String streetName;
	private String  city;
	private String zipcode;
	private String  registrationNo;
	
	public VehicleReview() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getSsno() {
		return ssno;
	}

	public void setSsno(String ssno) {
		this.ssno = ssno;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", ssno=" + ssno + ", vehicleType=" + vehicleType
				+ ", manufacturingYear=" + manufacturingYear + ", brandName=" + brandName + ", hno=" + hno
				+ ", streetName=" + streetName + ", city=" + city + ", zipcode=" + zipcode + ", registrationNo="
				+ registrationNo + "]";
	}

	    	
}
