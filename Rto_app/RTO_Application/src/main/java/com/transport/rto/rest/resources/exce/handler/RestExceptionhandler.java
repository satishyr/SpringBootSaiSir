package com.transport.rto.rest.resources.exce.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * this class is used to global exception handler for rest api
 * @author Rituraj
 *
 */
@RestControllerAdvice
public class RestExceptionhandler {

	/**
	 * this method  is used to provide error response when exception occurred in rest api  
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> excehandle(){
			
		ApiError apiError=new ApiError();
		apiError.setErrorCode(400);
		apiError.setErrorMsg("Some Exception occured try after some time");
		apiError.setDate(new Date());
		return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
	}
}
