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
		if(allContatti == null) {
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
	// TODO: IMPLEMENTA NELLA SERVLET
	public void ModificaContatto(Scanner s) {
		List<Contatto> ris = new ArrayList<>(allContatti);

		System.out.println("Lista Contatti Disponibili:");
		int i = 0;
		for(Contatto c : ris) {
			System.out.println("idList: "+i+" "+c);
			i++;
		}
		System.out.println("Inserire numero idList da modificare:");
		String nContatto = s.nextLine();
		try {
			i = Integer.parseInt(nContatto);
		}catch(NumberFormatException nfEx) {
			System.out.println("Inserire un numero valido!");
			nfEx.printStackTrace();
			System.out.println("Quitting...");
			return;
		}
		Contatto c = ris.get(i);
		System.out.println("Inserire Nome:");
		String nome = s.nextLine();
		if(nome.length() == 0 || nome.isEmpty())
			nome = c.getNome();
		System.out.println("Inserire Cognome:");
		String cognome = s.nextLine();
		if(cognome.length() == 0 || cognome.isEmpty())
			cognome = c.getCognome();
		System.out.println("Inserire Telefono:");
		String telefono = s.nextLine();
		if(telefono.length() == 0 || telefono.isEmpty())
			telefono = c.getTelefono();
		System.out.println("Inserire Email:");
		String email = s.nextLine();
		if(email.length() == 0 || email.isEmpty())
			email = c.getEmail();
		System.out.println("Inserire Note:");
		String note = s.nextLine();
		if(note.length() == 0 || note.isEmpty())
			note = c.getNote();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setTelefono(telefono);
		c.setEmail(email);
		c.setNote(note);
		ris.set(i, c);
		allContatti = new ArrayList<>(ris);
	}
	// TODO: IMPLEMENTA NELLA SERVLET
	public void EliminaContatto(Scanner s) {
		List<Contatto> ris = new ArrayList<>(allContatti);

		System.out.println("Lista Contatti Disponibili:");
		int i = 0;
		for(Contatto c : ris) {
			System.out.println("idList: "+i+" "+c);
			i++;
		}
		System.out.println("Inserire numero idList da eliminare:");
		String nContatto = s.nextLine();
		try {
			i = Integer.parseInt(nContatto);
		}catch(NumberFormatException nfEx) {
			System.out.println("Inserire un numero valido!");
			nfEx.printStackTrace();
			System.out.println("Quitting...");
			return;
		}
		ris.remove(i);
		allContatti = new ArrayList<>(ris);
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
	// TODO: IMPLEMENTA NELLA SERVLET
	/*
	public List<Contatto> TrovaContattiDuplicati(Scanner s){
		List<Contatto> ris = new ArrayList<>();
		sort(s);
		for(int i = 0; i + 1 < allContatti.size(); i++) {
			if(allContatti.get(i).equals(allContatti.get(i+1))) {
				ris.add(allContatti.get(i));
				i += 1;
			}
		}
		return ris;
	}
	*/
	// TODO: IMPLEMENTA NELLA SERVLET
	/*
	public void UnisciContattiDuplicati(Scanner s) {
		List<Contatto> ris = new ArrayList<>();
		sort(s);
		for(int i = 0; i < allContatti.size(); i++) {
			for(int j = i+1; j < allContatti.size();j++) {
				if(allContatti.get(i).getNome().equals(allContatti.get(j).getNome())
						&& allContatti.get(i).getCognome().equals(allContatti.get(j).getCognome())
						&& allContatti.get(i).getTelefono().equals(allContatti.get(j).getTelefono())
						&& allContatti.get(i).getEmail().equals(allContatti.get(j).getEmail())) {
					continue;
				}
				ris.add(allContatti.get(i));
				i = j-1;
				break;
			}
			if(i+1 >=  allContatti.size()) {
				ris.add(allContatti.get(i));
			}
		}
		allContatti = new ArrayList<>(ris);
	}
	*/
	public List<Contatto> cercaContatto(String nome, String cognome, String telefono, String email) {
		List<Contatto> ris = new ArrayList<>();
		
		if(nome.isEmpty())
			nome = null;
		if(cognome.isEmpty())
			cognome = null;
		if(telefono.isEmpty())
			telefono = null;
		if(email.isEmpty())
			email = null;
		if(nome != null && cognome == null && telefono == null && email == null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome)){
					ris.add(allContatti.get(i));
				}
			}
			
		}else if(nome == null && cognome != null && telefono == null && email == null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().contains(cognome)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome == null && telefono != null && email == null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getTelefono().contains(telefono)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome == null && telefono == null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getEmail().contains(email)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono == null && email == null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getCognome().contains(cognome)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome == null && telefono != null && email == null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getTelefono().contains(telefono)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome == null && telefono == null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getEmail().contains(email)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome != null && telefono != null && email == null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().contains(cognome) && allContatti.get(i).getTelefono().contains(telefono)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome != null && telefono == null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().contains(cognome) && allContatti.get(i).getEmail().contains(email)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome == null && telefono != null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getTelefono().contains(telefono) && allContatti.get(i).getEmail().contains(email)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono != null && email == null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getCognome().contains(cognome) && allContatti.get(i).getTelefono().contains(telefono)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono == null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getCognome().contains(cognome) && allContatti.get(i).getEmail().contains(email)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome == null && telefono != null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getTelefono().contains(telefono) && allContatti.get(i).getEmail().contains(email)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome == null && cognome != null && telefono != null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getCognome().contains(cognome) && allContatti.get(i).getTelefono().contains(telefono) && allContatti.get(i).getEmail().contains(email)){
					ris.add(allContatti.get(i));
				}
			}

		}else if(nome != null && cognome != null && telefono != null && email != null) {
			
			for(int i = 0; i < allContatti.size(); i++) {
				if(allContatti.get(i).getNome().contains(nome) && allContatti.get(i).getCognome().contains(cognome) 
						&& allContatti.get(i).getTelefono().contains(telefono) && allContatti.get(i).getEmail().contains(email)){
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
