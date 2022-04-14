package it.beije.turing.xmlparser7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Cognome Nome, Cognome Nome
 *
 */
public class XMLParser7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"/Users/simonepitossi/File/test_parser6.xml"
		
	}

	private static String xmlToString(String s) {
		String allInOne = "";
		try {
			FileReader fileReader = new FileReader(new File(s));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (bufferedReader.ready()) {
				allInOne += bufferedReader.readLine() + "\n";
			}
			System.out.println(allInOne);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return allInOne;
	}
	
	

}
