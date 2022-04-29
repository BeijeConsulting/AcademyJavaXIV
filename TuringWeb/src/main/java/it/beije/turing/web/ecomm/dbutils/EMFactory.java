package it.beije.turing.Ecomm.DBUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	
	private static EntityManager em;
	
	private EMFactory() 
	{
		
	}
	public static EntityManager getInstance()
	{
		if(em!=null)
		return em;
		else
		{
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("turing");
			em = entityManagerFactory.createEntityManager();
			return em;
		}
	}

}
