package it.beije.turing.gestorerubrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import it.beije.turing.db.JPAcriteriaManager;
import it.beije.turing.db.JPAmanager;
import it.beije.turing.file.CSVmanager;
import it.beije.turing.file.XMLmanager;
import it.beije.turing.rubrica.Contatto;

public class GestoreFunction {
	
	public static void stampa(List<Contatto> contatti) {
		System.out.println();
		for(Contatto c : contatti) {
			System.out.println(c);
		}
	}

	public static String sceltaFile(Scanner s) {
		String str = null;
		
		int x = 0;
		do {
			System.out.print("\nVuoi effettuare l'export su un file csv o xml? ");
			str = s.next();
			
			if(str.equalsIgnoreCase("csv")) {
				str = "csv";
				x++;
			} else if(str.equalsIgnoreCase("xml")) {
				str = "xml";
				x++;
			} else {
				System.out.print("Inserisci un tipo di file corretto.");
			}
		} while(x == 0);
		
		return str;
	}
	
	public static Contatto inserisciDati(Scanner s) {
		Contatto contatto = new Contatto();
		
		System.out.print("\nInserisci il nome : ");
		contatto.setNome(s.nextLine());
		System.out.print("Inserisci il cognome : ");
		contatto.setCognome(s.nextLine()); 
		System.out.print("Inserisci il numero di telefono : ");
		contatto.setTelefono(s.nextLine()); 
		System.out.print("Inserisci l' email : ");
		contatto.setEmail(s.nextLine()); 
		System.out.print("Inserisci il note : ");
		contatto.setNote(s.nextLine()); 
		
		return contatto;
	}
	
	public static void stampaRubrica(Scanner s) {
		List<Contatto> contatti = null;
		int x = 0;
		
		do {
			System.out.print("\nVuoi ordinarli per nome o per cognome? (no, nome, cognome) : ");
			String str = s.next();
			if(str.equalsIgnoreCase("no")) {	
				contatti = JPAcriteriaManager.getRubrica();
				x++;
			} else if(str.equalsIgnoreCase("nome")) {
				contatti = JPAcriteriaManager.getOrderedByNameRubrica();
				System.out.println("Rubrica ordinata per nome ->");
				x++;
			} else if(str.equalsIgnoreCase("cognome")) {
				contatti = JPAcriteriaManager.getOrderedByCognomeRubrica();
				System.out.println("Rubrica ordinata per cognome ->");
				x++;
			} else {
				System.out.println("Inserisci un input valido. ");
			}
		} while(x == 0);
		
		stampa(contatti);
	}
	
	public static void trovaContatto(Scanner s) {
		String nome = "";
		String cognome = "";
		List<Contatto> contattiTrovati = new ArrayList<Contatto>();
		List<Contatto> contatti = JPAcriteriaManager.getRubrica(); 
		
		System.out.print("\nInserisci nome del contatto che vuoi cercare: ");
		nome = s.next();
		System.out.print("Inserisci cognome del contatto che vuoi cercare: ");
		cognome = s.next();
		
		for(Contatto contatto : contatti) {
			if(nome.equals(contatto.getNome()) && cognome.equals(contatto.getCognome())) {
				contattiTrovati.add(contatto);
			}
		}
		
		if(contattiTrovati.size() == 1) {
			System.out.print("Contatto trovato -> ");
			stampa(contattiTrovati);
		} else if(contattiTrovati.size() > 1){
			System.out.print("Contatti trovati -> ");
			stampa(contattiTrovati);
		} else {
			System.out.print("Nessun " + nome +" "+ cognome +" e' stato trovato in rubrica.");
		}
	}
	
	public static void inserisciContatto(Scanner s) {
		s = new Scanner(System.in);
		
		Contatto newContatto = inserisciDati(s);
		
		JPAmanager.insertToRubrica(newContatto);
	}

	public static void modificaContatto(Scanner s) {
		String str = "";
		List<Contatto> contatti = JPAcriteriaManager.getRubrica();
		
		stampa(contatti);
		
		System.out.print("\nInserisci l'id del contatto che vuoi modificare: ");
		str = s.next();
		
		s = new Scanner(System.in);
		Contatto contatto = inserisciDati(s);
		
		JPAmanager.updateContattoRubrica(contatto, Integer.parseInt(str));;
	}

	public static void eliminaContatto(Scanner s) {
		List<Contatto> contatti = JPAcriteriaManager.getRubrica();
		
		stampa(contatti);
		
		
		System.out.print("\nInserisci l'id del contatto che vuoi eliminare: ");
		String str = s.next();
		
		int x = 0;
		do {
			System.out.print("\nSei sicuro di voler eliminare il contatto? (Si/No): ");
			String confirm = s.next().toLowerCase();
			
			if(confirm.equals("si")) {
				JPAmanager.deleteContattoRubrica(Integer.parseInt(str));
				x++;
			} else if(confirm.equals("no")) {
				x++;
			}
		} while(x == 0);
	}

	public static boolean areEqual(Contatto c, Contatto c1) {
		return c.getNome().equals(c1.getNome()) && c.getCognome().equals(c1.getCognome()) && c.getTelefono().equals(c1.getTelefono()) && c.getEmail().equals(c1.getEmail()) && c.getNote().equals(c1.getNote());
	}
	
	public static List<Contatto> trovaContattiDuplicati() {
		Contatto contattoDup = null;
		List<Contatto> contatti = JPAcriteriaManager.getRubrica();
		List<Contatto> contattiDup = new ArrayList<Contatto>();
		
		for(Contatto c : contatti) {
			for(Contatto c1 : contatti) {
				if(c.getId() != c1.getId()) {
					if(areEqual(c, c1)) {
						contattoDup = c1;
						if(contattiDup.size() == 0) {
							contattiDup.add(contattoDup);
						} else if(areEqual(contattoDup, contattiDup.get(0))) {
							contattiDup.add(contattoDup);
						}
					}
				}
			}
		}
		
		if(contattiDup.size() > 0) {
			System.out.println("Contatti duplicati: ");
			stampa(contattiDup);
		} else {
			System.out.println("Nessun contatto e' stato duplicato.");
		}
		
		return contattiDup;
	}
	
	public static void unisciContattiDuplicati(Scanner s) {
		List<Contatto> contattiDup = trovaContattiDuplicati();
		
		if(contattiDup.size() > 0) {
			int x = 0;
			do {
				System.out.print("\nVuoi unire i contatti duplicati? (Si/No): ");
				String confirm = s.next().toLowerCase();
				
				if(confirm.equals("si")) {
					while(contattiDup.size() > 1) {
						JPAmanager.deleteContattoRubrica(contattiDup.get(0).getId());
						contattiDup.remove(0);
					}
					x++;
				} else if(confirm.equals("no")) {
					x++;
				}
			} while(x == 0);
		} else {
			System.out.println("Nessun contatto e' stato duplicato.");
		}
	}
	
	public static void exportDatabase(Scanner s) {
		String str = null;
		String typeFile = sceltaFile(s);
		List<Contatto> contatti = JPAcriteriaManager.getRubrica();
		
		int j = 0;
		do {
			System.out.print("\nInserisci il path del file dove vuoi esportare il database: ");
			str = s.next();
			if(typeFile.equals("csv")) {
				String separator = null;
				System.out.print("\nInserisci il separatore: ");
				separator = s.next();
				try {
					CSVmanager.writeRubricaCSV(contatti, str, separator);
					j++;
					System.out.println("<<Export avvenuto con successo>>");
				} catch (IOException ioEx) {
					System.out.println("Inserisci un path valido.");
				}
			} else if(typeFile.equals("xml")) {
				try {
					XMLmanager.writeRubricaXML(contatti, str);
					j++;
					System.out.println("<<Export avvenuto con successo>>");
				} catch(TransformerConfigurationException tcEx) {
					System.out.println("Inserisci un path valido.");
				} catch(ParserConfigurationException pcEx) {
					System.out.println("Inserisci un path valido.");
				} catch(TransformerException tEx) {
					System.out.println("Inserisci un path valido.");
				}
			}
		} while(j == 0);
		
	}
	
	public static void importDatabase(Scanner s) {
		String typeFile = sceltaFile(s);
		String str = null;
		
		int j = 0;
		do {
			System.out.print("\nInserisci il path del file da dove vuoi importare i dati per il database: ");
			str = s.next();
			if(typeFile.equals("csv")) {
				System.out.print("\nInserisci il separatore: ");
				String separator = s.next();
				int y = 0;
				boolean virgolette = false;
				do {
					System.out.print("\nIl file usa le virgolette? (Si/No) ");
					String r = s.next();
					if(r.equalsIgnoreCase("si")) {
						virgolette = true;
						y++;
					} else if(r.equalsIgnoreCase("no")) {
						y++;
					} else {
						System.out.print("Inserisci un input valido.");
					}
				} while(y == 0);
				try {
					JPAmanager.importFromCSV(str, separator, virgolette);
					j++;
					System.out.println("<<Import avvenuto con successo>>");
				} catch (IOException ioEx) {
					System.out.println("Inserisci un path valido.");
				}
			} else if(typeFile.equals("xml")) {
				try {
					JPAmanager.importFromXML(str);
					j++;
					System.out.println("<<Import avvenuto con successo>>");
				} catch(IOException ioEx) {
					System.out.println("Inserisci un path valido.");
				} catch(ParserConfigurationException pcEx) {
					System.out.println("Inserisci un path valido.");
				} catch(SAXException saxEx) {
					System.out.println("Inserisci un path valido.");
				}
			}
		} while(j == 0);
	}
}
