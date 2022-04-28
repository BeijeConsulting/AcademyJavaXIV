package it.beije.turing.web.rubrica;


import org.hibernate.HibernateException;
import org.xml.sax.SAXException;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

        } catch (HibernateException hbmEx) {
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

    public static List<Contatto> getOrderedRubrica(String s) {
        EntityManager entityManager = null;
        List<Contatto> contatti = new ArrayList<>();
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
            entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = cb.createQuery();
            Root<Contatto> from = criteriaQuery.from(Contatto.class);

            CriteriaQuery<Object> select = criteriaQuery.select(from);
            select.orderBy(cb.asc(from.get(s)));
            TypedQuery<Object> typedQuery = entityManager.createQuery(select);
            List<Object> resultlist = typedQuery.getResultList();

            contatti = new ArrayList<>();
            for (Object o : resultlist) {
                Contatto e = (Contatto) o;
                contatti.add(e);
            }
        } catch (HibernateException hbmEx) {
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

    public static void insertContatto(Contatto contattoNuovo) {
        EntityManager entityManager = null;

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
            entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(contattoNuovo);

            entityTransaction.commit();

        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        finally {
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
            if (!contattoNuovo.getNome().equals("")) {
                contatto.setNome(contattoNuovo.getNome());
            }
            if (!contattoNuovo.getCognome().equals("")) {
                contatto.setCognome(contattoNuovo.getCognome());
            }
            if (!contattoNuovo.getTelefono().equals("")) {
                contatto.setTelefono(contattoNuovo.getTelefono());
            }
            if (!contattoNuovo.getEmail().equals("")) {
                contatto.setEmail(contattoNuovo.getEmail());
            }
            if (!contattoNuovo.getNote().equals("")) {
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

//    public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
//        List<Contatto> contatti = CSVManager.loadRubricaFromCSV(path, separatore, virgolette);
//
//        for (Contatto c : contatti) {
//            insertContatto(c);
//        }
//    }
//
//    public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
//        List<Contatto> contatti = XMLManager.loadRubricaFromXML(path);
//
//        for (Contatto c : contatti) {
//            insertContatto(c);
//        }
//    }

}
