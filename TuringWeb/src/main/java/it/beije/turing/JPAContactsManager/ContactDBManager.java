package it.beije.turing.JPAContactsManager;

import javax.persistence.EntityManager;
import java.util.List;

public class ContactDBManager {
    public static List<Contatto> ShowContacts() {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();
        entityManager.getTransaction();
        List<Contatto> contattoList = entityManager.createQuery("Select c from Contatto as c"). getResultList();

        return contattoList;
    }
}
