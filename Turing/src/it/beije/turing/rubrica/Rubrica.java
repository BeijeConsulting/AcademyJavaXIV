package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rubrica
{
	List<Contatto> contatti = new ArrayList<>();
	
	public static void main(String[] args)
	{
		Rubrica rubrica = new Rubrica();
		while(true)
		{
			System.out.print("	  Mattia Pagani\n\n\n");
			
			rubrica.avviaMenu();
		}
		
		
		//TESTING STATION
		//Scanner kb = new Scanner(System.in);
		//int scelta = kb.nextInt();
		//rubrica.testingStationCSV(scelta);		//1 read CSV, 2 write CSV
		//rubrica.testingStationXML(scelta);		//1 read CSV, 2 write CSV
	}

	
	private void avviaMenu()
	{
		Scanner kb = null;
		boolean riprova = false;
		
		do
		{
			menuAvvio();
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			switch(scelta)
			{
				case 1:					//JDBC
					avviaMenu(scelta);
					break;
					
				case 2:					//HIBERNATE
					avviaMenu(scelta);
					break;
					
				case 3:					//JPA
					avviaMenu(scelta);
					break;
					
				case 4:					//LOCALE
					avviaMenu(scelta);
					break;
					
				case 5:
					System.exit(0);
					break;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenu(int s) // 1 db jdbc,  2 db hibernate, 3 JPA, 4 locale
	{
		Scanner kb = null;
		boolean riprova = false;
		
		do
		{
			menuIniziale(s);
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			switch(scelta)
			{
				case 1:
					avviaMenuRubrica(s);
					break;
					
				case 2:
					avviaMenuContatti(s);
					break;
					
				case 3:
					return;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenuRubrica(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		
		do
		{
			menuRubrica();
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			switch(scelta)
			{
				case 1:
					avviaMenuImportazione(s);
					break;
					
				case 2:
					avviaMenuEsportazione(s);
					break;
					
				case 3:
					return;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenuImportazione(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		
		do
		{
			menuImportazione(s);
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			String pathFile = null;
			switch(scelta)
			{
				case 1:
					if (s == 1)
					{
						JDBChandler jdbcHandler = new JDBChandler();
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						
						
						jdbcHandler.loadRubricaToDB(csvHandler.loadRubricaFromCSV(pathFile, separator));
					}
					else if (s == 2)
					{
						HBhandler hbHandler = new HBhandler();
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						
						
						hbHandler.loadRubricaToDB(csvHandler.loadRubricaFromCSV(pathFile, separator));
					}
					else if (s == 3)
					{
						JPAhandler jpaHandler = new JPAhandler();
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						
						
						jpaHandler.loadRubricaToDB(csvHandler.loadRubricaFromCSV(pathFile, separator));
					}
					else if (s == 4)
					{
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						
						contatti = csvHandler.loadRubricaFromCSV(pathFile, separator);
					}
					break;
					
				case 2:
					if (s == 1)
					{
						JDBChandler jdbcHandler = new JDBChandler();
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						jdbcHandler.loadRubricaToDB(xmlHandler.loadRubricaFromXML(pathFile));
					}
					else if (s == 2)
					{
						HBhandler hbHandler = new HBhandler();
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						hbHandler.loadRubricaToDB(xmlHandler.loadRubricaFromXML(pathFile));
					}
					else if (s == 3)
					{
						JPAhandler jpaHandler = new JPAhandler();
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						jpaHandler.loadRubricaToDB(xmlHandler.loadRubricaFromXML(pathFile));
					}
					else if (s == 4)
					{
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						contatti = xmlHandler.loadRubricaFromXML(pathFile);
					}
					break;
					
				case 3:
					return;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenuEsportazione(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		
		do
		{
			menuEsportazione(s);
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			String pathFile = null;
			
			switch(scelta)
			{
				case 1:
					if (s == 1)
					{
						JDBChandler jdbcHandler = new JDBChandler();
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						csvHandler.writeRubricaCSV(jdbcHandler.getRubrica(""), pathFile, separator);
					}
					else if (s == 2)
					{
						HBhandler hbHandler = new HBhandler();
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						csvHandler.writeRubricaCSV(hbHandler.getRubrica(""), pathFile, separator);
					}
					else if (s == 3)
					{
						JPAhandler jpaHandler = new JPAhandler();
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						csvHandler.writeRubricaCSV(jpaHandler.getRubrica(""), pathFile, separator);
					}
					else if (s == 4)
					{
						CSVhandler csvHandler = new CSVhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						System.out.print("Inserisci il carattere separatore: ");
						String separator = kb.next();
						csvHandler.writeRubricaCSV(contatti, pathFile, separator);
					}					
					break;
					
				case 2:
					if (s == 1)
					{
						JDBChandler jdbcHandler = new JDBChandler();
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						xmlHandler.writeRubricaXML(jdbcHandler.getRubrica(""), pathFile);
					}
					else if (s == 2)
					{
						HBhandler hbHandler = new HBhandler();
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						xmlHandler.writeRubricaXML(hbHandler.getRubrica(""), pathFile);
					}
					else if (s == 3)
					{
						JPAhandler jpaHandler = new JPAhandler();
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						xmlHandler.writeRubricaXML(jpaHandler.getRubrica(""), pathFile);
					}
					else if (s == 4)
					{
						XMLhandler xmlHandler = new XMLhandler();
						System.out.print("Inserisci il path: ");
						pathFile = kb.next();
						xmlHandler.writeRubricaXML(contatti, pathFile);
					}
					break;
					
				case 3:
					return;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenuContatti(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		JDBChandler jdbcHandler = new JDBChandler();
		HBhandler hbHandler = new HBhandler();
		JPAhandler jpaHandler = new JPAhandler();
		do
		{
			if (s == 4 && contatti.size() == 0) System.out.println("Rubrica non caricata. Solo creazione nuovi contatti disponibile.");
			
			menuContatti();
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			if (s == 4 && contatti.size() == 0 && scelta != 3 && scelta != 8) scelta = -1;
			
			switch(scelta)
			{
				case 1:			//VISUALIZZA CONTATTI
					System.out.print("Vuoi riordinare la rubrica? ");
					String riordina = kb.next().toLowerCase();
					String filtro = null;
					switch(riordina)
					{
						case "si":
						case "sì":
						case "yes":
						case "y":
							System.out.print("Criterio di ordinamento (nome, cognome, email, telefono, note): ");
							filtro = kb.next().toLowerCase();
							System.out.println();
							break;
							
						default:
							filtro = "";
							break;
					}
					
					
					if (s == 1)
					{
						for(Contatto c : jdbcHandler.getRubrica(filtro))
						{
							System.out.println(c);
						}						
					}
					else if (s == 2)
					{
						for(Contatto c : hbHandler.getRubrica(filtro))
						{
							System.out.println(c);
						}	
					}
					else if (s == 3)
					{
						for(Contatto c : jpaHandler.getRubrica(filtro))
						{
							System.out.println(c);
						}	
					}
					else if (s == 4)
					{
						visualizzaContatti(filtro);
					}
					break;
					
				case 2:				//CERCA CONTATTO
					System.out.print("Valore di ricerca: ");
					String filtroRicerca = kb.next();
					System.out.println();
					List<Contatto> contacts = new ArrayList<>();
					
					if (s == 1)						//JDBC
					{
						contacts = jdbcHandler.findContatto(filtroRicerca);
					}
					else if (s == 2)				//HIBERNATE
					{
						contacts = hbHandler.findContatto(filtroRicerca);
					}
					else if (s == 3)				//JPA
					{
						contacts = jpaHandler.findContatto(filtroRicerca);
					}
					else if (s == 4)				//LOCALE
					{
						contacts = cercaContatto(filtroRicerca);						
					}
					
					if (contacts.isEmpty()) System.out.println("Nessuno contatto corrisponde ai criteri di ricerca.");
					else
					{
						for(Contatto contatto : contacts)
						{
							System.out.println(contatto.toString());
						}
					}
					break;
					
				case 3:			//CREA CONTATTO
					
					kb.nextLine();
					
					System.out.print("Nome: ");
					String nome = kb.nextLine();
					System.out.println();
					
					System.out.print("Cognome: ");
					String cognome = kb.nextLine();
					System.out.println();
					
					System.out.print("Email: ");
					String email = kb.nextLine();
					System.out.println();
					
					System.out.print("Telefono: ");
					String telefono = kb.nextLine();
					System.out.println();
					
					System.out.print("Note: ");
					String note = kb.nextLine();
					System.out.println();
					
					if (s == 1)					//JDBC
					{
						System.out.println(jdbcHandler.addContatto(new Contatto(nome, cognome, email, telefono, note)) ? "Contatto creato." : "Errore creazione contatto.");
					}
					else if (s == 2)			//HIBERNATE
					{
						System.out.println(hbHandler.addContatto(new Contatto(nome, cognome, email, telefono, note)) ? "Contatto creato." : "Errore creazione contatto.");
					}
					else if (s == 3)			//JPA
					{
						System.out.println(jpaHandler.addContatto(new Contatto(nome, cognome, email, telefono, note)) ? "Contatto creato." : "Errore creazione contatto.");
					}
					else if (s == 4)			//LOCALE
					{
						System.out.println(contatti.add(new Contatto(nome, cognome, email, telefono, note)) ? "Contatto creato." : "Errore creazione contatto.");
					}
					break;
					
				case 4:			//MODIFICA CONTATTO
					System.out.println("Posizione in rubrica del contatto da modificare: ");
					int pos = kb.nextInt();
					
					if (s == 1)					//JDBC
					{
						kb.nextLine();
						
						System.out.print("Nome: ");
						String n = kb.nextLine();
						System.out.println();
						
						System.out.print("Cognome: ");
						String c = kb.nextLine();
						System.out.println();
						
						System.out.print("Email: ");
						String e = kb.nextLine();
						System.out.println();
						
						System.out.print("Telefono: ");
						String t = kb.nextLine();
						System.out.println();
						
						System.out.print("Note: ");
						String no = kb.nextLine();
						System.out.println();
						
						Contatto cont = new Contatto(n, c, e, t, no);
						jdbcHandler.modifyContatto(pos, cont);
					}
					else if (s == 2)			//HIBERNATE
					{
						kb.nextLine();
						
						System.out.print("Nome: ");
						String n = kb.nextLine();
						System.out.println();
						
						System.out.print("Cognome: ");
						String c = kb.nextLine();
						System.out.println();
						
						System.out.print("Email: ");
						String e = kb.nextLine();
						System.out.println();
						
						System.out.print("Telefono: ");
						String t = kb.nextLine();
						System.out.println();
						
						System.out.print("Note: ");
						String no = kb.nextLine();
						System.out.println();
						
						Contatto cont = new Contatto(n, c, e, t, no);
						hbHandler.modifyContatto(pos, cont);
					}
					else if (s == 3)			//JPA
					{
						kb.nextLine();
						
						System.out.print("Nome: ");
						String n = kb.nextLine();
						System.out.println();
						
						System.out.print("Cognome: ");
						String c = kb.nextLine();
						System.out.println();
						
						System.out.print("Email: ");
						String e = kb.nextLine();
						System.out.println();
						
						System.out.print("Telefono: ");
						String t = kb.nextLine();
						System.out.println();
						
						System.out.print("Note: ");
						String no = kb.nextLine();
						System.out.println();
						
						Contatto cont = new Contatto(n, c, e, t, no);
						jpaHandler.modifyContatto(pos, cont);
					}
					else if (s == 4)			//LOCALE
					{
						modificaContatto(pos);
					}
					break;
					
				case 5:			//CANCELLA CONTATTO
					System.out.println("Posizione in rubrica del contatto da eliminare: ");
					int posizione = kb.nextInt();
					
					if (s == 1)					//JDBC
					{
						jdbcHandler.deleteContatto(posizione);
					}
					else if (s == 2)			//HIBERNATE
					{
						hbHandler.deleteContatto(posizione);
					}
					else if (s == 3)			//JPA
					{
						jpaHandler.deleteContatto(posizione);
					}
					else if (s == 4)			//LOCALE
					{
						cancellaContatto(posizione);
					}
					break;
					
				case 6:			//TROVA DUPLICATI
					List<Contatto> duplicati = new ArrayList<>();
					if (s == 1)									//JDBC
					{
						duplicati = jdbcHandler.findDuplicates();
						for(Contatto c : duplicati)
						{
							System.out.println(c + ", found");
						}
					}
					else if (s == 2)							//HIBERNATE
					{
						duplicati = hbHandler.findDuplicates();
						for(Contatto c : duplicati)
						{
							System.out.println(c + ", found");
						}
					}
					else if (s == 3)							//JPA
					{
						duplicati = jpaHandler.findDuplicates();
						for(Contatto c : duplicati)
						{
							System.out.println(c + ", found");
						}
					}
					else if (s == 4)							//LOCALE
					{
						duplicati = cercaDuplicati(false);
						
						String[] indici = duplicati.get(0).getNome().split(",");
						int counter = indici.length-1;
						boolean first = true;
						
						if (duplicati.isEmpty()) System.out.println("Nessuno contatto duplicato trovato.");
						else
						{
							for(Contatto contatto : duplicati)
							{
								if (first)
								{
									first = false;
									continue;
								}
								
								System.out.println(indici[counter--] + " " + contatto.toString());
							}
						}
					}
					break;
					
				case 7:			//UNISCI DUPLICATI
					List<Contatto> duplicatiUniti = new ArrayList<>();
					
					if (s == 1)							//JDBC
					{
						jdbcHandler.uniteDuplicates();
						
						for(Contatto c : jdbcHandler.getRubrica(""))
						{
							System.out.println(c);
						}
						
					}
					else if (s == 2)					//HIBERNATE
					{
						hbHandler.uniteDuplicates();
						
						for(Contatto c : hbHandler.getRubrica(""))
						{
							System.out.println(c);
						}
					}
					else if (s == 3)					//JPA
					{
						jpaHandler.uniteDuplicates();
						
						for(Contatto c : jpaHandler.getRubrica(""))
						{
							System.out.println(c);
						}
					}
					else if (s == 4)					//LOCALE
					{
						duplicatiUniti = cercaDuplicati(true);
						contatti = duplicatiUniti;
						visualizzaContatti("");
					}
					break;
					
				case 8:
					return;
					
				default:
					riprova = true;
					System.out.println("Errore, scelta non possibile.");
					break;
			}
		} while (riprova);
	}
	
	private void visualizzaContatti(String filtro)
	{
		if (filtro != "") ordinaRubrica(filtro);
		
		int counter = 1;
		
		for(Contatto contatto : contatti)
		{
			System.out.println(counter++ + " " + contatto.toString());
		}
	}
	
	private void ordinaRubrica(String filtro)
	{
		switch(filtro)
		{
			case "nome":
				contatti.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
				break;
				
			case "cognome":
				contatti.sort((o1, o2) -> o1.getCognome().compareTo(o2.getCognome()));
				break;
				
			case "email":
				contatti.sort((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()));
				break;
				
			case "telefono":
				contatti.sort((o1, o2) -> o1.getTelefono().compareTo(o2.getTelefono()));
				break;
				
			case "note":
				contatti.sort((o1, o2) -> o1.getNote().compareTo(o2.getNote()));
				break;
				
			default:
				return;
		}		
	}
	
	private List<Contatto> cercaContatto(String filtro)
	{
		List<Contatto> cont = new ArrayList<>();
		
		for(Contatto contatto : contatti)
		{
			if (contatto.getNome().equals(filtro)) cont.add(contatto);
			else if (contatto.getCognome().equals(filtro)) cont.add(contatto);
			else if (contatto.getEmail().equals(filtro)) cont.add(contatto);
			else if (contatto.getTelefono().equals(filtro)) cont.add(contatto);
			else if (contatto.getNote().equals(filtro)) cont.add(contatto);
		}
		
		return cont;
	}
	
	private void modificaContatto(int posizione)
	{
		if (posizione >= contatti.size())
		{
			System.out.println("Contatto non presente in rubrica.");
			return;
		}
		
		Contatto contatto = contatti.get(posizione-1);
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Nome: ");
		contatto.setNome(kb.nextLine());
		System.out.println();
		System.out.print("Cognome: ");
		contatto.setCognome(kb.nextLine());
		System.out.println();
		System.out.print("Email: ");
		contatto.setEmail(kb.nextLine());
		System.out.println();
		System.out.print("Telefono: ");
		contatto.setTelefono(kb.nextLine());
		System.out.println();
		System.out.print("Note: ");
		contatto.setNote(kb.nextLine());
		System.out.println();
		
		contatti.set(posizione-1, contatto);
	}
	
	private void cancellaContatto(int posizione)
	{
		if (posizione >= contatti.size())
		{
			System.out.println("Contatto non presente in rubrica.");
			return;
		}
		
		contatti.remove(posizione-1);
	}
	
	private List<Contatto> cercaDuplicati(boolean unisci)
	{
		List<Contatto> contacts = new ArrayList<>();
		contacts.add(new Contatto("","","","",""));
		
		Contatto contatto = contacts.get(0);
		
		for(int i = 0; i < contatti.size(); i++)
		{
			for(int j = 0; j < contatti.size(); j++)
			{
				if (!unisci)											//TROVA DUPLICATI
				{
					if (i == j) continue;
					if (contatti.get(i).equals(contatti.get(j)))
					{
						contatto.setNome(i+1 + "," + contatto.getNome());
						contacts.add(contatti.get(i));
						break;					
					}
				}
				else													//UNISCI DUPLICATI
				{
					if (i != j && contatti.get(i).equals(contatti.get(j)))
					{
						contatti.remove(j);
						j--;
					}
				}
			}
			
			if (unisci) contacts.add(contatti.get(i));
		}
		
		if (unisci) contacts.remove(0);
		
		return contacts;
	}
	
	
	
	//OUTPUT A SCHERMO
	
	private void menuAvvio()
	{
		System.out.print("------------ RUBRICA ------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------ Menu Database JDBC -------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Menu Database HB --------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Menu Database JPA -------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("---------- Menu Locale ----------\n");
		System.out.print("--------------- 4 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Esci dal Programma ------\n");
		System.out.print("--------------- 5 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuIniziale(int s)
	{
		if (s == 1) System.out.print("--------- DATABASE JDBC ---------\n");
		else if (s == 2) System.out.print("------ DATABASE HIBERNATE -------\n");
		else if (s == 3) System.out.print("--------- DATABASE JPA ----------\n");
		else if (s == 4)
		{
			System.out.print("\n\n------------ LOCALE -------------\n");
			System.out.print("---------------------------------\n");
			System.out.println((contatti.size() != 0) ? ("------- Rubrica: " + "caricata" + " -------") : ("----- Rubrica: non caricata -----"));
		}
		
		System.out.print("---------------------------------\n");
		System.out.print("------- Gestione Rubrica --------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Gestione Contatti -------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Menu Principale --------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuRubrica()
	{
		System.out.print("------- GESTIONE RUBRICA --------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Importa Rubrica --------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Esporta Rubrica --------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Menu Principale --------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuImportazione(int s)
	{
		System.out.print("----- IMPORTAZIONE RUBRICA ------\n");
		System.out.print("---------------------------------\n");
		
		if (s == 1)
		{
			System.out.print("- Importa Rubrica su  DB da CSV -\n");
			System.out.print("--------------- 1 ---------------\n");
			System.out.print("---------------------------------\n");
			System.out.print("- Importa Rubrica su  DB da XML -\n");
			System.out.print("--------------- 2 ---------------\n");
		}
		else
		{
			System.out.print("------ Importa Rubrica CSV ------\n");
			System.out.print("--------------- 1 ---------------\n");
			System.out.print("---------------------------------\n");
			System.out.print("------ Importa Rubrica XML ------\n");
			System.out.print("--------------- 2 ---------------\n");
		}
		
		System.out.print("---------------------------------\n");
		System.out.print("-------- Menu Principale --------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuEsportazione(int s)
	{
		System.out.print("----- ESPORTAZIONE RUBRICA ------\n");
		System.out.print("---------------------------------\n");
		
		if (s == 1)
		{
			System.out.print("-- Esporta Rubrica da DB a CSV --\n");
			System.out.print("--------------- 1 ---------------\n");
			System.out.print("---------------------------------\n");
			System.out.print("-- Esporta Rubrica da DB a XML --\n");
			System.out.print("--------------- 2 ---------------\n");
		}
		else
		{
			System.out.print("------ Esporta Rubrica CSV ------\n");
			System.out.print("--------------- 1 ---------------\n");
			System.out.print("---------------------------------\n");
			System.out.print("------ Esporta Rubrica XML ------\n");
			System.out.print("--------------- 2 ---------------\n");
		}
		
		System.out.print("---------------------------------\n");
		System.out.print("-------- Menu Principale --------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuContatti()
	{
		System.out.print("------ GESTIONE CONTATTI --------\n");
		System.out.print("---------------------------------\n");
		System.out.print("--- Visualizza Lista Contatti ---\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Cerca Contatto ---------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("--------- Crea Contatto ---------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Modifica Contatto -------\n");
		System.out.print("--------------- 4 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Cancella Contatto -------\n");
		System.out.print("--------------- 5 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("--- Trova Contatti Duplicati ----\n");
		System.out.print("--------------- 6 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("--- Unisci Contatti Duplicati ---\n");
		System.out.print("--------------- 7 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Menu Principale --------\n");
		System.out.print("--------------- 8 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	
	
	//TESTING AREA
	private void testingStationCSV(int scelta)
	{
		CSVhandler csvHandler = new CSVhandler();
		List<Contatto> contatty = new ArrayList<>();
		contatty.add(new Contatto());
		contatty.add(new Contatto("nome1", "cognome1", "telefono1", "email1", "nota1"));
		contatty.add(new Contatto("", "cognome2", "telefono2", "email2", ""));
		contatty.add(new Contatto("", "", "", "", ""));
		
		switch(scelta)
		{
			case 1:
				contatty = csvHandler.loadRubricaFromCSV("/temp/rubrica.csv", ";");
				System.out.println(contatty.toString());
				break;
				
			case 2:
				csvHandler.writeRubricaCSV(contatty, "/temp/rubrica.csv", ";");
				System.out.println("WRITE DONE");
				break;
				
			default:
				break;
		}
	}
	
	private void testingStationXML(int scelta)
	{
		XMLhandler xmlHandler = new XMLhandler();
		List<Contatto> contatti = new ArrayList<>();
		contatti.add(new Contatto());
		contatti.add(new Contatto("nome1", "cognome1", "telefono1", "email1", "nota1"));
		contatti.add(new Contatto("", "cognome2", "telefono2", "email2", ""));
		contatti.add(new Contatto("", "", "", "", ""));
		
		switch(scelta)
		{
			case 1:
				contatti = xmlHandler.loadRubricaFromXML("/temp/rubrica.xml");
				System.out.println(contatti.toString());
				break;
				
			case 2:
				xmlHandler.writeRubricaXML(contatti, "/temp/rubrica.xml");
				System.out.println("WRITE DONE");
				break;
				
			default:
				break;
		}
	}
}