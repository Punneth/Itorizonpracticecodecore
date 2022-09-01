package com.youtube.spring.durgesh.services;

import java.util.List;

import com.youtube.spring.durgesh.entity.Post;
import com.youtube.spring.durgesh.payloads.PostDto;
import com.youtube.spring.durgesh.payloads.PostResponse;

public interface PostService {
	
//	create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
//	delete
	void deletePost(Integer postId);

//	update
	PostDto updatePost(PostDto postDto,Integer postId);
	
//	get all posts
	PostResponse getAllPosts(Integer pageNumber,Integer pageSize);
	
//	get by posts
	PostDto getPostById(Integer postId);
	
//	get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
//	get all posts by users
	List<PostDto> getPostsByUsers(Integer userId);
	
//	search posts
	List<Post> searchPost(String keyword);
	

}
