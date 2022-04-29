package main.java.it.beije.turing.JPAContactsManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ContactDBManager {
    public static List<Contatto> ShowContacts() {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();

        return entityManager.createQuery("Select c from Contatto as c").getResultList();
    }

    public static void createContact(String nome, String cognome, String email, String telefono, String note) {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Contatto newContatto = new Contatto();
        newContatto.setCognome(cognome);
        newContatto.setNome(nome);
        newContatto.setEmail(email);
        newContatto.setTelefono(telefono);
        newContatto.setNote(note);

        entityManager.persist(newContatto);
        entityTransaction.commit();
    }

    public static List<Contatto> searchContacts(Contatto contact) {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();
        entityManager.getTransaction();
        List<Contatto> contactsFound= new ArrayList<>();
        System.out.println(contact);

        StringBuilder b = new StringBuilder("WHERE ");
        boolean firstCondition = true;
        if (contact.getNome() != null) {
            if (!firstCondition) b.append("AND ");
            firstCondition = false;
            b.append("nome LIKE '%" + contact.getNome() + "%' ");
        }
        if (contact.getCognome() != null) {
            if (!firstCondition) b.append("AND ");
            firstCondition = false;
            b.append("cognome LIKE '%" + contact.getCognome() + "%' ");
        }
        if (contact.getTelefono() != null) {
            if (!firstCondition) b.append("AND ");
            firstCondition = false;
            b.append("telefono LIKE '%" + contact.getTelefono() + "%' ");
        }
        if (contact.getEmail() != null) {
            if (!firstCondition) b.append("AND ");
            firstCondition = false;
            b.append("email LIKE '%" + contact.getEmail() + "%' ");
        }

        String beginStatement = "SELECT c FROM Contatto as c ";
        String queryStatement = b.insert(0, beginStatement).toString();

        System.out.println(queryStatement);

        Query query = entityManager.createQuery(queryStatement);
        contactsFound = query.getResultList();

        return contactsFound;
    }

    public static void updateContact(int id, String nome, String cognome, String email, String telefono, String note) {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Contatto contatto = entityManager.find(Contatto.class, id);

        if(contatto != null) {
            if(nome != "") {
                contatto.setNome(nome);
            }
            if(cognome != "") {
                contatto.setCognome(cognome);
            }
            if(email != "") {
                contatto.setEmail(email);
            }
            if(telefono != "") {
                contatto.setTelefono(telefono);
            }
            if(note != "") {
                contatto.setNote(note);
            }
            entityManager.persist(contatto);
            entityTransaction.commit();
        }
    }

    public static void deleteContact(int id) {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Contatto contatto = entityManager.find(Contatto.class, id);

        entityManager.remove(contatto);
        entityTransaction.commit();
    }
}
