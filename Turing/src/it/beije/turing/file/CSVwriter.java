package it.beije.turing.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import it.beije.turing.rubrica.Contatto;

public class CSVwriter {

	public static void main(String[] args) {
		
		File file = new File("/temp/prova123.txt");
		System.out.println("file exists? " + file.exists());
		
		
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			
//			// "NOME","COGNOME","TELEFONO","EMAIL","NOTE"
//			fileWriter.write("\"NOME\",\"COGNOME\",\"TELEFONO\",\"EMAIL\",\"NOTE\"");
//			fileWriter.write('\n');
//			//"Mario";"Rossi";"3432532555";"mario.rossi@gmail.com";"vicino di casa"
//			fileWriter.write("\"Mario\";\"Rossi\";\"00000000\";\"mario.rossi@gmail.com\";\"vicino di casa\"");
			
			List<Contatto> contatti = CSVreader.readCSV("/temp/prova.txt");
			for (Contatto contatto : contatti) {
//				fileWriter.write(row);
				fileWriter.write(contatto.getCognome());
				fileWriter.write('\t');
				fileWriter.write(contatto.getNome());
				fileWriter.write('\t');
				fileWriter.write(contatto.getEmail());
				fileWriter.write('\t');
				fileWriter.write(contatto.getTelefono());
				fileWriter.write('\t');
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

}
