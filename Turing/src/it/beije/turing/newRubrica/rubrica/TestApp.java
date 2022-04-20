package it.beije.turing.newRubrica.rubrica;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.newRubrica.file.DBManager;
import it.beije.turing.newRubrica.file.RubricaManager;
import it.beije.turing.newRubrica.rubrica.Contatto;
import it.beije.turing.newRubrica.rubrica.RubricaCSV;

public class TestApp {
	public Path p;
	public static void main (String[] args)  {
		
		
		RubricaManager rm = new RubricaManager();
		DBManager db = new DBManager(rm);
		
		Scanner s = new Scanner(System.in);
		String st = "";
		String tmp = "";
		System.out.println("Inserire nome ed estensione file:");
		tmp = s.nextLine();
		while(!new File(Paths.get("File",tmp).toAbsolutePath().toString()).exists()) {
			System.out.println("Il File non esiste.");
			System.out.println("Inserire nome ed estensione file:");
			tmp = s.nextLine();
		}
		String estensione = tmp.substring(tmp.length()-3);
		Rubrica r;
		if(estensione.equals("csv")) {
			r = new RubricaCSV(Paths.get("File",tmp));
		}else {
			r = new RubricaXML(Paths.get("File",tmp));
		}
		 
		//System.out.println(r.getPath().toAbsolutePath().toString());
		while (!st.equalsIgnoreCase("esci") && !st.equals("15")) {
			System.out.println("Selezionare programma da eseguire:\n"
					+ "1: Mostra tutta la rubrica e ordina per nome o cognome\n"
					+ "2: Cerca un contatto\n"
					+ "3: Aggiungi un contatto\n"
					+ "4: Modifica contatto\n"
					+ "5: Elimina contatto\n"
					+ "6: Trova contatti duplicati\n"
					+ "7: Unisci contatti duplicati\n"
					+ "8: Cambia File Rubrica\n"
					+ "9: Leggi da DB e salva su file\n"
					+ "10: Scrivi su DB\n"
					+ "11: Stampa contenuto su DB tramite Hibernate\n"
					+ "12: Inserisci nuovo contatto tramite Hibernate\n"
					+ "13: Aggiorna valore contatto tramite Hibernate\n"
					+ "14: Elimina Contatto tramite Hibernate\n"
					+ "15: Esci");
			st = s.nextLine();
			switch(st) {
				case "1":
					String type = "";
					while(type.isBlank()) {
						System.out.println("selezionare metodo di visualizzazione (nome,cognome):");
						type = s.nextLine();
					}
					r.setAllContact(r.sort(type));
					r.vediListaContatti();
					break;
				case "2":
					r.cercaContatto(s);
					break;
				case "3":
					Contatto c = r.inserisciNuovoContatto(s);
					if(c == null)continue;
					List<Contatto> ris = r.getAllContact();
					ris.add(c);
					r.setAllContact(ris);
					if(estensione.equals("csv")) {
						rm.writeRubricaCSV(r.getAllContact(), r.getPath().toAbsolutePath().toString(), ";");
					}
					else {
						rm.writeRubricaXML(r.getAllContact(), r.getPath().toAbsolutePath().toString());
					}
					break;
				case "4":
					r.modificaContatto(s);
					break;
				case "5":
					r.cancellaContatto(s);
					break;
				case "6":
					r.trovaContattiDuplicati();
					break;
				case "7":
					r.unisciContattiDuplicati();
					break;
				case "8":
					r.caricaFileContatti(s);
					break;
				case "9":
					r.setAllContact(db.leggiDaDB(s));
					if(estensione.equals("csv")) {
						rm.writeRubricaCSV(r.getAllContact(), r.getPath().toAbsolutePath().toString(), ";");
					}
					else {
						rm.writeRubricaXML(r.getAllContact(), r.getPath().toAbsolutePath().toString());
					}
					break;
				case "10":
					db.scriviSuDB(r.getAllContact(),s);
					break;
				case "11":
					List<Contatto> allContact = rm.loadRubricaFromHibernate();
					for(Contatto co: allContact) {
						System.out.println(co);
					}
					r.setAllContact(allContact);
					break;
				case "12":
					rm.insertRubricaOnHibernate();
					r.setAllContact(rm.loadRubricaFromHibernate());
					break;
				case "13":
					List<Contatto> allContact2 = rm.loadRubricaFromHibernate();
					for(Contatto co: allContact2) {
						System.out.println(co);
					}
					System.out.println("Inserire id Contatto da modificare su DB(inserire un numero da 1 a "+allContact2.size()+"): ");
					String k = s.nextLine();
					int num = Integer.parseInt(k);
					rm.updateRubricaOnHibernate(num);
					r.setAllContact(rm.loadRubricaFromHibernate());
					break;
				case "14":
					List<Contatto> allContact3 = rm.loadRubricaFromHibernate();
					for(Contatto co: allContact3) {
						System.out.println(co);
					}
					System.out.println("Inserire id Contatto da modificare su DB(inserire un numero da 1 a "+allContact3.size()+"): ");
					String k2 = s.nextLine();
					int num2 = Integer.parseInt(k2);
					rm.deleteRubricaOnHibernate(num2);
					r.setAllContact(rm.loadRubricaFromHibernate());
					break;
				case "15":
					continue;
				default:
					break;
			}
			
		}
		
		System.out.println("BYE!!");
		s.close();
	}

}