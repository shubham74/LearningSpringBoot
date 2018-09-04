package learning.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.book.ticket.app.dao.TicketBookingDao;
import learning.book.ticket.app.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId).orElse(null);
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public void updateTicket(Integer ticketId, Ticket ticket) {

		Ticket ticket2 = ticketBookingDao.findById(ticketId).orElse(null);
		ticket2.setPassengerName(ticket.getPassengerName());

		ticketBookingDao.save(ticket2);
	}
	
}
