package mum.waaproject.controller;

import mum.waaproject.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author sachindra
 *
 */
@Controller
public class HomeController {

	@Autowired
	ProductService productService;
	
	/**
	 * Displays featured products and newly added products
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
	public String helloWorld(Model model){
		model.addAttribute("featureProducts", productService.getFeatureProduct());
		model.addAttribute("newProducts", productService.findAllByOrderByCreatedDateDesc());
		return "home";
	}
}
