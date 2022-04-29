package main.java.it.beije.turing.JPAContactsManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager createEntityManager() {
        if(entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("turing");
        }

        return entityManagerFactory.createEntityManager();
    }
}
