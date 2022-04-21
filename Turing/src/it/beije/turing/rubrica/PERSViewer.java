package it.beije.turing.rubrica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

public class PERSViewer {
	public static void view (EntityManager entityManager) {
		Query query;
		Scanner s = new Scanner(System.in);
		System.out.println("Ordering contacts by name (n) or by surname (s) ?");
		String st = s.next();
		while (!st.equals("n") & !st.equals("s")) {
			System.out.println("Invalid input, enter n or s:");
			st = s.next();
		}
		if (st.equals("n")) {
			query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY nome");
		} else {
			query = entityManager.createQuery("SELECT c FROM Contatto as c ORDER BY cognome");
		}

		List<Contatto> contatti = query.getResultList();

		for (Contatto c: contatti) {
			System.out.println(c);
		}
	}

}
