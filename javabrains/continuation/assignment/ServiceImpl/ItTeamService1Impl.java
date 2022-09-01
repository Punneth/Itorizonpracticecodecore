package com.youtube.javabrains.continuation.assignment.ServiceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.javabrains.continuation.assignment.Dto.User1Dto;
import com.youtube.javabrains.continuation.assignment.Repo.User1Repo;
import com.youtube.javabrains.continuation.assignment.Service.ItTeamService1;
import com.youtube.javabrains.continuation.assignment.entity.User1;
import com.youtube.javabrains.continuation.assignment.exceptions.ResourceNotFoundException;


@Service
public class ItTeamService1Impl implements ItTeamService1 {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private User1Repo user1Repo;
	
	
	
	@Override
	public String createUser(User1Dto user1Dto) {
		User1 user1 = this.modelMapper.map(user1Dto, User1.class);
		user1.setName1(user1Dto.getName1());
		user1.setEmailId1(user1Dto.getEmailId1());
		user1.setCreateDateTime1(new Date());
		user1.setLastModifiedDateTime1(new Date());
		this.user1Repo.save(user1);
		String message = "User with " + user1Dto.getEmailId1()+" created successfully";
		return message;
	}

	@Override
	public User1Dto viewUser(Integer userId1) {
		User1 user1 = this.user1Repo.findById(userId1).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId1));
		User1Dto userDto = this.modelMapper.map(user1, User1Dto.class);
		return userDto;
	}

//	@Override
//	public User1DtoClass updateUser(User1DtoClass user1DtoClass, Integer userId1) {
//		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
//		user.setName(userDto.getName());
//		user.setEmailId(userDto.getEmailId());
//		user.setLastModifiedDateTime(new Date());
//		
//		User savedUser = this.userRepo.save(user);	
//		
//		return this.modelMapper.map(savedUser, UserDto.class);
//		return null;
//	}
	
}
