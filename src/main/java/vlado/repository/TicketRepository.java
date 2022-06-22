package vlado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vlado.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
