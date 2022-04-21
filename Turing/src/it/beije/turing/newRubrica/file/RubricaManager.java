package it.beije.turing.newRubrica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.turing.newRubrica.rubrica.Contatto;

public class RubricaManager {
	///////////////////////////////////////CSV///////////////////////////////////////////////
	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		try {
			fileReader = new FileReader(pathFile);
			
			bufferedReader = new BufferedReader(fileReader);
			int c = 0;
			contatti = new ArrayList<Contatto>();
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				String[] columns = row.split(separator);
				contatto = new Contatto();
				try {
					contatto.setCognome(columns[0]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setCognome("");
				}
				try {
					contatto.setNome(columns[1]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNome("");
				}
				try {
					contatto.setEmail(columns[2]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setEmail("");
				}
				try {
					contatto.setTelefono(columns[3]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setTelefono("");
				}
				try {
					contatto.setNote(columns[4]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNote("");
				}
				try {
					contatto.setId(Integer.parseInt(columns[5]));
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setId(0);
				}
				if(contatto.getNome().equalsIgnoreCase("NOME")) {
					continue;
				}
				eliminaVirgolette(contatto);
				contatti.add(contatto);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
		}
		
		System.out.println("contatti: " + contatti.size());
		return contatti;
	}
	
	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {
		File file = new File(pathFile);
		System.out.println("file exists? " + file.exists());
		
		if (file.exists()) {
			System.out.println("FILE GIA' ESISTENTE!!!");
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);

			for (Contatto contatto : contatti) {
				fileWriter.write(contatto.getCognome());
				fileWriter.write(separator);
				fileWriter.write(contatto.getNome());
				fileWriter.write(separator);
				fileWriter.write(contatto.getEmail());
				fileWriter.write(separator);
				fileWriter.write(contatto.getTelefono());
				fileWriter.write(separator);
				fileWriter.write(contatto.getNote());
				fileWriter.write(separator);
				fileWriter.write("\n");
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
			
			System.out.println("done");
		}
	}
	
	////////////////////////////////////////XML//////////////////////////////////////////////
	public List<Contatto> loadRubricaFromXML(String pathFile) {
		List<Contatto> ris = new ArrayList<>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(pathFile);
			
			Element root = document.getDocumentElement();
			//System.out.println("root : " + root.getTagName());
			NodeList nodes = root.getChildNodes();
			//System.out.println("nodes num : " + nodes.getLength());
			
			List<Element> children = getChildElements(root);
			System.out.println("children num : " + children.size());
			
			for (Element el : children) {
				if (el.getTagName().equalsIgnoreCase("contatto")) {
					List<Element> contatto = getChildElements(el);
					Contatto c = new Contatto();
					for (Element value : contatto) {
						switch (value.getTagName().toLowerCase()) {
						case "nome":
							//System.out.println("nome : " + value.getTextContent());
							c.setNome(value.getTextContent());
							break;
						case "cognome":
							//System.out.println("cognome : " + value.getTextContent());
							c.setCognome(value.getTextContent());
							break;
						case "telefono":
							//System.out.println("telefono : " + value.getTextContent());	
							c.setTelefono(value.getTextContent());
							break;
						case "email":
							//System.out.println("email : " + value.getTextContent());
							c.setEmail(value.getTextContent());
							break;
						case "note":
							//System.out.println("note : " + value.getTextContent());	
							c.setNote(value.getTextContent());
							break;

						default:
							break;
						}
						
					}
					
					//System.out.println("eta' : " + el.getAttribute("eta"));
					ris.add(c);
				}
			}
			
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
		System.out.println("Done!");
		return ris;
	}
	public void writeRubricaXML(List<Contatto> contatti, String pathFile) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		Document doc = documentBuilder.newDocument();
		
		Element contattiEl = doc.createElement("contatti");
		doc.appendChild(contattiEl);
		
		for(Contatto c : contatti) {
			Element contatto = doc.createElement("contatto");
			contatto.setAttribute("id", Integer.toString(c.getId()));
			
			Element cognome = doc.createElement("cognome");
			cognome.setTextContent(c.getCognome());//<cognome>Marrone</cognome>
			contatto.appendChild(cognome);

			Element nome = doc.createElement("nome");
			nome.setTextContent(c.getNome());//<nome>Emma</nome>
			contatto.appendChild(nome);

			Element telefono = doc.createElement("telefono");
			telefono.setTextContent(c.getTelefono());
			contatto.appendChild(telefono);

			Element email = doc.createElement("email");
			email.setTextContent(c.getEmail());
			contatto.appendChild(email);

			Element note = doc.createElement("note");
			note.setTextContent(c.getNote());
			contatto.appendChild(note);
			
			contattiEl.appendChild(contatto);
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File(pathFile));
		StreamResult syso = new StreamResult(System.out);

		try {
			transformer.transform(source, result);
			//transformer.transform(source, syso);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
	//////////////////////////////////////////SQL////////////////////////////////////////////
	public static Connection getConnection(String dbName, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"?serverTimezone=CET", username, password);
	}
	
	public List<Contatto> loadRubricaFromJDBC(String dbName, String username, String password){
		List<Contatto> allContact = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection(dbName,username,password);
			statement = connection.createStatement();
			
			rs = statement.executeQuery("SELECT * FROM rubrica");
			
			while (rs.next()) {
				Contatto c = new Contatto();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setTelefono( rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setNote(rs.getString("note"));
				allContact.add(c);
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return allContact;
	}
	
	
	
	public void writeRubricaOnJDBC(List<Contatto> contatti, String username, String password, String dbName) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection(dbName,username,password);
			statement = connection.createStatement();
			int i = 0;
			for(Contatto c : contatti) {
				i++;
				rs = statement.executeQuery("SELECT r.nome, r.cognome, r.telefono, r.email FROM rubrica AS r WHERE r.nome = '"+c.getNome()+"' AND r.cognome = '"+c.getCognome()+"' AND "
						+ "r.telefono = '"+c.getTelefono()+"' AND r.email = '"+c.getEmail()+"';");
				if(rs.next()) {
					rs.close();
				}else {
					int ris2 = statement.executeUpdate("INSERT INTO rubrica VALUES (null, '"+c.getNome()+"', '"+c.getCognome()+"', '"
							+c.getTelefono()+"', '"+c.getEmail()+"', '"+c.getNote()+"');");
					rs.close();
				}
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}
	
	
	public void writeRubricaOnJDBCPrepared(List<Contatto> contatti, String username, String password, String dbName) {
		Connection connection = null;
		PreparedStatement insertPrepStatement = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection(dbName,username,password);
			
			int i = 0;
			for(Contatto c : contatti) {
				insertPrepStatement = connection.prepareStatement("SELECT r.* FROM rubrica AS r WHERE (r.nome = ? AND r.cognome = ? AND r.telefono = ? AND r.email = ?);");
				insertPrepStatement.setString(1, c.getNome());
				insertPrepStatement.setString(2, c.getCognome());
				insertPrepStatement.setString(3, c.getTelefono());
				insertPrepStatement.setString(4, c.getEmail());
				rs = insertPrepStatement.executeQuery();
				if(rs.next()) {
					insertPrepStatement.close();
//					UPDATE(INUTILE)
//					insertPrepStatement = connection.prepareStatement("UPDATE rubrica AS r SET (nome = ?, cognome = ?, telefono = ?, email = ?, note = ?) WHERE (r.nome = ? AND r.cognome = ? AND r.telefono = ? AND r.email = ?);");
//					insertPrepStatement.setString(1, c.getNome());
//					insertPrepStatement.setString(2, c.getCognome());
//					insertPrepStatement.setString(3, c.getTelefono());
//					insertPrepStatement.setString(4, c.getEmail());
//					insertPrepStatement.setString(5, c.getNote());
//					insertPrepStatement.setString(6, c.getNome());
//					insertPrepStatement.setString(7, c.getCognome());
//					insertPrepStatement.setString(8, c.getTelefono());
//					insertPrepStatement.setString(9, c.getEmail());
//					insertPrepStatement.executeUpdate();
					rs.close();
				}else {
					insertPrepStatement.close();
					insertPrepStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");
					insertPrepStatement.setString(1, c.getNome());
					insertPrepStatement.setString(2, c.getCognome());
					insertPrepStatement.setString(3, c.getTelefono());
					insertPrepStatement.setString(4, c.getEmail());
					insertPrepStatement.setString(5, c.getNote());
					insertPrepStatement.executeUpdate();
					rs.close();
				}
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}	
				insertPrepStatement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}
	
//////////////////////////////////////////HIBERNATE////////////////////////////////////////////
	
	public List<Contatto> loadRubricaFromHibernate(){
		Session session = null;
		try {
			session = SessionFactorySingleton.openSession();
			
			//Select
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
			List<Contatto> contatti = query.getResultList();
			
			return contatti;
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
	
	public boolean updateRubricaOnHibernate(int id) {
		List<Contatto> allContact = null;
		Scanner s = new Scanner(System.in);
		Contatto tmp = null;
		
		
		Session session = null;
		try {
			session = SessionFactorySingleton.openSession();
			Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
			allContact = query.getResultList();
			for(Contatto c: allContact) {
				if(c.getId() == id) {
					tmp = c;
					break;
				}
			}
			if(tmp == null) return false;
			Transaction transaction = session.beginTransaction();
			
			System.out.println("Insert new name: ");
			String nome = s.nextLine();
			if(!nome.isEmpty() || !(nome.length() == 0)) {
				tmp.setNome(nome);
			}
			System.out.println("Insert new surname: ");
			String cognome = s.nextLine();
			if(!cognome.isEmpty() || !(cognome.length() == 0)) {
				tmp.setCognome(cognome);
			}
			System.out.println("Insert new phone number: ");
			String telefono = s.nextLine();
			if(!telefono.isEmpty() || !(telefono.length() == 0)) {
				tmp.setTelefono(telefono);
			}
			System.out.println("Insert new email: ");
			String email = s.nextLine();
			if(!email.isEmpty() || !(email.length() == 0)) {
				tmp.setEmail(email);
			}
			System.out.println("Insert new note: ");
			String note = s.nextLine();
			if(!note.isEmpty() || !(note.length() == 0)) {
				tmp.setNote(note);
			}
			
			session.save(tmp);
			transaction.commit();
		}catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return true;
	}
	
	public boolean insertRubricaOnHibernate() {
		Scanner s = new Scanner(System.in);
		Contatto tmp = new Contatto();
		
		System.out.println("Insert name: ");
		String nome = s.nextLine();
		if(!nome.isEmpty() || !(nome.length() == 0)) {
			tmp.setNome(nome);
		}
		System.out.println("Insert surname: ");
		String cognome = s.nextLine();
		if(!cognome.isEmpty() || !(cognome.length() == 0)) {
			tmp.setCognome(cognome);
		}
		System.out.println("Insert phone number: ");
		String telefono = s.nextLine();
		if(!telefono.isEmpty() || !(telefono.length() == 0)) {
			tmp.setTelefono(telefono);
		}
		System.out.println("Insert email: ");
		String email = s.nextLine();
		if(!email.isEmpty() || !(email.length() == 0)) {
			tmp.setEmail(email);
		}
		System.out.println("Insert note: ");
		String note = s.nextLine();
		if(!note.isEmpty() || !(note.length() == 0)) {
			tmp.setNote(note);
		}
		Session session = null;
		try {
			session = SessionFactorySingleton.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(tmp);
			transaction.commit();
		}catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return true;
	}
	
	public boolean deleteRubricaOnHibernate(int id) {
		List<Contatto> allContact = loadRubricaFromHibernate();
		Contatto tmp = null;
		for(Contatto c: allContact) {
			if(c.getId() == id) {
				tmp = c;
				break;
			}
		}
		if(tmp == null) return false;
		Session session = null;
		try {
			session = SessionFactorySingleton.openSession();
			Transaction transaction = session.beginTransaction();
			session.remove(tmp);
			transaction.commit();
		}catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return true;
	}
	public boolean deleteAllRubricaOnHibernate() {
		List<Contatto> allContact = loadRubricaFromHibernate();
		Session session = null;
		try {
			session = SessionFactorySingleton.openSession();
			Transaction transaction = session.beginTransaction();
			for(Contatto c: allContact) {
				session.remove(c);
			}
			
			transaction.commit();
		}catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
			throw hbmEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return true;
	}
	
//////////////////////////////////////////JPA////////////////////////////////////////////
	
	public List<Contatto> loadRubricaFromJPA(){
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			javax.persistence.Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
			List<Contatto> contatti = query.getResultList();
			return contatti;
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

	public boolean updateRubricaOnJPA(int id) {
		Scanner s = new Scanner(System.in);
		Contatto tmp = null;
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			tmp = entityManager.find(Contatto.class, id);
			if(tmp == null) return false;
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			System.out.println("Insert new name: ");
			String nome = s.nextLine();
			if(!nome.isEmpty() || !(nome.length() == 0)) {
				tmp.setNome(nome);
			}
			System.out.println("Insert new surname: ");
			String cognome = s.nextLine();
			if(!cognome.isEmpty() || !(cognome.length() == 0)) {
				tmp.setCognome(cognome);
			}
			System.out.println("Insert new phone number: ");
			String telefono = s.nextLine();
			if(!telefono.isEmpty() || !(telefono.length() == 0)) {
				tmp.setTelefono(telefono);
			}
			System.out.println("Insert new email: ");
			String email = s.nextLine();
			if(!email.isEmpty() || !(email.length() == 0)) {
				tmp.setEmail(email);
			}
			System.out.println("Insert new note: ");
			String note = s.nextLine();
			if(!note.isEmpty() || !(note.length() == 0)) {
				tmp.setNote(note);
			}
			entityManager.persist(tmp);
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
		return true;
	}

	public boolean insertRubricaOnJPA() {
		Scanner s = new Scanner(System.in);
		Contatto tmp = new Contatto();

		System.out.println("Insert name: ");
		String nome = s.nextLine();
		if(!nome.isEmpty() || !(nome.length() == 0)) {
			tmp.setNome(nome);
		}
		System.out.println("Insert surname: ");
		String cognome = s.nextLine();
		if(!cognome.isEmpty() || !(cognome.length() == 0)) {
			tmp.setCognome(cognome);
		}
		System.out.println("Insert phone number: ");
		String telefono = s.nextLine();
		if(!telefono.isEmpty() || !(telefono.length() == 0)) {
			tmp.setTelefono(telefono);
		}
		System.out.println("Insert email: ");
		String email = s.nextLine();
		if(!email.isEmpty() || !(email.length() == 0)) {
			tmp.setEmail(email);
		}
		System.out.println("Insert note: ");
		String note = s.nextLine();
		if(!note.isEmpty() || !(note.length() == 0)) {
			tmp.setNote(note);
		}
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(tmp);
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
		return true;
	}

	public boolean deleteRubricaOnJPA(int id) {
		Contatto tmp = null;
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			tmp = entityManager.find(Contatto.class, id);
			if(tmp == null) return false;
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(tmp);
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
		return true;
	}
	public boolean deleteAllRubricaOnJPA() {
		List<Contatto> allContact = null;
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerFactorySingleton.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			javax.persistence.Query query = entityManager.createQuery("SELECT c FROM Contatto as c");
			allContact = query.getResultList();
			for(Contatto c: allContact) {
				entityManager.remove(c);
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
		return true;
	}
/////////////////////////////////////////////Generale//////////////////////////////////////////
	public static boolean eliminaVirgolette(Contatto c) {
		
		for(int i = 0; i < c.getNome().length(); i++) {
			if(c.getNome().charAt(i) == '\'' || c.getNome().charAt(i) == '"') {
				c.setNome(c.getNome().substring(0,i).concat(c.getNome().substring(i+1)));
			}
		}
		for(int i = 0; i < c.getCognome().length(); i++) {
			if(c.getCognome().charAt(i) == '\'' || c.getCognome().charAt(i) == '"') {
				c.setCognome(c.getCognome().substring(0,i).concat(c.getCognome().substring(i+1)));
			}
		}
		for(int i = 0; i < c.getTelefono().length(); i++) {
			if(c.getTelefono().charAt(i) == '\'' || c.getTelefono().charAt(i) == '"') {
				c.setTelefono(c.getTelefono().substring(0,i).concat(c.getTelefono().substring(i+1)));
			}
		}
		for(int i = 0; i < c.getEmail().length(); i++) {
			if(c.getEmail().charAt(i) == '\'' || c.getEmail().charAt(i) == '"') {
				c.setEmail(c.getEmail().substring(0,i).concat(c.getEmail().substring(i+1)));
			}
		}
		return true;
	}
	
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}
}
