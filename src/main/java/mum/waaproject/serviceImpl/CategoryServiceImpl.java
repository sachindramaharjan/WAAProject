package mum.waaproject.serviceImpl;

import java.util.List;

import mum.waaproject.model.Category;
import mum.waaproject.repository.CategoryRepository;
import mum.waaproject.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category findOne(int categoryId) {
		return categoryRepository.findOne(categoryId);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findByName(String name) {
		
		return categoryRepository.findByName(name);
	}

	@Override
	public List<Category> findByLeafCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findByLeafCategory();
	}
	
	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.getCategoryById(id);
	}

}
