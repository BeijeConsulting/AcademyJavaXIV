package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.ListaServizio;

@Repository
public interface ListaServizioRepository extends JpaRepository<ListaServizio, Integer>{
}
