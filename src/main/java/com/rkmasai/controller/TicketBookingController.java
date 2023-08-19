package com.rkmasai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkmasai.entity.Ticket;
import com.rkmasai.service.TicketBookingService;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {
	
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	
	@PostMapping(value="/create")
	public Ticket createTicket( @RequestBody Ticket ticket) {
		
		return ticketBookingService.createTicket(ticket);
	}
	
	
	@GetMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		
		
		
		return ticketBookingService.getTicketById(ticketId);
	}

	@GetMapping(value="/ticket/alltickets")
	public Iterable<Ticket> getAllTicket(){
		
		return ticketBookingService.getAllTicket();
	}
	
	
	@DeleteMapping(value="/ticket/{ticketId}")
	public void deleteTicketById(@PathVariable("ticketId")int ticketId) {
		
		ticketBookingService.deleteTicketById(ticketId);
	}
	
	@PutMapping(value="/ticket/{ticketId}/{newEmailId:.+}")
	public Ticket updateTicket(@PathVariable ("ticketId") int ticketId, @PathVariable ("newEmailId") String newEmailId) {
		
		return ticketBookingService.updateTicket(ticketId,newEmailId);
	}
	
	
}
