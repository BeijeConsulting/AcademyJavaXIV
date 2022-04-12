package Rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Rubrica.Contatto;

public class RubricaCsv {
	public static void upload(String path, Boolean virgolette) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		String[] columns = null;

		
		try {
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			
			contatti = new ArrayList<Contatto>();
			Contatto contatto = null;
			
			while(bufferedReader.ready()) {
				String row = bufferedReader.readLine();    
				
				
				if(virgolette) {
					row = row.substring(1, row.length() - 1);
					columns = row.split("\";\"");
				} else {
					columns = row.split(";");
				}
				
				contatto = new Contatto();
				
//				for (String col : columns) System.out.println(col);
				
				for (int i = 0; i < columns.length; i++) {
					if(columns[0].equalsIgnoreCase("cognome"));
						contatto.setCognome(columns[0]);
						System.out.println("ok");
				}
				
				}
			
			
;		} catch (FileNotFoundException fnfEx) {
			// TODO Auto-generated catch block
			fnfEx.printStackTrace();
		} catch (IOException ioEx) {
			// TODO Auto-generated catch block
			ioEx.printStackTrace();
		}
		
	}
	
	//public static void write
	
	public static void main(String[] args) {
		upload("/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/Turing/src/File/temp/rubrica.csv", false);
		
	}

}
