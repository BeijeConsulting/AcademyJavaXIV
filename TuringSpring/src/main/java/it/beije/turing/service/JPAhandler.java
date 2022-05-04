package it.beije.turing.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.Contatto;
import it.beije.turing.JpaEntityManager;
import it.beije.turing.repository.ContattoRepository;

@Service
public class JPAhandler
{
	@Autowired
	private ContattoRepository contattoRepository;
	
	public List<Contatto> getRubrica()
	{
		List<Contatto> contatti = contattoRepository.findAll();
		
		return contatti;
	}
	
	public List<Contatto> findContatto(String filtro)
	{
		List<Contatto> cont = new ArrayList<>();
		List<Contatto> contatti = getRubrica();
		
		for(Contatto contatto : contatti)
		{
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
		EntityManager entityManager = JpaEntityManager.getInstance().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(contatto);
		
		entityTransaction.commit();
		entityManager.close();
		
		return true;
	}
	
	public void modifyContatto(int posizione, Contatto contatto)
	{
		EntityManager entityManager = JpaEntityManager.getInstance().createEntityManager();
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
		EntityManager entityManager = JpaEntityManager.getInstance().createEntityManager();
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
		List<Contatto> contatti = getRubrica();
		
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