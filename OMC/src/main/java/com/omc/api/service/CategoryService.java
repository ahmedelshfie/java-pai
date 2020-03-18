package com.omc.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omc.api.entity.Category;
import com.omc.api.repository.CategoryRepository;
import com.omc.api.util.Errors;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository cr;
	
	
	public Category findCategoryId(Integer id) {
		Optional<Category> cat = cr.findById(id);
		if (cat == null) {
			throw new Errors("Erro no id: "+ id + " do tipo : " + Category.class.getName());
		}
		return cat.orElse(null);
	}

}
