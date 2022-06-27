package it.beije.turing.settemmezzo.login;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.beije.turing.settemmezzo.exception.ExpiredTokenException;
import it.beije.turing.settemmezzo.exception.VerificationTokenException;
import it.beije.turing.settemmezzo.game.User;
import it.beije.turing.settemmezzo.http.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


@Service
public class RefreshTokenService {
	
	@Autowired
	RefreshTokenRepository tokenRepository;
	
	@Autowired
    UserRepository userRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${refreshToken.secretKey}")
	private String secretKey = "secretKey";

	@Value("${authToken.validityRefreshInSeconds}")
	private   long refresh_validity_in_second; //24 ore

	
	@Transactional
	public RefreshToken createRefreshToken(User user) {
		try {
			clearOldTokens();
			Optional<RefreshToken> oldToken = tokenRepository.findByUserId(user.getId());
			if(oldToken.isPresent())
				return oldToken.get();
			
			RefreshToken token = new RefreshToken();
			token.setUserId(user.getId());
			token.setRefreshToken(generateRefreshToken(user.getUsername()));
			token.setExpirationDate(Timestamp.valueOf(LocalDateTime.now().plusSeconds(refresh_validity_in_second)));
			
			return tokenRepository.saveAndFlush(token);
		}catch(EntityExistsException | DataIntegrityViolationException/* | SQLIntegrityConstraintViolationException*/ e) {
			return createRefreshToken(user);
		}
	}

	
	private String generateRefreshToken(String username) {
		String secretKey = this.secretKey + new Random().nextInt();
		return Jwts.builder().setClaims(Jwts.claims().setSubject(username))
				.setExpiration(new java.util.Date(new java.util.Date().getTime() + refresh_validity_in_second*1000))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}

	
	public AuthCredentials getAuthenticationFromRefreshToken(String tokenString) {
		clearOldTokens();
//		RefreshToken token = tokenRepository.findByRefreshToken(tokenString).orElseThrow(() -> new InvalidJwtAuthenticationException("token not present", InvalidJwtAuthenticationException.FORBIDDEN));
		RefreshToken token = tokenRepository.findByRefreshToken(tokenString).orElseThrow(() -> new ExpiredTokenException("token not present"));
		if(token.getExpirationDate().before(Timestamp.valueOf(LocalDateTime.now())))
//			throw new InvalidJwtAuthenticationException("token expired", InvalidJwtAuthenticationException.EXPIRED);
			throw new VerificationTokenException("token expired");
//		Utente user = userRepository.findById(token.getUserId()).orElseThrow(() -> new NoContentException("ERROR"));
		User user = userRepository.findById(token.getUserId()).orElseThrow(() -> new ExpiredTokenException("No user found associated with this token"));
		AuthCredentials auth = new AuthCredentials();
		auth.setEmail(user.getUsername());
		auth.setPassword(user.getPassword());
		return auth;
	}
	
	@Transactional
	@Scheduled(fixedDelay=1000*60*60, initialDelay = 1000*60) //1h
	public void clearOldTokens() {
		log.debug("Cleaning refreshToken from database");
		tokenRepository.deleteAll(tokenRepository.findByExpirationDateLessThan(Timestamp.valueOf(LocalDateTime.now().minusMinutes(10))));
	}

}
