package mum.waaproject.service;

import java.util.List;

import mum.waaproject.model.Product;

public interface ProductService {
	
	public Product getProductById(int id);
	
	public Product findByProductCode(String productCode);
	
	public void save(Product product);
	
	public List<Product> findAll();
	
	public Product findOne(int productid);
	
	
}
