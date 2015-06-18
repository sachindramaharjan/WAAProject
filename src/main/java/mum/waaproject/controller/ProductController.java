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
import mum.waaproject.exception.CategoryNotFoundException;
import mum.waaproject.exception.FileUploadException;
import mum.waaproject.exception.ProductNotFoundException;
import mum.waaproject.model.Category;
import mum.waaproject.model.Product;
import mum.waaproject.model.Store;
import mum.waaproject.service.CategoryService;
import mum.waaproject.service.ProductService;
import mum.waaproject.service.StoreService;
import mum.waaproject.service.UserService;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author sachindra
 *
 */
@Controller
@RequestMapping("/products")
public class ProductController implements HandlerExceptionResolver {

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

	/**
	 * Displays all products 
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String show(Model model) {

		model.addAttribute("products", productService.findAll());
		model.addAttribute("path",
				servletContext.getRealPath("/resources/images/"));
		return "products";
	}

	
	/**
	 * Gets product by product Id
	 * @param model
	 * @param productId
	 * @return 
	 */
	@RequestMapping("/product/{id}")
	public String getProductById(Model model, @PathVariable("id") int productId) {

		Product product = productService.getProductById(productId);
		if(product == null){
			throw new ProductNotFoundException(productId, "product.error.notfound");
		}
		
		Store store = storeService.getStoreById(product.getStore().getId());
		Category category = categoryService.getCategoryById(product
				.getCategory().getId());

		model.addAttribute("product", product);
		model.addAttribute("store", store);
		model.addAttribute("category", category);
		return "productdetail";
	}
	
	/**
	 * Displays add new product form
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String newProductForm(Product product, Model model) {

		model = prepareModel(model);

		return "addProduct";
	}

	/**
	 * Adds new record of product
	 * @param product
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") @Valid Product product,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model = prepareModel(model);
			return "addProduct";
		}

		System.out.println(product.getCategory().getName());

		Category category = categoryService.findOne(Integer.parseInt(product
				.getCategory().getName()));
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

	/**
	 * Deletes product and its image
	 * @param productId
	 */
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeProduct(@PathVariable("productId") int productId) {

		Product product = productService.findOne(productId);

		if(product == null){
			throw new ProductNotFoundException(productId, "product.error.notfound");
		}
		
		try {
			String imagePath = servletContext
					.getRealPath("/resources/images/product/"
							+ product.getImage());
			File file = new File(imagePath);
			System.out.println("file exists:" + file.exists());
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
		}

		productService.delete(product);
	}
	
	/**
	 * Displays products associated with particular category
	 * @param categoryId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/category/{categoryId}", method = RequestMethod.GET)
	public String categoryProducts(@PathVariable("categoryId") int categoryId, Model model){
		
		Category category = categoryService.findOne(categoryId);
		
		if(category == null){
			throw new CategoryNotFoundException(categoryId, "category.error.notfound");
		}
		
		List<Product> productList = productService.getProductByCategory(category);
		System.out.println(productList.size());
		
		model.addAttribute("category", category.getName());
		model.addAttribute("products", productList);
		
		return "categoryProduct";
	}
	
	/**
	 * Prepares data model from stock status and category and adds them to the Model object
	 * @param model
	 * @return
	 */
	public Model prepareModel(Model model) {
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

	/**
	 * Validates image type, throws FileUploadException 
	 * @param file
	 */
	private void validateImage(MultipartFile file) {
		if (!file.getContentType().equals("image/jpeg")) {
			throw new FileUploadException(file.getName(),
					"error.product.imagetype");
		}
	}

	/**
	 * Uploads file to the server path, throws FileUploadException
	 * @param file
	 * @param product
	 * @return
	 */
	public Product fileUpload(MultipartFile file, Product product) {
		if (!file.isEmpty()) {
			validateImage(file);
			try {
				byte[] bytes = file.getBytes();

				String rootDirectory = servletContext
						.getRealPath("/resources/images/");
				File dir = new File(rootDirectory + File.separator + "product");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				String filename = product.getProductcode() + "_"
						+ file.getName() + ".jpg";
				product.setImage(filename);
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + filename);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				throw new FileUploadException(file.getOriginalFilename(),
						"{error.product.upload}");
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
