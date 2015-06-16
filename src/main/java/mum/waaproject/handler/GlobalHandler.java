package mum.waaproject.handler;

import mum.waaproject.exception.ProductNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productNotFound(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("not-found-error");
		mv.addObject("errormsg", "{Product.not.found}");
		return mv;
	}
	
}
