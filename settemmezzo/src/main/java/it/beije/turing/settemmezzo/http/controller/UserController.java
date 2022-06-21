package it.beije.turing.settemmezzo.http.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.beije.turing.settemmezzo.login.RefreshTokenService;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.login.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.beije.turing.settemmezzo.login.security.JwtTokenProvider;
import it.beije.turing.settemmezzo.websocket.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//Questi due metodi sono inutili li teniamo per ricordo <3
//	@PostMapping(value = "/login")
//	public UserDto login(@RequestBody UserDto userDto) {
//		UserDto u = userService.login(userDto.getEmail(), userDto.getPassword());
//
//		// TODO online = true;
//
//		if (u == null) {
//			throw new RuntimeException("");
//		}
//		return u;
//	}

//	@PostMapping(value = "/addUser")
//	public UserDto addUser(@RequestBody User user) {
//		if (user.getPassword() == null || user.getEmail() == null || user.getUsername() == null) {
//			throw new RuntimeException("One or more fields missing for creating a user");
//		}
//		user.setScore(0);
//
//		userService.addUser(user);
//		UserDto userDto = new UserDto(user);
//
//		return userDto;
//
//	}

	@PreAuthorize("permitAll()")
	@PostMapping("/user/registration")
	public User insertUser(@RequestBody User user) {

		try {
			User utente = userService.createUser(user);
			utente.setPassword(passwordEncoder.encode(utente.getPassword()));
			String token = jwtTokenProvider.generateTokenRegistration(utente.getEmail(), LocalDateTime.now());
//			mailUtil.senMail(token,utente);

			userService.saveRegisteredUser(utente);

			return utente;

		} catch (Exception alreadyExistException) {
			throw alreadyExistException;
		} 
//		catch (MessagingException messagingException) {
//			log.error("Insert User MessagingException", messagingException);
//			throw new ServiceException("Error system");
//		}
	}

	@PreAuthorize("permitAll()")
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		List<User> users = userService.getAllUser();
		return users;

	}

	@PreAuthorize("hasAuthority('USER')")
	@PutMapping(value = "/editprofile")
	public User updateUser(Authentication auth, @RequestBody UserDto userDto) {

		if (auth.isAuthenticated()) {

			User orginUser = (User) auth.getPrincipal();
			return userService.updateUser(orginUser, userDto);

		} else {
			throw new RuntimeException("Autenticazione non valida - 401");
		}

	}
	
	@PreAuthorize("hasAuthority('USER')")
	@PutMapping(value = "/user")
	public  Map<String, Boolean> deleteUser(Authentication auth) {

		if (auth.isAuthenticated()) {

			User user = (User) auth.getPrincipal();
			Map<String, Boolean> map = new HashMap<String, Boolean>();
			map.put("Esito: ", Boolean.TRUE);
			return map;
		} else {
			throw new RuntimeException("Autenticazione non valida -- 401");
		}
	}

}
