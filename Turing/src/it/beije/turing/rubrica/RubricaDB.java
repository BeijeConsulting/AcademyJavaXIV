package it.beije.turing.rubrica;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.beije.turing.file.JDBCUtil;

public class RubricaDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = JDBCUtil.getConnection(
					"jdbc:mysql://localhost:3306/turing?serverTimezone=CET",
					"root", "verde");
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM rubrica");
			
			while (rs.next()) {
				System.out.println("id : " + rs.getInt(1));				
				System.out.println("nome : " + rs.getString(2));				
				System.out.println("cognome : " + rs.getString(3));				
				System.out.println("email : " + rs.getString(4));				
				System.out.println("telefono : " + rs.getString(5));				
				System.out.println("note : " + rs.getString(6));	
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
			} catch (SQLException fEx) {
				fEx.printStackTrace();
			}
		}
	}

}
