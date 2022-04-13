package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LetturaCVS {
	
	public List<Contatto> getLetturaCVS(String path , List<Contatto> lista , String separatore){
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path.trim());
			br = new BufferedReader(fr);
			while(br.ready()) {
				String riga = br.readLine();
				char c = (char)34;
				boolean b = riga.startsWith(c+"");
				Contatto contatto = splittaRiga(riga , b , separatore);
				lista.add(contatto);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return lista;
	}
	
	private Contatto splittaRiga(String riga , boolean b , String separatore) {
		StringBuilder sb = new StringBuilder();
		char c = 34;
		sb.append(c+"");
		sb.append(separatore);
		sb.append(c+"");
		String riga1 = null;
		String[] aString = null;
		if(b){
			riga1 = riga.substring(1, riga.length());
			aString = riga.split(sb.toString()); //splitta con ";"
		} else {
			aString = riga.split(separatore); // splitta con ;
		}
		Contatto contatto = new Contatto();
		for (int i = 0; i < aString.length; i++) {
			switch (i) {
			case 0:
				contatto.setCognome(aString[0]);
				break;
			case 1 :
				contatto.setNome(aString[1]);
				break;
			case 2 :
				contatto.setEmail(aString[2]);
				break;
			case 3 :
				if(aString[3].toString().contains("'")) {
					contatto.setTelefono(aString[3].toString().substring(1));
				} else {
					contatto.setTelefono(aString[3]);
				}
				break;
			}
			
		}
		System.out.println(contatto.toString());
		return contatto;
	}
	
//	public List<Contatto> getLetturaCVS(String path , List<Contatto> lista){
//		FileReader fr = null;
//		BufferedReader br = null;
//		try {
//			fr = new FileReader(path.trim());
//			br = new BufferedReader(fr);
//			while(br.ready()) {
//				String riga = br.readLine();
//				char c = (char)34;
//				boolean b = riga.startsWith(c+"");
//				Contatto contatto = splittaRiga(riga , b , ";");
//				lista.add(contatto);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				br.close();
//				fr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//		}
//		return lista;
//	}

	

}
