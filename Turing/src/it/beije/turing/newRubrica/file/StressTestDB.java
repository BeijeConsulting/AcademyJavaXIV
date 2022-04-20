package it.beije.turing.newRubrica.file;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import it.beije.turing.newRubrica.rubrica.Contatto;

public class StressTestDB {
	
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		long end = 0L;
		end = StressTestHibernate();
		System.out.println("connection in "+(end-start)+"ms");
		
		start = System.currentTimeMillis();
		end = 0L;
		end = StressTestJDBC();
		System.out.println("connection in "+(end-start)+"ms");
		
	}
	
	public static long StressTestJDBC() {
		int i = 0;
		List<Connection> connection = new ArrayList<Connection>();
		try {
			while(true) {
				connection.add(RubricaManager.getConnection("turing", "root", "CorraroErcole"));
				//System.out.println(i+": "+connection.get(i));
				i++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(OutOfMemoryError err) {
			System.out.print("JDBC Opened "+i+" ");
			return System.currentTimeMillis();
		}catch (SQLException e) {
			System.out.print("JDBC Opened "+i+" ");
			return System.currentTimeMillis();
		}
		return 0L;
	}
	
	public static long StressTestHibernate() {
		List<Session> session = new ArrayList<Session>();
		int i = 0;
		try {
			while(true) {
				session.add(SessionFactorySingleton.openSession());
				//System.out.println(i+": "+session.get(i));
				i++;
			}
		} catch (HibernateException hbmEx) {
			hbmEx.printStackTrace();
		}catch(OutOfMemoryError err) {
			System.out.print("Hibernate Opened "+i+" ");
			return System.currentTimeMillis();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return 0L;
	}
	
}
