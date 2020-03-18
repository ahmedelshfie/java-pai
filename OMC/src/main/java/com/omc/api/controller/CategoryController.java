package com.omc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omc.api.entity.Category;
import com.omc.api.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

//	@Autowired
//	private CategoryRepository demo;
	
	@Autowired
	private CategoryService cs;
	
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Category> findById(@PathVariable("id") Integer id) {		
		Category cat = new Category();		
		cat = cs.findCategoryId(id);		
		if (cat == null) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}		
		return ResponseEntity.ok(cat);	
		
	}
}
