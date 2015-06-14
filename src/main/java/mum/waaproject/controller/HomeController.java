package mum.waaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
	public String helloWorld(){
		return "home";
	}
	
	@RequestMapping(value="/newproducts", method = RequestMethod.GET)
	public String newProducts(){
		return "newproducts";
	}
	
	@RequestMapping(value="/manageproducts", method = RequestMethod.GET)
	public String manageProducts(){
		return "manageproducts";
	}
	
	@RequestMapping(value="/shoppingcart", method = RequestMethod.GET)
	public String mycart(){
		return "shoppingcart";
	}
	
	@RequestMapping(value="/contactus", method = RequestMethod.GET)
	public String contactUs(){
		return "contactus";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}

}
