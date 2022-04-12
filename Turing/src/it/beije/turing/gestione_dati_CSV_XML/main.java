package it.beije.turing.gestione_dati_CSV_XML;

import java.util.List;
import java.util.Scanner;

import it.beije.turing.rubrica.Contatto;

public class main {
	static boolean shouldBeRunning=true;
	static final String INPUT_ERROR = "errore, comando non riconosciuto";
	public static void main(String[] args) {
		 GestoreRubrica manager = GestoreRubrica.getInstance();
		 Scanner scanner = new Scanner(System.in);
	 while (shouldBeRunning)
	 {
		
		 String command = scanner.next(); 
		 switch(command.toLowerCase())
		 {
		 case "import":
			 manager.RubricImportCSV(scanner.next(), Boolean.parseBoolean(scanner.next()));
			 break;
		 case "print":
		
				manager.print(scanner.next());
				break;
		 case "save":
			 manager.save();
			 break;
		 case "search":
			 System.out.println("nome cognome telefono email. X per non includere il campo nella ricerca");
			manager.search(scanner.next(),scanner.next(),scanner.next(),scanner.next());
		 case "new":
			 manager.add(scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next());
			 break;
		 case "modify":
			 manager.modify(Integer.parseInt(scanner.next())-1, scanner.next(), scanner.next(), scanner.next(), scanner.next(),scanner.next());
			 break;
		 case "del":
			 manager.delete(Integer.parseInt(scanner.next())-1);
			 break;
		default: 
			System.out.println(INPUT_ERROR);
			break;
		 case "exit":
			 shouldBeRunning=false;
		 }
			 
	 }
	}

}
