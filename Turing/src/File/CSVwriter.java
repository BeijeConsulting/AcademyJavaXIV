package File;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;

import com.sun.tools.javac.util.List;

public class CSVwriter {

	public static void main(String[] args) {
		File file = new File("/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/Turing/src/File/temp/File123.txt");

		
		System.out.println("file exists? " + file.exists());
	
		//per scrivere un file 
		FileWriter fileWriter = null;
		
		 
		
		try {
			 fileWriter = new FileWriter(file);
			 
			 //scrivo la riga da 0
			 fileWriter.write("\"NOME\";\"COGNOME\";\"TELEFONO\";\"EMAIL\";\"NOTE\""); 
			 
			 //per andare a capo sereve inserire \n
			 fileWriter.write('\n'); 
			 
			 fileWriter.write("\"Mario\";\"Rossi\";\"3425728273\";\"Mario.rossi@gmail.com\";\"vicino di casa\"");
			 
			 
		
			 
		} catch (IOException ioEx) {
			// TODO Auto-generated catch block
			ioEx.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter
				.close();
			} catch (IOException fex) {
				// TODO Auto-generated catch block
				fex.printStackTrace();
			}
			
			System.out.println("done");
		}
		
		
	}

}
