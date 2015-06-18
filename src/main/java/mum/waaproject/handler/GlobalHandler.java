package mum.waaproject.handler;

import javax.servlet.http.HttpServletRequest;

import mum.waaproject.exception.CategoryNotFoundException;
import mum.waaproject.exception.FileUploadException;
import mum.waaproject.exception.ProductNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Contains Exception Handler methods
 * @author sachindra
 *
 */
@ControllerAdvice
public class GlobalHandler {

	/**
	 * Returns error page when ProductNotFoundException occurs
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productNotFound(ProductNotFoundException ex, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notfound-error");
		mv.addObject("message", ex.getMessage());
		return mv;
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ModelAndView productNotFound(CategoryNotFoundException ex, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notfound-error");
		mv.addObject("message", ex.getMessage());
		return mv;
	}
	
	/**
	 * Returns error page when FileUploadException occurs
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(FileUploadException.class)
	public ModelAndView fileUploadError(FileUploadException ex, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload-error");
		mv.addObject("message", ex.getMessage());
		mv.addObject("referred", request.getRequestURL());
		return mv;
	}
}
