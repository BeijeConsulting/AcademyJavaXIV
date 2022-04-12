package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RubricaCsvController {
	
	public static List<Contatto> readCSV(String csvPath, boolean virgolette) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		try {
			
			fileReader = new FileReader(csvPath);
			bufferedReader = new BufferedReader(fileReader);
			contatti = new ArrayList<Contatto>();
			Contatto contatto = null;
			int c = 0;
			int nome = -1, cognome = -1, telefono = -1, email = -1, note = -1;
			
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				
				row = row.substring(1, row.length()-1);
				String[] columns = null;
				if(virgolette) {
					columns = row.split("\";\"");
				} else {					
					columns = row.split(";");
				}
				
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
					if(columns.length > 0) {
						if(nome != -1) {
							contatto.setNome(columns[nome]);
						}
						if(cognome != -1) {
							contatto.setCognome(columns[cognome]);		
						}
						if(telefono != -1) {
							contatto.setTelefono(columns[telefono]);
						}
						if(email != -1) {
							contatto.setEmail(columns[email]);
						}
						if(note != -1) {
							contatto.setNote(columns[note]);
						}
					}

					System.out.println(contatto);
					contatti.add(contatto);
				}
				c++;
				//System.out.println(c + " " + row);
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
	
	public static void writeCSV(List<Contatto> contatti, String csvPath) {
		File file = new File(csvPath);
		System.out.println("file exists? " + file.exists());
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			int i = 0;
			for (Contatto contatto : contatti) {
				if(i == 0) {
					fileWriter.write("COGNOME;NOME;EMAIL;TELEFONO;NOTE\n");
				} else {					
					if(contatto.getCognome() != null) {					
						fileWriter.write(contatto.getCognome());
					}
					fileWriter.write(';');
					if(contatto.getNome() != null) {					
						fileWriter.write(contatto.getNome());
					}
					fileWriter.write(';');
					if(contatto.getEmail() != null) {					
						fileWriter.write(contatto.getEmail());
					}
					fileWriter.write(';');
					if(contatto.getTelefono() != null) {					
						fileWriter.write(contatto.getTelefono());
					}
					fileWriter.write(';');
					if(contatto.getNote() != null) {				
						fileWriter.write(contatto.getNote());
					}	
					fileWriter.write('\n');
				}
				i++;
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

	public static void scannerCSV(String csvPath) {
		
	}
	
	public static void main(String[] args) {
		
		List<Contatto> contatti = RubricaCsvController.readCSV("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.csv", false);
		//System.out.println(contatti);
		RubricaCsvController.writeCSV(contatti, "/Users/lorenzoorru0/Desktop/CSVjava/rubricaNew.csv");
	}

}
