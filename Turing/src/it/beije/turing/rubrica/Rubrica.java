package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLASSE MAIN DI RUBRICA
 * 
 * 
 * @author Mattia
 *
 */

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
	}

	@SuppressWarnings("resource")
	private void avviaMenu()
	{
		Scanner kb = null;
		boolean riprova = false;
		CLIvisualizer cliVisualizer = new CLIvisualizer();
		
		do
		{
			cliVisualizer.menuAvvio();
			
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
	
	@SuppressWarnings("resource")
	private void avviaMenu(int s) // 1 db jdbc,  2 db hibernate, 3 JPA, 4 locale
	{
		Scanner kb = null;
		boolean riprova = false;
		CLIvisualizer cliVisualizer = new CLIvisualizer();
		
		do
		{
			cliVisualizer.menuIniziale(s, contatti.size());
			
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
	
	@SuppressWarnings("resource")
	private void avviaMenuRubrica(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		CLIvisualizer cliVisualizer = new CLIvisualizer();
		
		do
		{
			cliVisualizer.menuRubrica();
			
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
	
	@SuppressWarnings("resource")
	private void avviaMenuImportazione(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		CLIvisualizer cliVisualizer = new CLIvisualizer();
		
		do
		{
			cliVisualizer.menuImportazione(s);
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			String pathFile = null;
			switch(scelta)
			{
				case 1:
					CSVhandler csvHandler = new CSVhandler();
					System.out.print("Inserisci il path: ");
					pathFile = kb.next();
					System.out.print("Inserisci il carattere separatore: ");
					String separator = kb.next();
					
					if (s == 1)												//JDBC
					{
						JDBChandler jdbcHandler = new JDBChandler();
						jdbcHandler.loadRubricaToDB(csvHandler.loadRubricaFromCSV(pathFile, separator));
					}
					else if (s == 2)										//HIBERNATE
					{
						HBhandler hbHandler = new HBhandler();
						hbHandler.loadRubricaToDB(csvHandler.loadRubricaFromCSV(pathFile, separator));
					}
					else if (s == 3)										//JPA
					{
						JPAhandler jpaHandler = new JPAhandler();
						jpaHandler.loadRubricaToDB(csvHandler.loadRubricaFromCSV(pathFile, separator));
					}
					else if (s == 4)										//LOCALE
					{
						contatti = csvHandler.loadRubricaFromCSV(pathFile, separator);
					}
					break;
					
				case 2:
					XMLhandler xmlHandler = new XMLhandler();
					System.out.print("Inserisci il path: ");
					pathFile = kb.next();
					
					if (s == 1)												//JDBC
					{
						JDBChandler jdbcHandler = new JDBChandler();						
						jdbcHandler.loadRubricaToDB(xmlHandler.loadRubricaFromXML(pathFile));
					}
					else if (s == 2)										//HIBERNATE
					{
						HBhandler hbHandler = new HBhandler();
						hbHandler.loadRubricaToDB(xmlHandler.loadRubricaFromXML(pathFile));
					}
					else if (s == 3)										//JPA
					{
						JPAhandler jpaHandler = new JPAhandler();
						jpaHandler.loadRubricaToDB(xmlHandler.loadRubricaFromXML(pathFile));
					}
					else if (s == 4)										//LOCALE
					{
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
	
	@SuppressWarnings("resource")
	private void avviaMenuEsportazione(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		CLIvisualizer cliVisualizer = new CLIvisualizer();
		
		do
		{
			cliVisualizer.menuEsportazione(s);
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			String pathFile = null;
			
			switch(scelta)
			{
				case 1:
					CSVhandler csvHandler = new CSVhandler();
					System.out.print("Inserisci il path: ");
					pathFile = kb.next();
					System.out.print("Inserisci il carattere separatore: ");
					String separator = kb.next();
					
					if (s == 1)												//JDBC
					{
						JDBChandler jdbcHandler = new JDBChandler();
						csvHandler.writeRubricaCSV(jdbcHandler.getRubrica(""), pathFile, separator);
					}
					else if (s == 2)										//HIBERNATE
					{
						HBhandler hbHandler = new HBhandler();
						csvHandler.writeRubricaCSV(hbHandler.getRubrica(""), pathFile, separator);
					}
					else if (s == 3)										//JPA
					{
						JPAhandler jpaHandler = new JPAhandler();
						csvHandler.writeRubricaCSV(jpaHandler.getRubrica(""), pathFile, separator);
					}
					else if (s == 4)										//LOCALE
					{
						csvHandler.writeRubricaCSV(contatti, pathFile, separator);
					}					
					break;
					
				case 2:
					XMLhandler xmlHandler = new XMLhandler();
					System.out.print("Inserisci il path: ");
					pathFile = kb.next();
					
					if (s == 1)												//JDBC
					{
						JDBChandler jdbcHandler = new JDBChandler();
						xmlHandler.writeRubricaXML(jdbcHandler.getRubrica(""), pathFile);
					}
					else if (s == 2)										//HIBERNATE
					{
						HBhandler hbHandler = new HBhandler();
						xmlHandler.writeRubricaXML(hbHandler.getRubrica(""), pathFile);
					}
					else if (s == 3)										//JPA
					{
						JPAhandler jpaHandler = new JPAhandler();
						xmlHandler.writeRubricaXML(jpaHandler.getRubrica(""), pathFile);
					}
					else if (s == 4)										//LOCALE
					{
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
	
	@SuppressWarnings("resource")
	private void avviaMenuContatti(int s)
	{
		Scanner kb = null;
		boolean riprova = false;
		CLIvisualizer cliVisualizer = new CLIvisualizer();
		LocaleHandler localeHandler = new LocaleHandler();
		JDBChandler jdbcHandler = new JDBChandler();
		HBhandler hbHandler = new HBhandler();
		JPAhandler jpaHandler = new JPAhandler();
		
		do
		{
			if (s == 4 && contatti.size() == 0) System.out.println("Rubrica non caricata. Solo creazione nuovi contatti disponibile.");
			
			cliVisualizer.menuContatti();
			
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
					
					if (s == 1)												//JDBC
					{
						for(Contatto c : jdbcHandler.getRubrica(filtro))
						{
							System.out.println(c);
						}						
					}
					else if (s == 2)										//HIBERNATE
					{
						for(Contatto c : hbHandler.getRubrica(filtro))
						{
							System.out.println(c);
						}	
					}
					else if (s == 3)										//JPA
					{
						for(Contatto c : jpaHandler.getRubrica(filtro))
						{
							System.out.println(c);
						}	
					}
					else if (s == 4)										//LOCALE
					{
						localeHandler.visualizzaContatti(filtro, contatti);
					}
					break;
					
				case 2:											//CERCA CONTATTO
					System.out.print("Valore di ricerca: ");
					String filtroRicerca = kb.next();
					System.out.println();
					List<Contatto> contacts = new ArrayList<>();
					
					if (s == 1)									//JDBC
					{
						contacts = jdbcHandler.findContatto(filtroRicerca);
					}
					else if (s == 2)							//HIBERNATE
					{
						contacts = hbHandler.findContatto(filtroRicerca);
					}
					else if (s == 3)							//JPA
					{
						contacts = jpaHandler.findContatto(filtroRicerca);
					}
					else if (s == 4)							//LOCALE
					{
						contacts = localeHandler.cercaContatto(filtroRicerca, contatti);						
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
					Contatto cont = null;
					
					if (s != 4)
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
						
						cont = new Contatto(n, c, e, t, no);
					}
					
					if (s == 1)					//JDBC
					{
						jdbcHandler.modifyContatto(pos, cont);
					}
					else if (s == 2)			//HIBERNATE
					{
						hbHandler.modifyContatto(pos, cont);
					}
					else if (s == 3)			//JPA
					{
						jpaHandler.modifyContatto(pos, cont);
					}
					else if (s == 4)			//LOCALE
					{
						localeHandler.modificaContatto(pos, contatti);
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
						localeHandler.cancellaContatto(posizione, contatti);
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
						duplicati = localeHandler.cercaDuplicati(false, contatti);
						
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
						duplicatiUniti = localeHandler.cercaDuplicati(true, contatti);
						contatti = duplicatiUniti;
						localeHandler.visualizzaContatti("", contatti);
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
}