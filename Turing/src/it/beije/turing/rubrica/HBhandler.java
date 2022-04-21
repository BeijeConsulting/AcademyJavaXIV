package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.turing.db.HBsessionFactory;

public class HBhandler
{

	public void loadRubricaToDB(List<Contatto> contatti)
	{
		Session session = null;
		Transaction transaction = null;
		try
		{
			session = HBsessionFactory.openSession();
			transaction = session.beginTransaction();
			
			for(Contatto contatto : contatti)
			{
				session.save(contatto);
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				transaction.commit();
				session.close();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public List<Contatto> getRubrica(String filtro)
	{
		List<Contatto> contatti = new ArrayList<>();
		Session session = null;
		
		if (filtro != "") riordinaRubrica(filtro);
		
		try
		{
			session = HBsessionFactory.openSession();
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
			contatti = query.getResultList();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				session.close();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}
		
		return contatti;
	}
	
	private void riordinaRubrica(String filtro)
	{
		List<Contatto> contatti = getRubrica("");
		
		
		switch(filtro)
		{
			case "nome":
				contatti.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
				break;
				
			case "cognome":
				contatti.sort((o1, o2) -> o1.getCognome().compareTo(o2.getCognome()));
				break;
				
			case "email":
				contatti.sort((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()));
				break;
				
			case "telefono":
				contatti.sort((o1, o2) -> o1.getTelefono().compareTo(o2.getTelefono()));
				break;			
				
			case "note":
				contatti.sort((o1, o2) -> o1.getNote().compareTo(o2.getNote()));
				break;
				
			default:
				return;
		}
		
		clearDB();
		loadRubricaToDB(contatti);
	}
	
	private void clearDB()
	{
		Session session = null;
		Transaction transaction = null;
		
		try
		{
			session = HBsessionFactory.openSession();
			transaction = session.beginTransaction();
						
			for(Contatto contatto : getRubrica(""))
			{
				session.remove(contatto);
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				transaction.commit();
				session.close();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public List<Contatto> findContatto(String filtro)
	{
		List<Contatto> cont = new ArrayList<>();
		List<Contatto> contatti = getRubrica("");
		
		for(Contatto contatto : contatti)
		{
			if (contatto.getId() == Integer.parseInt(filtro)) cont.add(contatto);
			else if (contatto.getNome().equals(filtro)) cont.add(contatto);
			else if (contatto.getCognome().equals(filtro)) cont.add(contatto);
			else if (contatto.getEmail().equals(filtro)) cont.add(contatto);
			else if (contatto.getTelefono().equals(filtro)) cont.add(contatto);
			else if (contatto.getNote().equals(filtro)) cont.add(contatto);
		}
		
		return cont;
	}
	
	public boolean addContatto(Contatto contatto)
	{
		Session session = null;
		try
		{
			session = HBsessionFactory.openSession();
			session.save(contatto);			
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				session.close();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
				return false;
			}
		}	
		
		return true;
	}
	
	public void modifyContatto(int posizione, Contatto contatto)
	{
		Session session = null;
		Transaction transaction = null;
		try
		{
			session = HBsessionFactory.openSession();
			List<Contatto> contatti = getRubrica("");
			transaction = session.beginTransaction();
			
			for(Contatto c : contatti)
			{
				if (c.getId() == posizione)
				{
					c.setNome(contatto.getNome());
					c.setCognome(contatto.getCognome());
					c.setEmail(contatto.getEmail());
					c.setTelefono(contatto.getTelefono());
					c.setNote(contatto.getNote());
					session.update(c);
					break;
				}
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				transaction.commit();
				session.close();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void deleteContatto(int posizione)
	{
		Session session = null;
		Transaction transaction = null;
		try
		{
			session = HBsessionFactory.openSession();
			transaction = session.beginTransaction();
			List<Contatto> contatti = getRubrica("");
			
			for(Contatto c : contatti)
			{
				if (c.getId() == posizione)
				{
					session.remove(c);
					break;
				}
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				transaction.commit();
				session.close();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public List<Contatto> findDuplicates()
	{
		List<Contatto> duplicati = new ArrayList<>();
		List<Contatto> contatti = getRubrica("");
		
		for(int i = 0; i < contatti.size(); i++)
		{
			for(int j = i; j < contatti.size(); j++)
			{				
				if (i == j) continue;
				if (contatti.get(i).equals(contatti.get(j)))
				{
					duplicati.add(contatti.get(j));
					contatti.remove(j);
					j = j-1;
				}
			}
		}
		
		return duplicati;
	}
	
	public void uniteDuplicates()
	{
		List<Contatto> duplicati = findDuplicates();
		
		for(Contatto c : duplicati)
		{
			deleteContatto(c.getId());
		}		
	}
}