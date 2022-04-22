package it.beije.turing.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import it.beije.turing.rubrica.Contatto;

public class CSVwriter {

	public static void write(List<Contatto> contatti) {
		
		File file = new File("C:\\Users\\39346\\IdeaProjects\\AcademyJavaXIV\\Turing\\src\\it\\beije\\turing\\rubrica\\dbTocsv.csv");

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);

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
				fileWriter.write(contatto.getNome());
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
			
			System.out.println("File modificato");
		}
		
	}

}
