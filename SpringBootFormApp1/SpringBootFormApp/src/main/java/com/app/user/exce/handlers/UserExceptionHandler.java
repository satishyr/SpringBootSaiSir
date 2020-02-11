package com.app.user.exce.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * This class used to handle global exception handle
 * for web application 
 * @author satish
 *
 */
@ControllerAdvice
public class UserExceptionHandler {
	
	/**
	 * this is used to generate all exception 
	 * 
	 * @return String 
	 */
	@ExceptionHandler(Exception.class)
	public String  errorHandling() {
		return "errorPage";
	}	
}