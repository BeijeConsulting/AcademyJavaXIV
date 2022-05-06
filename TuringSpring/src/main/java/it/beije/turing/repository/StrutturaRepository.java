package it.beije.turing.repository;

import it.beije.turing.beans.Struttura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrutturaRepository extends JpaRepository<Struttura, Integer> {
}
