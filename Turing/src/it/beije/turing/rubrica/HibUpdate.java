package it.beije.turing.rubrica;

import java.util.Scanner;

import org.hibernate.Session;

public class HibUpdate {

	public static void update (Session session, Contatto contatto) {
	//UPDATE
	System.out.println("Updating contact : " + contatto);
	//contatto.setId(20);
	String st = null;
	Scanner s = new Scanner(System.in);
	System.out.println("Enter return to leave field unedited");
	
	System.out.println("Please insert new Contact Surname: ");
	st= s.nextLine().trim();
	if (!st.equals("")) {contatto.setCognome(st);}
	System.out.println("Please insert new Contact Name: ");
	st= s.nextLine().trim();
	if (!st.equals("")) {contatto.setNome(st);}
	System.out.println("Please insert new Contact Email: ");
	st= s.nextLine().trim();
	if (!st.equals("")) {contatto.setEmail(st);}
	System.out.println("Please insert new Contact Phone: ");
	st= s.nextLine().trim();
	if (!st.equals("")) {contatto.setTelefono(st);}
	System.out.println("Please insert new Contact Notes: ");
	st= s.nextLine().trim();
	if (!st.equals("")) {contatto.setNote(st);}
	s.close();

	session.save(contatto);
	System.out.println("Contact correctly updated:");
	System.out.println(contatto);
	}
	
}
