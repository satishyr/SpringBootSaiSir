package com.uidai.user.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uidai.user.constants.AppConstants;
import com.uidai.user.pojo.PageDto;
import com.uidai.user.pojo.User;
import com.uidai.user.properties.AppProperties;
import com.uidai.user.service.UserService;
/**
 * This is user Controller to handle All Request
 * and provide Appropriate response
 * 
 * @author Rituraj
 *
 */
@Controller
public class UserController {
	
	/**
	 * to inject cache or yml file message in that class used
	 */
	@Autowired
	private AppProperties props;
	
	/**
	 * 
	 * to inject service class object by using Autowiring
	 */
	@Autowired
	private UserService service;
	/**
	 * 
	 * This Method is used To Display The Form in browser
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value ="/getForm")
	public String getRegForm(Model model) {
		User userObj = new User();
		model.addAttribute(AppConstants.USER_MOD_OBj, userObj);
		loadFormData(model);
		return AppConstants.LOGIC_VIEW_NAME_REG;
	}
	/**
	 * The Method is used take the Form Submission Data Form the Jsp Page
	 * 
	 * @param user
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getUserData(@ModelAttribute("user") User user, RedirectAttributes redirect) {
		System.out.println(user);
		Integer prId = service.saveUserEntity(user);
		if (prId != null) {
			String sucmsg = props.getMessages().get(AppConstants.SUCC_MSG);
			redirect.addFlashAttribute(AppConstants.MODEL_KEY, sucmsg+  prId);
		} else {
			String failmsg = props.getMessages().get(AppConstants.FAIL_MSG);
			redirect.addFlashAttribute(AppConstants.MODEL_KEY, failmsg);
		}
		return AppConstants.PRG_PATTERN_REDIRECT;
	}
	/**
	 * This method is used retrieve all user data
	 * @param model
	 * @return String
	 */	
	@RequestMapping("/getAllUsers")
	public String getAllUsers(Model model) {
			List<User> usersList = service.getAllUser();
			model.addAttribute(AppConstants.ALL_USERS_KEY, usersList);		
		return AppConstants.LOGICAL_VIEW_FOR_USER_LIST;
	}
	/**
	 * this Method is used to delete the recored after deletion it redirection 
	 * to all user list
	 * @param userId
	 * @return String 
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		service.deleteUserByid(userId,1);
		return AppConstants.REDIRECT_USER_LIST;
	}
	/**
	 * Here we use this delete method to perform 
	 * deletion when User click from  server side pagination
	 * 
	 * @param userId
	 * @return String
	 */
	@RequestMapping("/deleteUserFromPage")
	public String deleteUserFromServerSidePage(@RequestParam("userId") Integer userId, @RequestParam("pn")  Integer pageNum)  {
		Integer recPresent = service.deleteUserByid(userId,pageNum);
		if(recPresent==0 && pageNum>1) {
			Integer page=pageNum-1;
			return AppConstants.REDIRECT_FOR_PAGINATION_VIEW+page;
		}
		return AppConstants.REDIRECT_FOR_PAGINATION_VIEW+pageNum;
	}
	/**
	 * 
	 * it is use to ediatbe page for user we get data based on his id
	 * @param userId
	 * @param model
	 * @return String
	 */
	@RequestMapping("/editUser")
	public String editUser(@RequestParam("userId") Integer userId,Model model) {
		User user = service.findUserById(userId);
		model.addAttribute(AppConstants.USER_MOD_OBj, user);
		loadFormData(model);
		return AppConstants.LoGIC_VIEW_UPDATE_PAGE;	
	}
	/**
	 * this is method is used to get user data and update and after that return back
	 * to same with success messages
	 * 
	 * @param user
	 * @param model
	 * @return String constants
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user,Model model) {
		User updatedUser = service.UpdateUser(user);
		String updateMsg = props.getMessages().get(AppConstants.UPDATE_MSG_KEY);
		model.addAttribute(AppConstants.USER_MOD_OBj, updatedUser);
		model.addAttribute(AppConstants.MODEL_KEY ,updateMsg);
		loadFormData(model);
		return AppConstants.LoGIC_VIEW_UPDATE_PAGE;
	}
	/**
	 *
	 *  This method is used to handle Ajax call when user want to view his Data 
	 *  So we use Response body to send data 
	 *  
	 * @param userId
	 * @param model
	 * @return String
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/getOneUser")
	public @ResponseBody String findUserById(@RequestParam("userId") Integer userId) throws JsonProcessingException {
		User user = service.findUserById(userId);
		ObjectMapper mapper=new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);
		return userJson;
	}
	/**
	 *This method is used for Apply Server side pagination  
	 *  
	 * @param model
	 * @return String
	 */
	@RequestMapping("/pagination")
	public String getDataInpagination(Model model,@RequestParam("pn") Integer currpage) {
		int pagesize=4;
		PageDto pageDto = service.serverSidepagination(currpage, pagesize);
		List<User> usersList=pageDto.getList();
		Integer currPage= pageDto.getCurrPage();
		Integer totPage=pageDto.getTotalPage();
		
		model.addAttribute(AppConstants.CURRENT_PAGE, currPage);
		model.addAttribute(AppConstants.TOTAL_PAGE, totPage);
		model.addAttribute(AppConstants.ALL_USERS_KEY, usersList);		
	return AppConstants.LOGIC_FOR_PAGINATION_VIEW;
		
	} 
	/**
	 * This Method is used before populating the form on browser call that method
	 * and give the city name in the form of drop down
	 * 
	 * @param model
	 */
	private void loadFormData(Model model) {
		List<String> countriesList = new ArrayList<>();
		countriesList.add("India");
		countriesList.add("Nepal");
		countriesList.add("USA");
		countriesList.add("China");
		countriesList.add("UK");
		countriesList.add("Germany");
		countriesList.add("Austrila");
		countriesList.add("Denmark");
		model.addAttribute("countries", countriesList);
	}
}