//Realizzare un programma che, ottenuto in
//input il percorso di una directory, ne elenchi il contenuto in un file di testo.

package File;

import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Es {
	public static void dir(String directory) {
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		FileWriter fileWriter = null;
		try {
			file = new File(directory);
			
			fileReader = new FileReader(directory);
			bufferedReader = new BufferedReader(fileReader);
			
		
				fileWriter = new FileWriter(file);
			
			
			if (file.exists()) {
				System.out.println("FILE GIA' ESISTENTE!!!");
				return;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	public static void main(String[] args) {
		
	}

}
