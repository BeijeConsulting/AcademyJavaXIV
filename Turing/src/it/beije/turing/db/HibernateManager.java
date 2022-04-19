package it.beije.turing.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.beije.turing.rubrica.Contatto;

public class HibernateManager {

	
	
public List<Contatto> DbGetContatti()
{
	Session session = null;
	Configuration config = new Configuration().configure().addAnnotatedClass(Contatto.class);
	
	SessionFactory factory = config.buildSessionFactory();
	
	session=factory.openSession();
	
	Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
	return query.getResultList();
}

public void SaveContattiToDB(List<Contatto> list)
{
	Session session = null;
	Configuration config = new Configuration().configure().addAnnotatedClass(Contatto.class);
	
	SessionFactory factory = config.buildSessionFactory();
	
	session=factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	for(Contatto c : list)
	{
		session.save(c);
	}
	transaction.commit();
	session.close();
	
}
public void update(Contatto c)
{
	Session session = null;
	Configuration config = new Configuration().configure().addAnnotatedClass(Contatto.class);
	
	SessionFactory factory = config.buildSessionFactory();
	
	session=factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	
		session.update(c);
	transaction.commit();
	session.close();
	
}
}
