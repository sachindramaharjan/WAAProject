package mum.waaproject.controller;

import mum.waaproject.model.Product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@RequestMapping
	public String show(){
		return "products";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String newProductForm(Product product, Model model){
		return "addProduct";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") Product product, BindingResult result, Model model){
		
		System.out.println("description" + product.getDescription());
		
		return "redirect:/home";
	}
	
	
	
}
