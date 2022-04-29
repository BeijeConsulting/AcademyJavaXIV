package it.beije.turing.Ecomm.DBUtils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.beije.turing.Ecomm.Beans.Cliente;
import it.beije.turing.Ecomm.Beans.Ordine;
import it.beije.turing.Ecomm.Beans.Prodotto;

public class JPA_Manager implements DBInterface{

	@Override
	public List<Cliente> getClienti() {
		EntityManager em = EMFactory.getInstance();
		TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente as c",Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Ordine> getOrderHistory() {
		EntityManager em = EMFactory.getInstance();
		TypedQuery<Ordine> query = em.createQuery("SELECT c FROM Ordine as c",Ordine.class);
		return query.getResultList();
	}

	@Override
	public List<Prodotto> getInventory() {
		EntityManager em = EMFactory.getInstance();
		TypedQuery<Prodotto> query = em.createQuery("SELECT c FROM Prodotto as c",Prodotto.class);
		return query.getResultList();
	}
	
}
