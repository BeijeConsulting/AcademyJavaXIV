package it.beije.turing.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LetturaFile {
	private static final String PATH = "C:\\Users\\aless\\Desktop\\test";
	private List<String> lista = new ArrayList<String>();

	public List<String> getLista() {
		return lista;
	}

	public static void main(String[] args) {
		LetturaFile lf = new LetturaFile();
		File file = new File(PATH);
		lf.getNomeFile(file, lf.getLista() , "");
		lf.stampaLista(lf.getLista());
	}

	private void stampaLista(List<String> lista2) {
		for (String string : lista2) {
			System.out.println(string);
		}
	}

	public void getNomeFile(File file, List<String> lista , String space) {
		if (file.canRead()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File file2 : files) {
					if (file2.canRead()) {
						lista.add(space + file2.getName());
						getNomeFile(file2, lista , space + " ");
					}
				}
			}

		}
	}

}
