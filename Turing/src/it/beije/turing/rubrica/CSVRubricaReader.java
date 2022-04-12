package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVRubricaReader {
	private static  List <Integer> a = new ArrayList<>();
	private static boolean quotation=false;
	static List<Contatto> contatti = null;

	public static List<Contatto> readCSV(String csvPath) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String chooseDelimiter= checkUser();
		try {
			fileReader = new FileReader(csvPath);
			
			bufferedReader = new BufferedReader(fileReader);
			int c = 0;
			contatti = new ArrayList<Contatto>();
			while (bufferedReader.ready()) {
				Contatto contatto = new Contatto();
				String row = bufferedReader.readLine();
				String[] columns=checkQuationMark(row, chooseDelimiter);
				for (String el : columns){System.out.println(el);}
				contatto=fieldMenage(columns, contatto);
				contatti.add(contatto);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
		}
		
		//System.out.println("contatti: " + contatti.size());
		System.out.println(contatti);
		return contatti;
	}

	private static String checkUser() {
		System.out.println("NEL FILE SONO PRESENTI VIRGOLETTE COME DELIMITATORE FIELD?: ");
		Scanner s = new Scanner(System.in);
		String st;
		st= s.next();
		while (!st.equalsIgnoreCase("si") && !st.equalsIgnoreCase("no")){
			System.out.println("scelta errata, ripetere scelta");
			st= s.next();
		}
		if (st.equalsIgnoreCase("si")){
			quotation=true;
		}
		System.out.println("Selezionare delimitatore (\"/\",\";\" \":\"\"-\")");
		String choose= s.next();
		while (!choose.equalsIgnoreCase(";") && !choose.equalsIgnoreCase("-") && !choose.equalsIgnoreCase(",") &&!choose.equalsIgnoreCase(":")){
			System.out.println("scelta errata, ripetere scelta");
			choose= s.next();
		}
		s.close();
		return choose;
	}

	private static String[] checkQuationMark(String row, String chooseDelimiter) {
		String[] columns;
		if (quotation) {
			row = row.substring(1, row.length() - 1);
			columns= row.split("\""+chooseDelimiter+"\"");
		}
		else {
			columns= row.split(chooseDelimiter);
		}
		return columns;
	}

	private static Contatto fieldMenage(String[] columns, Contatto contatto) {
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].equalsIgnoreCase("NOME")) {
				a.add(i);
			}
		}
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].equalsIgnoreCase("COGNOME")) {
				a.add(i);
			}
		}for (int i = 0; i < columns.length; i++) {
			if (columns[i].equalsIgnoreCase("TELEFONO")) {
				a.add(i);
			}
		}for (int i = 0; i < columns.length; i++) {
			if (columns[i].equalsIgnoreCase("EMAIL")) {
				a.add(i);
			}
		}for (int i = 0; i < columns.length; i++) {
			if (columns[i].equalsIgnoreCase("NOTE")) {
				a.add(i);
			}
		}
		contatto.setNome(columns[a.get(0)]);
		contatto.setCognome(columns[a.get(1)]);
		contatto.setTelefono(columns[a.get(2)]);
		contatto.setEmail(columns[a.get(3)]);
		contatto.setNote(columns[a.get(4)]);
		return contatto;
	}

	public static List<Contatto> getContatti() {
		return contatti;
	}
}
