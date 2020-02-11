package com.app.user.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/**
 * this class is used to sending and recieving the data 
 * from controller to UI
 * 
 * @author satish
 *
 */
@Data
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	private Integer userId;
	private String username;
	private String pazzword; 
	private String email;
	private Long phno;
	private String country;
	@JsonIgnore
	@XmlTransient
	private Integer active;
	
	
}
