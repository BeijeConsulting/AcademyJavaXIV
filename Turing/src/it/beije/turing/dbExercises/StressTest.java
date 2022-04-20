package it.beije.turing.dbExercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.turing.db.HBsessionFactory;
import it.beije.turing.rubrica.Contatto;

public class StressTest {
public static void main(String...args) throws SQLException 
{
	
System.out.println("Max numnber of connections for JDBC: "+HibernateNumberOfConnections());
//System.out.println("Time before connection is closed: "+ JDBCTimeOut()+ " seconds");
}

private static int JDBCTimeOut() {
	try {
		Connection connection = getConnection();
		
		int time=LocalTime.now().toSecondOfDay();
		do {
			time=LocalTime.now().toSecondOfDay()-time;
		}while(!connection.isClosed());
		return time;
	} catch (SQLException e) {
		e.printStackTrace();
		return -1;
	}
	
}

private static int JDBCNumberOfConnections()
{
	int counter=0;
	try {
		List<Connection> stack=new ArrayList<>();
		while(true)
		{		
			Connection connection = getConnection();
			counter++;
			stack.add(connection);
		}
		}
		catch(SQLException e){
			
		}
	finally {
		return counter;
	}
}

private static int HibernateNumberOfConnections()
{
	int counter=0;
	try {
		List<Session> stack=new ArrayList<>();
		while(true)
		{	
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);

			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session connection = sessionFactory.openSession();                                                                                                            
			counter++;
			stack.add(connection);
		}
		}
	finally {
		return counter;
	}
}



private static Connection getConnection() throws SQLException
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "1234");
}
}
