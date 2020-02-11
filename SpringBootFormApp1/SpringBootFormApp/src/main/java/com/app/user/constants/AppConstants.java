package com.app.user.constants;
/**
 * This Interface used to declare all String Constant
 * 
 * @author satish
 *
 */
public interface AppConstants {
	
	/**
	 * this is used to provide model Object Key
	 */
	public static final String USER_MOD_OBj="user";
	
	/**
	 * 
	 * this is used to use P-R-G pattern to avoid 
	 * double posting problem
	 */
	public static final String PRG_PATTERN_REDIRECT="redirect:getForm";
	
	/**
	 * this is used to provide Logical view name for register page
	 */
	public static final String LOGIC_VIEW_NAME_REG="registerUser";
	
	/**
	 * this is key to sent msg through model Object
	 */
	public static final String MODEL_KEY="msg";
	/**
	 * this is used to get success  Message from map 
	 */
	public static final String SUCC_MSG="succMsg";
	/**
	 * this is used to get Failure Message
	 */
	public static final String FAIL_MSG="failMsg";
	/**
	 * this is used key to send list of all users from model to ui
	 */
	public static final String ALL_USERS_KEY="users";
	/**
	 * this is used to return logical view name to display 
	 * all user list in tabular format 
	 * 
	 */
	public static final String LOGICAL_VIEW_FOR_USER_LIST="usersDetails";
	
	/**
	 * this is used to redirect the link after deletion 
	 * redirect to user list page
	 * 
	 */
	public static final String REDIRECT_USER_LIST="redirect:getAllUsers";
	/**
	 * Logical view name for update record
	 */
	public static final String LoGIC_VIEW_UPDATE_PAGE="editUser";
	/**
	 * 
	 *  Success message Key to get success msg from .yml file
	 */
	public static final String UPDATE_MSG_KEY="updateMsg";	
	/**
	 * Logical view name for pagination Page
	 * 
	 */
	public static final String LOGIC_FOR_PAGINATION_VIEW="serverSidePaginationView";
	
	/**
	 *Sending current page status for Pagination  
	 */
	public static final String CURRENT_PAGE="cp";
	/**
	 * Sending Total page count for generate pagination hyperlink
	 * 
	 */
	public static final String TOTAL_PAGE="tp";
	
	/**
	 *sending redirection view page when we perform deletion 
	 *from server side pagination 
	 */
	public static final String REDIRECT_FOR_PAGINATION_VIEW="redirect:pagination?pn=";
}