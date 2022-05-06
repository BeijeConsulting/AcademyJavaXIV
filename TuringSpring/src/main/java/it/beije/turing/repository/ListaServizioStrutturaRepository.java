package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.ListaServizioStruttura;

@Repository
public interface ListaServizioStrutturaRepository  extends JpaRepository<ListaServizioStruttura, Integer>{
}
