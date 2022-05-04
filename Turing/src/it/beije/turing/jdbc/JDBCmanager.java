package it.beije.turing.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.beije.turing.rubrica.Contatto;

public class JDBCmanager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET", "root",
				"nardella");
	}

	public static String buildStatement(Object[] o) {
		StringBuilder sb = new StringBuilder("(");
		for (int i = 0; i < o.length; i++) {
			if (o[i] != null)
				sb.append("' " + o[i].toString().trim() + " '");
			else
				sb.append(o[i]);

			if (i == o.length - 1)
				sb.append(")");
			else
				sb.append(" , ");
		}
		return sb.toString();
	}

	public static void addContatto(Contatto c, Statement statement) throws SQLException {
//		StringBuilder update = new StringBuilder("INSERT INTO contatto VALUES ('" + c.getId() + "', " + "'"
//				+ c.getNome() + "', " + "'" + c.getCognome() + "', " + "'" + c.getTelefono() + "', " + "'"
//				+ c.getEmail() + "', " + "'" + c.getNote() + "')");
		if(c.getTelefono().contains("+"))
			c.setTelefono(c.getTelefono().substring(1, c.getTelefono().length()));
		Object[] o = new Object[] { c.getId(), c.getNome(), c.getCognome(), c.getTelefono(), c.getEmail(),
				c.getNote() };
		StringBuilder update = new StringBuilder("INSERT INTO rubrica VALUES" + buildStatement(o));
		System.out.print(update);
		statement.executeUpdate(update.toString());
	}

	public static void addContatti(ArrayList<Contatto> contatti) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();

			for (Contatto c : contatti) {
				addContatto(c, statement);
			}

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}

	public static void readContatti() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			if (statement.execute("SELECT * FROM rubrica")) {
				ResultSet rs = statement.getResultSet();
				while (rs.next()) {
					System.out.println("id : " + rs.getInt(1));
					System.out.println("nome : " + rs.getString(2));
					System.out.println("cognome : " + rs.getString(3));
					System.out.println("email : " + rs.getString(4));
					System.out.println("telefono : " + rs.getString(5));
					System.out.println("note : " + rs.getString(6));
				}
			}

		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

	}
//		Connection connection = null;
//		Statement statement = null;
//		ResultSet rs = null;
//		Contatto contatto = new Contatto(1 , "Marco", "Nardella", "393449875210", "ciao@gmail.com", "Marco Nardo");
////		try {
////			connection = getConnection();
////			statement = connection.createStatement();
////			
////			//INSERT
////			addContatto(contatto, statement);
//			//statement.executeUpdate("INSERT INTO contatto VALUES (null, 'Piero', 'Verde', '5355223532', 'l.verde@beije.it', null)");
//			
//			//UPDATE
//			//statement.executeUpdate("UPDATE rubrica SET telefono = '123452' where id = 2");
//
//			//DELETE
//			//statement.executeUpdate("DELETE FROM rubrica where id = 4");
//
//			//SELECT
////			if (statement.execute("SELECT * FROM rubrica")) {
////				ResultSet rs = statement.getResultSet(); 
////			}
//			rs = statement.executeQuery("SELECT * FROM contatto");
//			//ResultSet rs = statement.executeQuery("SELECT nome, cognome, email FROM rubrica");
//			while (rs.next()) {
////				System.out.println("id : " + rs.getInt(1));				
////				System.out.println("nome : " + rs.getString(2));				
////				System.out.println("cognome : " + rs.getString(3));				
////				System.out.println("email : " + rs.getString(4));				
////				System.out.println("telefono : " + rs.getString(5));				
////				System.out.println("note : " + rs.getString(6));				
//
////				System.out.println("nome : " + rs.getString(1));				
////				System.out.println("cognome : " + rs.getString(2));				
////				System.out.println("email : " + rs.getString(3));				
//
//				System.out.println("id : " + rs.getInt("id"));				
//				System.out.println("nome : " + rs.getString("nome"));				
//				System.out.println("cognome : " + rs.getString("cognome"));				
//				System.out.println("email : " + rs.getString("email"));				
//				System.out.println("telefono : " + rs.getString("telefono"));				
//				System.out.println("note : " + rs.getString("note"));				
//
////				System.out.println("cognome : " + rs.getString("cognome"));				
////				System.out.println("nome : " + rs.getString("nome"));				
////				System.out.println("email : " + rs.getString("email"));				
//			}
//
//			
//		} catch (ClassNotFoundException cnfEx) {
//			cnfEx.printStackTrace();
//		} catch (SQLException sqlEx) {
//			sqlEx.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				statement.close();
//				connection.close();
//			} catch (SQLException sqlEx) {
//				sqlEx.printStackTrace();
//			}
//		}
//
//	}

}
