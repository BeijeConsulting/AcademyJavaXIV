package it.beije.turing.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.xml.sax.SAXException;

import it.beije.turing.file.CSVmanager;
import it.beije.turing.file.XMLmanager;
import it.beije.turing.rubrica.Contatto;


public class HBmanager {
	
	public static List<Contatto> getRubrica() {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		Session session = null;
		try {
			session = HBsessionFactory.openSession();
			
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
			contatti = query.getResultList();
		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		
		return contatti;
	}

	public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
		List<Contatto> contatti = CSVmanager.loadRubricaFromCSV(path, separatore, virgolette);
		
		saveIntoDB(contatti);
	}

	public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
		List<Contatto> contatti = XMLmanager.loadRubricaFromXML(path);
		
		saveIntoDB(contatti);
	}
	
	public static void saveIntoDB(List<Contatto> contatti) {
		Session session = null;
		try {
			session = HBsessionFactory.openSession();
			
			//INSERT
			//Transaction transaction = session.beginTransaction();
			Transaction transaction = session.getTransaction();
			transaction.begin();
			
			
			for(Contatto c : contatti) {
				session.save(c);
			}
			
			transaction.commit();
		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public static void updateDB(Contatto contattoNuovo, int id) {
		Session session = null;
		try {
			session = HBsessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
			List<Contatto> contatti = query.getResultList();
			
			Contatto contatto = null;
			for (Contatto c : contatti) {
				if (c.getId() == id) contatto = c;
			}

			
			//UPDATE
			
			System.out.println(contattoNuovo.getNome());
			if(!contattoNuovo.getNome().equals("")) {
				contatto.setNome(contattoNuovo.getNome());
			}
			if(!contattoNuovo.getCognome().equals("")) {
				contatto.setCognome(contattoNuovo.getCognome());
			}
			if(!contattoNuovo.getTelefono().equals("")) {
				contatto.setTelefono(contattoNuovo.getTelefono());
			}
			if(!contattoNuovo.getEmail().equals("")) {
				contatto.setEmail(contattoNuovo.getEmail());
			}
			if(!contattoNuovo.getNote().equals("")) {
				contatto.setNote(contattoNuovo.getNote());
			}
			
			session.save(contatto);

			transaction.commit();
		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		
		Session session = null;
		try {
			
			session = HBsessionFactory.openSession();
			System.out.println("session is open ? " + session.isOpen());
			
			
			//INSERT
			//Transaction transaction = session.beginTransaction();
//			Transaction transaction = session.getTransaction();
//			transaction.begin();
			
//			//INSERT
//			Contatto newContatto = new Contatto();
//			newContatto.setId(3);
//			newContatto.setCognome("Giuseppe");
//			newContatto.setNome("Verde");
//			newContatto.setEmail("g.verde@beije.it");
//			System.out.println("contatto PRE : " + newContatto);
//			
//			session.save(newContatto);
//			
//			System.out.println("contatto POST : " + newContatto);

			
			//SELECT HQL
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");//SELECT * FROM contatti
			List<Contatto> contatti = query.getResultList();
			
			Contatto contatto = null;
			for (Contatto c : contatti) {
				System.out.println(c);
				if (c.getId() == 12) contatto = c;
			}

			
//			//UPDATE
//			System.out.println("modifico : " + contatto);
//			//contatto.setId(20);
//			contatto.setNote("queste sono le note");
//			contatto.setNome("Piero");
//			session.save(contatto);
//			System.out.println("contatto POST update : " + contatto);
			
//			//DELETE
//			session.remove(contatto);
			
			//transaction.commit();
			//transaction.rollback();

		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		
	}

}
