package it.beije.turing.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import it.beije.turing.Contatto;
import it.beije.turing.JPAentityManager;

@Service
public class JPAhandler
{
	public void loadRubricaToDB(List<Contatto> contatti)
	{
		EntityManager entityManager = JPAentityManager.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		for(Contatto contatto : contatti)
		{
			entityManager.persist(contatto);
		}
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public List<Contatto> getRubrica(String filtro)
	{
		EntityManager entityManager = JPAentityManager.createEntityManager();
		
		if (filtro != "") riordinaRubrica(filtro);
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();

		entityManager.close();
		
		return contatti;
	}
	
	private void riordinaRubrica(String filtro)
	{
		EntityManager entityManager = JPAentityManager.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
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
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		for(Contatto c : contatti)
		{
			Contatto contatto = new Contatto(c.getNome(), c.getCognome(), c.getEmail(), c.getTelefono(), c.getNote());
			entityManager.persist(contatto);
		}
		
		entityTransaction.commit();
	}
	
	private void clearDB()
	{
		EntityManager entityManager = JPAentityManager.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		for(Contatto c : contatti)
		{
			entityManager.remove(c);
		}
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public List<Contatto> findContatto(String filtro)
	{
		List<Contatto> cont = new ArrayList<>();
		List<Contatto> contatti = getRubrica("");
		
		for(Contatto contatto : contatti)
		{
			//if (contatto.getId() == Integer.parseInt(filtro)) cont.add(contatto);
			if (contatto.getNome().equals(filtro)) cont.add(contatto);
			else if (contatto.getCognome().equals(filtro)) cont.add(contatto);
			else if (contatto.getEmail().equals(filtro)) cont.add(contatto);
			else if (contatto.getTelefono().equals(filtro)) cont.add(contatto);
			else if (contatto.getNote().equals(filtro)) cont.add(contatto);
		}
		
		return cont;
	}
	
	public boolean addContatto(Contatto contatto)
	{
		EntityManager entityManager = JPAentityManager.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(contatto);
		
		entityTransaction.commit();
		entityManager.close();
		
		return true;
	}
	
	public void modifyContatto(int posizione, Contatto contatto)
	{
		EntityManager entityManager = JPAentityManager.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		Contatto c = entityManager.find(Contatto.class, posizione);
		
		c.setNome(contatto.getNome());
		c.setCognome(contatto.getCognome());
		c.setEmail(contatto.getEmail());
		c.setTelefono(contatto.getTelefono());
		c.setNote(contatto.getNote());
		entityManager.persist(c);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public void deleteContatto(int posizione)
	{
		EntityManager entityManager = JPAentityManager.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		Contatto c = entityManager.find(Contatto.class, posizione);
		entityManager.remove(c);
		
		entityTransaction.commit();
		entityManager.close();
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