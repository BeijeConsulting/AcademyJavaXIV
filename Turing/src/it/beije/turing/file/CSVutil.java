package it.beije.turing.file;

import java.io.*;
import java.util.*;

import it.beije.turing.rubrica.Contatto;

public class CSVutil {
	private static List<String> fields = null;
	
	
	
//	public List<Contatto> loadRubricaFromXML(String pathFile) {
//		
//	}
	
	
	
	public void writeRubricaXML(List<Contatto> contatti, String pathFile) {
		
	}
	
	public static List<String> readFile(String csvPath) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<String> rows = null;
		
		try {			
			fileReader = new FileReader(csvPath);
			bufferedReader = new BufferedReader(fileReader);
			rows = new ArrayList<>();
			
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				rows.add(row);
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
		
		return rows;
	}
	
	public static String[] cleanRow(String row, String separator) {
		String[] columns = row.split(separator);
		for (int i = 0; i < columns.length; i++) {
			columns[i] = replaceIfNull(columns[i], "");
		}
		if (columns.length < 4) {
			String[] newCols = new String[4];
			for (int i = 0; i < columns.length; i++) {
				newCols[i] = columns[i];
			}
			newCols[newCols.length - 1] = "";
			return newCols;
		}
		return columns;
	}
	
	public static String replaceIfNull(String str, String replace) {
		if (str == null) {
			return replace;
		}
		return str;
	}
	
	public static void matchField() {
		
	}
	
	public static void setFields() {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		while (!str.equalsIgnoreCase("exit")) {
			System.out.println(str);
			fields.add(str);
			str = s.next();
		}
		
		System.out.println("campi inseriti");
		s.close();
		
	}
	
}
