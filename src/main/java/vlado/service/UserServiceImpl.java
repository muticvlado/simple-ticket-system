package vlado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import vlado.model.User;
import vlado.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		userRepository.save(user);		
	}

	@Override
	public Optional<User> findById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}	
}
