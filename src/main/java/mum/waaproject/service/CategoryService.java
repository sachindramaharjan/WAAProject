package mum.waaproject.service;

import java.util.List;

import mum.waaproject.model.Category;

public interface CategoryService {

	Category findOne(int categoryId);
	
	List<Category> findAll();
	
	Category findByName(String name);
	
	List<Category> findByLeafCategory();
	
	Category getCategoryById(int id);
	
	List<Category> getRootCategories();
	
	void delete(int id);

	void save(Category category);
}
