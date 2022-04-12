package it.beije.turing.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {	
	
	public static void main(String[] args) {
		readFileList(new File("/Users/simonepitossi/File").listFiles());
	}

	public static void readFileList(File[] fL) {
		
		for(File f : fL) {
			if(f.isFile() && !f.getName().equalsIgnoreCase(".DS_Store")) {
				System.out.println(f.getName() + "\n");
				readFile(f);
			} else if(f.isDirectory()) {
				readFileList(f.listFiles());
			}
		}
	}
	
	public static void readFile(File file) {
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		
		try {
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
			
			while(bufferReader.ready()) {
				System.out.println(bufferReader.readLine() + "\n");
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				bufferReader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void readContatti(File file) {
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		boolean campiTraVirgolette = false;
		boolean primaLinea = true;
		
		try {
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
			
			while(bufferReader.ready()) {
				if(primaLinea) {
					String campi = bufferReader.readLine();
					String[] individuaCampi = campi.split(campi);
					primaLinea = false;
					if(csvContieneVirgolette(campi)) {
						for(String s: individuaCampi) {
							switch(s.toLowerCase()) {
							case "nome":
								break;
							case "cognome":
								break;
							case "telefono":
								break;
							case "email":
								break;
							case "note":
								break;
							}
						}
					} else {
						for(String s: individuaCampi) {
							switch(s.toLowerCase()) {
							case "\"nome":
								break;
							case "\"cognome\"":
								break;
							case "\"telefono\"":
								break;
							case "\"email\"":
								break;
							case "\"note\"":
								break;
							}
						}
					}
					
					
				}
				String row = bufferReader.readLine();
					
			}
	
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}

	public static boolean csvContieneVirgolette(String campi) {
		boolean campiTraVirgolette = false;
		String[] individuaCampi = campi.split(";");
		
		switch(individuaCampi[0].toLowerCase()) {
		case "nome":
			return campiTraVirgolette;
		case "cognome":
			return campiTraVirgolette;
		case "telefono":
			return campiTraVirgolette;
		case "email":
			return campiTraVirgolette;
		case "note":
			return campiTraVirgolette;
		default:
			break;
		}
		
		return campiTraVirgolette = true;
	}

}
