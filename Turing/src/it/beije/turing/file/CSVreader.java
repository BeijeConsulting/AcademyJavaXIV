package it.beije.turing.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.rubrica.Contatto;


public class CSVreader {
	
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
				System.out.println(++c + " " + row);
				
				row = row.substring(1, row.length()-1);
				String[] columns = row.split("\";\"");
//				for (String col : columns) System.out.println(col);
				
				contatto = new Contatto();
				contatto.setNome(columns[0]);
				contatto.setCognome(columns[1]);
				contatto.setTelefono(columns[2]);
				contatto.setEmail(columns[3]);
				contatto.setNote(columns[4]);
				
				System.out.println(contatto);
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
		
		System.out.println("contatti: " + contatti.size());
		return contatti;
	}

	public static void main(String[] args) {

		readCSV("/temp/prova.txt");

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
