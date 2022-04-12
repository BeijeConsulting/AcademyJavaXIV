package it.beije.turing.rubrica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import it.beije.turing.file.CSVreader;

public class WriteToFile {
	
	static File file = new File("C:/Users/Padawan/Downloads/rubrica.csv");
	
	public static void writeFile(Contatto c, File file) {
		FileWriter fileWriter = null;
		ArrayList<Integer> bins = Parser.getCSVBins(file.getPath());
		
		try {
			fileWriter = new FileWriter(file, true);

		for (int i:bins){
			
		switch(i) { 
		  case 0:
			  	fileWriter.write(c.getNome());
			  	fileWriter.write(';');
			    break;
		  case 1:
			  	fileWriter.write(c.getCognome());
			  	fileWriter.write(';');
			    break;
		  case 2:
			  	fileWriter.write(c.getEmail());
			  	fileWriter.write(';');
			    break;
		  case 3:
			  	fileWriter.write(c.getTelefono());
			  	fileWriter.write(';');
			    break;

			}

		}
		fileWriter.write("\n");

//	}
} catch (IOException ioEx) {
	ioEx.printStackTrace();
} finally {
	try {
		fileWriter.flush();
		fileWriter.close();
	} catch (IOException fEx) {
		fEx.printStackTrace();
	}
}
}
	
	
	public static void main (String[] args) {
		
		writeFile(Creator.insert(),file);
	}
}
