package mum.waaproject.repository;

import mum.waaproject.model.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product getProductById(int id);

	@Query("select p from product p where p.productcode = :productCode")
	public Product findByProductCode(String productCode);
	
}
