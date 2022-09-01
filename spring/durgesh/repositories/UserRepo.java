package com.youtube.spring.durgesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.spring.durgesh.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
}
