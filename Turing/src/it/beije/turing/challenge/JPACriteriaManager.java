package it.beije.turing.challenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.parsers.ParserConfigurationException;


import it.beije.turing.file.CSVManager;
import it.beije.turing.file.XMLManager;
import it.beije.turing.db.MyHBManager;
import it.beije.turing.rubrica.Contatto;
import org.hibernate.HibernateException;
import org.xml.sax.SAXException;

public class JPACriteriaManager {
    public static List<Contatto> getRubrica() {
        List<Contatto> contatti = new ArrayList<>();
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
            entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
            Root<Contatto> from = cq.from(Contatto.class);
            cq.select(from);
            TypedQuery<Contatto> q = entityManager.createQuery(cq);
            contatti = q.getResultList();

        }catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }


        return contatti;
    }
    public static void insertContatto(List<Contatto> contatti) {
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
            entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

//            CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
//            Root<Contatto> from = cq.from(Contatto.class);
//            cq.select(from);
//            TypedQuery<Contatto> q = entityManager.createQuery(cq);
//            List<Contatto> contatti = q.getResultList();
            for (Contatto contattoNuovo: contatti) {
                entityManager.persist(contattoNuovo);
            }
            entityTransaction.commit();

        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public static void updateDB(Contatto contattoNuovo, int id) {
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
            entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
            Root<Contatto> from = cq.from(Contatto.class);
            cq.select(from);
            TypedQuery<Contatto> q = entityManager.createQuery(cq);
            List<Contatto> contatti = q.getResultList();

            Contatto contatto = null;
            for (Contatto c : contatti) {
                if (c.getId() == id) contatto = c;
            }

            System.out.println("modifico : " + contatto);
            if(!contattoNuovo.getNome().equals("")) {
                contatto.setNome(contattoNuovo.getNome());
            }
            if(!contattoNuovo.getCognome().equals("")) {
                contatto.setCognome(contattoNuovo.getCognome());
            }
            if(!contattoNuovo.getTelefono().equals("")) {
                contatto.setTelefono(contattoNuovo.getTelefono());
            }
            if(!contattoNuovo.getEmail().equals("")) {
                contatto.setEmail(contattoNuovo.getEmail());
            }
            if(!contattoNuovo.getNote().equals("")) {
                contatto.setNote(contattoNuovo.getNote());
            }
            entityManager.persist(contatto);
            entityTransaction.commit();

        } catch (HibernateException hbmEx) {
        hbmEx.printStackTrace();
        throw hbmEx;
    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    } finally {
        entityManager.close();
    }
    }
    public static void deleteDB(int id) {
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
            entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
            Root<Contatto> from = cq.from(Contatto.class);
            cq.select(from);
            TypedQuery<Contatto> q = entityManager.createQuery(cq);
            List<Contatto> contatti = q.getResultList();

            Contatto contatto = null;
            for (Contatto c : contatti) {
                if (c.getId() == id) contatto = c;
            }

            entityManager.remove(contatto);

            entityTransaction.commit();

        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }
    public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
        List<Contatto> contatti = CSVManager.loadRubricaFromCSV(path, separatore, virgolette);

        MyHBManager.saveIntoDB(contatti);
    }

    public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
        List<Contatto> contatti = XMLManager.loadRubricaFromXML(path);

        MyHBManager.saveIntoDB(contatti);
    }

//    public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
//        List<Contatto> contatti = CSVManager.loadRubricaFromCSV(path, separatore, virgolette);
//
//        saveIntoDB(contatti);
//    }
//
//    public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
//        List<Contatto> contatti = XMLManager.loadRubricaFromXML(path);
//
//        saveIntoDB(contatti);
//    }


//    public static void main(String[] args) {
//
//        List<Contatto> cont = new ArrayList<>();
////        for(Contatto c : contatti) {
////            System.out.println(c);
////        }
//
//        Contatto contatto = new Contatto();
//        contatto.setNome("Francesco");
//        contatto.setCognome("Montale");
//        contatto.setEmail("framontale@beije.it");
//        contatto.setTelefono("3459998887");
//        contatto.setNote("Sono nuovo");
//        cont.add(contatto);
//
//        //updateDB(contatto,2);
//        insertContatto(cont);
//
//        List<Contatto> contatti = getRubrica();
//        for(Contatto c : contatti) {
//            System.out.println(c);
//        }
//        //INSERT
////		Contatto newContatto = new Contatto();
////		//newContatto.setId(3);
////		newContatto.setCognome("Corraro");
////		newContatto.setNome("Mattia");
////		newContatto.setEmail("m.corraro@beije.it");
////		System.out.println("contatto PRE : " + newContatto);
////
////		entityManager.persist(newContatto);
////
////		System.out.println("contatto POST : " + newContatto);
//
//
////		//DELETE
////		entityManager.remove(contatto);
//
//        //entityTransaction.commit();
//        //entityTransaction.rollback();
//
////        //SELECT JPQL
////        Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
////        List<Contatto> contatti = query.getResultList();
////
////        for (Contatto c : contatti) {
////            System.out.println(c);
////        }
//
////        entityManager.close();
//
//    }
}
