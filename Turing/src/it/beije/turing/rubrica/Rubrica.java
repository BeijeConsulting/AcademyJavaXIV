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
		Scanner kb = null;
		
		while(true)
		{
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
			menuIniziale();
			
			riprova = false;
			
			kb = new Scanner(System.in);
			int scelta = kb.nextInt();
			
			switch(scelta)
			{
				case 1:
					avviaMenuRubrica();
					break;
					
				case 2:
					//avviaMenuContatti(kb);
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
	
	private void avviaMenuRubrica()
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
					avviaMenuImportazione();
					break;
					
				case 2:
					avviaMenuEsportazione();
					break;
					
				case 3:
					return;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenuImportazione()
	{
		Scanner kb = null;
		boolean riprova = false;
		
		do
		{
			menuImportazione();
			
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
					
					System.out.println("LOG path: " + pathFile + ", separatore: " + separator);
					
					contatti = csvHandler.loadRubricaFromCSV(pathFile, separator);
					break;
					
				case 2:
					XMLhandler xmlHandler = new XMLhandler();
					System.out.print("Inserisci il path: ");
					pathFile = kb.next();
					contatti = xmlHandler.loadRubricaFromXML(pathFile);
					break;
					
				case 3:
					return;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	private void avviaMenuEsportazione()
	{
		Scanner kb = null;
		boolean riprova = false;
		
		do
		{
			menuEsportazione();
			
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
					csvHandler.writeRubricaCSV(contatti, pathFile, separator);
					break;
					
				case 2:
					XMLhandler xmlHandler = new XMLhandler();
					System.out.print("Inserisci il path: ");
					pathFile = kb.next();
					xmlHandler.writeRubricaXML(contatti, pathFile);
					break;
					
				case 3:
					return;
					
				default:
					riprova = true;
					break;
			}
			
			
		} while (riprova);
	}
	
	
	//OUTPUT A SCHERMO
	
	private void menuIniziale()
	{
		System.out.print("------------ RUBRICA ------------\n");
		System.out.print("---------------------------------\n");
		
		System.out.println((contatti.size() != 0) ? ("------- Rubrica: " + "caricata" + " -------") : ("----- Rubrica: non caricata -----"));
		
		System.out.print("---------------------------------\n");
		System.out.print("------- Gestione Rubrica --------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Gestione Contatti -------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------ Esci dal Programma -------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuRubrica()
	{
		for(int x = 0; x != 10; x++) System.out.println();
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
	
	private void menuImportazione()
	{
		for(int x = 0; x != 10; x++) System.out.println();
		System.out.print("----- IMPORTAZIONE RUBRICA ------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------ Importa Rubrica CSV ------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------ Importa Rubrica XML ------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Menu Principale --------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuEsportazione()
	{
		for(int x = 0; x != 10; x++) System.out.println();
		System.out.print("----- ESPORTAZIONE RUBRICA ------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------ Esporta Rubrica CSV ------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------ Esporta Rubrica XML ------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("-------- Menu Principale --------\n");
		System.out.print("--------------- 3 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void menuContatti()
	{
		for(int x = 0; x != 10; x++) System.out.println();
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
