package it.beije.turing.settemmezzo.login;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import it.beije.turing.settemmezzo.game.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import it.beije.turing.settemmezzo.login.security.JwtTokenProvider;

@Controller
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	UserService userService;

	@Autowired
	RefreshTokenService refreshTokenService;


	@PostMapping("/signin")
	public ResponseEntity<Map<String, Object>> signin(@RequestBody AuthCredentials credentials) {

		try {
			
			String username = credentials.getEmail();
			User user = userService.loadUserByUsername(username);
			
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
	public ResponseEntity<Map<String, Object>> reSignin(@RequestBody RefreshToken refreshToken) {
		try {
			return this.signin(refreshTokenService.getAuthenticationFromRefreshToken(refreshToken.getRefreshToken()));
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
