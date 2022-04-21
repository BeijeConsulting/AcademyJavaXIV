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
	return search("id="+id).get(0);
}

@Override
public List<Contatto> search(String string) {
	Session session = null;
	session=HBsessionFactory.openSession();
	
	Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c WHERE "+string);
	return query.getResultList();
}

@Override
public List<Contatto> getOrdered(String string) {
	Session session = null;
	session=HBsessionFactory.openSession();
	
	Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c ORDER BY "+string);
	return query.getResultList();
}

@Override
public void delete(int id) {
	Session session = null;
	session=HBsessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	session.remove(getContatto(id));
	transaction.commit();
	session.close();
}
}
