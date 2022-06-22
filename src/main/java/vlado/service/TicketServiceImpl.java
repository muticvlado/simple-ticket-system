package vlado.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.model.Ticket;
import vlado.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> findAll() {
		
		return ticketRepository.findAll();
	}

	@Override
	public void save(Ticket ticket) {

		if(ticket.getDate_time() == null)
			ticket.setDate_time(LocalDateTime.now());
		if(ticket.getNumber() == null)
			ticket.setNumber(ticket.makeNumber());
		ticketRepository.save(ticket);		
	}

	@Override
	public Optional<Ticket> findById(Long id) {
		
		return ticketRepository.findById(id);
	}
}
