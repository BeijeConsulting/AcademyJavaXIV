package it.beije.turing.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;

import it.beije.turing.rubrica.Contatto;

public class HBManager {

	public static void main(String[] args) {
		Session session = null;

		try {
//			Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
//			
//			SessionFactory sessionFactory = configuration.buildSessionFactory();
//			
//			session = sessionFactory.openSession();
			session = SessionFactorySingleton.getInstance();
			System.out.print("Session is open? > " + session.isOpen());

			Transaction transaction = session.beginTransaction();
			

			Contatto newContatto = new Contatto( "Ciao", "Sono", "Marco", "39843323",
					"Quello non è il mio vero numero");
			session.save(newContatto);

			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");// SELECT * FROM contatti
			List<Contatto> contatti = query.getResultList();

			for (Contatto c : contatti) {
				System.out.println(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
