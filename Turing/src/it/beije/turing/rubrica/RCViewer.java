package it.beije.turing.rubrica;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class RCViewer {
	public static void view (EntityManager entityManager) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();		//SELECT * FROM contatti
		CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
		Root<Contatto> con = q.from(Contatto.class);
		q.select(con);
		
		Query query;
		Scanner s = new Scanner(System.in);
		System.out.println("Ordering contacts by name (n) or by surname (s) ?");
		String st = s.next();
		while (!st.equals("n") & !st.equals("s")) {
			System.out.println("Invalid input, enter n or s:");
			st = s.next();
		}
		s.close();
		if (st.equals("n")) {
			q.orderBy(cb.asc(con.get("nome")));
			query = entityManager.createQuery(q);
		} else {
			q.orderBy(cb.asc(con.get("cognome")));
			query = entityManager.createQuery(q);
		}

		List<Contatto> contatti = query.getResultList();

		for (Contatto c: contatti) {
			System.out.println(c);
		}
		
	}

}
