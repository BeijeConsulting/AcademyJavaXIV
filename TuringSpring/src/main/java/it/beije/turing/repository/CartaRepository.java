package it.beije.turing.repository;

import java.util.List;

import it.beije.turing.beans.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer>{

	public List<Carta> findByUtenteId(Integer utenteId);

}
