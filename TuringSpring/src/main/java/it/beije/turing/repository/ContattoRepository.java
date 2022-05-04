package it.beije.turing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.turing.Contatto;


@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer>
{
	public List<Contatto> findByNome(String nome);
	public List<Contatto> findByCognome(String cognome);
	public List<Contatto> findByEmail(String email);
	public List<Contatto> findByTelefono(String telefono);
	public List<Contatto> findByNote(String note);
}