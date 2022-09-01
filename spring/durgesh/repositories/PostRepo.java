package com.youtube.spring.durgesh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.spring.durgesh.entity.Category;
import com.youtube.spring.durgesh.entity.Post;
import com.youtube.spring.durgesh.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
