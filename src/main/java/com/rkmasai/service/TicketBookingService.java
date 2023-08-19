package com.rkmasai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkmasai.dao.TicketBookingDao;
import com.rkmasai.entity.Ticket;

@Service
public class TicketBookingService {
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		
		Ticket saveTicket = ticketBookingDao.save(ticket);
		
		return saveTicket;
		
	}

	public Ticket getTicketById(Integer ticketId) {
	
		Optional<Ticket> ticket = ticketBookingDao.findById(ticketId);
		return ticket.get();
	}

	public Iterable<Ticket> getAllTicket() {
		
		return ticketBookingDao.findAll();
	}

	public  void deleteTicketById(int ticketId) {
		
		try {
			ticketBookingDao.deleteById(ticketId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Ticket updateTicket(int ticketId, String newEmailId) {
	Optional<Ticket> ticket = 	ticketBookingDao.findById(ticketId);
	
		ticket.get().setEmail(newEmailId);
	Ticket UpdateTicket =	ticketBookingDao.save(ticket.get());
		return UpdateTicket;
	}
	
	

}
