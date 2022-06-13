package it.beije.turing.repository;

import it.beije.turing.beans.Recensione;
import it.beije.turing.beans.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Integer> {


    public List<Recensione> findByPunteggio(Integer punteggio);
    public List<Recensione> findByReviewerId(Integer reviewerId);
    public List<Recensione> findByPrenotazioneId(Integer prenotazioneId);


    @Query(value = "SELECT rec FROM Recensione as rec WHERE rec.punteggio >= :min AND rec.punteggio<= :max")
    public List<Recensione> searchByPunteggioRange(@Param("min") Integer min, @Param("max") Integer max);

}
