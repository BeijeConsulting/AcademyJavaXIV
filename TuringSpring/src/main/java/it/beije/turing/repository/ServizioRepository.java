package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.Servizio;

@Repository
public interface ServizioRepository extends JpaRepository<Servizio, Integer>{
}
