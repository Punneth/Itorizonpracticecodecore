package com.youtube.javabrains.continuation.assignment.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.javabrains.continuation.assignment.Dto.User1Dto;
import com.youtube.javabrains.continuation.assignment.Service.ItTeamService1;

@RestController
@RequestMapping("/api/team")
public class ItTeamController1 {
	
	@Autowired
	private ItTeamService1 itTeamService1;
	
	@PostMapping("/createUser")
	public String createUser(@Valid @RequestBody User1Dto user1Dto) {
		String message = this.itTeamService1.createUser(user1Dto);
		return message;
	}

	@GetMapping("/viewUser/")
	public User1Dto viewUser(@RequestParam("userId") Integer uId){
		User1Dto user1Dto = this.itTeamService1.viewUser(uId);	
		return user1Dto;
	}

}
