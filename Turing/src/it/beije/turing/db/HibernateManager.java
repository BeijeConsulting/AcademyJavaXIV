package it.beije.turing.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.beije.turing.rubrica.Contatto;

public class HibernateManager implements DbInterface {

	
	
public List<Contatto> getContatti()
{
	Session session = null;
	session=HBsessionFactory.openSession();
	
	Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
	return query.getResultList();
}

public void insertContatti(Contatto c)
{
	Session session=null;
	session=HBsessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	session.save(c);
	transaction.commit();
	session.close();
	
}
public void updateContatti(Contatto c)
{
	
	Session session=HBsessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	session.merge(c);
	transaction.commit();
	
	
	session.close();
	
}
public Contatto getContatto(int id)
{
	for(Contatto c:getContatti())
	{
		if(c.getId()==id)
			return c;
	}
	return null;
}
}
