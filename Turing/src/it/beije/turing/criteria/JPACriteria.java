//package it.beije.turing.criteria;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaDelete;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import it.beije.turing.db.HBsessionFactory;
//import it.beije.turing.hibernate.SessionFactorySingleton;
//import it.beije.turing.jpa.EntityManagerSingleton;
//import it.beije.turing.rubrica.Contatto;
//
//public class JPACriteria {
//	
//	
//	public static List<Contatto> findAll(EntityManager em, int order){
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
//		Root<Contatto> root = cr.from(Contatto.class);
//		cr.select(root);
//		if(order == 1)
//			cr.orderBy(cb.asc(root.get("cognome")));
//		else if(order == 2)
//			cr.orderBy(cb.asc(root.get("nome")));
//		
//		Query query = em.createQuery(cr);
//		
//		return query.getResultList();
//	}
//	
//	public static List<Contatto> findContatto(int idContatto, EntityManager em) {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
//		Root<Contatto> root = cr.from(Contatto.class);
//		cr.select(root).where(cb.equal(root.get("id"), idContatto));
//
//		Query query = em.createQuery(cr);
//		
//		return query.getResultList();
//	}
//	
//	public static List<Contatto> findContatto(String input, EntityManager em, int mode) {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Contatto> cr = cb.createQuery(Contatto.class);
//		Root<Contatto> root = cr.from(Contatto.class);
//		if(mode == 1)
//			cr.select(root).where(cb.equal(root.get("cognome"), input));
//		else if(mode == 2)
//			cr.select(root).where(cb.equal(root.get("nome"), input));
//		else
//			cr.select(root).where(cb.equal(root.get("email"), input));
//		
//		Query query = em.createQuery(cr);
//		
//		return query.getResultList();
//	}
//
//}
