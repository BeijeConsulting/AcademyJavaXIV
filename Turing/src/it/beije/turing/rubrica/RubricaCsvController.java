package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RubricaCsvController {
	
	public static List<Contatto> readCSV(String csvPath) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		try {
			
			fileReader = new FileReader(csvPath);
			bufferedReader = new BufferedReader(fileReader);
			contatti = new ArrayList<Contatto>();
			Contatto contatto = null;
			int c = 0;
			int nome = 0, cognome = 0, telefono = 0, email = 0, note = 0;
			
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				
				row = row.substring(1, row.length()-1);
				String[] columns = row.split("\";\"");
				
				if (c == 0) {
					int i = 0;
					for(String s : columns) {
						switch(s) {
							case "NOME":
								nome = i;
								break;
							case "COGNOME":
								cognome = i;
								break;
							case "TELEFONO":
								telefono = i;
								break;
							case "EMAIL":
								email = i;
								break;
							case "NOTE":
								note = i;
								break;
						}
					}
				} else {
					contatto = new Contatto();
					contatto.setNome(columns[nome]);
					contatto.setCognome(columns[cognome]);
					contatto.setTelefono(columns[telefono]);
					contatto.setEmail(columns[email]);
					contatto.setNote(columns[note]);
					
					System.out.println(contatto);
					contatti.add(contatto);
				}
				System.out.println(++c + " " + row);
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
		
		
	}

}
