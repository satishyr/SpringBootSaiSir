package com.uidai.user.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * This class beaves like a cache which get all the message from 
 * yml fle one time and provide to all classes or controllers 
 * multiple time
 *  
 * @author Rituraj
 * 
 *
 */
@Component
@ConfigurationProperties(prefix = "form-app")
@Data
public class AppProperties {
	/**
	 * this variable used to stored all the message which present in yml file 
	 * 
	 */
	private Map<String,String> messages;
	
}
