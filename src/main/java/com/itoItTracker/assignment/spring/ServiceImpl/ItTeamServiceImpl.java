package com.itoItTracker.assignment.spring.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.CommentHelperClass;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Dto.UserDto;
import com.itoItTracker.assignment.spring.Services.ItTeamService;
import com.itoItTracker.assignment.spring.entity.AdminTeam;
import com.itoItTracker.assignment.spring.entity.Category;
import com.itoItTracker.assignment.spring.entity.Comments;
import com.itoItTracker.assignment.spring.entity.Priority;
import com.itoItTracker.assignment.spring.entity.Status;
import com.itoItTracker.assignment.spring.entity.SubCategory;
import com.itoItTracker.assignment.spring.entity.Ticket;
import com.itoItTracker.assignment.spring.entity.User;
import com.itoItTracker.assignment.spring.exceptions.ResourceNotFoundException;
import com.itoItTracker.assignment.spring.repositories.AdminTeamRepo;
import com.itoItTracker.assignment.spring.repositories.CategoryRepo;
import com.itoItTracker.assignment.spring.repositories.CommentsRepo;
import com.itoItTracker.assignment.spring.repositories.PriorityRepo;
import com.itoItTracker.assignment.spring.repositories.StatusRepo;
import com.itoItTracker.assignment.spring.repositories.SubCategoryRepo;
import com.itoItTracker.assignment.spring.repositories.TicketRepo;
import com.itoItTracker.assignment.spring.repositories.UserRepo;


@Service
public class ItTeamServiceImpl implements ItTeamService {
	
	@Autowired
	private SubCategoryRepo subCategoryRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PriorityRepo priorityRepo;
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	@Autowired
	private StatusRepo statusRepo;
	
	@Autowired
	private AdminTeamRepo adminTeamRepo;
		
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	Date date = new Date();
	SimpleDateFormat formateDate = new SimpleDateFormat("dd-MMMM-yyyy hh:mm aa");
	String newDate = formateDate.format(date);
	String regex = "^[a-zA-Z ]+$";
	Pattern p = Pattern.compile(regex);
	
	@Override
	public ApiResponse createUser(UserDto userDto) {
		
		Matcher m = p.matcher(userDto.getName());
		if(userDto.getName()!=null && m.matches()) {
			User user = this.modelMapper.map(userDto, User.class);
			user.setCreateDateTime(newDate);
			user.setLastModifiedDateTime(newDate);
			this.userRepo.save(user);
		}
		else {
			return new ApiResponse("Enter a valid User Name");
		}
		String message = "User with "+userDto.getEmailId() + " created successfully";
		return (new ApiResponse(message));
	}
	
	@Override
	public UserDto viewUser(Optional<Integer> userId, Optional<String> emailId) {
		UserDto userDto = new UserDto();
		String newEmailId = null;
		Integer newUserId =null;
		try {
			newUserId = Integer.valueOf(userId.get());
		}
		catch(Exception ex) {
			newUserId=null;
		}
		try {
			newEmailId = String.valueOf(emailId.get());
		}
		catch(Exception ex) {
			newEmailId=null;
		}
		String email = null;
		
		if(newUserId!=null && newEmailId!=null )
		{
			int variable = newUserId;
			User user = this.userRepo.findById(variable).orElseThrow(()->new ResourceNotFoundException("User", "user Id", variable));
			try {
				email = this.userRepo.findByEmailId(newEmailId);
			}
			catch(Exception ex) {
				throw new ResourceNotFoundException("Please enter valid email id");
			}
			if(variable==user.getUserId()&&newEmailId==email) {
				userDto = this.modelMapper.map(user, UserDto.class);
			}
			else {
				throw new ResourceNotFoundException("userId and emailId mismatched");
			}
		}
		else 
			if(newUserId!=null && newEmailId==null ) {
				int variable = newUserId;
				User user = this.userRepo.findById(variable).orElseThrow(()->new ResourceNotFoundException("User", "user Id", variable));
				userDto = this.modelMapper.map(user, UserDto.class);
			}
		else {
			Integer id = null;
			id = userRepo.findIdByEmail(newEmailId);
			
			try {
				id = userRepo.findIdByEmail(newEmailId);
				System.out.println(id);
			}
			catch(Exception ex) {
				throw new ResourceNotFoundException("emailId not present");
			}
			Integer variable = id;
			User user = userRepo.findById(variable).orElseThrow(()->new ResourceNotFoundException("User", "user Id", variable));
			userDto = this.modelMapper.map(user, UserDto.class);
			}
					
		return userDto;
	}
	
	@Override
	public List<UserDto> viewAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user ->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		
		return userDtos;
		
	}
	
	@Override
	public ApiResponse deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		this.userRepo.delete(user);
		String message = "User with "+ userId +" deleted successfully";
		return new ApiResponse(message);
	}
	
	@Override
	public ApiResponse updateUser(UserDto userDto) {
		Matcher m = p.matcher(userDto.getName());
		Integer userId = userDto.getUserId();
		String message=null;
		if(userDto.getName()!=null && m.matches()) {
			User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
			user.setName(userDto.getName());
			user.setLastModifiedDateTime(newDate);
			this.userRepo.save(user);	
			message = "User with "+ userId +" Updated successfully";
		}
		else {
			return new ApiResponse("Enter a valid User Name");
		}
		return new ApiResponse(message);
	}

	@Override
	public List<HelperPojoClass> ViewTicketList() {
		
		List<Ticket> tickets = ticketRepo.findAll();
		List<HelperPojoClass> ticket2=new ArrayList<>();
			for(Ticket ticket : tickets) {
				HelperPojoClass helperPojoClass = new HelperPojoClass();
				Category categoryid = categoryRepo.getById(ticket.getCategoryId());
				helperPojoClass.setCategory(categoryid.getCategoryDesc());
				SubCategory subCategoryid = subCategoryRepo.getById(ticket.getSubCategoryId());
				helperPojoClass.setSubCategory(subCategoryid.getSubCategoryDesc());
				try {
					Priority priorityid = priorityRepo.getById(ticket.getPriorityId());
					helperPojoClass.setPriority(priorityid.getPriority());	
				}
				catch(Exception ex) {
					helperPojoClass.setPriority(null);
				}
				Status status = statusRepo.getById(ticket.getStatusId());
				System.out.println(status.getStatus());
				helperPojoClass.setStatus(status.getStatus());
				try {
					AdminTeam adminName = adminTeamRepo.getById(ticket.getAssigneeId());
					helperPojoClass.setAssignee(adminName.getName());
				}
				catch(Exception ex) {
					helperPojoClass.setAssignee(null);
				}
				helperPojoClass.setTicketId(ticket.getTicketId());
				helperPojoClass.setSubject(ticket.getSubject());
				helperPojoClass.setDescription(ticket.getDescription());
				helperPojoClass.setCreateDateTime(ticket.getCreateDateTime());
				helperPojoClass.setLastModifiedDateTime(ticket.getCreateDateTime());
				helperPojoClass.setSubject(ticket.getSubject());

				ticket2.add(helperPojoClass);
			}
		return ticket2;
	}

	
	@Override
	public List<Comments> viewTicketByTicketId(Integer ticketId) {
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket Id"));
		List<Comments> comments = commentsRepo.findByTicket(ticket);
		List result = new ArrayList<>();
		HelperPojoClass helperPojoClass = new HelperPojoClass();
		helperPojoClass.setTicketId(ticket.getTicketId());
		Category category = categoryRepo.getById(ticket.getCategoryId());
		helperPojoClass.setCategory(category.getCategoryDesc());
		SubCategory subcategory = this.subCategoryRepo.getById(ticket.getSubCategoryId());
		helperPojoClass.setSubCategory(subcategory.getSubCategoryDesc());
		Priority priority = priorityRepo.getById(ticket.getPriorityId());
		helperPojoClass.setPriority(priority.getPriority());
		helperPojoClass.setDescription(ticket.getDescription());
		helperPojoClass.setSubject(ticket.getSubject());
		helperPojoClass.setCreateDateTime(ticket.getCreateDateTime());
		helperPojoClass.setLastModifiedDateTime(ticket.getLastModifiedDateTime());
		Status status= statusRepo.getById(ticket.getStatusId());
		helperPojoClass.setStatus(status.getStatus());
		result.add(helperPojoClass);
		
		for (Comments comment : comments) {
			CommentHelperClass commentHelperClass = new CommentHelperClass();
			commentHelperClass.setComment(comment.getMessage());
			commentHelperClass.setUserId(comment.getUser().getUserId());
			result.add(commentHelperClass);
		}
		
		return result;
	}

	@Override
	public void setAssignee(TicketDto ticketDto,Integer userId) {
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid User Id"));
		adminTeamRepo.findById(ticketDto.getAssigneeId()).orElseThrow(()->new ResourceNotFoundException("Invalid Admin Id"));
		Ticket ticket = ticketRepo.findById(ticketDto.getTicketId()).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket Id"));
		Ticket fetchedTicket = this.modelMapper.map(ticketDto, Ticket.class);
		ticket.setAssigneeId(fetchedTicket.getAssigneeId());
		ticket.setLastModifiedDateTime(newDate);
		ticketRepo.save(ticket);
	}

		
	@Override
	public String changeTheStatus(Integer ticketId,Integer statusId,Integer assigneeId) {
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket id"));
		String oldStatus=statusRepo.getById(ticket.getStatusId()).getStatus();
		adminTeamRepo.findById(assigneeId).orElseThrow(()->new ResourceNotFoundException("Invalid Admin id"));
		Status status = statusRepo.findById(statusId).orElseThrow(()->new ResourceNotFoundException("Invalid Status id"));
		String message = null;
		if(ticket.getStatusId()!=4) {
			String newStatus = status.getStatus();
			ticket.setStatusId(statusId);
			ticket.setLastModifiedDateTime(newDate);
			ticketRepo.save(ticket);
			message = "Status Changed from"+" "+oldStatus+" to "+newStatus;
		}
		else {
			message="Status is already Completed you can not change the status";
		}
		return message;
	}

	
	@Override
	public String changeThePriority(Integer ticketId,Integer priorityId,Integer assigneeId ) {
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket id"));
		String oldPriority = priorityRepo.getById(ticket.getPriorityId()).getPriority();
		adminTeamRepo.findById(assigneeId).orElseThrow(()->new ResourceNotFoundException("Invalid Admin id"));
		Priority priority = priorityRepo.findById(priorityId).orElseThrow(()->new ResourceNotFoundException("Invalid Priority id"));
		String newPriority = priority.getPriority();
		String message = null;
		if(ticket.getStatusId()==1) {
			ticket.setPriorityId(priorityId);
			ticket.setLastModifiedDateTime(newDate);
			message = "Priority Changed from"+" "+oldPriority+" to " + newPriority;
			ticketRepo.save(ticket);
		}
		else {
			message="You can not able to change the Priority";
		}
		return message;
	}

	@Override
	public String deleteTicket(Integer ticketId, Integer userId) {
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket id"));
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid User Id"));
		String message = null;
		if(ticket.getTicketId()==ticketId && ticket.getUser().getUserId()==userId) {
			ticketRepo.delete(ticket);
			message = "Ticket deleted Successfully";
		}
		else {
			message = "Ticket id and user id mismatched";
		}
		return message;
	}

}

