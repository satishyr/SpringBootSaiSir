package com.app.user.error;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * this is used to return error details for rest api calls 
 * 
 * @author satish
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="api-error")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"error-code","error-desc","date"})
public class ApiError {
	
	@XmlElement(name="error-code")
	@JsonProperty("error-code")
	private Integer errorCode;
	
	@XmlElement(name="error-desc")
	@JsonProperty("error-desc")
	private String  errorDesc;
	
	private Date date;
}
