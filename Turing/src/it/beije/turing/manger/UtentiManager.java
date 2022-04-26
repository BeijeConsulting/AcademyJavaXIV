package it.beije.turing.manger;

import it.beije.turing.beanecommerce.Utente;
import it.beije.turing.db.HBsessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Giuseppe Raddato
 * Data: 26 apr 2022
 */



import java.util.List;

import org.hibernate.query.Query;


public class UtentiManager {

//	public static Session openHBSession() {
//		Configuration configuration = new Configuration().configure()
//				.addAnnotatedClass(Contatto.class);
//		//.addAnnotatedClass(AltraClasse.class)
//
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//		return sessionFactory.openSession();
//	}

        public static void main(String[] args) {

            Session session = null;
            try {

                session = HBsessionFactory.openSession();
                System.out.println("session is open ? " + session.isOpen());

			//Transaction transaction = session.beginTransaction();


//			//INSERT
//			Contatto newContatto = new Contatto();
//			newContatto.setId(3)
//			newContatto.setCognome("Giuseppe");
//			newContatto.setNome("Verde");
//			newContatto.setEmail("g.verde@beije.it");
//			System.out.println("contatto PRE : " + newContatto);
//
//			session.save(newContatto);
//
//			System.out.println("contatto POST : " + newContatto);


                //SELECT HQL

			Query<Utente> query = session.createQuery("SELECT c FROM Utenti as c");//SELECT * FROM contatti
			List<Utente> contatti = query.getResultList();

			UtentiManager contatto = null;
			for (Utente c : contatti) {
				System.out.println(c);
			}



//			//UPDATE
//			System.out.println("modifico : " + contatto);
//			//contatto.setId(20);
//			contatto.setNote("queste sono le note");
//			contatto.setNome("Piero");
//			session.save(contatto);
//			System.out.println("contatto POST update : " + contatto);

//			//DELETE
//			sessi/*/*/*`*/*/*/on.remove(contatto);

                //transaction.commit();
                //transaction.rollback();

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
