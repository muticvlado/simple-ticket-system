package vlado.service;

import java.util.List;
import java.util.Optional;

import vlado.model.Client;

public interface ClientService {

	List<Client> findAll();
	
	void save(Client client);
	
	Optional<Client> findById(Long id);
	
	void deleteById(Long id);
}
