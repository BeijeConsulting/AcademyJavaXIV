package it.beije.turing.xmlparser7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Documento {

	private String[] splitAllInOne;
	private Root root;


	public String[] getSplitAllInOne() {
		return splitAllInOne;
	}

	public void setSplitAllInOne(String[] splitAllInOne) {
		this.splitAllInOne = splitAllInOne;
	}

	public Root getRootElement() {
		return root;
	}

	public void setRoot(Root root) {
		this.root = root;
	}

	private Documento(String[] splitAllInOne, Root root) {
		this.root = root;
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

		return splitAllInOne;
	}

	public static Documento parse(String s) {
		String[]splitAllInOne = XMLToString(s);
		Root root = Root.creaInstanzaRoot(splitAllInOne);
		return new Documento(splitAllInOne, root);
	}
}
