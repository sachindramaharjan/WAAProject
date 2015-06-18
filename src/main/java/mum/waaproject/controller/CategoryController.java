package mum.waaproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import mum.waaproject.model.Category;
import mum.waaproject.service.CategoryService;
import mum.waaproject.service.ProductService;
import mum.waaproject.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@Autowired
	public StoreService storeService;

	@Autowired
	public ProductService productService;

	@RequestMapping
	public String getAll(Model model) {

		model.addAttribute("categoryList", categoryService.findAll());

		return "categories";
	}

	@RequestMapping("/addCategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("rootCategoryList",
				categoryService.getRootCategories());
		// model.addAttribute("storeList", storeService.getAllStores());

		return "addcategory";
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String addCategory(
			@Valid @ModelAttribute("category") Category category,
			HttpServletRequest request, BindingResult result) {

		if (result.hasErrors()) {
			return "addcategory";
		} else {

			categoryService.save(category);
			HttpSession session = request.getSession();
			session.setAttribute("categoryList", categoryService.findAll());
			return "redirect:/category";
		}

	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable("id") int id, Model model,
			HttpServletRequest request) {

		categoryService.delete(id);
		HttpSession session = request.getSession();
		session.setAttribute("categoryList", categoryService.findAll());

	}

}
