package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.ListaRegole;
import it.beije.turing.beans.PeriodoPrenotato;

@Repository
public interface PeriodoPrenotatoRepository extends JpaRepository<PeriodoPrenotato, Integer> {

}
