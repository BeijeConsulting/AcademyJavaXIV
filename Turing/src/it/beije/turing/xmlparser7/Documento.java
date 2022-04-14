package it.beije.turing.xmlparser7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Documento {

	private String xmlDichiarazione;
	String[] splitAllInOne;
	
	
//	public String getXmlDichiarazione() {
//		return xmlDichiarazione;
//	}
//
//	public void setXmlDichiarazione(String xmlDichiarazione) {
//		this.xmlDichiarazione = xmlDichiarazione;
//	}

	
//	public void isXmlDichiarazione(String s) {
//		if(s.contentEquals("<?xml")) {
//			setXmlDichiarazione(s);
//		} else {
//			
//		}
//	}
	
	private Documento(String[] splitAllInOne) {
		this.splitAllInOne = splitAllInOne;
	}
	
	public static String[] XMLToString(String s) {
		String allInOne = "";
		String campo = "";
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(new File(s));
			bufferedReader = new BufferedReader(fileReader);
			
			while (bufferedReader.ready() ) {
				allInOne += bufferedReader.readLine() + "\n";
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException ioE) {
				ioE.printStackTrace();
			}
		}
		
		String[] splitAllInOne = allInOne.split("<");
		
		for(int i = 0; i < splitAllInOne.length; i++) {
			System.out.println();
			System.out.println("QuA INZIA LA riga " + i + splitAllInOne[i] + "QuA FINISCE LA riga " + i);
			System.out.println();
		}
//		if(splitAllInOne[44].substring(0, splitAllInOne[44].indexOf(">")).equalsIgnoreCase(splitAllInOne[45].substring(1, splitAllInOne[45].indexOf(">")))) {
//			System.out.println("Spiegazione trovata");
//		}
		return splitAllInOne;
	}

	private void creaRoot() {
		Root.creaInstanzaRoot(splitAllInOne);
	//	creaInstanzaRoot();
//		String campo;
//		if(splitAllInOne[1].indexOf(" ") == -1) {
//			System.out.println("Qua c'è a[1]" + splitAllInOne[1]);
//			campo = splitAllInOne[1].substring(0, splitAllInOne[1].indexOf(">"));
//			
//		} else {
//			campo = splitAllInOne[1].substring(0, splitAllInOne[1].indexOf(" "));
//			for(int i = 1; i < splitAllInOne.length; i+= 2) {
//				//a[i] contiene la variabile più il testo, a[i + 1] contiene la variabile che possiamo usare per rimuovere la prima parte del testo per ottenerlo
//				newDatoInstance(splitAllInOne[i], splitAllInOne[i + 1]);
//				if(campo.equalsIgnoreCase(splitAllInOne[i].substring(1, campo.length() + 1))) {
//					System.out.println(splitAllInOne[i].replace("/",  " ").replace(">",  " ").replace("/t",  " ").trim() + "\tQua finisce la stringa\n");
//					System.out.println("Campo trovato.");
//					break;
//				}
//			}
//		}
	}
	
	

	
	public static Documento parse(String s) {
		String[]splitAllInOne = XMLToString(s);
		return new Documento(splitAllInOne);
	}
}
