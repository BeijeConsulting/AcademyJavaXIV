package it.beije.turing.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Service
public class RCViewer {
	public static List<Contatto> view (EntityManager entityManager, String command) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();		//SELECT * FROM contatti
		CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
		Root<Contatto> con = q.from(Contatto.class);
		q.select(con);
		
		Query query;
		if (command.equals("name")) {
			q.orderBy(cb.asc(con.get("nome")));
			query = entityManager.createQuery(q);
		} else {
			q.orderBy(cb.asc(con.get("cognome")));
			query = entityManager.createQuery(q);
		}

		List<Contatto> contatti = query.getResultList();
		for (Contatto c : contatti){
			System.out.println(c);
		}
		return contatti;
	}

}
