package com.itoItTracker.assignment.spring.Services;

import java.util.List;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.CommentsDto;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;

public interface UserModuleService {
	
	ApiResponse createTicket(TicketDto ticketDto,Integer userId);
	List<HelperPojoClass> viewTicketsByUserId(Integer userId);
	List<HelperPojoClass> viewTicketsByTicketId(Integer userId,Integer ticketId);
	ApiResponse commentOnTicket(CommentsDto commentsDto,Integer ticketId,Integer userId);

}
