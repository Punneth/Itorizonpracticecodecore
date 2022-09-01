package com.itoItTracker.assignment.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itoItTracker.assignment.spring.entity.Comments;
import com.itoItTracker.assignment.spring.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
//	@Query(value = "select * from ticket where reported_id=:userId",nativeQuery = true)
//	List<Ticket> findByUser(@Param(value="userId") Integer userId);
	List<Ticket> findByReportedId(Integer userId);
//	List<TicketDto> findByCategory(TicketDto ticketDto);
	List<Ticket> findAllByReportedId(Integer userId);

	Integer findByAssigneeId(Integer assigneeId);

}
