package com.youtube.spring.durgesh.services;

import java.util.List;
import com.youtube.spring.durgesh.payloads.CategoryDto;

public interface CategoryService {
	
//	create
	CategoryDto createCategory(CategoryDto categoryDto);
	
//	update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
//	delete
	void deleteCategory(Integer categoryId);
	
//	get
	CategoryDto getCategory(Integer categotyId);
	
//	getAll
	List<CategoryDto> getCategories();

}
