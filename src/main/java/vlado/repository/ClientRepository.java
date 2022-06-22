package vlado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vlado.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
