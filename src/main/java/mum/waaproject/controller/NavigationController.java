package mum.waaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigationController {
	
	@RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
	public String helloWorld(){
		return "home";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String mycart(){
		return "login";
	}
	
	
	
	@RequestMapping(value="/contactus", method = RequestMethod.GET)
	public String contactUs(){
		return "contactus";
	}
}
