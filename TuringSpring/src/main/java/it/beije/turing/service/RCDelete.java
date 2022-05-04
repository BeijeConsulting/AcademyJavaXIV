package it.beije.turing.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Scanner;

@Service
public class RCDelete {
	public static void delete (EntityManager entityManager, String contactId) {
			int targetId = Integer.parseInt(contactId);
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();		//SELECT * FROM contatti
			CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
			Root<Contatto> con = q.from(Contatto.class);
			q.select(con).where(cb.equal(con.get("id"),targetId));

			Query query = entityManager.createQuery(q);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(query.getResultList().get(0));
			entityTransaction.commit();
	}
}
