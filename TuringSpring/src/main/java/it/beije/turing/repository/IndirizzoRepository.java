package it.beije.turing.repository;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.TipoStruttura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo,Integer> {

    @Query(value = "SELECT i FROM Indirizzo as i WHERE i.citta  = :citta")
    public List<Indirizzo> searchByTipo(@Param("citta") String citta);
}
