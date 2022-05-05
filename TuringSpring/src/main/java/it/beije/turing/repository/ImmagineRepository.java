package it.beije.turing.repository;

import it.beije.turing.beans.Immagine;
import it.beije.turing.beans.Struttura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmagineRepository extends JpaRepository<Immagine,Integer> {
}
