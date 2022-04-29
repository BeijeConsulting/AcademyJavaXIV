package it.beije.turing.web.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;



public class RubricaManager {
	private List<Contatto> allContatti = null;

	public RubricaManager(){
		allContatti = new ArrayList<Contatto>();
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Contatto> cq = cb.createQuery(Contatto.class);
			Root<Contatto> from = cq.from(Contatto.class);
			cq.select(from);
			TypedQuery<Contatto> q = entityManager.createQuery(cq);
			allContatti = q.getResultList();

		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	public List<Contatto> getAllContatti() {
		return allContatti;
	}

	public void setAllContatti(List<Contatto> allContatti) {
		this.allContatti = allContatti;
	}

	public void printAllContatti() {
		for(Contatto c : allContatti) {
			System.out.println(c);
		}
	}

	public List<Contatto> AggiungiContatto(String nome, String cognome, String telefono, String email, String note) {
		List<Contatto> ris = new ArrayList<>(allContatti);
		Contatto c = new Contatto();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setTelefono(telefono);
		c.setEmail(email);
		c.setNote(note);
		ris.add(c);
		return ris;
	}
	public List<Contatto> ModificaContatto(List<Contatto> allContatti, Contatto contatto) {
		List<Contatto> ris = new ArrayList<>(allContatti);
		int pos = -1;
		Contatto c = null;
		for(int i = 0; i < ris.size(); i++) {
			if(ris.get(i).getId() == contatto.getId()) {
				c = ris.get(i);
				pos = i;
				break;
			}
		}
		if(c == null) {
			System.out.println("Nessun contatto trovato");
			return ris;
		}
		String nome = contatto.getNome();
		if(nome.length() == 0 || nome.isEmpty())
			nome = c.getNome();

		String cognome = contatto.getCognome();
		if(cognome.length() == 0 || cognome.isEmpty())
			cognome = c.getCognome();

		String telefono = contatto.getTelefono();
		if(telefono.length() == 0 || telefono.isEmpty())
			telefono = c.getTelefono();

		String email = contatto.getEmail();
		if(email.length() == 0 || email.isEmpty())
			email = c.getEmail();

		String note = contatto.getNote();
		if(note.length() == 0 || note.isEmpty())
			note = c.getNote();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setTelefono(telefono);
		c.setEmail(email);
		c.setNote(note);
		ris.set(pos, c);
		return ris;
	}

	public List<Contatto> EliminaContatto(List<Contatto> allContatti,int id) {
		List<Contatto> ris = new ArrayList<>(allContatti);
		for(Contatto c : ris) {
			if(c.getId() == id) {
				ris.remove(c);
				break;
			}
		}
		return ris;
	}

	public void EliminaTuttiContatti() {
		List<Contatto> ris = new ArrayList<>(allContatti);
		System.out.println("Eliminazione contatti...");
		for(int i = 0; i < ris.size(); i++) {
			ris.remove(i);
		}
		allContatti =  new ArrayList<>();
		System.out.println("Fatto.");
	}

	public List<Contatto> TrovaContattiDuplicati(List<Contatto> allContatti){
		List<Contatto> ris = new ArrayList<>();
		List<Contatto> tmp = sort(allContatti,"N");
		for(int i = 0; i + 1 < tmp.size(); i++) {
			if(tmp.get(i).getNome().equals(tmp.get(i+1).getNome())
					&& tmp.get(i).getCognome().equals(tmp.get(i+1).getCognome())
					&& tmp.get(i).getTelefono().equals(tmp.get(i+1).getTelefono())
					&& tmp.get(i).getEmail().equals(tmp.get(i+1).getEmail())) {
				ris.add(tmp.get(i));
				i += 1;
			}
		}
		return ris;
	}


	public List<Contatto> UnisciContattiDuplicati(List<Contatto> allContatti) {
		List<Contatto> ris = new ArrayList<>();
		List<Contatto> tmp = sort(allContatti,"N");
		for(int i = 0; i < tmp.size(); i++) {
			for(int j = i+1; j < tmp.size();j++) {
				if(tmp.get(i).getNome().equals(tmp.get(j).getNome())
						&& tmp.get(i).getCognome().equals(tmp.get(j).getCognome())
						&& tmp.get(i).getTelefono().equals(tmp.get(j).getTelefono())
						&& tmp.get(i).getEmail().equals(tmp.get(j).getEmail())) {
					continue;
				}
				ris.add(tmp.get(i));
				i = j-1;
				break;
			}
			if(i+1 >=  tmp.size()) {
				ris.add(tmp.get(i));
			}
		}
		return ris;
	}

	public List<Contatto> cercaContatto(List<Contatto> allContatti, String nome, String cognome, String telefono, String email) {
		List<Contatto> ris = new ArrayList<>();

		if(nome.isEmpty())
			nome = null;
		if(cognome.isEmpty())
			cognome = null;
		if(telefono.isEmpty())
			telefono = null;
		if(email.isEmpty())
			email = null;
		if(nome == null && cognome == null && telefono == null && email == null) {
			for(int i = 0; i < allContatti.size(); i++) {
				ris.add(allContatti.get(i));
			}
		}
		else if(nome != null && cognome == null && telefono == null && email == null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome != null && telefono == null && email == null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome == null && telefono != null && email == null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome == null && telefono == null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono == null && email == null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase()) && allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome == null && telefono != null && email == null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase()) && allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome == null && telefono == null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase()) && allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome != null && telefono != null && email == null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase()) && allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome != null && telefono == null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase()) && allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome == null && telefono != null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase()) && allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono != null && email == null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase()) && allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase()) && allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono == null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase()) && allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase()) && allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome == null && telefono != null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase()) && allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase()) && allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome != null && telefono != null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase()) && allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase()) && allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono != null && email != null) {

			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().toUpperCase().contains(nome.toUpperCase()) && allContatti.get(i).getCognome().toUpperCase().contains(cognome.toUpperCase()) 
						&& allContatti.get(i).getTelefono().toUpperCase().contains(telefono.toUpperCase()) && allContatti.get(i).getEmail().toUpperCase().contains(email.toUpperCase())){
					ris.add(allContatti.get(i));
				}
			}

		}

		return ris;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void swap(List<Contatto> contatti, int i) {
		Contatto tmp = contatti.get(i);
		Contatto tmp2 = contatti.get(i+1);
		contatti.remove(i+1);
		contatti.remove(i);
		contatti.add(i,tmp2);
		contatti.add(i+1,tmp);
	}

	public List<Contatto> sort(List<Contatto> allContatti, String type) {
		boolean swapped = true;
		List<Contatto> ris = new ArrayList<>(allContatti);

		switch(type.toUpperCase().charAt(0)) {
		case 'N':
			while(swapped) {
				swapped = false;
				for(int i = 0; (i+1) < ris.size(); i++) {
					if(ris.get(i).getNome().toUpperCase().compareTo(ris.get(i+1).getNome().toUpperCase()) >= 0) {
						if(ris.get(i).getNome().toUpperCase().compareTo(ris.get(i+1).getNome().toUpperCase()) == 0) {
							continue;
						}
						swap(ris,i);
						swapped = true;
					}
				}
			}
			break;
		default:
			System.out.println("Tipo invalido, ordinamento per Cognome.");
		case 'S':
			while(swapped) {
				swapped = false;
				for(int i = 0; (i+1) < ris.size(); i++) {
					if(ris.get(i).getCognome().toUpperCase().compareTo(ris.get(i+1).getCognome().toUpperCase()) >= 0) {
						if(ris.get(i).getCognome().toUpperCase().compareTo(ris.get(i+1).getCognome().toUpperCase()) == 0) {
							continue;
						}
						swap(ris,i);
						swapped = true;
					}
				}
			}
			break;
		}
		return ris;
	}

	public List<Contatto> writeRubricaOnDB(List<Contatto> allContact) {
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
