package it.beije.turing.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import it.beije.turing.rubrica.Contatto;


public class CSVManager {
	
	public static List<Contatto> readCSV(String csvPath) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		try {
			fileReader = new FileReader(csvPath);
			
			bufferedReader = new BufferedReader(fileReader);
			int c = 0;
			contatti = new ArrayList<Contatto>();
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				//System.out.println(++c + " " + row);
				
				//row = row.substring(0, row.length());
				String[] columns = row.split(";");
//				for (String col : columns) System.out.println(col);
				
				contatto = new Contatto();
				try {
					contatto.setCognome(columns[0]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setCognome("");
				}
				try {
					contatto.setNome(columns[1]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNome("");
				}
				try {
					contatto.setEmail(columns[2]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setEmail("");
				}
				try {
					contatto.setTelefono(columns[3]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setTelefono("");
				}
				try {
					contatto.setNote(columns[4]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNote("");
				}
				
				eliminaVirgolette(contatto);
				//System.out.println(contatto);
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
		return contatti;
	}
	
	public static boolean eliminaVirgolette(Contatto c) {
		
			if(c.getNome().startsWith("\"")) {
				c.setNome(c.getNome().substring(1));
			}else if(c.getNome().endsWith("\"")) {
				c.setNome(c.getNome().substring(0,c.getNome().length()-1));
			}else if(c.getNome().startsWith("\"") && c.getNome().endsWith("\"")) {
				c.setNome(c.getNome().substring(1,c.getNome().length()-1));
			}
			if(c.getCognome().startsWith("\"")) {
				c.setCognome(c.getCognome().substring(1));
			}else if(c.getCognome().endsWith("\"")) {
				c.setCognome(c.getCognome().substring(0,c.getCognome().length()-1));
			}else if(c.getCognome().startsWith("\"") && c.getCognome().endsWith("\"")) {
				c.setCognome(c.getCognome().substring(1,c.getCognome().length()-1));
			}
			if(c.getTelefono().startsWith("\"")) {
				c.setTelefono(c.getTelefono().substring(1));
			}else if(c.getTelefono().endsWith("\"")) {
				c.setTelefono(c.getTelefono().substring(0,c.getTelefono().length()-1));
			}else if(c.getTelefono().startsWith("\"") && c.getTelefono().endsWith("\"")) {
				c.setTelefono(c.getTelefono().substring(1,c.getTelefono().length()-1));
			}
			if(c.getEmail().startsWith("\"")) {
				c.setEmail(c.getEmail().substring(1));
			}else if(c.getEmail().endsWith("\"")) {
				c.setEmail(c.getEmail().substring(0,c.getEmail().length()-1));
			}else if(c.getEmail().startsWith("\"") && c.getEmail().endsWith("\"")) {
				c.setEmail(c.getEmail().substring(1,c.getEmail().length()-1));
			}
			return true;
	}
	
	public static void writeCSV(String csvPath, List<Contatto> contatti) {
		File file = new File(csvPath);
		System.out.println("file exists? " + file.exists());
		
		if (file.exists()) {
			System.out.println("FILE GIA' ESISTENTE!!!");
//			return;
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			
//			// "NOME","COGNOME","TELEFONO","EMAIL","NOTE"
//			fileWriter.write("\"NOME\",\"COGNOME\",\"TELEFONO\",\"EMAIL\",\"NOTE\"");
//			fileWriter.write('\n');
//			//"Mario";"Rossi";"3432532555";"mario.rossi@gmail.com";"vicino di casa"
//			fileWriter.write("\"Mario\";\"Rossi\";\"00000000\";\"mario.rossi@gmail.com\";\"vicino di casa\"");
			
			for (Contatto contatto : contatti) {
//				fileWriter.write(row);
				fileWriter.write(contatto.getCognome());
				fileWriter.write(';');
				fileWriter.write(contatto.getNome());
				fileWriter.write(';');
				fileWriter.write(contatto.getEmail());
				fileWriter.write(';');
				fileWriter.write(contatto.getTelefono());
				fileWriter.write(';');
				fileWriter.write(contatto.getNote());
				fileWriter.write('\n');
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
			
			System.out.println("done");
		}
	}
	
	public static void main(String[] args) {
		

//		File file = new File("/temp/prova.txt");
//		System.out.println("file exists? " + file.exists());
//		System.out.println("file is file? " + file.isFile());
//		System.out.println("file is dir? " + file.isDirectory());
//				
//		FileReader fileReader = null;
//		BufferedReader bufferedReader = null;
//		try {
//			fileReader = new FileReader(file);
////			while (fileReader.ready()) {
////				System.out.print((char)fileReader.read());
////			}
//			
//			bufferedReader = new BufferedReader(fileReader);
//			int c = 0;
//			List<String> rows = new ArrayList<String>();
//			while (bufferedReader.ready()) {
//				String row = bufferedReader.readLine();
//				System.out.println(++c + " " + row);
//				rows.add(row);
//				
////				StringTokenizer tokenizer = new StringTokenizer(row, ";");
////				while (tokenizer.hasMoreElements()) {
////					System.out.println(tokenizer.nextToken());
////				}
//				String[] columns = row.split(";");
//				for (String col : columns) System.out.println(col);
//			}
//			System.out.println("rows number: " + rows.size());
//		} catch (IOException ioEx) {
//			ioEx.printStackTrace();
//		} finally {
//			try {
//				bufferedReader.close();
//				fileReader.close();
//			} catch (IOException fEx) {
//				fEx.printStackTrace();
//			}
//		}
		
	}

}
