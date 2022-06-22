package vlado.service;

import java.util.List;
import java.util.Optional;

import vlado.model.User;

public interface UserService {
	
	List<User> findAll();
	
	void save(User user);
	
	Optional<User> findById(Long id);
	
	void deleteById(Long id);
}
