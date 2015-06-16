package mum.waaproject.repository;

import mum.waaproject.model.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product getProductById(int id);
	
}
