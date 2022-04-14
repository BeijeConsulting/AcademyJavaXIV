package it.beije.turing.rubrica.persistenza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import it.beije.turing.rubrica.*;

public class JDBCDataBase {
	
	public void getInsertContatti(List<Contatto> lista) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "beije");
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "beije");
			statement = connection.createStatement();
			
			//INSERT
			//statement.executeUpdate("INSERT INTO rubrica VALUES (null, 'Piero', 'Verde', 'l.verde@beije.it', '5355223532', null)");


			
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
