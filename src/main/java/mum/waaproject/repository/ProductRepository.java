package mum.waaproject.repository;

import java.util.List;

import mum.waaproject.model.Category;
import mum.waaproject.model.Product;
import mum.waaproject.model.Store;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	public Product getProductById(int id);

	@Query("select p from product p where p.store = :store and p.productcode = :productCode")
	public Product findByProductCode(@Param("store") Store store, @Param("productCode") String productCode);
	
	@Query("SELECT p FROM product p WHERE p.isFeatured = 1")
	public List<Product> getFeatureProducts(Pageable pageable);
	
	@Query("SELECT p FROM product p where p.category = :category")
	public List<Product> getProductByCategory(@Param("category") Category category);
	
	public List<Product> findAllByOrderByCreatedDateDesc(Pageable pageable);
}
