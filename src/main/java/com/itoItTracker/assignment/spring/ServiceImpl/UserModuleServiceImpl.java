package com.itoItTracker.assignment.spring.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.CommentsDto;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Services.UserModuleService;
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
public class UserModuleServiceImpl implements UserModuleService{
	
	@Autowired
	private AdminTeamRepo adminTeamRepo;
	
	@Autowired
	private StatusRepo statusRepo;
	
	@Autowired
	private PriorityRepo priorityRepo;
	
	@Autowired
	private HelperPojoClass helperPojoClass;
	
	@Autowired
	private SubCategoryRepo subCategoryRepo;
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TicketRepo ticketRepo;
		
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	Date date = new Date();
	SimpleDateFormat formateDate = new SimpleDateFormat("dd-MMMM-yyyy hh:mm aa");
	String newDate = formateDate.format(date);

	@Override
	public ApiResponse createTicket(TicketDto ticketDto, Integer userId) {
		Ticket ticket = this.modelMapper.map(ticketDto, Ticket.class);
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		categoryRepo.findById(ticket.getCategoryId()).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id",ticket.getCategoryId()));
		subCategoryRepo.findById(ticket.getSubCategoryId()).orElseThrow(()->new ResourceNotFoundException("SubCategory", "SubCategory Id",ticket.getSubCategoryId()));
		ticket.setReportedId(userId);
		ticket.setStatusId(1);
		ticket.setCategoryId(ticket.getCategoryId());
		ticket.setSubCategoryId(ticket.getSubCategoryId());
		ticket.setDescription(ticketDto.getDescription());
		ticket.setLastModifiedDateTime(newDate);
		ticket.setCreateDateTime(newDate);
		ticket.setPriorityId(ticketDto.getPriorityId());
		this.ticketRepo.save(ticket);
		String message =  "Ticket id "+ticket.getTicketId()+" Created Successfully. localhost:8080/api/user/createTicket/";
		return new ApiResponse(message);
	}

	@Override
	public List<HelperPojoClass> viewTicketsByUserId(Integer userId) {
		
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		List<Ticket> tickets = ticketRepo.findAll();
		List<HelperPojoClass> ticket2 = new ArrayList<>();
			for(Ticket ticket : tickets) {
				if(ticket.getReportedId()==userId) {
					
					helperPojoClass = new HelperPojoClass();
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
					helperPojoClass.setLastModifiedDateTime(ticket.getLastModifiedDateTime());
					ticket2.add(helperPojoClass);
				}
			}	
		return ticket2;
		
	}
	

	@Override
	public List<HelperPojoClass> viewTicketsByTicketId(Integer userId, Integer ticketId) {
		
		List ticket2=new ArrayList<>();
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Ticket", "ticket Id", ticketId));
		Ticket byId = ticketRepo.getById(ticketId);
		if(byId.getTicketId()==ticketId && byId.getReportedId()==userId) {
			Integer reportedId=userId;
			
			List<Ticket> tickets = ticketRepo.findByReportedId(reportedId);
			for (Ticket ticket : tickets) {
				if(ticket.getTicketId()==ticketId) {
					helperPojoClass = new HelperPojoClass();
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
					helperPojoClass.setLastModifiedDateTime(ticket.getLastModifiedDateTime());
					ticket2.add(helperPojoClass);
					
				}
			}
		}
//		else {
//			return new ApiResponse("User id and ticket id does not match");
//		}
			return ticket2;
	}
	

	@Override
	public ApiResponse commentOnTicket(CommentsDto commentsDto, Integer ticketId, Integer userId) {
		
		Comments comments = new Comments();
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user id", userId));
		Ticket ticket = this.ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Ticket", "ticket id", ticketId));
		
		comments.setTicketId(ticket.getTicketId());
		comments.setUserId(user.getUserId());
		comments.setTicket(ticket);
		comments.setUser(user);
		comments.setMessage(commentsDto.getMessage());
		commentsRepo.save(comments);
		String message = "Successfully added comment on "+ticketId;
		return new ApiResponse(message);
	}

	
}
