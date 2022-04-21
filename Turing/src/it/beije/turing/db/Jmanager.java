package it.beije.turing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import it.beije.turing.rubrica.*;

public class Jmanager {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "MySQL123");
	}

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		PreparedStatement insertPrepStatement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			//			statement = connection.createStatement();

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

			//UPDATE
			//statement.executeUpdate("UPDATE rubrica SET telefono = '123452' where id = 2");

			//DELETE
			//statement.executeUpdate("DELETE FROM rubrica where id = 4");

			//SELECT
			//			if (statement.execute("SELECT * FROM rubrica")) {
			//				ResultSet rs = statement.getResultSet(); 
			//			}
			//			rs = statement.executeQuery("SELECT * FROM rubrica");			
			//ResultSet rs = statement.executeQuery("SELECT nome, cognome, email FROM rubrica");
			//			while (rs.next()) {
			//				System.out.println("id : " + rs.getInt(1));				
			//				System.out.println("nome : " + rs.getString(2));				
			//				System.out.println("cognome : " + rs.getString(3));				
			//				System.out.println("email : " + rs.getString(4));				
			//				System.out.println("telefono : " + rs.getString(5));				
			//				System.out.println("note : " + rs.getString(6));				

			//				System.out.println("nome : " + rs.getString(1));				
			//				System.out.println("cognome : " + rs.getString(2));				
			//				System.out.println("email : " + rs.getString(3));				

			//				System.out.println("id : " + rs.getInt("id"));				
			//				System.out.println("nome : " + rs.getString("nome"));				
			//				System.out.println("cognome : " + rs.getString("cognome"));				
			//				System.out.println("email : " + rs.getString("email"));				
			//				System.out.println("telefono : " + rs.getString("telefono"));				
			//				System.out.println("note : " + rs.getString("note"));				

			//				System.out.println("cognome : " + rs.getString("cognome"));				
			//				System.out.println("nome : " + rs.getString("nome"));				
			//				System.out.println("email : " + rs.getString("email"));		

//			List<Contatto> contatti = JSearch.search(connection);
//			for (Contatto c : contatti) {
//				System.out.println(c);
//			}
			
			JViewer.view(connection);
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
//				rs.close();
//				statement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

	}

}
