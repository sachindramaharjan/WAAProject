package mum.waaproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mum.waaproject.enumeration.StockStatus;
import mum.waaproject.exception.FileUploadException;
import mum.waaproject.model.Category;
import mum.waaproject.model.Product;
import mum.waaproject.model.Store;
import mum.waaproject.service.CategoryService;
import mum.waaproject.service.ProductService;
import mum.waaproject.service.StoreService;
import mum.waaproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController implements HandlerExceptionResolver  {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private UserService userService;

	@RequestMapping
	public String show(Model model) {
		
		model.addAttribute("products", productService.findAll());
		model.addAttribute("path", servletContext.getRealPath("/resources/images/"));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") int productId) {
		
		Product product = productService.getProductById(productId);
		Store store = storeService.getStoreById(product.getStore().getId());
		Category category = categoryService.getCategoryById(product.getCategory().getId());

		model.addAttribute("product", product);
		model.addAttribute("store", store);
		model.addAttribute("category", category);
		return "productdetail";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String newProductForm(Product product, Model model) {
		
		model = prepareModel(model);

		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") @Valid Product product,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model = prepareModel(model);
			return "addProduct";
		}
		
		System.out.println(product.getCategory().getName());
		
		Category category = categoryService.findOne(Integer.parseInt(product.getCategory().getName()));
		Store store = storeService.findOne(1);
	
		System.out.println("category:" + category);
		
		
		product.setStore(store);
		product.setCategory(category);
		product.setCreatedDate(new Date());
		
		MultipartFile file = product.getImageFile();
		product = fileUpload(file, product);
		
		productService.save(product);

		return "redirect:/products";
	}
	
	public Model prepareModel(Model model){
		Map<String, String> stockStatus = new HashMap<String, String>();
		stockStatus.put(StockStatus.AVAILABLE.name(),
				StockStatus.AVAILABLE.name());
		stockStatus.put(StockStatus.IN_PRODUCTION.name(),
				StockStatus.IN_PRODUCTION.name());
		stockStatus.put(StockStatus.OUTOFSTOCK.name(),
				StockStatus.OUTOFSTOCK.name());

		List<Category> categories = categoryService.findByLeafCategory();

		Map<Integer, String> mapCategory = new HashMap<Integer, String>();
		for (Category c : categories) {
			mapCategory.put(c.getId(), c.getName());
		}
		
		model.addAttribute("categories", mapCategory);
		model.addAttribute("stockStatus", stockStatus);
		
		return model;
	}
	
	private void validateImage(MultipartFile file) {
		if (!file.getContentType().equals("image/jpeg")) {
			throw new FileUploadException(file.getName(),
					"error.product.imagetype");
		}
	}
	
	public Product fileUpload(MultipartFile file, Product product) {
		if (!file.isEmpty()) {
			validateImage(file);
			try {
				byte[] bytes = file.getBytes();
				
				String rootDirectory = servletContext.getRealPath("/resources/images/");
				File dir = new File(rootDirectory + File.separator + "product");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				String filename = product.getProductcode() + "_" + file.getName() + ".jpg";
				product.setImage(filename);
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + filename);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			}
			catch (Exception e) {
				throw new FileUploadException(
						file.getOriginalFilename(), "{error.product.upload}");
			}
		} else {
			throw new FileUploadException(file.getOriginalFilename(),
					"error.product.invalidfile");
		}
		
		return product;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		// TODO Auto-generated method stub
		return null;
	}
}
