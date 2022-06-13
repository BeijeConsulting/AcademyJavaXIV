package it.beije.turing.repository;

import java.util.List;

import it.beije.turing.beans.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    public Utente findDistinctByEmail(String email);

}
