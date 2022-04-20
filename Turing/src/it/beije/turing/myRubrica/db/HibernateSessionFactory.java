package it.beije.turing.myRubrica.db;

import it.beije.turing.rubrica.Contatto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Giuseppe Raddato
 * Data: 20 apr 2022
 */
public class HibernateSessionFactory {
    private HibernateSessionFactory(){}

    private static SessionFactory sessionF;
    public static Session opSession(){
        if(sessionF==null){
           Configuration c= new Configuration().configure().addAnnotatedClass(Contatto.class);
           sessionF=c.buildSessionFactory();
        }
        return sessionF.openSession();

    }

}
