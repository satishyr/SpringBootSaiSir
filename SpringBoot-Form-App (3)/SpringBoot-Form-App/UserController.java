package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pojo.User;

@Controller
public class UserController {

	/**
	 * This method is used to load user reg form
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/registerUser")
	public String loadForm(Model model) {
		User userObj = new User();// form binding obj
		model.addAttribute("user", userObj);// storing in model
		return "userReg";// logical view name
	}

	/**
	 * This method is used to handle user reg form submission
	 * 
	 * @param user
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		System.out.println(user);
		// logic to store in db
		model.addAttribute("succMsg", "Registration Successfull");
		return "userReg";// logical view name
	}

}
