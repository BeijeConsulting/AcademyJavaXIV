package it.beije.turing.rubrica;

import it.beije.turing.db.HBsessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MyH8Manager {

    public static List<Contatto> loadRubricaFromH8() {
        Session session = null;
        List<Contatto> contacts = null;

        try {
            session = HBsessionFactory.openH8Session();

            Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
            contacts = query.getResultList();

        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }

        return contacts;
    }

    public static void insertContact(Contatto contact) {
        Session session = null;

        try {
            session = HBsessionFactory.openH8Session();

            Transaction transaction = session.beginTransaction();

            session.save(contact);
            transaction.commit();

        } catch (HibernateException hbmEx) {
            hbmEx.printStackTrace();
            throw hbmEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }


}
