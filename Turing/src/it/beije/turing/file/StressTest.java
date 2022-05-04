package it.beije.turing.file;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.turing.jdbc.JDBCmanager;
import it.beije.turing.rubrica.Contatto;

public class StressTest {

	public static void main(String[] args) {
		ArrayList<Connection> connections = new ArrayList<>();
		ArrayList<Session> sessions = new ArrayList<>();
		int jdbCount = 0;
		int hbCount = 0;
	}
}

//		while (true) {
//			connections.add(JDBCmanager.getConnection());
//			jdbCount++;
//		}
//		System.out.println(jdbCount);

//		int lastCount = 0;
//		Session session = null;

//		try {
//			connections.add(JDBCmanager.getConnection());
//			connections.get(connections.size() - 1).beginRequest();
//			jdbCount++;
//
//			do {
//				//Do nothing and wait for the connection to get close
//				//It may take a while(28800 seconds)
//			} while (!connections.get(connections.size() - 1).isClosed());
//			System.out.println("Finito");
//			Scanner scanner = new Scanner(System.in);
//			scanner.nextLine();
//			scanner.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(jdbCount + "is the max number of connections for jdbc");
//		}

//		do {
//
//			try {
//				connections.add(JDBCmanager.getConnection());
//				//connections.get(connections.size() - 1).beginRequest();
//				jdbCount++;

//				for (Connection c : connections) {
//					if (c.isClosed())
//						break;
//				}

//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println(jdbCount + "is the max number of connections for jdbc");
//			} finally {
//				try {
//
//					Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
//
//					SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//					sessions.add(sessionFactory.openSession());
//					hbCount++;
//
//				} catch (Exception e) {
//					System.out.println(hbCount + "is the max number of connections for Hibernate");
//				}
//
//			}
//		} while (true);
//
//	}
//}
