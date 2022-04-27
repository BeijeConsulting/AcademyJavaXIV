package it.beije.turing.JPAContactsManager;

import javax.persistence.EntityManager;

public class ContactDBManager {
    public static void ShowContacts() {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();
    }
}
