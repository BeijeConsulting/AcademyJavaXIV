package it.beije.turing.web.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityFactory {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager createJPAEntityManager(String serverName) {
        if (entityManagerFactory == null) {
            System.out.println("creating EntityManager...");

            entityManagerFactory = Persistence.createEntityManagerFactory(serverName);
        }

        return entityManagerFactory.createEntityManager();
    }

}
