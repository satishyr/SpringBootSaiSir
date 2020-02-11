package com.app.user.rest.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.constants.RestApiConstants;
import com.app.user.custom.exceptions.NoUserFoundException;
import com.app.user.pojo.User;
import com.app.user.properties.AppProperties;
import com.app.user.service.UserService;
/**
 * This class is work as a restContoller  to perform B2B communication
 * @author satish
 *
 */

@RestController
@RequestMapping("/rest")
public class UserRestController {

	private static final Logger log=LoggerFactory.getLogger(UserRestController.class); 
	@Autowired
	private UserService service;
	@Autowired
	private AppProperties prop; 
	
	/**
	 * get One user based on Primary key
	 * @param uid
	 * @return ResponseEntity
	 * @throws NoUserFoundException
	 */
	@GetMapping(value="/getUserById/{userId}",produces = {"application/json","application/xml"})
	public ResponseEntity<?> getUserById(@PathVariable("userId") Integer uid) throws NoUserFoundException{
		log.info("All Message from cache object:: "+prop);
		ResponseEntity<?> entity=null;	
		User user = service.findUserById(uid);
			if(user!=null) {
				String pwd=user.getPazzword();
				String tempPwd="";
				for(int i=0;i<pwd.length();i++) {
					tempPwd=tempPwd+"*";
				}
				user.setPazzword(tempPwd);
			entity=new ResponseEntity<User>(user,HttpStatus.OK);	
			}
			else {
				throw new NoUserFoundException(RestApiConstants.CUSTOM_EXE_NO_USER);
			}

		return entity;
	}
	
	/**
	 * This is used to getAll Users data
	 *  
	 * @return ResponseEntity(users,status)
	 */
	@GetMapping(value="/getAllUsers",produces = {"application/json","application/xml"})
	public ResponseEntity<List<User>> findAllUser(){
		List<User> users = service.getAllUser();
		users.forEach(user->{
					String pazzword = user.getPazzword();
					String tempPazzword="";
					for(int i=0;i<pazzword.length();i++) {
						tempPazzword=tempPazzword+"*";
					}
					user.setPazzword(tempPazzword);
		});
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	/**
	 * This method is used to delete record based on id
	 * 
	 * @param uid
	 * @return ResponseEntity
	 * @throws NoUserFoundException 
	 */
	@GetMapping("/deleteById/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userId") Integer uid) throws NoUserFoundException{
		User user=service.findUserById(uid);
		if(user!=null) {
			 service.deleteuserFromRestApi(uid);
			String msg=prop.getMessages().get(RestApiConstants.DELETE_KEY);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else {
			throw new  NoUserFoundException(RestApiConstants.CUSTOM_EXE_NO_USER);
		}
	}

	/**
	 *  this is used to update the user data
	 * @param user
	 * @return ResponseEntity
	 * @throws NoUserFoundException 
	 */
	@PostMapping(value="/updateUser",consumes = {"application/json","application/xml"})
	public ResponseEntity<String> updateUser(@RequestBody User user) throws NoUserFoundException{
		Integer userId = user.getUserId();
		ResponseEntity<String> entity=null;
		if(userId!=null) {
			User userdetail = service.findUserById(userId);
			if(userdetail!=null) {
				User user2 = service.UpdateUser(userdetail);
				entity=new ResponseEntity<String>(prop.getMessages().get(RestApiConstants.UPDATE_KEY)+user2.getUserId(),HttpStatus.OK);
			}
		}
		else {
			throw new NoUserFoundException(RestApiConstants.CUSTOM_EXE_NO_USER);
		}
		return entity;
	}
	
	@PostMapping(value="/saveUser",consumes = {"application/json","application/xml"} )
	public ResponseEntity<String> saveUser(@RequestBody User user){
		Integer userId = service.saveUserEntity(user);
		String msg=prop.getMessages().get(RestApiConstants.SAVE_MSG_kEY)+"::"+userId;
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
}
