package mum.waaproject.validator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String helloWorld(){
		return "home";
	}
}
