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
	
	@RequestMapping(value="/shop", method = RequestMethod.GET)
	public String newProducts(){
		return "shop";
	}
	
	@RequestMapping(value="/productdetail", method = RequestMethod.GET)
	public String manageProducts(){
		return "productdetail";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String mycart(){
		return "login";
	}
	
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public String checkout(){
		return "checkout";
	}
	
	@RequestMapping(value="/contactus", method = RequestMethod.GET)
	public String contactUs(){
		return "contactus";
	}

}
