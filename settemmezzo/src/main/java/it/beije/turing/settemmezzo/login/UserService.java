package it.beije.turing.settemmezzo.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;

	private static final Integer DEFAULT_AUTHORITY = 1;
	
	private void setDefaultAuthority(User newUser) {

        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setUserId(newUser.getId());
        userAuthority.setAuthorityId(DEFAULT_AUTHORITY);
        userAuthorityRepository.saveAndFlush(userAuthority);

    }
	
	public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }
	
	public User createUser(User user) {

		if ((user.getUsername() != null && !user.getUsername().isEmpty()
				&& user.getPassword() != null && !user.getPassword().isEmpty())
				&& (user.getEmail() != null && !user.getEmail().isEmpty())) {

			if (userRepository.findByEmail(user.getEmail()) == null) {

				User newUser = userRepository.save(user);
				setDefaultAuthority(newUser);

				userRepository.flush();

				return user;
			} else {
				throw new RuntimeException("Email giá presente nel database");
			}
		} else {
			throw new RuntimeException("Nome, Cognome, Password o Email = null, o stringa vuota");
		}
	}

//	public UserDto login(String email, String password) {
//		System.out.print("Password inserita: " + passwordEncoder.encode(password));
//		System.out.print("Password inserita: " + passwordEncoder.encode(password));
//		// TODO buon lunedì owo
//
//		User user = userRepository.findByEmail(email);
//		if (user == null) {
//			throw new RuntimeException("No user found.");// TODONoContentException();
//		}
//		if (passwordEncoder.matches(password, user.getPassword())) {
//			System.out.println("Password corretta");
//		}
//
//		return new UserDto(user);
//	}

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

	public boolean removeUser(User user) {

		if (user == null) {
			throw new RuntimeException("No user found with given id");
		}
		userRepository.deleteById(user.getId());
		return true;
	}

	public User updateUser(User user, UserDto newUser) {
		
		if (newUser.getEmail() != null && newUser.getEmail() != "") {
			user.setEmail(newUser.getEmail());
		}
		if (newUser.getPassword() != null && newUser.getPassword() != "") {
			user.setPassword(newUser.getPassword());
		}
		if (newUser.getUsername() != null && newUser.getEmail() != "") {
			user.setUsername(newUser.getUsername());
		}

		userRepository.save(user);

		return user;
	}

	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {

		try {
			User utente = userRepository.findByEmail(email);
			if (utente == null) {

				throw new UsernameNotFoundException("email: " + email + " not found");
			}

			return utente;
		} catch (IllegalArgumentException iaEx) {
			throw new RuntimeException("email = null");
		}
//        catch (Exception e) {
//            throw e;
//        }
	}
}
