package mum.waaproject.controller;


import javax.validation.Valid;

import mum.waaproject.model.User;
import mum.waaproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waaproject.enumeration.*;

/**
 * 
 * @author sachindra
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	/**
	 * Displays login form
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String mycart(){
		return "login";
	}
	
	/**
	 * Displays user registration form
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user, Model model){

		model.addAttribute("roles", Role.values());
		return "userregistration";
	}
	
	/**
	 * Adds new user record
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result){
		
		if(result.hasErrors()){
			return "userregistration";
		}else{
			userService.save(user);
			return "registrationsuccess";
		}
	}
	
	/**
	 * Redirects to home page after logout success
	 * @return
	 */
	@RequestMapping("/dologout")
	public String doLogout(){
		return "redirect:/home";
	}

}
