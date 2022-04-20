package it.beije.turing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import it.beije.turing.rubrica.Contatto;
public class ConcurrentConnections {

	public static void main(String[] args) throws SQLException, HibernateException, ClassNotFoundException
	{
		int hibernateTests = 10000000;
		int jdbcTests = 10000000;
		int i = 0;
		
		try
		{
			for (i = 0; i < hibernateTests; i++) testHibernateConnections(i);
		}
		finally
		{
			System.out.println("Achieved " + i + " concurrent Hibernate connections.");
		}
		
		try
		{
			for (i = 0; i < jdbcTests; i++) testJdbcConnections(i);
		}
		finally
		{
			System.out.println("Achieved " + i + " concurrent Jdbc connections.");
		}
	}
	
	private static void testHibernateConnections(int i) throws HibernateException
	{
		Session session = null;
		try
		{
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);

			session = configuration.buildSessionFactory().openSession();
		}
		catch (HibernateException e)
		{
			throw new HibernateException("HIBERNATE CONNECTIONS: " + i);
		}
	}
	
	private static void testJdbcConnections(int i) throws SQLException, ClassNotFoundException
	{
		Connection connection = null;

		try
		{
			connection = getConnection();
		}
		catch (ClassNotFoundException e)
		{
			throw new ClassNotFoundException("JDBC CONNECTIONS: " + i);
		}
		catch (SQLException e)
		{
			throw new SQLException("JDBC CONNECTIONS: " + i);
		}
	}
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "MattiaPagani");
	}
}
