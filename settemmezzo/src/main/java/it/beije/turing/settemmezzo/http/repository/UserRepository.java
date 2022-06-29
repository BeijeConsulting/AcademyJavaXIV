package it.beije.turing.settemmezzo.http.repository;

import it.beije.turing.settemmezzo.game.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
		
	User findByEmail(String Email);
	
	Optional<User> findById(Integer id);
	
	User findByEmailAndPassword(String email, String password);
	
	@Query(nativeQuery = true, value = "SELECT * FROM settemmezzo.users WHERE users.score > 0 ORDER BY users.score DESC LIMIT 10;")
	List<User> getLeaderboard();
}
