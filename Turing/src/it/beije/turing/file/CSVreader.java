package it.beije.turing.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CSVreader {
 //Esempio IVO
	public static void main(String[] args) {
		
		File file = new File("/temp/prova.txt");
		System.out.println("file exists? " + file.exists());
		System.out.println("file is file? " + file.isFile());
		System.out.println("file is dir? " + file.isDirectory());
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
//			while (fileReader.ready()) {
//				System.out.print((char)fileReader.read());
//			}
			
			bufferedReader = new BufferedReader(fileReader);
			int c = 0;
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				System.out.println(++c + " " + row);
				
//				StringTokenizer tokenizer = new StringTokenizer(row, ";");
//				while (tokenizer.hasMoreElements()) {
//					System.out.println(tokenizer.nextToken());
//				}
				String[] rows = row.split(";");
				for (String r : rows) System.out.println(r);
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
		
	}

}
