package it.beije.ecommerce;

import javax.persistence.EntityManager;

public class MainManager {

    public static void mainSwitch(String... args) {
        EntityManager entityManager = EntityManagerFactorySingleton.createEntityManager();

    }
}
