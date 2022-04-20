package it.beije.turing.file;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import it.beije.turing.rubrica.Contatto;

public class HBManager {

	public static void main(String[] args) {
		Session session = null;
		try {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			System.out.print("Session is open? > " + session.isOpen());
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
