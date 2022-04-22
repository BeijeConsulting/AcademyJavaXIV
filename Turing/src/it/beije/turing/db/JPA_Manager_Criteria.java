package it.beije.turing.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import it.beije.turing.rubrica.Contatto;

public class JPA_Manager_Criteria implements DbInterface {

	
	@Override
	public List<Contatto> getContatti() {
		EntityManager em = EMFactory.getInstance();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
		Root<Contatto> rt = cq.from(Contatto.class);
		cq.select(rt);
		TypedQuery<Contatto> query = em.createQuery(cq);
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
		//em.merge(c);
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaUpdate<Contatto> cu = cb.createCriteriaUpdate(Contatto.class);
		Root<Contatto> rt =cu.from(Contatto.class);
		cu.set("nome",c.getNome());
		cu.set("cognome",c.getCognome());
		cu.set("telefono",c.getTelefono());
		cu.set("email",c.getEmail());
		cu.set("note",c.getNote());
		cu.where(cb.equal(rt.get("id"),c.getId()));
		Query query = em.createQuery(cu);
		query.executeUpdate();
		entityTransaction.commit();

	}

	@Override
	public Contatto getContatto(int id) {
		EntityManager em = EMFactory.getInstance();
		return search(" id='"+id+"' ").get(0);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contatto> search(String string) {
		EntityManager em = EMFactory.getInstance();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contatto> cq =cb.createQuery(Contatto.class);
		Root<Contatto> rt = cq.from(Contatto.class);
		cq.select(rt);
		for(String s : string.split(","))
		{
			String[] parts = s.split("='");
			cq.where(cb.equal(rt.get(parts[0].substring(1)),parts[1].substring(0,parts[1].length()-2)));
		}
		TypedQuery<Contatto> query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public List<Contatto> getOrdered(String string) {
		EntityManager em = EMFactory.getInstance();
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
		Root<Contatto> rt = cq.from(Contatto.class);
		cq.select(rt);
		cq.orderBy(cb.asc(rt.get(string)));
		TypedQuery<Contatto> query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		EntityManager em = EMFactory.getInstance();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		//em.remove(getContatto(id));
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Contatto> cq =cb.createCriteriaDelete(Contatto.class);
		Root<Contatto> rt = cq.from(Contatto.class);
		cq.where(cb.equal(rt.get("id"), id));
		Query query = em.createQuery(cq);
		query.executeUpdate();
		entityTransaction.commit();
	}

}
