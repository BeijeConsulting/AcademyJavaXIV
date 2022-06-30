package it.beije.turing.settemmezzo.http.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.beije.turing.settemmezzo.exception.ForbiddenException;
import it.beije.turing.settemmezzo.exception.InvalidArgumentException;
import it.beije.turing.settemmezzo.game.lobby.Lobby;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
//import io.swagger.v3.oas.annotations.tags.Tag;
import it.beije.turing.settemmezzo.game.Game;
import it.beije.turing.settemmezzo.game.Leaderboard;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.login.RefreshTokenService;
import it.beije.turing.settemmezzo.login.UserDto;
import it.beije.turing.settemmezzo.login.UserRegistration;
import it.beije.turing.settemmezzo.login.security.JwtTokenProvider;
import it.beije.turing.settemmezzo.websocket.service.HashService;
import it.beije.turing.settemmezzo.websocket.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
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

	@Autowired
	private HashService hashService;

	@PreAuthorize("permitAll()")
	@PostMapping("/user/registration")
	public User insertUser(@RequestBody UserRegistration userRegistration) {
		User user = new User();
		user.setEmail(userRegistration.getEmail());
		user.setPassword(userRegistration.getPassword());
		user.setUsername(userRegistration.getUsername());
		log.debug("//user//registration -> User: " + user);
		try {
			//Check email validity
			if (!user.getEmail().matches("^[A-z0-9-_.]+@[A-z]+(\\.[A-z]+)+$")) {
				throw new InvalidArgumentException("Email isn't in the correct format");
			}
			//Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
			if(!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
				throw new InvalidArgumentException("Password must contain minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character");
			}
			User utente = userService.createUser(user);
			utente.setPassword(hashService.pswToHash(utente.getPassword()));

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
	@GetMapping(value = "/getuser/{user_id}")
	public User getUser(@PathVariable("user_id") Integer userId) {
		log.debug("//users");
		User user = userService.getUser(userId);
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
	public Map<String, Boolean> deleteUser(Authentication auth) {
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

			if (Game.getInstance().getUser(user.getId()) == null)
				Game.getInstance().addUser(user);
			user = Game.getInstance().getUser(user.getId());

			return userService.createLobby(user);

		} else {
			throw new ForbiddenException("Autenticazione non valida -- 401");
		}
	}

	@PreAuthorize("hasAuthority('USER')")
	@PutMapping(value = "/lobby/{room_id}")
	public Lobby joinLobby(Authentication auth, @PathVariable("room_id") Integer roomId) {
		log.debug("joinLobby");
		log.debug("auth " + auth);

		if (auth.isAuthenticated()) {

			User user = (User) auth.getPrincipal();

			log.error("auth: " + user);

			if (Game.getInstance().getUser(user.getId()) == null) {
				Game.getInstance().addUser(user);
			}

			user = Game.getInstance().getUser(user.getId());

			return userService.joinLobby(user, roomId);

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

			if (Game.getInstance().getUser(user.getId()) == null)
				Game.getInstance().addUser(user);
			user = Game.getInstance().getUser(user.getId());

			return userService.quitLobby(user);

		} else {
			throw new ForbiddenException("Autenticazione non valida -- 401");
		}
	}
	
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping(value = "/leaderboard")
	public Leaderboard getLeaderboard(Authentication auth) {
		log.debug("getLeaderboard");
		log.debug("auth " + auth);

		if (auth.isAuthenticated())
		{
			return userService.getLeaderboard();

		} else {
			throw new ForbiddenException("Autenticazione non valida -- 401");
		}
	}
}
