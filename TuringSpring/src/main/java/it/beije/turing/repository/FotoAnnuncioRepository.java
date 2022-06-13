package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.FotoAnnuncio;

@Repository
public interface FotoAnnuncioRepository extends JpaRepository<FotoAnnuncio,Integer> {
    
}
