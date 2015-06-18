package mum.waaproject.serviceImpl;

import java.util.List;

import mum.waaproject.model.Category;
import mum.waaproject.repository.CategoryRepository;
import mum.waaproject.repository.StoreRepository;
import mum.waaproject.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Category Service
 * @author sachindra
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StoreRepository storeRepostory;
	
	/**
	 * Delegates find request to CategoryRepository, returns Category object
	 */
	@Override
	public Category findOne(int categoryId) {
		return categoryRepository.findOne(categoryId);
	}

	/**
	 * Delegates findAll request to CategoryRepository, returns list of Category objects
	 */
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	/**
	 * Delegates findByName request to CategoryRepository, returns Category object
	 */
	@Override
	public Category findByName(String name) {
		
		return categoryRepository.findByName(name);
	}

	/**
	 * Delegates findByLeafCategory to CategoryRepository, returns list of Category objects
	 */
	@Override
	public List<Category> findByLeafCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findByLeafCategory();
	}
	
	/**
	 * Delegates getCategoryById requests to CategoryRepository, returns Category object
	 */
	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.getCategoryById(id);
	}


	@Override
	public 	void save(Category category){
		
		if(category.getParent().getId() != 0){
			category.setLeaf(true);
		}
		else
		{
			category.setLeaf(false);
			category.setParent(null);
		}
		
		category.setStore(storeRepostory.findOne(1));
		categoryRepository.save(category);
	}

	@Override
	public List<Category> getRootCategories() {
		return categoryRepository.getCategoryByLeaf(false);
	}
	
	@Override
	public void delete(int id){
		categoryRepository.delete(id);
	}
}
