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
				case 1:
					avviaMenu(scelta);
					break;
					
				case 2:
					avviaMenu(scelta);
					break;
					
				case 3:
					System.exit(0);
					break;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenu(int s) // 1 database 2 locale
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
					else
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
					else
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
						csvHandler.writeRubricaCSV(jdbcHandler.writeRubricaFromDB(), pathFile, separator);
					}
					else
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
						xmlHandler.writeRubricaXML(jdbcHandler.writeRubricaFromDB(), pathFile);
					}
					else
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
		
		do
		{
			if (contatti.size() == 0) System.out.println("Rubrica non caricata. Solo creazione nuovi contatti disponibile.");
			
			menuContatti();
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			if (contatti.size() == 0 && scelta != 3 && scelta != 8) scelta = -1;
			
			
			switch(scelta)
			{
				case 1:			//VISUALIZZA CONTATTI
					if (s == 1)
					{
						
					}
					else
					{
						if (contatti.size() != 0)
						{
							System.out.print("Vuoi riordinare la rubrica? ");
							String riordina = kb.next().toLowerCase();
							String filtro = null;
							switch(riordina)
							{
								case "si":
								case "sì":
								case "yes":
								case "y":
									System.out.print("Criterio di ordinamento (nome, cognome, telefono, email, note): ");
									filtro = kb.next().toLowerCase();
									System.out.println();
									break;
									
								default:
									filtro = "";
									break;
							}
							
							visualizzaContatti(filtro);
						}
						else System.out.println("Rubrica vuota.");
					}
					break;
					
				case 2:				//CERCA CONTATTO
					if (s == 1)
					{
						
					}
					else
					{
						System.out.print("Valore di ricerca: ");
						String filtro = kb.next();
						System.out.println();
						List<Contatto> contacts = cercaContatto(filtro);
						
						if (contacts.isEmpty()) System.out.println("Nessuno contatto corrisponde ai criteri di ricerca.");
						else
						{
							for(Contatto contatto : contacts)
							{
								System.out.println(contatto.toString());
							}
						}
					}
					break;
					
				case 3:			//CREA CONTATTO
					if (s == 1)
					{
						
					}
					else
					{
						kb.nextLine();
						
						System.out.print("Nome: ");
						String nome = kb.nextLine();
						System.out.println();
						
						System.out.print("Cognome: ");
						String cognome = kb.nextLine();
						System.out.println();
						
						System.out.print("Telefono: ");
						String telefono = kb.nextLine();
						System.out.println();
						
						System.out.print("Email: ");
						String email = kb.nextLine();
						System.out.println();
						
						System.out.print("Note: ");
						String note = kb.nextLine();
						System.out.println();
						
						System.out.println(contatti.add(new Contatto(nome, cognome, telefono, email, note)) ? "Contatto creato." : "Errore creazione contatto.");
					}
					break;
					
				case 4:			//MODIFICA CONTATTO
					if (s == 1)
					{
						
					}
					else
					{
						System.out.println("Posizione in rubrica del contatto da modificare: ");
						int pos = kb.nextInt();
						modificaContatto(pos);
					}
					break;
					
				case 5:			//CANCELLA CONTATTO
					if (s == 1)
					{
						
					}
					else
					{
						System.out.println("Posizione in rubrica del contatto da eliminare: ");
						int posizione = kb.nextInt();
						cancellaContatto(posizione);
					}
					break;
					
				case 6:			//TROVA DUPLICATI
					if (s == 1)
					{
						
					}
					else
					{
						List<Contatto> duplicati = cercaDuplicati(false);
						
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
					if (s == 1)
					{
						
					}
					else
					{
						List<Contatto> duplicatiUniti = cercaDuplicati(true);
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
				
			case "telefono":
				contatti.sort((o1, o2) -> o1.getTelefono().compareTo(o2.getTelefono()));
				break;
				
			case "email":
				contatti.sort((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()));
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
			else if (contatto.getTelefono().equals(filtro)) cont.add(contatto);
			else if (contatto.getEmail().equals(filtro)) cont.add(contatto);
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
		System.out.print("Telefono: ");
		contatto.setTelefono(kb.nextLine());
		System.out.println();
		System.out.print("Email: ");
		contatto.setEmail(kb.nextLine());
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
		System.out.print("--------- Menu Database ---------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("---------- Menu Locale ----------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Esci dal Programma ------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuIniziale(int s)
	{
		if (s == 1) System.out.print("------------ DATABASE -----------\n");
		else
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