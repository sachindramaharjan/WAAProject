package mum.waaproject.handler;

import javax.servlet.http.HttpServletRequest;

import mum.waaproject.exception.FileUploadException;
import mum.waaproject.exception.ProductNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productNotFound(ProductNotFoundException ex){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notFoundError");
		mv.addObject("errormsg", ex.getMessage());
		return mv;
	}

	@ExceptionHandler(FileUploadException.class)
	public ModelAndView fileUploadError(FileUploadException ex, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload-error");
		mv.addObject("message", ex.getMessage());
		mv.addObject("referred", request.getRequestURL());
		return mv;
	}
	
}
