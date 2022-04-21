package it.beije.turing.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.turing.rubrica.Contatto;

public class JPA_Manager implements DbInterface {

	@SuppressWarnings("unchecked")
	@Override
	public List<Contatto> getContatti() {
		EntityManager em = EMFactory.getInstance();
		Query query = em.createQuery("SELECT c FROM Contatto as c");
		return query.getResultList();
	}

	@Override
	public void insertContatti(Contatto c) {
		EntityManager em = EMFactory.getInstance();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.persist(c);
		entityTransaction.commit();
	}

	@Override
	public void updateContatti(Contatto c) {
		EntityManager em = EMFactory.getInstance();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.merge(c);
		entityTransaction.commit();

	}

	@Override
	public Contatto getContatto(int id) {
		EntityManager em = EMFactory.getInstance();
		return em.find(Contatto.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contatto> search(String string) {
		EntityManager em = EMFactory.getInstance();
		Query query = em.createQuery("SELECT c FROM Contatto as c WHERE "+string + " ORDER BY nome");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contatto> getOrdered(String string) {
		EntityManager em = EMFactory.getInstance();
		Query query = em.createQuery("SELECT c FROM Contatto as c ORDER BY " +string);
		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		EntityManager em = EMFactory.getInstance();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.remove(search("id ="+id).get(0));
		entityTransaction.commit();
		
	}

}
