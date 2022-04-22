package it.beije.turing.db;

import it.beije.turing.rubrica.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

import static it.beije.turing.db.SingletonJPA.entityManager;

public class JPAcriteria {


    private EntityManager session;
    private EntityManagerFactory entityManagerFactory;
    private CriteriaBuilder cb;
    public JPAcriteria(){

        session = SingletonJPA.getEntityManagerInstance();
        entityManagerFactory = Persistence.createEntityManagerFactory("turing");

    }

    @Transactional
    public void JPAaggiungiContatto(Contatto c){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();


        entityManager.createNativeQuery("INSERT INTO rubrica (nome, cognome, email, telefono, note) VALUES ( ?, ?, ?, ?, ?)")

                .setParameter(1, c.getNome())
                .setParameter(2, c.getCognome())
                .setParameter(3, c.getEmail())
                .setParameter(4, c.getTelefono())
                .setParameter(5, c.getNote())
                .executeUpdate();

        entityTransaction.commit();
        entityManager.close();

    }
    public  List<Contatto> JPACriteriaLeggiContatti(){

        cb = session.getCriteriaBuilder();
        CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
        Root<Contatto> root = cr.from(Contatto.class);
        cr.select(root);

//        Query<Contatto> query = session.createQuery(cr);
//        List<Contatto> results = query.getResultList();

//        return  results;

        return session.createQuery(cr).getResultList();
    }

        public void aggiungiContatto(Contatto contattoNuovo){

            cb = session.getCriteriaBuilder();
            CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
            Root<Contatto> root = cr.from(Contatto.class);
            cr.select(root);

//            Query<Contatto> query = session.createQuery(cr);
//            List<Contatto> results = query.getResultList();



        }

    public void delete(Contatto c) {

        CriteriaBuilder cb = this.session.getCriteriaBuilder();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // create delete
        CriteriaDelete<Contatto> delete = cb.
                createCriteriaDelete(Contatto.class);

        // set the root class
        Root e = delete.from(Contatto.class);

        // set where clause
        delete.where(cb.equal(e.get("id"), c.getId()));

        // perform update
        this.session.createQuery(delete).executeUpdate();

        entityTransaction.commit();


    }
}
