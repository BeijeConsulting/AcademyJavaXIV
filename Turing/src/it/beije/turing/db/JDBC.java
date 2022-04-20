package it.beije.turing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.InsertParams;

import it.beije.turing.rubrica.Contatto;

public class JDBC {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "provezza");
	}
	
	public static int insert(Contatto contatto) {

		Connection connection = null;
		Statement statement = null;

		
		PreparedStatement insertPreparedStatement = null;
		
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			insertPreparedStatement = connection.prepareStatement("INSERT INTO rubrica VALUES(null, ?, ?, ?, ?, ?)");
			
			insertPreparedStatement.setString(1, contatto.getNome());
			insertPreparedStatement.setString(2, contatto.getCognome());
			insertPreparedStatement.setString(3, contatto.getEmail());
			insertPreparedStatement.setString(4, contatto.getTelefono());
			insertPreparedStatement.setString(5, contatto.getNote());
			
			return insertPreparedStatement.executeUpdate();		
			
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
		return -1;
	}
	
	public static void select(String query) {
		
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
	
		if (statement.execute("SELECT * FROM rubrica")) {
			rs = statement.getResultSet(); 
		}
		
		rs = statement.executeQuery(query);
		while (rs.next()) {
			System.out.println("id : " + rs.getInt("id"));
			System.out.println("nome : " + rs.getString("nome"));
			System.out.println("cognome : " + rs.getString("cognome"));
			System.out.println("email : " + rs.getString("email"));
			System.out.println("telefono : " + rs.getString("telefono"));
			System.out.println("note : " + rs.getString("note"));
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
		
	public static int delete(String query) {
		Statement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();

			return statement.executeUpdate(query);

		}  catch (ClassNotFoundException cnfEx) {
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
		return -1;
	}
	
	public static int update(String query) {
		Statement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		
		PreparedStatement insertPreparedStatement = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();

			return statement.executeUpdate(query);
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
		
				connection.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
	
		Scanner tst = new Scanner(System.in);
		int  result = 0;
		
		switch (tst.nextInt()) {
		case 1:
			Contatto contatto = new Contatto();
			contatto.setCognome("bruni");
			contatto.setNome("paolo");
			contatto.setEmail("p.bruno@gmail.com");
			contatto.setTelefono("381649");
			contatto.setNote("zio");
			
			 result = insert(contatto);
			
			if(result != 0) System.out.println("contatto inserito correttamente");
			
			break;
			
		case 2:
			result = delete("DELETE FROM rubrica where id = 21");
			 if(result != 0 ) if(result != 0) System.out.println("contatto cancellato correttamente");
			break;
		case 3:
			result = update("UPDATE rubrica SET telefono = '543210' where id = 2");
			if(result != 0) System.out.println("contatto inserito correttamente");
			break;
		case 4:
			select("SELECT * FROM rubrica");
			break;


		}
		

		

		

		

		

		

	}

}
