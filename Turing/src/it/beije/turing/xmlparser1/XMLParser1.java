package it.beije.turing.xmlparser1;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.turing.xmlparser1.ConcreteClass.DocumentoBuilder;
import it.beije.turing.xmlparser1.Interfaces.Documento;
import it.beije.turing.xmlparser1.Interfaces.Elemento;
import java.util.Scanner;
/**
 * 
 * @author Ercole Corraro, Lorenzo Leopardi
 *
 */
public class XMLParser1 {

	public static void main(String[] args) {

		System.out.println("Per uscire, digitare \"exit\".");
		System.out.println("Inserisci nome del file .xml: ");
		
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();

		Documento test = null;
		test = DocumentoBuilder.parse(Paths.get("Turing","File", "Challenge", st
					+ ".xml").toAbsolutePath().toString());
		
		Elemento root = test.getDocumentElement();
		if(root == null) {
			return;
		}
		
		while (!st.equalsIgnoreCase("exit")) {
			
			System.out.println("\n\n"
								+"1: get complete text\n"
								+"2: get tag name\n"
								+"3: get text content\n"
								+"4: get attribute by name\n"
								+"5: get all attributes\n"
								+"6: get child nodes\n"
								+"7: get child elements\n"
								+"8: get all elements by tag name\n"
								+"exit: leave the program");
			String command = s.nextLine();
			
			switch (command) {
				case("1"):
					System.out.println(root.getTestoCompleto());
					break;
				case("2"):
					System.out.println("TagName: \n" + root.getTagName());
					break;	
				case("3"):
					System.out.println("Text Content: \n" + root.getTextContent());
					break;
				case("4"):
					System.out.println("Insert attribute name to search:");
					String attributeName = s.nextLine();
					System.out.println(attributeName+" = "+root.getAttribute(attributeName));
					break;
				case("5"):
					System.out.println(root.getAttributes());
					break;
				case("6"):
					System.out.println(root.getChildNodes());
					break;
				case("7"):
					System.out.println(root.getChildElements());
					break;
				case("8"):
					System.out.println("Insert attribute name to search:");
					String tagNameSearch = s.nextLine();
					System.out.println(root.getElementsByTagName(tagNameSearch,new ArrayList<Elemento>(),0));
					break;
				case("exit"):
					System.out.println("Leaving program.");
					st = command;
					continue;
				default:
					System.out.println("Invalid input");
					continue;
			}
		}		
		System.out.println("BYE!!");
		s.close();
	}

}