package it.beije.turing.gestione_rubrica_commandline;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.rubrica.Contatto;

public class main {
	static boolean shouldBeRunning=true;
	static final String INPUT_ERROR = "errore, comando non riconosciuto";
	static final String PAPPARDELLA_INIZIALE ="\n\ncommands: print, new, modify, import,export and exit to close program";
	
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
		 //System.out.println(PAPPARDELLA_INIZIALE);
		 System.out.print("-");
		 String input = scanner.nextLine();
		 String command[] = input.split(" ");
		 if(command.length<1)
			 throw new CommandException();
		 switch(command[0].toLowerCase())
		 {
		 
		 case "import":
			 try {
			 String type = command[1];
			 if(type.equalsIgnoreCase("csv"))
			 {
			 clInterface.importCSV(command[2], Boolean.parseBoolean(command[3]));
			 }
			 else if(type.equalsIgnoreCase("xml"))
			 {
			 clInterface.importXML(command[2]);
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
		 case "order":
			 clInterface.printOrdered(command[1]);
			 break;
		 case "print":
		
				clInterface.print();
				break;
		 
		 
		 case "search":
			 clInterface.search(command);
			 break;
		 
		 case "new":
			 if(command.length==1)
			 {
				 System.out.println("syntax: nome cognome telefono email note  insert x to ignore field");
				 command=("x "+scanner.nextLine()).split(" ");
			 }
			 try {
			 clInterface.add(command[1],command[2],command[3],command[4],command[5]);
			 break;
			 }
			 catch(IndexOutOfBoundsException e)
			 {
				 throw new CommandException();
			 }
			 
		 
		 
		 case "modify":
			 if(command.length==1)
			 {
				 System.out.println("syntax: id nome cognome telefono email note  insert x to ignore field id is the id of the entry you want to update");
				 command=("x "+scanner.nextLine()).split(" ");
			 }
			 try {
			 clInterface.modify(Integer.parseInt(command[1]),command[2],command[3],command[4],command[5],command[6]);
			 break;
			 }
			 catch(IndexOutOfBoundsException e)
			 {
				 throw new CommandException();
			 }
		 
		 
		 case "del":
			 //manager.delete(Integer.parseInt(scanner.next())-1);
			 break;
		
		 case "export":
			 clInterface.ExportXML("tmp/Rubrica.xml");
			 break;
		 
		 default: 
			System.out.println(INPUT_ERROR);
			break;
		 case "exit":
			 shouldBeRunning=false;
		 }	 
	}

}

class CommandException extends Exception
{
	
}
