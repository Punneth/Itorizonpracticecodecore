package com.youtube.spring.durgesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.spring.durgesh.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	

}
