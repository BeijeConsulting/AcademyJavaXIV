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
		 String command[] = input.split("? ?|\"");
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
			 for(Contatto c : clInterface.search(command))
			 {
				 System.out.println(c);
			 }
			 break;
		 
		 case "new":
			 if(command.length==1)
			 {
				 System.out.println("syntax: nome cognome telefono email note  insert x to ignore field");
				 command=("x "+scanner.nextLine()).split(" ");
			 }
			 if(command.length>6) {
				 for(int i = 6;i<command.length;i++)
				 {
					 command[5]+=" "+command[i];
				 }
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
			 if(command.length>7) {
				 for(int i = 7;i<command.length;i++)
				 {
					 command[6]+=" "+command[i];
				 }
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
			Contatto c = (clInterface.search("x","id",command[1])).get(0);
			System.out.println("are you sure to delete " + c +" ? y/n");
			String answer = scanner.next();
			if(answer.equalsIgnoreCase("y"))
			clInterface.delete(command[1]);
			else
			 break;
		
		 case "export":
			 clInterface.ExportXML("tmp/Rubrica.xml");
			 break;
		 
		 default: 
			System.out.println(INPUT_ERROR);
			break;
		
		 case "duplicates":
			 clInterface.findDuplicates();
			 break;
		 case "merge":
			 clInterface.mergeContacts(command);
			 break;
		 case "exit":
			 shouldBeRunning=false;
		 }	 
	}

}

class CommandException extends Exception
{
	
}
