package it.beije.turing.web.ecomm.dbutils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.beije.turing.web.ecomm.beans.*;



public class JPA_Manager implements DBInterface{

	@Override
	public List<Client> getClientList() {
		EntityManager em = EMFactory.getInstance();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client as c",Client.class);
		return query.getResultList();
	}

	@Override
	public List<Order> getOrderHistory() {
		EntityManager em = EMFactory.getInstance();
		TypedQuery<Order> query = em.createQuery("SELECT c FROM Order as c",Order.class);
		return query.getResultList();
	}

	@Override
	public List<Good> getInventory() {
		EntityManager em = EMFactory.getInstance();
		TypedQuery<Good> query = em.createQuery("SELECT c FROM Prodotto as c",Good.class);
		return query.getResultList();
	}

	@Override
	public List<Client> search(String fields) {
		EntityManager em = EMFactory.getInstance();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client as c Where "+fields,Client.class);
		return query.getResultList();
	}

	@Override
	public void add(Client c) {
		EntityManager em = EMFactory.getInstance();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(c);
		t.commit();
		em.close();
	}
	
}
