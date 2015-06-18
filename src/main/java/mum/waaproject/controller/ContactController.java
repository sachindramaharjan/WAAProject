package mum.waaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author sachindra
 *
 */
@Controller
public class ContactController {
	
	/**
	 * Displays contact us page
	 * @return
	 */
	@RequestMapping(value="/contactus", method = RequestMethod.GET)
	public String contactUs(){
		return "contactus";
	}
}
