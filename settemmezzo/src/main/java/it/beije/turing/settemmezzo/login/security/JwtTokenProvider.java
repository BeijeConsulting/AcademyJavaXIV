package it.beije.turing.settemmezzo.login.security;

import it.beije.turing.settemmezzo.http.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.websocket.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;


@Component
@Slf4j

public class JwtTokenProvider {    

	@Value("${authToken.secretKey}")
	private String secretKey;
	@Value("${authToken.validityInSeconds}")
	private long validityInSeconds;
	@Value("${token.validityConfirmRegistrationInSecond}")
	private long validityConfirmRegistrationInSecond; 
	@Autowired
	private UserService serviceUtente;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}    

	public String createToken(String username, List<String> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles);        

		Date now = new Date();
		Date validity = new Date(now.getTime() + (validityInSeconds*1000));

		return Jwts.builder()//
				.setClaims(claims)//
				.setIssuedAt(now)//
				.setExpiration(validity)//
				.signWith(SignatureAlgorithm.HS256, secretKey)//
				.compact();
	}

	public String generateTokenRegistration(String email, LocalDateTime dataIscrizione) {
		Claims claims = Jwts.claims().setSubject(email);
		claims.put("dataiscrizione", dataIscrizione.toString());
		Date now = new Date();
		Date validity = new Date(now.getTime() + (10000*validityConfirmRegistrationInSecond));

		return Jwts.builder()//
				.setClaims(claims)//
				.setIssuedAt(now)//
				.setExpiration(validity)//
				.signWith(SignatureAlgorithm.HS256, secretKey)//
				.compact();
	}


	public Authentication getAuthentication(String token) {
		User user = serviceUtente.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
	}    

	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public String getMail(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();

	}
	public String getDataRegistrazione(String token) {
		Claims res = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		return res.get("dataiscrizione",String.class);
	}

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}    

	public boolean validateToken(String token) {
		try {
			System.out.println("TOKEN:" + token);
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			
            return !claims.getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
        		System.out.println("Sono stato sopra");
	           throw new InvalidJwtAuthenticationException("Expired JWT1 token", InvalidJwtAuthenticationException.EXPIRED);
		} catch (JwtException | IllegalArgumentException e) {
			System.out.println("Sono stato qui");
			e.printStackTrace();
            throw new InvalidJwtAuthenticationException("Invalid JWT3 token", InvalidJwtAuthenticationException.FORBIDDEN);
		}
	}

}