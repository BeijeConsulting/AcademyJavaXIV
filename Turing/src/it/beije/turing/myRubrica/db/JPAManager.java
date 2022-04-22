package it.beije.turing.myRubrica.db;

import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 21 apr 2022
 */
public class JPAManager implements OpRubrica {


    @Override
    public List<Contatto> showContact(Order order) {
        EntityManager entityManager = SingletonJPA.getIstance();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contatto> criteriaQuery = criteriaBuilder.createQuery(Contatto.class);
        Root<Contatto> itemRoot = criteriaQuery.from(Contatto.class);
        criteriaQuery.select(itemRoot);
        if(order==Order.COGNOME){
            criteriaQuery.orderBy(criteriaBuilder.asc(itemRoot.get("cognome")));
        }
        if(order==Order.NOME){
            criteriaQuery.orderBy(criteriaBuilder.asc(itemRoot.get("nome")));
        }


        return entityManager.createQuery(criteriaQuery).getResultList();


    }

    @Override
    public List<Contatto> search(String s) {
        return null;
    }

    @Override
    public boolean insert(Contatto c) {
        return false;
    }

    @Override
    public boolean modificaContatto(Contatto c) {
        return false;
    }

    @Override
    public boolean deleteContatto(Contatto c) {
        return false;
    }

    @Override
    public List<Contatto> contattiDuplicati() {
        return null;
    }

    @Override
    public void unisciContatti() {

    }

    @Override
    public List<Contatto> importFromCVS(String path,String separator) {
        return null;
    }

    @Override
    public List<Contatto> importFromXML(String path) {
        return null;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contatti,String separator) {

    }

    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {

    }

     static class SingletonJPA{
        private SingletonJPA(){}

        private static EntityManager entityManager=null;
        public static EntityManager getIstance(){

            if(entityManager==null){
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
                 entityManager = entityManagerFactory.createEntityManager();
            }
            return entityManager;
        }
    }
}
