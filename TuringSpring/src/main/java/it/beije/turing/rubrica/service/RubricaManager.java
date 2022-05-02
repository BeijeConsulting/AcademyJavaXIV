package it.beije.turing.rubrica.service;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.EntityManagerFactorySingleton;


@Service
public class RubricaManager {
	

	public EntityManager init(){
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return entityManager;
	}
	
	public List<Contatto> printAllContatti() {
		List<Contatto> allContatti = new ArrayList<Contatto>();
		EntityManager entityManager = init();
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		allContatti = query.getResultList();
		return allContatti;
	}
	
	public List<Contatto> printAllContatti(String type) {
		List<Contatto> allContatti = new ArrayList<Contatto>();
		EntityManager entityManager = init();
		Query query;
		if(type.toUpperCase().startsWith("N")) {
			query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY c.nome ASC");
		}else {
			query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY c.cognome ASC");
		}
		allContatti = query.getResultList();
		return allContatti;
	}

	public Contatto AggiungiContatto(String nome, String cognome, String telefono, String email, String note) {
		if((nome == null && cognome == null && telefono == null && email == null && note == null) || (nome.isEmpty() && cognome.isEmpty() && telefono.isEmpty() && email.isEmpty() && note.isEmpty())){
			return null;
		}
		EntityManager entityManager = init();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Contatto c = new Contatto();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setTelefono(telefono);
		c.setEmail(email);
		c.setNote(note);
		entityManager.persist(c);
		entityTransaction.commit();
		return c;
	}
	public Contatto ModificaContatto(Contatto contatto) {
		EntityManager entityManager = init();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Contatto tmp = entityManager.find(Contatto.class, contatto.getId());
		if(tmp == null)
			return tmp;
		String nome = contatto.getNome();
		if(nome == null || nome.length() == 0 || nome.isEmpty())
			nome = tmp.getNome();

		String cognome = contatto.getCognome();
		if(cognome == null || cognome.length() == 0 || cognome.isEmpty())
			cognome = tmp.getCognome();

		String telefono = contatto.getTelefono();
		if(telefono == null || telefono.length() == 0 || telefono.isEmpty())
			telefono = tmp.getTelefono();

		String email = contatto.getEmail();
		if(email == null || email.length() == 0 || email.isEmpty())
			email = tmp.getEmail();

		String note = contatto.getNote();
		if(note == null || note.length() == 0 || note.isEmpty())
			note = tmp.getNote();
		Contatto c = new Contatto();
		tmp.setCognome(cognome);
		tmp.setNome(nome);
		tmp.setTelefono(telefono);
		tmp.setEmail(email);
		tmp.setNote(note);
		entityManager.persist(tmp);
		entityTransaction.commit();
		return tmp;
	}
	public Contatto cercaContatto() {
		return null;
	}
	/*
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

		}catch (Exception e) {
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
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		return ris;
	}
*/
}
