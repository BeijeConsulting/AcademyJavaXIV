package it.beije.turing.rubrica;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HibViewer {
	public static void view (Session sessione) {
		Query<Contatto> query;
		Scanner s = new Scanner(System.in);
		System.out.println("Ordering contacts by name (n) or by surname (s) ?");
		String st = s.next();
		while (!st.equals("n") & !st.equals("s")) {
			System.out.println("Invalid input, enter n or s:");
			st = s.next();
		}
		if (st.equals("n")) {
			query = sessione.createQuery("SELECT c FROM Contatto as c ORDER BY nome");
		} else {
			query = sessione.createQuery("SELECT c FROM Contatto as c ORDER BY cognome");
		}

		List<Contatto> contatti = query.getResultList();

		for (Contatto c: contatti) {
			System.out.println(c);
		}
	}
}
