package it.beije.turing.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.turing.Contatto;
import it.beije.turing.service.JPAentityManagerFactoryService;

public class JPAmanagerService {
	
	public static List<Contatto> getRubrica() {
		EntityManager entityManager = JPAentityManagerFactoryService.openEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		entityManager.close();
		return contatti;
	}
	
	public static void insertToRubrica(Contatto contatto) {
		EntityManager entityManager = JPAentityManagerFactoryService.openEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		if(contatto.getId() == 0) {
			if(contatto.getNome().equals("")) {
				contatto.setNome(null);
			}
			if(contatto.getCognome().equals("")) {
				contatto.setCognome(null);
			}
			if(contatto.getEmail().equals("")) {
				contatto.setEmail(null);
			}
			if(contatto.getTelefono().equals("")) {
				contatto.setTelefono(null);
			}
			if(contatto.getNote().equals("")) {
				contatto.setNote(null);
			}
			if(contatto.getDataDiNascita().equals("")) {
				contatto.setDataDiNascita(null);
			}
			if(contatto.getIndirizzo().equals("")) {
				contatto.setIndirizzo(null);
			}
			entityManager.persist(contatto);
		} else {
			System.out.println("Contatto invalido per questa operazione.");
		}
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void updateContattoRubrica(Contatto newContatto, int id) {
		EntityManager entityManager = JPAentityManagerFactoryService.openEntityManager();
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
			if(!newContatto.getDataDiNascita().equals("") && newContatto.getDataDiNascita() != null) {
				contatto.setDataDiNascita(newContatto.getDataDiNascita());
			}
			if(!newContatto.getIndirizzo().equals("") && newContatto.getIndirizzo() != null) {
				contatto.setIndirizzo(newContatto.getIndirizzo());
			}
			entityManager.persist(contatto);
		}
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public static void deleteContattoRubrica(int id) {
		EntityManager entityManager = JPAentityManagerFactoryService.openEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Contatto contatto = entityManager.find(Contatto.class, id);
		System.out.println("cancello : " + contatto);
		
		entityManager.remove(contatto);
		
		entityTransaction.commit();
		entityManager.close();
	}

//	public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
//		List<Contatto> contatti = CSVmanager.loadRubricaFromCSV(path, separatore, virgolette);
//		
//		for(Contatto contatto : contatti) {
//			insertToRubrica(contatto);
//		}
//	}

//	public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
//		List<Contatto> contatti = XMLmanager.loadRubricaFromXML(path);
//		
//		for(Contatto contatto : contatti) {
//			insertToRubrica(contatto);
//		}
//	}
	
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