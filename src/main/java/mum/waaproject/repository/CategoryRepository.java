package mum.waaproject.repository;

import java.util.List;

import mum.waaproject.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByName(String name);
	
	@Query("select c from category c where c.leaf = true")
	List<Category> findByLeafCategory();
	
	Category getCategoryById(int id);
	
}
