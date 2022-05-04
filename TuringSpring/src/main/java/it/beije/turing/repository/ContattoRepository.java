package it.beije.turing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.turing.rubrica.bean.Contatto;



@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer> {

	public List<Contatto> findByCognome(String cognome);
	
	public List<Contatto> findByCognomeAndNome(String cognome, String nome);
	
	@Query(value = "SELECT c FROM Contatto as c WHERE email = :email")
//	@Query(nativeQuery = true, value = "SELECT * FROM rubrica WHERE email = :email")
	public List<Contatto> searchByEmail(@Param("email") String email);
	
}
