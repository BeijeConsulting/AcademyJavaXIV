package it.beije.turing.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rubrica
{
	public static void main(String[] args)
	{
		Rubrica rubrica = new Rubrica();
		
		rubrica.inizializza();
		
		Scanner kb = new Scanner(System.in);
		
		int scelta = kb.nextInt();
		
		rubrica.testingStationCSV(scelta);		//1 read CSV, 2 write CSV
	}

	private void inizializza()
	{
		System.out.print("------------ RUBRICA ------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Gestione Rubrica --------\n");
		System.out.print("--------------- 1 ---------------\n");
		System.out.print("---------------------------------\n");
		System.out.print("------- Gestione Contatti -------\n");
		System.out.print("--------------- 2 ---------------\n");
		System.out.print("---------------------------------\n");
	}
	
	private void testingStationCSV(int scelta)
	{
		CSVhandler csvHandler = new CSVhandler();
		List<Contatto> contatti = new ArrayList<>();
		contatti.add(new Contatto());
		contatti.add(new Contatto("nome1", "cognome1", "telefono1", "email1", "nota1"));
		contatti.add(new Contatto("", "cognome2", "telefono2", "email2", ""));
		contatti.add(new Contatto("", "", "", "", ""));
		
		switch(scelta)
		{
			case 1:
				contatti = csvHandler.loadRubricaFromCSV("/temp/rubrica.csv", ";");
				System.out.println(contatti.toString());
				break;
				
			case 2:
				csvHandler.writeRubricaCSV(contatti, "/temp/rubrica.csv", ";");
				System.out.println("WRITE DONE");
				break;
				
			default:
				break;
		}
	}
}
