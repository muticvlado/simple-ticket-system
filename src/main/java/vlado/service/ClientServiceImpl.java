package vlado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.model.Client;
import vlado.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		
		return clientRepository.findAll();
	}

	@Override
	public void save(Client client) {
		
		clientRepository.save(client);		
	}

	@Override
	public Optional<Client> findById(Long id) {
		
		return clientRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		
		clientRepository.deleteById(id);		
	}
}
