package it.beije.turing.gestione_rubrica_commandline;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.GestoreRubrica;

public class main {
	static boolean shouldBeRunning=true;
	static final String INPUT_ERROR = "errore, comando non riconosciuto";
	static final String PAPPARDELLA_INIZIALE ="only one command per line: print, new, modify,search,duplicates,merge,del,import,export and exit to close program";
	
	public static void main(String...args)
	{	
		while (shouldBeRunning)
		 {
		try {
			Interface();
		} catch (CommandException e) {
			System.out.println("Error in command");
		}
		 }
		
	}
	
	private static void Interface() throws CommandException {
		 CommandLineInterface clInterface = GestoreRubrica.getInstance();
		 Scanner scanner = new Scanner(System.in);
		 //clInterface.print();
		 System.out.println(PAPPARDELLA_INIZIALE);
		 System.out.print("-");
		 String input = scanner.nextLine();
		
		 if(input.contains(" "))
			 throw new CommandException();
		 switch(input.toLowerCase())
		 {
		 
		 case "import":
			 try {
			 System.out.println("XML or CSV?");
			 String type = scanner.nextLine();
			 System.out.println("nome del file?");
			 String filename=scanner.nextLine();
			 if(type.equalsIgnoreCase("csv"))
			 {
			 
			 System.out.println("ci sono gli apici? true/false");
			 String apici = scanner.nextLine();
			 clInterface.importCSV(filename, Boolean.parseBoolean(apici));
			 }
			 else if(type.equalsIgnoreCase("xml"))
			 {
			 clInterface.importXML(filename);
			 }
			 else
			 {
				 throw new CommandException();
			 }
			 break;
			 }
			 catch(IndexOutOfBoundsException e)
			 {
				 throw new CommandException();
			 }
			 
			////////////////////////////////////////7
			 
		 case "order":
			 System.out.println("secondo quale colonna?");
			 String colonna = scanner.nextLine();
			 clInterface.printOrdered(colonna);
			 break;
			 
			 
		 case "print":
		
				clInterface.print();
				break;
		 
		 
		 case "search":
			 System.out.println("scrivi i parametri come segue(senza quadre): [Nome colonna] [valore] [altra colonna] [altro valore]");
			 String filters = scanner.nextLine();
			 for(Contatto c : clInterface.search(filters.split(" ")))
			 {
				 System.out.println(c);
			 }
			 break;
		 
		 case "new":
			 System.out.println("x per indicare un campo null");
			 String data[]= new String[5];
			 String colonne[] = {"nome","cognome","telefono","email","note"};
			 for(int i = 0;i<data.length;i++)
			 {
				 System.out.println(colonne[i]);
				data[i]=scanner.nextLine();
			 }
			 try {
			 clInterface.add(data[0],data[1],data[2],data[3],data[4]);
			 break;
			 }
			 catch(IndexOutOfBoundsException e)
			 {
				 throw new CommandException();
			 }
			 
		 
		 
		 case "modify":
			 System.out.println("x per indicare un campo null");
			 String data2[]= new String[6];
			 String colonne2[] = {"id","nome","cognome","telefono","email","note"};
			 for(int i = 0;i<data2.length;i++)
			 {
				 System.out.println(colonne2[i]);
				data2[i]=scanner.nextLine();
			 }
			 try {
			 clInterface.modify(Integer.parseInt(data2[0]),data2[1],data2[2],data2[3],data2[4],data2[5]);
			 break;
			 }
			 catch(IndexOutOfBoundsException e)
			 {
				 throw new CommandException();
			 }
		 
		 
		 case "del":
			 System.out.println("inerisci l'id del contatto da eliminare");
			String id= scanner.nextLine();
			Contatto c = (clInterface.search("id",id)).get(0);
			System.out.println("are you sure to delete " + c +" ? y/n");
			String answer = scanner.next();
			if(answer.equalsIgnoreCase("y"))
			clInterface.delete(id);
			break;
		
		 case "export":
			 System.out.println("XML or CSV?");
			 String type = scanner.nextLine();
			 if(type.equalsIgnoreCase("xml"))
			 clInterface.ExportXML("tmp/Rubrica.xml");
			 else if(type.equalsIgnoreCase("csv"))
				 clInterface.ExportCSV("tmp/Rubrica.csv");
			 break;
		 
		 default: 
			System.out.println(INPUT_ERROR);
			break;
		
		 case "duplicates":
			 clInterface.findDuplicates();
			 break;
		 case "merge":
			 System.out.println("WARNING: da eseguire solo su contatti duplicati trovali con 'duplicate'");
			 System.out.println("continuare? y/n");
			 String answer2=scanner.nextLine();
			 if(!answer2.equalsIgnoreCase("y"))
				 break;
			 System.out.println("inerisci gli id dei contatti da fondere");
			 String ids = scanner.nextLine();
			 clInterface.mergeContacts(ids.split(" "));
			 break;
		 case "exit":
			 scanner.close();
			 shouldBeRunning=false;
		 }	 
	}

}

class CommandException extends Exception
{
	
}
