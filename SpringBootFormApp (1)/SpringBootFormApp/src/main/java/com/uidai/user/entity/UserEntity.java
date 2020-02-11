package com.uidai.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * This class behaves A as Entity which is used to
 * send and get the data from database in object format
 * 
 * @author Rituraj
 *
 */
@Data
@Entity
@Table(name="user_master")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name="user_Id")
	private Integer userId;
	
	@Column(name="user_Name",length = 20)
	private String username;
	
	@Column(name="user_Pazzword",length = 16)
	private String pazzword;
	
	@Column(name="user_Email",length=30)
	private String email;
	
	@Column(name="user_Phno")
	private Long phno;
	
	@Column(name="user_country",length = 20)
	private String country;
	
	@Column(name="active",length = 1)
	private Integer active;
	
}
