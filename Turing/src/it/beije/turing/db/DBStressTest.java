package it.beije.turing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




import it.beije.turing.rubrica.Contatto;

public class DBStressTest {

	public static void stressTestHB() {
		List<Session> sessioni = new ArrayList<Session>();
		
		for(int i = 0; i < 1000; i++) {
			Configuration configuration = new Configuration().configure()
					.addAnnotatedClass(Contatto.class);

			SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		
			sessioni.add(sessionFactory.openSession());
			System.out.println(sessioni.size());
		}
	}
	
	public static void stressTestJDBC() throws SQLException, ClassNotFoundException {
		List<Connection> connessioni = new ArrayList<Connection>();
		
		for(int i = 0; i < 1000; i++) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				connessioni.add(DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "BeijeTuring"));
			} catch (ClassNotFoundException cnfEx) {
				cnfEx.printStackTrace();
				throw cnfEx;
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
				throw sqlEx;
			}
			
			System.out.println(connessioni.size());
		}
	}
	
	public static void timeCloseSessionHB() {
		Configuration configuration = new Configuration().configure()
				.addAnnotatedClass(Contatto.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	
		Session session = sessionFactory.openSession();
		LocalDateTime open = LocalDateTime.now();
		System.out.println("Open: " + open);
		
		do {
			if(!session.isOpen()) {				
				LocalDateTime close = LocalDateTime.now();
				System.out.println("Close: " + close);
			}
		} while(session.isOpen());
	}
	
	public static void timeCloseConnectionJDBC() throws SQLException, ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "BeijeTuring");
			
			//System.out.println(connection.isValid(100000));
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
			throw cnfEx;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}
			
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//stressTestHB();
		//stressTestJDBC();
		//timeCloseSessionHB();
		timeCloseConnectionJDBC();
	}

}
