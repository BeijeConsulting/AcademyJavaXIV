package it.beije.turing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCmanager {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "Marazzini");
	}

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			//INSERT
			//statement.executeUpdate("INSERT INTO rubrica VALUES (null, 'Piero', 'Verde', 'l.verde@beije.it', '5355223532', null)");
			
			//UPDATE
			//statement.executeUpdate("UPDATE rubrica SET note = 'quarto contatto' where id = 4");

			//DELETE
			//statement.executeUpdate("DELETE FROM rubrica where id = 4");

			//SELECT
//			if (statement.execute("SELECT * FROM rubrica")) {
//				ResultSet rs = statement.getResultSet(); 
//			}
			rs = statement.executeQuery("SELECT * FROM rubrica");
			//ResultSet rs = statement.executeQuery("SELECT nome, cognome, email FROM rubrica");
			while (rs.next()) {
//				System.out.println("id : " + rs.getInt(1));				
//				System.out.println("nome : " + rs.getString(2));				
//				System.out.println("cognome : " + rs.getString(3));				
//				System.out.println("email : " + rs.getString(4));				
//				System.out.println("telefono : " + rs.getString(5));				
//				System.out.println("note : " + rs.getString(6));				

//				System.out.println("nome : " + rs.getString(1));				
//				System.out.println("cognome : " + rs.getString(2));				
//				System.out.println("email : " + rs.getString(3));				

				System.out.println("id : " + rs.getInt("id"));				
				System.out.println("nome : " + rs.getString("nome"));				
				System.out.println("cognome : " + rs.getString("cognome"));				
				System.out.println("email : " + rs.getString("email"));				
				System.out.println("telefono : " + rs.getString("telefono"));				
				System.out.println("note : " + rs.getString("note"));				

//				System.out.println("cognome : " + rs.getString("cognome"));				
//				System.out.println("nome : " + rs.getString("nome"));				
//				System.out.println("email : " + rs.getString("email"));				
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

}
