package it.beije.turing.db;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.turing.rubrica.Contatto;


public class HBManager {
	
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
			
			session = HBsessionFactory.openH8Session();
			System.out.println("session is open ? " + session.isOpen());
			
			
			//Transaction transaction = session.beginTransaction();
//			Transaction transaction = session.getTransaction();
//			transaction.begin();
			
//			//INSERT
//			Contatto newContatto = new Contatto();
//			newContatto.setId(3);
//			newContatto.setCognome("Giuseppe");
//			newContatto.setNome("Verde");
//			newContatto.setEmail("g.verde@beije.it");
//			System.out.println("contatto PRE : " + newContatto);
//			
//			session.save(newContatto);
//			
//			System.out.println("contatto POST : " + newContatto);

			
			//SELECT HQL
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM contatti
			List<Contatto> contatti = query.getResultList();
			
			Contatto contatto = null;
			for (Contatto c : contatti) {
				System.out.println(c);
				if (c.getId() == 12) contatto = c;
			}

			
//			//UPDATE
//			System.out.println("modifico : " + contatto);
//			//contatto.setId(20);
//			contatto.setNote("queste sono le note");
//			contatto.setNome("Piero");
//			session.save(contatto);
//			System.out.println("contatto POST update : " + contatto);
			
//			//DELETE
//			session.remove(contatto);
			
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
