package it.beije.turing.settemmezzo.login;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Integer> {


}
