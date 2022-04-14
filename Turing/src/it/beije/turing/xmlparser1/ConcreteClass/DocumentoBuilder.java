package it.beije.turing.xmlparser1.ConcreteClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.xmlparser1.Interfaces.Documento;

public class DocumentoBuilder {
	public static Documento parse(String path) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		DocumentoConcreto d = new DocumentoConcreto();
		List<String> tmp = new ArrayList<>();
		try {
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				if(row == null) {
					break;
				}
				tmp.add(row);
			}
			d.setTestoTotale(tmp);
		} catch(Exception e) {
			
		}finally {
			
		}
		d.setPath(path);
		return d;
	}
}
