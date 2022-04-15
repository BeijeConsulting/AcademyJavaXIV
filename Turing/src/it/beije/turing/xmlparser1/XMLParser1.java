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

	public static void printElements(List<Elemento> elements, String tabs) {
		for (Elemento element : elements) {
//			System.out.println(tabs + "element : " + element);
			System.out.println(tabs + "element.getTagName() : " + element.getTagName());
//			System.out.println(tabs + "element.getTextContent() : " + element.getTextContent());
			System.out.println(tabs + "element.getChildNodes() : " + element.getChildNodes());
			List<Elemento> innerElements = element.getChildElements();
			System.out.println(tabs + "element.getChildElements() : " + innerElements);
			//getElementsByTagName NON STANDARD E NON DOCUMENTATO
//			System.out.println(tabs + "element.getElementsByTagName(\"contatto\") : " + element.getElementsByTagName("contatto"));
//			System.out.println(tabs + "element.getElementsByTagName(\"altro\") : " + element.getElementsByTagName("altro"));
			System.out.println(tabs + "element.getAttributes() : " + element.getAttributes());
			System.out.println(tabs + "element.getAttribute(\"name\") : " + element.getAttribute("name"));
			
			if (innerElements != null && !innerElements.isEmpty()) {
				printElements(innerElements, tabs + '\t');
			}
		}
	}
	
	public static void testChallenge(String path) {
		Documento doc = DocumentoBuilder.parse(path);

		Elemento root = doc.getDocumentElement();
//		System.out.println("root : " + root);
		System.out.println("root.getTagName() : " + root.getTagName());
		System.out.println("root.getTextContent() : " + root.getTextContent());
		System.out.println("root.getChildNodes() : " + root.getChildNodes());
		List<Elemento> elements = root.getChildElements();
		System.out.println("root.getChildElements() : " + elements);
		//getElementsByTagName NON STANDARD E NON DOCUMENTATO
//		System.out.println("root.getElementsByTagName(\"contatto\") : " + root.getElementsByTagName("contatto"));
//		System.out.println("root.getElementsByTagName(\"altro\") : " + root.getElementsByTagName("altro"));
		System.out.println("root.getAttributes() : " + root.getAttributes());
		System.out.println("root.getAttribute(\"question\") : " + root.getAttribute("question"));
		
		printElements(elements, "\t");
	}

	public static void main(String[] args) {
		testChallenge("/tmp/test_parser1.xml");
	}
	
	public static void console(String[] args) {

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