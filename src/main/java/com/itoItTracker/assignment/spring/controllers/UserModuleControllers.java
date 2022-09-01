package com.itoItTracker.assignment.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.CommentsDto;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Services.UserModuleService;
import com.itoItTracker.assignment.spring.entity.Comments;

@RestController
@RequestMapping("/api/user")
public class UserModuleControllers {
	
	
	
	@Autowired
	private UserModuleService userModuleService;
	
	
	@PostMapping("/createTicket/")
	public ResponseEntity<ApiResponse> createTicket(@RequestBody TicketDto ticketDto,@RequestParam Integer userId) {
		ApiResponse apiResponse = this.userModuleService.createTicket(ticketDto, userId);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/viewTicketsByUserId/")
	public List<HelperPojoClass> viewTicketsByUserId(@RequestParam Integer userId){
		List<HelperPojoClass> ticketDto = this.userModuleService.viewTicketsByUserId(userId);
		return ticketDto;
	}
	
	@GetMapping("/viewTicketsByTicketId/{userId}/{ticketId}")
	public List<HelperPojoClass> viewTicketsByTicketId(@PathVariable Integer userId,@PathVariable Integer ticketId) {
		List<HelperPojoClass> ticketDtos = userModuleService.viewTicketsByTicketId(userId, ticketId);
		return ticketDtos;
	}
	
	@PostMapping("/commentOnTicket/")
	public ResponseEntity<ApiResponse> commentOnTicket(@RequestBody CommentsDto commentsDto,@RequestParam Integer ticketId,@RequestParam Integer userId ){
		ApiResponse apiResponse = this.userModuleService.commentOnTicket(commentsDto, ticketId, userId);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}

}
