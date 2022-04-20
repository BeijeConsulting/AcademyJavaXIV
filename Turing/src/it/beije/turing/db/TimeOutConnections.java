package it.beije.turing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TimeOutConnections {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, HibernateException
	{
		Connection connection = getConnection();
		LocalTime startJdbc = LocalTime.now();
		Session session = HBsessionFactory.openSession();
		LocalTime startHibernate = LocalTime.now();
		while(true)
		{
			if (connection.isClosed()) System.out.println(LocalTime.now() + ", Jdbc Closed. Started at: " + startJdbc);
			if (!session.isOpen() || !session.isConnected()) System.out.println(LocalTime.now() + ", Hibernate Closed. Started at: " + startHibernate);
		}
	}
	
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "MattiaPagani");
	}
}
