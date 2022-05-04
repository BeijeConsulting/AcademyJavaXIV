package it.beije.turing.rubrica.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.*;

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
