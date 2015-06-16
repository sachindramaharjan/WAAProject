package mum.waaproject.serviceImpl;

import java.util.List;

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

	@Override
	public Product getProductByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findOne(int productid) {
		// TODO Auto-generated method stub
		return null;
	}

}
