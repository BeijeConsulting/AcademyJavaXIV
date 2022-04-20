package it.beije.turing.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.turing.rubrica.Contatto;

public class EseHibernate {
	
	public static void main(String[] args) {
		EseHibernate h = new EseHibernate();
		h.svolgiTransazioni();
	}
	
	public void svolgiTransazioni() {
		Session session = null;
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);	
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		System.out.println("session is open ? " + session.isOpen());
		
		//Transaction transaction = session.beginTransaction();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM contatti
		List<Contatto> contatti = query.getResultList();
		session.close();
	}

}
