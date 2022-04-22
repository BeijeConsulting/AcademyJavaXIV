package it.beije.turing.challenge.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RubricaCSV implements Rubrica{

	public static List<Contatto> readRubricaFromFile(Scanner s){
		List<Contatto> ris = new ArrayList<Contatto>();
		String path = null;
		while(path == null) {
			System.out.println("Inserire nome file senza estensione.");
			path = s.nextLine();
			if(path.equalsIgnoreCase("exit")) return null;
			Path filePath = Paths.get("File",path+".csv");
			File file = new File(filePath.toAbsolutePath().toString());
			if(!file.exists()) {
				System.out.println("File inesistente! inserire nuovo file.(scrivere exit per uscire)");
				path = null;
			}
		}
		String separator = null;
		while(separator == null) {
			System.out.println("Inserire separatore del file .csv.");
			separator = s.nextLine();
		}
		Path filePath = Paths.get("File",path+".csv");

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(filePath.toAbsolutePath().toString());
			bufferedReader = new BufferedReader(fileReader);
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				String[] columns = row.split(separator);
				contatto = new Contatto();
				try {
					contatto.setCognome(columns[0]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setCognome("");
				}
				try {
					contatto.setNome(columns[1]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNome("");
				}
				try {
					contatto.setEmail(columns[2]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setEmail("");
				}
				try {
					contatto.setTelefono(columns[3]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setTelefono("");
				}
				try {
					contatto.setNote(columns[4]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNote("");
				}
				try {
					contatto.setId(Integer.parseInt(columns[5]));
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setId(0);
				}
				if(contatto.getNome().equalsIgnoreCase("NOME")) {
					continue;
				}
				eliminaVirgolette(contatto);
				ris.add(contatto);
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

		System.out.println("contatti: " + ris.size());
		return ris;
	}


	public static List<Contatto> writeRubricaOnFile(List<Contatto> allContact, Scanner s) {
		List<Contatto> tmp = new ArrayList<Contatto>();
		String path = null;
		while(path == null) {
			System.out.println("Inserire nome file senza estensione.");
			path = s.nextLine();
			if(path.equalsIgnoreCase("exit")) return null;
		}
		String separator = null;
		while(separator == null) {
			System.out.println("Inserire separatore del file .csv.");
			separator = s.nextLine();
		}
		Path filePath = Paths.get("File",path+".csv");
		File file = new File(filePath.toAbsolutePath().toString());
		if(file.exists()) {
			System.out.println("File esistente, che fare?\n"
					+ "1: Sovrascrivi File\n"
					+ "2: Scrivi in append");
			String a = s.nextLine();
			switch(a) {
			default:
			case "1":
				break;
			case "2": 
				FileReader fileReader = null;
				BufferedReader bufferedReader = null;
				try {
					fileReader = new FileReader(filePath.toAbsolutePath().toString());
					bufferedReader = new BufferedReader(fileReader);
					Contatto contatto = null;
					while (bufferedReader.ready()) {
						String row = bufferedReader.readLine();
						String[] columns = row.split(separator);
						contatto = new Contatto();
						try {
							contatto.setCognome(columns[0]);
						}catch(ArrayIndexOutOfBoundsException e) {
							contatto.setCognome("");
						}
						try {
							contatto.setNome(columns[1]);
						}catch(ArrayIndexOutOfBoundsException e) {
							contatto.setNome("");
						}
						try {
							contatto.setEmail(columns[2]);
						}catch(ArrayIndexOutOfBoundsException e) {
							contatto.setEmail("");
						}
						try {
							contatto.setTelefono(columns[3]);
						}catch(ArrayIndexOutOfBoundsException e) {
							contatto.setTelefono("");
						}
						try {
							contatto.setNote(columns[4]);
						}catch(ArrayIndexOutOfBoundsException e) {
							contatto.setNote("");
						}
						try {
							contatto.setId(Integer.parseInt(columns[5]));
						}catch(ArrayIndexOutOfBoundsException e) {
							contatto.setId(0);
						}
						if(contatto.getNome().equalsIgnoreCase("NOME")) {
							continue;
						}
						eliminaVirgolette(contatto);
						tmp.add(contatto);
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
				break;
			}

		}
		for(Contatto c : allContact) {
			tmp.add(c);
		}
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);

			fileWriter.write("COGNOME");
			fileWriter.write(separator);
			fileWriter.write("NOME");
			fileWriter.write(separator);
			fileWriter.write("EMAIL");
			fileWriter.write(separator);
			fileWriter.write("TELEFONO");
			fileWriter.write(separator);
			fileWriter.write("NOTE");
			fileWriter.write(separator);
			fileWriter.write("\n");

			for (Contatto contatto : tmp) {
				fileWriter.write(contatto.getCognome());
				fileWriter.write(separator);
				fileWriter.write(contatto.getNome());
				fileWriter.write(separator);
				fileWriter.write(contatto.getEmail());
				fileWriter.write(separator);
				fileWriter.write(contatto.getTelefono());
				fileWriter.write(separator);
				fileWriter.write(contatto.getNote());
				fileWriter.write(separator);
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
		}
		return tmp;
	}



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean eliminaVirgolette(Contatto c) {

		for(int i = 0; i < c.getNome().length(); i++) {
			if(c.getNome().charAt(i) == '\'' || c.getNome().charAt(i) == '"') {
				c.setNome(c.getNome().substring(0,i).concat(c.getNome().substring(i+1)));
			}
		}
		for(int i = 0; i < c.getCognome().length(); i++) {
			if(c.getCognome().charAt(i) == '\'' || c.getCognome().charAt(i) == '"') {
				c.setCognome(c.getCognome().substring(0,i).concat(c.getCognome().substring(i+1)));
			}
		}
		for(int i = 0; i < c.getTelefono().length(); i++) {
			if(c.getTelefono().charAt(i) == '\'' || c.getTelefono().charAt(i) == '"') {
				c.setTelefono(c.getTelefono().substring(0,i).concat(c.getTelefono().substring(i+1)));
			}
		}
		for(int i = 0; i < c.getEmail().length(); i++) {
			if(c.getEmail().charAt(i) == '\'' || c.getEmail().charAt(i) == '"') {
				c.setEmail(c.getEmail().substring(0,i).concat(c.getEmail().substring(i+1)));
			}
		}
		return true;
	}
}
