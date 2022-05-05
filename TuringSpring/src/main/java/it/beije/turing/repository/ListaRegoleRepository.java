package it.beije.turing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.beans.ListaRegole;


@Repository
public interface ListaRegoleRepository extends JpaRepository<ListaRegole, Integer> {}