package mum.waaproject.serviceImpl;

import java.util.List;

import mum.waaproject.model.Product;
import mum.waaproject.model.Store;
import mum.waaproject.repository.ProductRepository;
import mum.waaproject.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProductById(int id) {
		return productRepository.getProductById(id);
	}

	@Override
	public Product findByProductCode(Store store, String productCode) {
		 return productRepository.findByProductCode(store,productCode);
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>)productRepository.findAll();
	}

	@Override
	public Product findOne(int productid) {
		// TODO Auto-generated method stub
		return productRepository.findOne(productid);
	}

}
