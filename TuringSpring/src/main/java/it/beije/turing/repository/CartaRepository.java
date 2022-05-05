package it.beije.turing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.turing.beans.Carta;


public interface CartaRepository extends JpaRepository<Carta, Integer>{

	List<Carta> findByUtenteId(Integer utente_id);

}
