package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class RCSearch {
	public static Contatto search(EntityManager entityManager, String id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();		//SELECT * FROM contatti
		CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
		Root<Contatto> con = q.from(Contatto.class);
		q.select(con).where(cb.equal(con.get("id"),id));
		Query query = entityManager.createQuery(q);
		List<Contatto> contatti = query.getResultList();
		return contatti.get(0);
	}
	
	public static List<Contatto> search(EntityManager entityManager) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();		//SELECT * FROM contatti
		CriteriaQuery<Contatto> q = cb.createQuery(Contatto.class);
		Root<Contatto> con = q.from(Contatto.class);
		q.select(con);
		Query query = entityManager.createQuery(q);
		List<Contatto> contatti = query.getResultList();
		List<Contatto> results = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		System.out.println("What to search for?\n");
		String keyword = s.next();
		System.out.println("What field do you want to search?\n"
				+"1: nome\n"
				+"2: cognome\n"
				+"3: telefono\n"
				+"4: email\n"
				+"5: note\n");
		String st = s.next();
		while(true) {
			if (st.equals("exit")) {
				s.close();
				return results;
			}
			switch (st) {
			case "1":
				for (Contatto c: contatti){
					if (c.getNome()!=null && c.getNome().toLowerCase().indexOf(keyword.toLowerCase())!=-1){
						results.add(c);
					}
				}
				break;
			case "2":
				for (Contatto c: contatti){
					if (c.getCognome()!=null && c.getCognome().toLowerCase().indexOf(keyword.toLowerCase())!=-1){
						results.add(c);
					}
				}
				break;
			case "3":
				for (Contatto c: contatti){
					if (c.getTelefono()!=null && c.getTelefono().toLowerCase().indexOf(keyword.toLowerCase())!=-1){
						results.add(c);
					}
				}
				break;
			case "4":
				for (Contatto c: contatti){
					if (c.getEmail()!=null && c.getEmail().toLowerCase().indexOf(keyword.toLowerCase())!=-1){
						results.add(c);
					}
				}
				break;
			case "5":
				for (Contatto c: contatti){
					if (c.getNote()!=null && c.getNote().toLowerCase().indexOf(keyword.toLowerCase())!=-1){
						results.add(c);
					}
				}
				break;
			default:
				System.out.println("invalid input, please enter 1-5 or exit to leave:");
				st = s.next();
				continue;
			}
			System.out.println("Found "+results.size()+" matches.");
			s.close();
			return results;
		}

	}
}
