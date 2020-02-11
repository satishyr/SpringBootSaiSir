package com.transport.rto.model;

import java.util.Date;


import lombok.Data;
/**
 * This class is able to capture all data comes in VehicleOwnerDetails Ui 
 * and send in service to store in database 
 * and used that class refrence in VehicleSummary class to get all details related to owner
 * 
 * @author Rituraj
 *
 */
@Data
public class VehicleOwnerDetails {

	private Integer vhclOwnerid;
	private String fname;
	private String lname;
	private Date dob;
	private String gender;
	private String email;
	private Long phno;
	private String zzn;
}
