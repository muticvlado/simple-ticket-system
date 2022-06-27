package vlado.service;

import java.util.List;
import java.util.Optional;

import vlado.model.Ticket;

public interface TicketService {
	
	List<Ticket> findAll();
	
	void save(Ticket ticket);
	
	Optional<Ticket> findById(Long id);
}
