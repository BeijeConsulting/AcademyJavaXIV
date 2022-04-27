package it.beije.turing.web.rubrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JPAcriteriaManager {
	
	public static List<Contatto> getRubrica() {
		
		EntityManager entitymanager = JPAentityManagerFactory.openEntityManager();
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Contatto> from = criteriaQuery.from(Contatto.class);
		
		//select all records
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		for(Object o:resultlist) {
			Contatto e = (Contatto)o;
			contatti.add(e);
		}
		
		entitymanager.close();
		
		return contatti;
	}
	
	public static List<Contatto> getOrderedRubrica(String s) {
		EntityManager entitymanager = JPAentityManagerFactory.openEntityManager();
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Contatto> from = criteriaQuery.from(Contatto.class);
		
		//Ordering the records 
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		select.orderBy(criteriaBuilder.asc(from.get(s)));
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		for(Object o:resultlist) {
			Contatto e = (Contatto)o;
			contatti.add(e);
		}
		
		entitymanager.close();
		
		return contatti;
	}
	
	public static List<Contatto> getOrderedByNameRubrica() {
		List<Contatto> contattiOrdered = getOrderedRubrica("nome");
		
		return contattiOrdered;
	}
		
	public static List<Contatto> getOrderedByCognomeRubrica() {
		List<Contatto> contattiOrdered = getOrderedRubrica("cognome");
		
		return contattiOrdered;
	}
	
}
