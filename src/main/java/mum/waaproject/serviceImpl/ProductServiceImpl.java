package mum.waaproject.serviceImpl;

import mum.waaproject.model.Product;
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

}
