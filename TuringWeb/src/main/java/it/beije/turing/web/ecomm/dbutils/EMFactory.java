package it.beije.turing.web.ecomm.dbutils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	private static EntityManagerFactory em;
private EMFactory()
{
	
}
public static EntityManager getInstance()
{
	if(em!=null&&em.isOpen())
	return em.createEntityManager();
	else
	{
		em = Persistence.createEntityManagerFactory("turing");
		return getInstance();
	}
}
}
