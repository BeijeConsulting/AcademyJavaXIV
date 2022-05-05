package it.beije.turing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.Messaggio;

@Repository
public interface MessaggioRepository extends JpaRepository<Messaggio, Integer>{
	
	List<Messaggio> findByUtendeId(Integer utente_id);

}
