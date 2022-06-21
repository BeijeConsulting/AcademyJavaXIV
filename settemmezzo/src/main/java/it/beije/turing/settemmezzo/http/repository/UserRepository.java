package it.beije.turing.settemmezzo.http.repository;

import it.beije.turing.settemmezzo.game.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
		
	User findByEmail(String Email);
	
	User findByEmailAndPassword(String email, String password);
	
}
