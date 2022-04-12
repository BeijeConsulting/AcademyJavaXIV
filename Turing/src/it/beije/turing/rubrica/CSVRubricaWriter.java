package it.beije.turing.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVRubricaWriter {

	public static void writeCsv(String fileName) {
		
		File file = new File(fileName);
		System.out.println("file exists? " + file.exists());
		
		if (file.exists()) {
			System.out.println("FILE GIA' ESISTENTE!!!");
			appendInFile();
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			
//			// "NOME","COGNOME","TELEFONO","EMAIL","NOTE"
//			fileWriter.write("\"NOME\",\"COGNOME\",\"TELEFONO\",\"EMAIL\",\"NOTE\"");
//			fileWriter.write('\n');
//			//"Mario";"Rossi";"3432532555";"mario.rossi@gmail.com";"vicino di casa"
//			fileWriter.write("\"Mario\";\"Rossi\";\"00000000\";\"mario.rossi@gmail.com\";\"vicino di casa\"");
			List<Contatto> contatti = CSVRubricaReader.getContatti();
			for (Contatto contatto : contatti) {
//				fileWriter.write(row);
				fileWriter.write("\"");
				fileWriter.write(contatto.getCognome());
				fileWriter.write("\";");
				fileWriter.write(contatto.getNome());
				fileWriter.write("\";");
				fileWriter.write(contatto.getEmail());
				fileWriter.write("\";");
				fileWriter.write(contatto.getTelefono());
				fileWriter.write("\";");
				fileWriter.write(contatto.getNote());
				fileWriter.write("\"");
				fileWriter.write("\n");
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

	private static void appendInFile() {
	}

}
