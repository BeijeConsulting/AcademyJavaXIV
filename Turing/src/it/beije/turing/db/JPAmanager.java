package it.beije.turing.db;


import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import it.beije.turing.file.CSVmanager;
import it.beije.turing.file.XMLmanager;
import it.beije.turing.rubrica.Contatto;

public class JPAmanager {
	
	public static List<Contatto> getRubrica() {
		EntityManager entityManager = JPAentityManagerFactory.openEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		entityManager.close();
		return contatti;
	}
	
	public static void insertToRubrica(Contatto contatto) {
		EntityManager entityManager = JPAentityManagerFactory.openEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		if(contatto.getId() == 0) {
			entityManager.persist(contatto);
		} else {
			System.out.println("Contatto invalido per questa operazione.");
		}
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void updateContattoRubrica(Contatto newContatto, int id) {
		EntityManager entityManager = JPAentityManagerFactory.openEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Contatto contatto = entityManager.find(Contatto.class, id);
		System.out.println("modifico : " + contatto);
		
		if(contatto != null) {
			if(!newContatto.getNome().equals("") && newContatto.getNome() != null) {
				contatto.setNome(newContatto.getNome());
			}
			if(!newContatto.getCognome().equals("") && newContatto.getCognome() != null) {
				contatto.setCognome(newContatto.getCognome());
			}
			if(!newContatto.getEmail().equals("") && newContatto.getEmail() != null) {
				contatto.setEmail(newContatto.getEmail());
			}
			if(!newContatto.getTelefono().equals("") && newContatto.getTelefono() != null) {
				contatto.setTelefono(newContatto.getTelefono());
			}
			if(!newContatto.getNote().equals("") && newContatto.getNote() != null) {
				contatto.setNote(newContatto.getNote());
			}
			entityManager.persist(contatto);
		}
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void deleteContattoRubrica(int id) {
		EntityManager entityManager = JPAentityManagerFactory.openEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Contatto contatto = entityManager.find(Contatto.class, id);
		System.out.println("cancello : " + contatto);
		
		entityManager.remove(contatto);
		
		entityTransaction.commit();
		entityManager.close();
	}

	public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
		List<Contatto> contatti = CSVmanager.loadRubricaFromCSV(path, separatore, virgolette);
		
		for(Contatto contatto : contatti) {
			insertToRubrica(contatto);
		}
	}

	public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
		List<Contatto> contatti = XMLmanager.loadRubricaFromXML(path);
		
		for(Contatto contatto : contatti) {
			insertToRubrica(contatto);
		}
	}
	
	public static void main(String[] args) {
		
		//INSERT
		Contatto newContatto = new Contatto();
		//newContatto.setId(3);
		newContatto.setCognome("Melis");
		newContatto.setNome("Mattia");
		newContatto.setEmail("m.melis@beije.it");
		newContatto.setTelefono("3782563490");
		newContatto.setNote("Collega");
		//insertToRubrica(newContatto);

		
		//UPDATE
		Contatto contatto = new Contatto();
		contatto.setId(20);
		contatto.setNote("Collega");
		contatto.setTelefono("33890761287");
		//updateContattoRubrica(contatto, 23);
		
		//DELETE
		//deleteContattoRubrica(25);
		
		List<Contatto> contatti = getRubrica();

		for (Contatto c : contatti) {
			System.out.println(c);
		}
		
	}
}
