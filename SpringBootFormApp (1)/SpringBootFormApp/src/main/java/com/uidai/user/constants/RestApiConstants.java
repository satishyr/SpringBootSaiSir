package com.uidai.user.constants;
/**
 * 
 * This interface used to declare constants for rest api call
 * @author Rituraj
 *
 */
public interface RestApiConstants {

	/**
	 * This is for if Custom exception come NOUserFound then send that msg
	 */
	public static final String CUSTOM_EXE_NO_USER="User Data Not Avilable...!!";
	/**
	 * For save user get success message 
	 */
	public final static String SAVE_MSG_kEY="restSaveMSg";
	/**
	 * for getting update msg from cache
	 * 
	 */
	public final static String UPDATE_KEY="updateMsg";
	
	/**
	 * For gtting deleted message from cache
	 */
	
	public static final String DELETE_KEY="deleteMsg";
}
