package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.Regola;

@Repository
public interface RegolaRepository extends JpaRepository<Regola, Integer>{

}
