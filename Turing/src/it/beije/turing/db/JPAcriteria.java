package it.beije.turing.db;

import it.beije.turing.rubrica.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public class JPAcriteria {


    private EntityManager session;
    private EntityManagerFactory entityManagerFactory;
    public JPAcriteria(){

        session = SingletonJPA.getEntityManagerInstance();
        entityManagerFactory = Persistence.createEntityManagerFactory("turing");

    }

    @Transactional
    public void JPAaggiungiContatto(Contatto c){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

//        Contatto newContatto = new Contatto();
//		//newContatto.setId(3);
//		newContatto.setCognome(c.getCognome());
//		newContatto.setNome(c.getNome());
//		newContatto.setEmail(c.getEmail());
//        newContatto.setTelefono(c.getTelefono());
//        newContatto.setNote(c.getNote());
//		System.out.println("contatto PRE : " + newContatto);

//		entityManager.persist(newContatto);
//
//   turing.rubrica (nome, cognome, email, telefono)

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

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
        Root<Contatto> root = cr.from(Contatto.class);
        cr.select(root);

//        Query<Contatto> query = session.createQuery(cr);
//        List<Contatto> results = query.getResultList();

//        return  results;

        return session.createQuery(cr).getResultList();
    }

        public void aggiungiContatto(Contatto contattoNuovo){

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
            Root<Contatto> root = cr.from(Contatto.class);
            cr.select(root);

//            Query<Contatto> query = session.createQuery(cr);
//            List<Contatto> results = query.getResultList();



        }
}
