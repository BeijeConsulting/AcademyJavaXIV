package it.beije.turing.db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.turing.rubrica.*;

public class HibManager {

	public static void main(String[] args) {
		
		Session session = null;
		try {
		//	session = HBsessionFactory.openSession();
		//	System.out.println("session is open ? " + session.isOpen());
			
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);
			SessionFactory sf = configuration.buildSessionFactory();
			session = sf.openSession();
			
			//INSERT
//		Transaction transaction = session.beginTransaction();
//			Transaction transaction = session.getTransaction();
//			transaction.begin();
			
//			HibInsert.insert(session);
			
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
//			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM contatti
//			List<Contatto> contatti = query.getResultList();
//			List<Contatto> contatti = HibSearch.search(session);
//			Contatto contatto = null;
//			for (Contatto c : contatti) {
//				System.out.println(c);
//			}
			
			//HibUpdate.update(session, contatto);
			
//			//UPDATE
//			System.out.println("modifico : " + contatto);
//			//contatto.setId(20);
//			contatto.setNote("queste sono le note");
//			contatto.setNome("Piero");
//			session.save(contatto);
//			System.out.println("contatto POST update : " + contatto);
			
//			//DELETE
			//HibDelete.delete(session, contatto);
	//		HibDuplicate.mergeDuplicates(session);
	//		HibViewer.view(session);
			
			//transaction.commit();
			//transaction.rollback();

		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
//		}catch (InterruptedException iEx) {
//				iEx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		
	}

}
