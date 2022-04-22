package it.beije.turing.rubrica;

public class CLIvisualizer
{
	public void menuAvvio()
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
	
	public void menuIniziale(int s, int size)
	{
		if (s == 1) System.out.print("--------- DATABASE JDBC ---------\n");
		else if (s == 2) System.out.print("------ DATABASE HIBERNATE -------\n");
		else if (s == 3) System.out.print("--------- DATABASE JPA ----------\n");
		else if (s == 4)
		{
			System.out.print("\n\n------------ LOCALE -------------\n");
			System.out.print("---------------------------------\n");
			System.out.println((size != 0) ? ("------- Rubrica: " + "caricata" + " -------") : ("----- Rubrica: non caricata -----"));
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
	
	public void menuRubrica()
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
	
	public void menuImportazione(int s)
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
	
	public void menuEsportazione(int s)
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
	
	public void menuContatti()
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
}