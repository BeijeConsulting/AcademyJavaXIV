package it.beije.turing.repository;

import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.StrutturaImmagini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrutturaImmaginiRepository extends JpaRepository<StrutturaImmagini,Integer> {
}
