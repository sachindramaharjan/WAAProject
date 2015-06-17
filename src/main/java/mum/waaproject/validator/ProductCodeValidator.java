package mum.waaproject.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mum.waaproject.model.Store;
import mum.waaproject.model.User;
import mum.waaproject.service.ProductService;
import mum.waaproject.service.StoreService;
import mum.waaproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductCodeValidator implements
		ConstraintValidator<ProductCode, String> {

	private Store store;
	private User user;

	@Autowired
	private ProductService productService;

	@Autowired
	private StoreService storeService;

	@Autowired
	UserService userService;

	@Override
	public void initialize(ProductCode constraintAnnotation) {
	}

	@Override
	public boolean isValid(String productCode,
			ConstraintValidatorContext context) {

		if (productCode.isEmpty()) {
			return true;
		}
		
		user = userService.findOne(1);
		store = storeService.findByUsername(user);
		if (productService.findByProductCode(store, productCode) != null) {
			return false;
		}

		return true;
	}

}
