package it.beije.turing.settemmezzo.http.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import it.beije.turing.settemmezzo.game.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.settemmezzo.login.AuthCredentials;
import it.beije.turing.settemmezzo.login.RefreshToken;
import it.beije.turing.settemmezzo.login.RefreshTokenService;
import it.beije.turing.settemmezzo.login.security.JwtTokenProvider;
import it.beije.turing.settemmezzo.websocket.service.HashService;
import it.beije.turing.settemmezzo.websocket.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	UserService userService;

	@Autowired
	RefreshTokenService refreshTokenService;
	
	@Autowired
    private HashService hashService;

	
	@PostMapping("/signin")
	public ResponseEntity<Map<String, Object>> signin(@RequestBody AuthCredentials credentials) {

		try {
			
			String username = credentials.getEmail();
			User user = userService.loadUserByUsername(username);
			credentials.setPassword(hashService.pswToHash(credentials.getPassword()));
			
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, credentials.getPassword()));
			
			
			String token = jwtTokenProvider.createToken(username, user.getAuthorityList());

			System.out.println("TOKEN: ----------->" + token);
			RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);

			Map<String, Object> res = new HashMap<>();
			res.put("email", username);
			res.put("permission", user.getAuthorityList());
			res.put("token", token);
			res.put("refreshToken", refreshToken.getRefreshToken());
			res.put("id", user.getId());

			return ok(res);

		} catch (AuthenticationException e) {
			e.printStackTrace();
			throw new BadCredentialsException("Invalid username/password supplied");
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@PreAuthorize("permitAll()")
	@PostMapping("/updateAuthToken")
	public ResponseEntity<Map<String, Object>> reSignin(@RequestBody String refreshToken) {
		try {
			return this.signin(refreshTokenService.getAuthenticationFromRefreshToken(refreshToken));
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
