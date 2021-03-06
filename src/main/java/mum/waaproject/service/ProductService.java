package mum.waaproject.service;

import java.util.List;

import mum.waaproject.model.Category;
import mum.waaproject.model.Product;
import mum.waaproject.model.Store;

public interface ProductService {
	
	public Product getProductById(int id);
	
	public Product findByProductCode(Store store, String productCode);
	
	public void save(Product product);
	
	public List<Product> findAll();
	
	public Product findOne(int productid);
	
	public List<Product> getFeatureProduct();
	
	public void delete(Product product); 
	
	public List<Product> getProductByCategory(Category category);
	
	public List<Product> findAllByOrderByCreatedDateDesc();
}
