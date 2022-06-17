package it.beije.turing.settemmezzo.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDto login(String email, String password) {
		System.out.print("Password inserita: " + passwordEncoder.encode(password));
		System.out.print("Password inserita: " + passwordEncoder.encode(password));
		//TODO buon lunedì owo
		
		User user = userRepository.findByEmailAndPassword(email, passwordEncoder.encode(password));
		if (user == null) {
			throw new RuntimeException("No user found.");// TODONoContentException();
		}
		return new UserDto(user);
	}

	public List<User> getAllUser() {
		List<User> list = userRepository.findAll();

		if (list.isEmpty()) {
			throw new RuntimeException("No users found.");// TODONoContentException();
		}
		return list;
	}

	public User addUser(User user) {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw new RuntimeException("User already exists");
		}
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		} catch (IllegalArgumentException e) {
			throw e;
		}

		return user;

	}

	public boolean removeUser(Integer id) {
		User user;

		user = userRepository.findById(id).get();

		if (user == null) {
			throw new RuntimeException("No user found with given id");
		}
		userRepository.deleteById(id);
		return true;
	}
	
	public User updateUser(User user, Integer id) {
		User u = userRepository.findById(id).get();
		if(u == null) {
			throw new RuntimeException("User not found with given id");
		}
		if(user.getEmail() != null && user.getEmail() != "") {
			u.setEmail(u.getEmail());
		}
		if(user.getPassword() != null&& user.getPassword() != "") {
			u.setPassword(u.getPassword());
		}
		if(user.getUsername() != null && user.getEmail() != "") {
			u.setUsername(u.getUsername());
		}
		
		userRepository.save(u);
		
		return u;
	}
}
