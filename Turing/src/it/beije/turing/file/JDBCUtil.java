package it.beije.turing.file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	
	public static Connection getConnection(String address, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(address, username, password);
	}
	
//	public static ResultSet getRecords(Statement statement) {
//		returnResultSet rs = statement
//	}
}
