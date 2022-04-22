package it.beije.turing.challenge.rubrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;




public class RubricaJPA implements Rubrica{
	public static List<Contatto> readRubricaFromDB(){
		List<Contatto> ris = new ArrayList<Contatto>();
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
			Root<Contatto> from = cq.from(Contatto.class);
			cq.select(from);
			TypedQuery<Contatto> q = entityManager.createQuery(cq);
			ris = q.getResultList();
			
		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		return ris;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Contatto> writeRubricaOnDB(List<Contatto> allContact) {
		List<Contatto> ris = new ArrayList<Contatto>();
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
			List<Contatto> contatti = query.getResultList();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			//REMOVE CONTATTO IN DB
			OUTER:for(int i = 0; i < contatti.size(); i++) {
				for(int j = 0; j < allContact.size(); j++) {
					if(contatti.get(i).equals(allContact.get(j))) {
						continue OUTER;
					}
				}
				entityManager.remove(contatti.get(i));
			}
			entityTransaction.commit();
			
		}catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
			List<Contatto> contatti = query.getResultList();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			//INSERT NEW CONTATTO IN DB
			OUTER:for(int i = 0; i < allContact.size(); i++) {
				for(int j = 0; j < contatti.size(); j++) {
					if(contatti.get(j).equals(allContact.get(i))) {
						continue OUTER;
					}
				}
				Contatto tmp = new Contatto();
				tmp.setNome(allContact.get(i).getNome());
				tmp.setCognome(allContact.get(i).getCognome());
				tmp.setEmail(allContact.get(i).getEmail());
				tmp.setNote(allContact.get(i).getNote());
				tmp.setTelefono(allContact.get(i).getTelefono());
				entityManager.persist(tmp);
			}
			entityTransaction.commit();
			ris = query.getResultList();
		}catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		return ris;
	}
}
