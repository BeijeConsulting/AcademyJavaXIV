package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
	
	public static ArrayList<Integer> getCSVBins(String csvPath) {		//returns arraylist of ints with the positions of NOME,COGNOME,EMAIL,TELEFONO
		boolean virgolette = false;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		ArrayList<Integer> contatti = null;
		try {
			fileReader = new FileReader(csvPath);
			bufferedReader = new BufferedReader(fileReader);
			contatti = new ArrayList<Integer>();
				String row = bufferedReader.readLine();
				List<String> columns=new ArrayList<String>();
				if (virgolette) {
					row = row.substring(1, row.length()-1);			//extreme quotes cleanup
					columns = Arrays.asList(row.split("\";\""));			//split
				} else {
					columns = Arrays.asList(row.split(";"));			//split
				}
				//for (String col : columns) System.out.println(col);
				
				contatti.add(columns.indexOf("NOME"));
				contatti.add(columns.indexOf("COGNOME"));
				contatti.add(columns.indexOf("EMAIL"));
				contatti.add(columns.indexOf("TELEFONO"));
			
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
		
		return contatti;
	}
	
	
//	public static List<String> getCSVBins(String csvPath) {		//returns arraylist of ints with the positions of NOME,COGNOME,EMAIL,TELEFONO
//	boolean virgolette = false;
//	
//	FileReader fileReader = null;
//	BufferedReader bufferedReader = null;
//	//ArrayList<Integer> contatti = null;
//	try {
//		fileReader = new FileReader(csvPath);
//		bufferedReader = new BufferedReader(fileReader);
//		//contatti = new ArrayList<Integer>();
//			String row = bufferedReader.readLine();
//			List <String> columns = new ArrayList<String>();
//			if (virgolette) {
//				row = row.substring(1, row.length()-1);			//extreme quotes cleanup
//				columns = Arrays.asList(row.split("\";\""));			//split
//			} else {
//				columns = Arrays.asList(row.split(";"));			//split
//			}
//			//for (String col : columns) System.out.println(col);
////			
////			contatti.add(columns.indexOf("NOME"));
////			contatti.add(columns.indexOf("COGNOME"));
////			contatti.add(columns.indexOf("EMAIL"));
////			contatti.add(columns.indexOf("TELEFONO"));
//			return columns;
//		
//	} catch (IOException ioEx) {
//		ioEx.printStackTrace();
//		
//	} finally {
//		try {
//			bufferedReader.close();
//			fileReader.close();
//		} catch (IOException fEx) {
//			fEx.printStackTrace();
//		}
//	}
//	
//	
//}
	
	
	public static void main (String[] args) {
		
//		String s = "C:/Users/Padawan/Downloads/rubrica.csv";
//		System.out.println(getCSVBins(s));
		
	}

}
