package com.itoItTracker.assignment.spring.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Dto.UserDto;
import com.itoItTracker.assignment.spring.Services.ItTeamService;
import com.itoItTracker.assignment.spring.entity.Comments;

@RestController
@RequestMapping("/api/team")
public class ItTeamController {
	
	@Autowired
	private ItTeamService itTeamService;
	
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserDto userDto) {
		
		ApiResponse createdUser = this.itTeamService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<UserDto>> viewAllUsers() {
		return ResponseEntity.ok(this.itTeamService.viewAllUsers());
	}
	
	@GetMapping("/viewUser/")
	public ResponseEntity<UserDto> viewUser(@RequestParam ("userId") Optional<Integer> userId,@RequestParam Optional<String> emailId){
		UserDto userById = this.itTeamService.viewUser(userId,emailId);	
		return ResponseEntity.ok(userById);
	}
	
	@DeleteMapping("/deleteUser/")
	public ResponseEntity<ApiResponse> deleteUser(@RequestParam Integer userId) {
		ApiResponse apiResponse = this.itTeamService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto userDto){
		ApiResponse apiResponse = this.itTeamService.updateUser(userDto);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
	
	@GetMapping("/ticketsList/")
	public List<HelperPojoClass> ViewTicketList() {
		List<HelperPojoClass> tickets = itTeamService.ViewTicketList();
		return tickets;
	}
	
	@GetMapping("/ticket/")
	public List<Comments> viewTicketByTicketId(@RequestParam Integer ticketId){
		List<Comments> comments = this.itTeamService.viewTicketByTicketId(ticketId);
		return comments;
	}
	
	@PutMapping("/assignee")
	public void setAssignee(@RequestBody TicketDto ticketDto,@RequestParam Integer userId) {
		this.itTeamService.setAssignee(ticketDto, userId);
	}

	@PutMapping("/{ticketId}/{statusId}/{assigneeId}")
	public String changeTheStatus(@PathVariable Integer ticketId,@PathVariable Integer statusId,@PathVariable Integer assigneeId) {
		String message = this.itTeamService.changeTheStatus(ticketId, statusId, assigneeId);
		return message;
	}
	
	@PutMapping("/priority/")
	public String changeThePriority(@RequestParam Integer ticketId, @RequestParam Integer priorityId, @RequestParam Integer assigneeId) {
		String message = this.itTeamService.changeThePriority(ticketId, priorityId, assigneeId);
		return message;
	}
	
	@DeleteMapping("/delete")
	public String deleteTicket(@RequestParam Integer ticketId,@RequestParam Integer userId) {
		String message = itTeamService.deleteTicket(ticketId, userId);
		return message;
	}
	

}
