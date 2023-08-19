package com.rkmasai;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rkmasai.entity.Ticket;
import com.rkmasai.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingAppApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext applicationContext = 	SpringApplication.run(TicketBookingAppApplication.class, args);
	
	TicketBookingService ticketBookingService	= applicationContext.getBean("ticketBookingService" , TicketBookingService.class);
	
	Ticket ticket = new Ticket();
	ticket.setBookingDate(new Date());
	ticket.setDestStation("Bhagalpur");
	ticket.setSourceStation("Patna Jn");
	ticket.setEmail("rk@gmail.com");
	ticket.setPassengerName("Vijay");
	
	
	
	ticketBookingService.createTicket(ticket);
	
	
	}

}
