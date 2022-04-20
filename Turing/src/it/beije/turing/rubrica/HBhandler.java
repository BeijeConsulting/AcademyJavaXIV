package it.beije.turing.rubrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import it.beije.turing.db.HBsessionFactory;

public class HBhandler
{

	public void loadRubricaToDB(List<Contatto> contatti)
	{
		Session session = null;
		System.out.println("READ HB");
		try
		{
			session = HBsessionFactory.openSession();
			
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
				session.close();
			}
			catch (HibernateException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public List<Contatto> writeRubricaFromDB()
	{
		System.out.println("WRITE HB");
		List<Contatto> contatti = null;
		Session session = null;
		
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
}