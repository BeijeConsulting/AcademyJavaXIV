package it.beije.turing.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import it.beije.turing.file.CSVmanager;
import it.beije.turing.file.XMLmanager;
import it.beije.turing.rubrica.Contatto;


import it.beije.turing.rubrica.Contatto;

import it.beije.turing.rubrica.Contatto;

import it.beije.turing.rubrica.Contatto;

import it.beije.turing.rubrica.Contatto;


public class JDBCmanager {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "BeijeTuring");
	}
	
	public static List<Contatto> getRubrica() {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		Connection connection = null;
		Statement statement = null;
		PreparedStatement insertPrepStatement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			

			rs = statement.executeQuery("SELECT * FROM rubrica");
			

			//INSERT
			//statement.executeUpdate("INSERT INTO rubrica VALUES (null, 'Piero', 'Verde', 'l.verde@beije.it', '5355223532', null)");


//			Contatto contatto = new Contatto();
//			contatto.setCognome("Leopardi");
//			contatto.setNome("Giacomo");
//			contatto.setEmail("g.leopardi@poeti.it");
//			statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + contatto.getNome() + "', '" + contatto.getCognome() + "', '" + contatto.getEmail() + "', '" + contatto.getTelefono() + "', " + contatto.getNote() + ")");
//			insertPrepStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");
//			insertPrepStatement.setString(1, contatto.getNome());
//			insertPrepStatement.setString(2, contatto.getCognome());
//			insertPrepStatement.setString(3, contatto.getEmail());
//			insertPrepStatement.setString(4, contatto.getTelefono());
//			insertPrepStatement.setString(5, contatto.getNote());
//			insertPrepStatement.executeUpdate();

//			Contatto contatto = new Contatto();
//			contatto.setCognome("Leopardi");
//			contatto.setNome("Giacomo");
//			contatto.setEmail("g.leopardi@poeti.it");
//			statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + contatto.getNome() + "', '" + contatto.getCognome() + "', '" + contatto.getEmail() + "', '" + contatto.getTelefono() + "', " + contatto.getNote() + ")");
//			insertPrepStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");
//			insertPrepStatement.setString(1, contatto.getNome());
//			insertPrepStatement.setString(2, contatto.getCognome());
//			insertPrepStatement.setString(3, contatto.getEmail());
//			insertPrepStatement.setString(4, contatto.getTelefono());
//			insertPrepStatement.setString(5, contatto.getNote());
//			insertPrepStatement.executeUpdate();


//			Contatto contatto = new Contatto();
//			contatto.setCognome("Leopardi");
//			contatto.setNome("Giacomo");
//			contatto.setEmail("g.leopardi@poeti.it");
//			statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + contatto.getNome() + "', '" + contatto.getCognome() + "', '" + contatto.getEmail() + "', '" + contatto.getTelefono() + "', " + contatto.getNote() + ")");
//			insertPrepStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");
//			insertPrepStatement.setString(1, contatto.getNome());
//			insertPrepStatement.setString(2, contatto.getCognome());
//			insertPrepStatement.setString(3, contatto.getEmail());
//			insertPrepStatement.setString(4, contatto.getTelefono());
//			insertPrepStatement.setString(5, contatto.getNote());
//			insertPrepStatement.executeUpdate();

//			Contatto contatto = new Contatto();
//			contatto.setCognome("Leopardi");
//			contatto.setNome("Giacomo");
//			contatto.setEmail("g.leopardi@poeti.it");
//			statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + contatto.getNome() + "', '" + contatto.getCognome() + "', '" + contatto.getEmail() + "', '" + contatto.getTelefono() + "', " + contatto.getNote() + ")");
//			insertPrepStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");
//			insertPrepStatement.setString(1, contatto.getNome());
//			insertPrepStatement.setString(2, contatto.getCognome());
//			insertPrepStatement.setString(3, contatto.getEmail());
//			insertPrepStatement.setString(4, contatto.getTelefono());
//			insertPrepStatement.setString(5, contatto.getNote());
//			insertPrepStatement.executeUpdate();

			
			//UPDATE
			//statement.executeUpdate("UPDATE rubrica SET telefono = '123452' where id = 2");

			//DELETE
			//statement.executeUpdate("DELETE FROM rubrica where id = 4");

			//SELECT
//			if (statement.execute("SELECT * FROM rubrica")) {
//				ResultSet rs = statement.getResultSet(); 
//			}
			rs = statement.executeQuery("SELECT * FROM rubrica");			
			//ResultSet rs = statement.executeQuery("SELECT nome, cognome, email FROM rubrica");

			while (rs.next()) {
				Contatto contatto = new Contatto();
				contatto.setId(rs.getInt("id"));
				contatto.setNome(rs.getString("nome"));
				contatto.setCognome(rs.getString("cognome"));
				contatto.setEmail(rs.getString("email"));
				contatto.setTelefono(rs.getString("telefono"));
				contatto.setNote(rs.getString("note"));
				contatti.add(contatto);
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
		
		return contatti;
	}

	public static void exportToCSV(String path, String separatore) throws IOException {
		List<Contatto> contatti = getRubrica();
		CSVmanager.writeRubricaCSV(contatti, path, separatore);
	}
	
	public static void exportToXML(String path) throws TransformerConfigurationException, ParserConfigurationException, TransformerException {
		List<Contatto> contatti = getRubrica();
		XMLmanager.writeRubricaXML(contatti, path);
	}
	
	public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
		List<Contatto> contatti = CSVmanager.loadRubricaFromCSV(path, separatore, virgolette);
		
		insertContacts(contatti);
	}
	
	public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
		List<Contatto> contatti = XMLmanager.loadRubricaFromXML(path);
		
		insertContacts(contatti);
	}
	
	public static void insertContacts(List<Contatto> contatti) {
		Connection connection = null;
		PreparedStatement insertPrepStatement = null;
		
		try {
			connection = getConnection();
			insertPrepStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");
			
			for(Contatto contatto : contatti) {
				insertPrepStatement.setString(1, contatto.getNome());
				insertPrepStatement.setString(2, contatto.getCognome());
				insertPrepStatement.setString(3, contatto.getEmail());
				insertPrepStatement.setString(4, contatto.getTelefono());
				insertPrepStatement.setString(5, contatto.getNote());
				insertPrepStatement.executeUpdate();
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				insertPrepStatement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}
	
 	public static void updateContact(int id, Contatto contatto) {
 		Connection connection = null;
		PreparedStatement insertPrepStatement = null;
		
		try {
			connection = getConnection();
			insertPrepStatement = connection.prepareStatement("UPDATE rubrica SET nome = ?, cognome = ?, email = ?, telefono = ?, note = ? where id = ?");
			
			
			insertPrepStatement.setString(1, contatto.getNome());
			insertPrepStatement.setString(2, contatto.getCognome());
			insertPrepStatement.setString(3, contatto.getEmail());
			insertPrepStatement.setString(4, contatto.getTelefono());
			insertPrepStatement.setString(5, contatto.getNote());
			insertPrepStatement.setInt(6, id);
			insertPrepStatement.executeUpdate();
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				insertPrepStatement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
 	}
	
 	public static void deleteContact(int id) {
 		Connection connection = null;
		PreparedStatement insertPrepStatement = null;
		
		try {
			connection = getConnection();
			insertPrepStatement = connection.prepareStatement("DELETE FROM rubrica where id = ?");
			
			insertPrepStatement.setInt(1, id);
			insertPrepStatement.executeUpdate();
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				insertPrepStatement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
 	}
	//DELETE
	//statement.executeUpdate("DELETE FROM rubrica where id = 4");
	
	public static void main(String[] args) {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		Contatto contatto = new Contatto();
		contatto.setNome("Piero");
		contatto.setCognome("Bianchi");
		contatto.setEmail("p.bianchi@gmail.com");
		contatto.setTelefono("3387561234");
		contatto.setNote("Calcetto");
		contatti.add(contatto);
		
		//insertContacts(contatti);
		//updateContact(17, contatto);
		//deleteContact(17);
		List<Contatto> newContatti = getRubrica();
		for(Contatto c : newContatti) {
			System.out.println(c);
		}
	}

}
