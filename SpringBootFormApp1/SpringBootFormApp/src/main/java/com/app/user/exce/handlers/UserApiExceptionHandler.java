package com.app.user.exce.handlers;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.user.custom.exceptions.NoUserFoundException;
import com.app.user.error.ApiError;
/**
 * This is used to To handle rest Api  related exception 
 * 
 * @author satish
 */
@RestControllerAdvice
public class UserApiExceptionHandler {
	
	/**
	 * this is used if user is not found then return that error message
	 * @return ResponseEntity
	 */
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<ApiError> noUserFound(){
		ApiError apiError=new ApiError(400,"User Record Not Found..!!",new Date());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
	}
	/**
	 * this is used to handle all exception 
	 * because by default  i used parent class for all interface
	 * @return ResponseEntity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> errorMsg() {
		ApiError apiError=new ApiError(400, "Some error occurred Try again", new Date());
		return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
	}
	
}
