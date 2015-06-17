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
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user, Model model){

		model.addAttribute("roles", Role.values());
		return "userregistration";
	}
	
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result){
		
		if(result.hasErrors()){
			return "userregistration";
		}else{
			userService.save(user);
			return "registrationsuccess";
		}
	}
	
	@RequestMapping("/dologout")
	public String doLogout(){
		return "redirect:/home";
	}
	
	@RequestMapping(value="/securedcontents", method=RequestMethod.GET)
	public String viewSecuredContents(){
		return "securedcontents";
	}

}
