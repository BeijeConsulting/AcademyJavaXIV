package it.beije.turing.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonJPA {

    private SingletonJPA(){

    }

    static EntityManager entityManager = null;

    public static EntityManager getEntityManagerInstance(){
        if(entityManager== null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
            entityManager = entityManagerFactory.createEntityManager();

        }
        return entityManager;
    }

}
