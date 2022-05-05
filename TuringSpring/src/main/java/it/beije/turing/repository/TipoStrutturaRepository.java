package it.beije.turing.repository;

import it.beije.turing.beans.TipoStruttura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TipoStrutturaRepository extends JpaRepository<TipoStruttura,Integer> {


    @Query(value = "SELECT t FROM TipoStruttura as t WHERE t.tipo = :tipo")
    public List<TipoStruttura> searchByTipo(@Param("tipo") String tipo);

   /* static final String INSERT_QUERY="INSERT INTO tipologia_struttura (tipo) VALUES (':tipo');";
    //CREATE
    @Query(nativeQuery = true ,value = INSERT_QUERY)
    void insertNewTipoStruttura(@Param("tipo") String tipo);
    */

}
