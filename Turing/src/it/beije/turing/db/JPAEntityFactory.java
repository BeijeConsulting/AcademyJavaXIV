package it.beije.turing.db;

import it.beije.turing.rubrica.Contatto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
