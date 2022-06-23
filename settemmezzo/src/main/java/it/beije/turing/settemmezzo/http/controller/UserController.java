package it.beije.turing.settemmezzo.http.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;

import it.beije.turing.settemmezzo.exception.ForbiddenException;
import it.beije.turing.settemmezzo.exception.GameActionException;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.v3.oas.annotations.tags.Tag;
import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.login.RefreshTokenService;
import it.beije.turing.settemmezzo.login.UserDto;
import it.beije.turing.settemmezzo.login.security.JwtTokenProvider;
import it.beije.turing.settemmezzo.websocket.service.UserService;


@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private RefreshTokenService refreshTokenService;
	
	

	private final SimpMessagingTemplate simpMessagingTemplate;

	@PreAuthorize("permitAll()")
	@PostMapping("/user/registration")
	public User insertUser(@RequestBody User user) {
		log.debug("//user//registration -> User: " + user);
		try {
			User utente = userService.createUser(user);
			
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
		log.debug("//users");
		List<User> users = userService.getAllUser();
		return users;

	}
	
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping(value = "/getuser")
	public User getUser(@PathVariable("id") Integer id) {
		log.debug("//users");
		User user = userService.getUser(id);
		return user;
	}

	@PreAuthorize("hasAuthority('USER')")
	@PutMapping(value = "/editprofile")
	public User updateUser(Authentication auth, @RequestBody UserDto userDto) {
		log.debug("//user//registration -> UserDto: " + userDto + " Authentication: " + auth);
		if (auth.isAuthenticated()) {

			User orginUser = (User) auth.getPrincipal();
			return userService.updateUser(orginUser, userDto);

		} else {
			throw new ForbiddenException("Autenticazione non valida - 401");
		}

	}
	
	@PreAuthorize("hasAuthority('USER')")
	@DeleteMapping(value = "/deleteuser")
	public  Map<String, Boolean> deleteUser(Authentication auth) {
		log.debug("/deleteuser -> Authentication: " + auth);
		if (auth.isAuthenticated()) {

			User user = (User) auth.getPrincipal();
			userService.removeUser(user);
			Map<String, Boolean> map = new HashMap<String, Boolean>();
			map.put("Esito: ", Boolean.TRUE);
			return map;
		} else {
			throw new ForbiddenException("Autenticazione non valida -- 401");
		}
	}

	@PreAuthorize("hasAuthority('USER')")
	@PostMapping(value = "/lobby")
	public Lobby createLobby(Authentication auth) {
		log.debug("createLobby");
		if (auth.isAuthenticated()) {

			User user = (User) auth.getPrincipal();
			
			if (Game.getInstance().getUser(user) == null) Game.getInstance().addUser(user);
			user = Game.getInstance().getUser(user);
			
			return userService.createLobby(user);

		} else {
			throw new ForbiddenException("Autenticazione non valida -- 401");
		}
	}

	@PreAuthorize("hasAuthority('USER')")
	@PutMapping(value = "/lobby/{room_id}")
	public Lobby joinLobby(Authentication auth, @PathVariable("room_id") Integer roomId) {
		log.debug("joinLobby");
		
		if (auth.isAuthenticated()) {

			User user = (User) auth.getPrincipal();
			
			if (Game.getInstance().getUser(user) == null) Game.getInstance().addUser(user);
			user = Game.getInstance().getUser(user);

			Lobby lobby = userService.joinLobby(user, roomId);

			simpMessagingTemplate.convertAndSend("/lobby/" + roomId, lobby);

			return lobby;

		} else {
			throw new ForbiddenException("Autenticazione non valida -- 401");
		}
	}

	@PreAuthorize("hasAuthority('USER')")
	@DeleteMapping(value = "/lobby")
	public Map<String, Boolean> quitLobby(Authentication auth) {
		log.debug("quitLobby");

		if (auth.isAuthenticated()) {
			
			User user = (User) auth.getPrincipal();
			
			if (Game.getInstance().getUser(user) == null) Game.getInstance().addUser(user);
			user = Game.getInstance().getUser(user);

			return userService.quitLobby(user);

		} else {
			throw new ForbiddenException("Autenticazione non valida -- 401");
		}
	}
}
