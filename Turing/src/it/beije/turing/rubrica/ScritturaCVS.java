package it.beije.turing.rubrica;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ScritturaCVS {
	
	public void getScrittursCVS(String pathFile){
		FileWriter fw = null;
		try {
			fw = new FileWriter(pathFile);
//			fw.write("\"NOME\";\"COGNOME\";\"TELEFONO\";\"EMAIL\";\"NOTE\"");
//			fw.write("\n");
			fw.write("\"Mario\";\"Rossi\";\"00000000\";\"mario.rossi@gmail.com\";\"vicino di casa\"");
			fw.write("\n");
			fw.write("\"Gino\";\"Pauli\";\"3778899678\";\"gino.pauli@gmail.com\";\"uno stronzo amaro\"");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("done");
		}
		
		
	}
	
	public void getScrittursCVS(List<Contatto> contatti, String pathFile, String separator) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(pathFile);
			for (Contatto contatto : contatti) {
				if(contatto.getCognome() != null) {
					fw.write(contatto.getCognome() + separator);
				}
				if(contatto.getNome() != null) {
					fw.write(contatto.getNome() + separator);
				}
				if(contatto.getEmail() != null) {
					fw.write(contatto.getEmail() + separator);
				}
				if(contatto.getTelefono() != null) {
					fw.write(contatto.getTelefono() + separator);
				}
				if(contatto.getNote() != null) {
					fw.write(contatto.getNote() + separator);
				}
				fw.write('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.flush();
				fw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
