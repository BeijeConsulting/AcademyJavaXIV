package it.beije.turing.web.util;

import it.beije.turing.web.rubrica.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MyJPAManager {

    public static List<Contatto> showContacts() {
        EntityManager entityManager = JPAEntityFactory.createJPAEntityManager("turing");
        entityManager.getTransaction();
        List<Contatto> contacts = entityManager.createQuery("Select c from Contatto as c").getResultList();

        return contacts;
    }

    public static List<Contatto> searchContacts(Contatto contact) {
        EntityManager entityManager = JPAEntityFactory.createJPAEntityManager("turing");
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

    public static void createContact(Contatto contact) {
        EntityManager entityManager = JPAEntityFactory.createJPAEntityManager("turing");
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Contatto newContatto = new Contatto();
        newContatto.setCognome(contact.getCognome());
        newContatto.setNome(contact.getNome());
        newContatto.setEmail(contact.getEmail());
        newContatto.setTelefono(contact.getTelefono());
        newContatto.setNote(contact.getNote());

        entityManager.persist(newContatto);
        entityTransaction.commit();
    }

    public static void updateContact(Contatto contact) {
        //TODO mofica contatto
    }

}
