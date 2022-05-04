package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.Annuncio;


@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio, Integer> {
}
