package it.beije.turing.file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.rubrica.*;
public class RubricaCSV {
	public static String[] ordine;
	
	public static void main(String args[]) {
		leggiRubrica("C:\\Users\\Marco\\Desktop\\rubrica.csv");
	}
	
	public static String[] stabilisciOrdine(BufferedReader br) throws IOException {
		String s = br.readLine();
		String[] columns = splitString(s);
		String[] ordine = new String[s.length()];
		int count = 0;
		System.out.println("LENGTH: " + columns.length);
//		for(String str : columns) {
//			System.out.println(str);
//		}
		for(int i = 0; i < columns.length && !(count == 5); i++) {
			columns[i] = columns[i].toLowerCase();
			if(columns[i].equals("nome"))
				ordine[count] = columns[i];
			else if(columns[i].equals("cognome"))
				ordine[count] = columns[i];
			else if(columns[i].equals("email"))
				ordine[count] = columns[i];
			else if(columns[i].equals("telefono"))
				ordine[count] = columns[i];
			else if(columns[i].equals("note"))
				ordine[count] = columns[i];
			else {
				count--;
			}
			count++;
		}
		
		return ordine;
	}
	
	public static String[] splitString(String s) {
		s.substring(1, s.length() - 1);
		
//		for(String sr : s.split(";"))
////			System.out.print(sr);
		return s.split(";");
	}
	
	public static String avoidNull(String s) {
		if(s != null)
			return s;
		return "";
	}
	
	public static void scriviFile(List<Contatto> contatti, String path) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(new File(path));
			fileWriter.write("cognome;nome;email;telefono;note;\n");
			for (Contatto contatto : contatti) {
				fileWriter.write(avoidNull(contatto.getCognome()));
				fileWriter.write(';');
				//fileWriter.write('\t');
				fileWriter.write(avoidNull(contatto.getNome()));
				fileWriter.write(';');
				//fileWriter.write('\t');
				fileWriter.write(avoidNull(contatto.getEmail()));
				fileWriter.write(';');
				//fileWriter.write('\t');
				fileWriter.write(avoidNull(contatto.getTelefono()));
				fileWriter.write(';');
				//fileWriter.write('\t');
				fileWriter.write(avoidNull(contatto.getNote()));
				fileWriter.write('\n');
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch(IOException e) {e.printStackTrace();}
		}
		
	}
	
	public static ArrayList<Contatto> leggiRubrica(String path) {
		FileReader fileReader;
		BufferedReader bufferedReader;
		ArrayList<Contatto> contatti = null;
		Contatto contatto;
		try {
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			contatti = new ArrayList<>();
			String s;
			
			if(bufferedReader.ready())
				ordine = stabilisciOrdine(bufferedReader);
			
			
			while(bufferedReader.ready()) {
				s = bufferedReader.readLine();
				String[] columns = splitString(s);
				contatto = new Contatto();
				contatto.setCognome("");
				contatto.setNome("");
				contatto.setEmail("");
				contatto.setTelefono("");
				contatto.setNote("");
				for(int i = 0; ordine[i] != null && i < ordine.length && i < columns.length; i++) {
					
					if(ordine[i].equals("nome"))
						contatto.setNome(columns[i]);
					else if(ordine[i].equals("cognome"))
						contatto.setCognome(columns[i]);
					else if(ordine[i].equals("telefono"))
						contatto.setTelefono(columns[i]);
					else if(ordine[i].equals("email"))
						contatto.setEmail(columns[i]);
					else if(ordine[i].equals("note"))
						contatto.setNote(columns[i]);
				}
				contatti.add(contatto);	
			}
			
		}catch(IOException e ) {e.printStackTrace();}
		return contatti;
	}
}
