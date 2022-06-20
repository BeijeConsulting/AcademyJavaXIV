package it.beije.turing.settemmezzo.login;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer>{

	Optional<RefreshToken> findByRefreshToken(String refreshTokenString);

	Optional<RefreshToken> findByUserId(Integer id);

	List<RefreshToken> deleteByExpirationDateLessThan(Timestamp valueOf);

	Iterable<? extends RefreshToken> findByExpirationDateLessThan(Timestamp valueOf);

}
