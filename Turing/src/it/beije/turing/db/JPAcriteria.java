package it.beije.turing.db;

import it.beije.turing.rubrica.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
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

        entityManager = entityManagerFactory.createEntityManager();
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

        List<Contatto> l = session.createQuery(cr).getResultList();


        return l ;



    }

        public void aggiungiContatto(Contatto contattoNuovo){

            cb = session.getCriteriaBuilder();
            CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
            Root<Contatto> root = cr.from(Contatto.class);
            cr.select(root);

//            Query<Contatto> query = session.createQuery(cr);
//            List<Contatto> results = query.getResultList();
            entityManager.close();
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

    public CriteriaDelete<Contatto> multipleDelete(Contatto c) {

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

        return delete;
    }

    public void singleSessionDeleteExecution(CriteriaDelete<Contatto> delete){

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        this.session.createQuery(delete).executeUpdate();

        entityTransaction.commit();
    }


    public void modifica(Contatto c, String nome, String cognome, String email, String telefono, String note) {


        CriteriaBuilder cb = this.session.getCriteriaBuilder();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // create delete
        CriteriaUpdate<Contatto> update = cb.
                createCriteriaUpdate(Contatto.class);

        // set the root class
        Root e = update.from(Contatto.class);

        // set where clause
        if(!nome.equalsIgnoreCase("NO")){
            update.set("nome", nome);
        }
        if(!cognome.equalsIgnoreCase("NO")){
            update.set("cognome", cognome);
        }
        if(!email.equalsIgnoreCase("NO")){
            update.set("email", email);
        }
        if(!telefono.equalsIgnoreCase("NO")){
            update.set("telefono", telefono);
        }
        if(!note.equalsIgnoreCase("NO")){
            update.set("note", note);
        }
        update.where(cb.equal(e.get("id"), c.getId()));

        // perform update
        this.session.createQuery(update).executeUpdate();

//      this.session.createQuery("SELECT * FROM rubrica");
        entityTransaction.commit();

//      entityManager.createNativeQuery("SELECT * FROM turing.rubrica");

    }



}
