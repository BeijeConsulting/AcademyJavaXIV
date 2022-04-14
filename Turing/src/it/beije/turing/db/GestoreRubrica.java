package it.beije.turing.db;

import java.io.IOException;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import it.beije.turing.file.CSVmanager;
import it.beije.turing.file.XMLmanager;
//import it.beije.turing.file.CSVmanager;
//import it.beije.turing.file.XMLmanager;
import it.beije.turing.rubrica.Contatto;

public class GestoreRubrica {
	
	public static void stampaMenu() {
		System.out.print("\n\n<<<Menu Rubrica>>>\n");
		System.out.println("1- Stampa contatti (print)");
		System.out.println("2- Cerca contatto (find)");
		System.out.println("3- Inserisci nuovo contatto (insert)");
		System.out.println("4- Modifica contatto (modify)");
		System.out.println("5- Cancella contatto (delete)");
		System.out.println("6- Trova contatti duplicati (findDup)");
		System.out.println("7- Unisci contatti duplicati (mergeDup)");
		System.out.println("8- Esci dal gestore della rubrica (exit)");
		System.out.println("9- Export Database (export)");
		System.out.println("10- Import to Database (import)");
		System.out.print("Scrivi la parola tra parentesi per la funzione che vuoi avviare sulla rubrica inserita: ");
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

	public static void stampaRubrica(List<Contatto> contatti, Scanner s) {
		//Scanner s = new Scanner(System.in);
		List<Contatto> contattiSupport = null;
		int i = 0;
		int x = 0;
		
		do {
			System.out.print("\nVuoi ordinarli per nome o per cognome? (no, nome, cognome) :");
			String str = s.next();
			if(str.equalsIgnoreCase("no")) {	
				x++;
			} else if(str.equalsIgnoreCase("nome")) {
				String[] array = new String[contatti.size()];
				int j = 0;
				
				for(Contatto contatto : contatti) {
					array[j] = contatto.getNome();
					j++;
				}
				Arrays.sort(array);
				contattiSupport = new ArrayList<Contatto>();
				for(String nome : array) {
					for(Contatto contatto : contatti) {
						if(nome.equals(contatto.getNome())) contattiSupport.add(contatto);
					}
				}
				contatti = contattiSupport;
				System.out.println("Rubrica ordinata per nome ->");
				x++;
			} else if(str.equalsIgnoreCase("cognome")) {
				String[] array = new String[contatti.size()];
				int j = 0;
				
				for(Contatto contatto : contatti) {
					array[j] = contatto.getCognome();
					j++;
				}
				Arrays.sort(array);
				contattiSupport = new ArrayList<Contatto>();
				for(String cognome : array) {
					for(Contatto contatto : contatti) {
						if(cognome.equals(contatto.getNome())) contattiSupport.add(contatto);
					}
				}
				contatti = contattiSupport;
				System.out.println("Rubrica ordinata per cognome ->");
				x++;
			} else {
				System.out.println("Inserisci un input valido. ");
			}
		} while(x == 0);
		
		for(Contatto c : contatti) {
			System.out.println(i +" - "+ c);
			i++;
		}
	}
	
	public static void trovaContatto(List<Contatto> contatti, Scanner s) {
		String nome = "";
		String cognome = "";
		List<Contatto> contattiTrovati = new ArrayList<Contatto>();
		
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
			for(Contatto c : contattiTrovati) {
				System.out.print(c);
			}
		} else if(contattiTrovati.size() > 1){
			System.out.print("Contatti trovati -> ");
			for(Contatto c : contattiTrovati) {
				System.out.println(c);
			}
		} else {
			System.out.print("Nessun " + nome +" "+ cognome +" e' stato trovato in rubrica.");
		}
	}
	
	public static Scanner inserisciContatto(List<Contatto> contatti, Scanner s) {
		Contatto contatto = new Contatto();
		s = new Scanner(System.in);
		
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
		
		contatti.add(contatto);
		
//		if(typeFile.equalsIgnoreCase("csv")) {
//			CSVmanager.writeRubricaCSV(contatti, path, typeFile);
//		} else {
//			XMLmanager.writeRubricaXML(contatti, path);
//		}
		
		System.out.println("Contatto inserito -> " + contatto);
		return s;
	}
	
	public static void modificaContatto(List<Contatto> contatti) {
		System.out.println("Modifica Contatto");
	}
	
	public static void eliminaContatto(List<Contatto> contatti) {
		System.out.println("Elimina Contatto");
	}
	
	public static void trovaContattiDuplicati(List<Contatto> contatti) {
		System.out.println("Trova contatti duplicati");
	}
	
	public static void unisciContattiDuplicati(List<Contatto> contatti) {
		System.out.println("Unisci contatti duplicati");
	}
	
	public static void exportDatabase(List<Contatto> contatti, Scanner s) {
		String str = null;
		String typeFile = sceltaFile(s);
		
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
					JDBCmanager.importFromCSV(str, separator, virgolette);
					j++;
					System.out.println("<<Import avvenuto con successo>>");
				} catch (IOException ioEx) {
					System.out.println("Inserisci un path valido.");
				}
			} else if(typeFile.equals("xml")) {
				try {
					JDBCmanager.importFromXML(str);
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
	
	public static void gestoreRubrica() {
		Scanner s = new Scanner(System.in);
		List<Contatto> contatti = null;
		
		/*String typeFile = "";
		int x = 0;
		do {
			System.out.print("Vuoi leggere un file csv o un file xml? ");
			typeFile = s.next();
			
			if(typeFile.equalsIgnoreCase("csv")) {
				x++;
			} else if(typeFile.equalsIgnoreCase("xml")) {
				x++;
			} else {
				System.out.print("Inserisci un tipo di file valido -> ");
			}
		} while(x == 0);
		
		String path = "";
		String separatore = "";
		boolean virgolette = false;
		int i = 0;
		do {
			System.out.print("Inserisci il path del file che vuoi leggere: ");
			path = s.next();
			if(typeFile.equalsIgnoreCase("csv")) {
				System.out.print("Inserisci il separatore utilizzato: ");
				separatore = s.next();
				System.out.print("Nel file sono state utilizzate le virgolette per scrivere i singoli campi? (input: Si/No) ");
				String v = s.next();
				if(v.equalsIgnoreCase("si")) {
					virgolette = true;
				}
			}
			
			if(typeFile.equalsIgnoreCase("csv")) {
				try {
					contatti = CSVmanager.loadRubricaFromCSV(path, separatore, virgolette);
					i++;
				} catch(IOException ioEx) {
					System.out.print("Inserisci dati validi -> ");
				}
			} else if(typeFile.equalsIgnoreCase("xml")) {
				try {
					contatti = XMLmanager.loadRubricaFromXML(path);
					i++;
				} catch(Exception Ex) {
					Ex.printStackTrace();
					System.out.print("Inserisci un path valido -> ");
				}
			}
		} while(i == 0);*/
		
		GestoreRubrica.stampaMenu();
		//System.out.println(contatti);
		
		String st = s.next();
		while (!st.equalsIgnoreCase("exit")) {
			st = st.toLowerCase();
			contatti = JDBCmanager.getRubrica();
			switch(st) {
				case "print":
					stampaRubrica(contatti, s);
					break;
				case "find":
					trovaContatto(contatti, s);
					break;
				case "insert":
					s = inserisciContatto(contatti, s);
					break;
				case "modify":
					modificaContatto(contatti);
					break;
				case "delete":
					eliminaContatto(contatti);
					break;
				case "finddup":
					trovaContattiDuplicati(contatti);
					break;
				case "mergedup":
					unisciContattiDuplicati(contatti);
					break;
				case "export":
					exportDatabase(contatti, s);
					break;
				case "import":
					importDatabase(s);
					break;
				default:
					System.out.println("\n<<Scrivi un input valido per il gestore.>>");
			}
			GestoreRubrica.stampaMenu();
			st = s.next();
			if(st.equalsIgnoreCase("exit")) {				
				System.out.println("\n\n<<Gestore rubrica chiuso.>>");
			}
		}
		s.close();
	}

	public static void main(String[] args) {
		
		gestoreRubrica();

	}

}
