package it.beije.turing.rubrica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.Query;

public class JViewer {
	public static void view (Connection connection) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ordering contacts by name (n) or by surname (s) ?");
		String st = s.next();
		while (!st.equals("n") & !st.equals("s")) {
			System.out.println("Invalid input, enter n or s:");
			st = s.next();
		}
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			if (st.equals("n")) {
				rs = statement.executeQuery("SELECT * FROM rubrica ORDER BY nome");			
			} else {
				rs = statement.executeQuery("SELECT * FROM rubrica ORDER BY cognome");	
			}

			while (rs.next()) {
				System.out.print("id : " + rs.getInt("id")+"\t|| ");				
				System.out.print("nome : " + rs.getString("nome")+"\t|| ");				
				System.out.print("cognome : " + rs.getString("cognome")+"\t|| ");				
				System.out.print("email : " + rs.getString("email")+"\t|| ");				
				System.out.print("telefono : " + rs.getString("telefono")+"\t|| ");				
				System.out.print("note : " + rs.getString("note")+"\n");	
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				s.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
	}
}
