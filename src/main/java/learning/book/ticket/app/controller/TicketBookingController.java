package learning.book.ticket.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.book.ticket.app.entities.Ticket;
import learning.book.ticket.app.service.TicketBookingService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(value = "createTicket")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
	}

	@GetMapping(value = "getTicket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}

	@GetMapping(value = "/allTickets")
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingService.getAllBookedTickets();
	}

	@DeleteMapping(value = "delete/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketBookingService.deleteTicket(ticketId);
	}
	
	@PutMapping(value="/update/{ticketId}")
	public void updateTicket(@PathVariable("ticketId") Integer ticketId, @RequestBody Ticket ticket) {
		ticketBookingService.updateTicket(ticketId, ticket);
	}
	
}
