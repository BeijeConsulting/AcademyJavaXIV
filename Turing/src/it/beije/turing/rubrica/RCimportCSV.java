package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RCimportCSV {
	public static ArrayList<Integer> getCSVBins(String csvPath, String separator) {		//returns arraylist of ints with the positions of NOME,COGNOME,EMAIL,TELEFONO
		ArrayList<Integer> bins = new ArrayList<>();
		ArrayList<String[]> lines = getCSVLines(csvPath, separator);
		if (new File(csvPath).length()==0) {
			for(int i = 0; i<5;i++) bins.add(-1);
			return bins;
		}
		List<String> firstLine = Arrays.asList(lines.get(0));
		//for (String col : columns) System.out.println(col);
		bins.add(firstLine.indexOf("NOME"));
		bins.add(firstLine.indexOf("COGNOME"));
		bins.add(firstLine.indexOf("EMAIL"));
		bins.add(firstLine.indexOf("TELEFONO"));
		bins.add(firstLine.indexOf("NOTE"));

		return bins;
	}

	public static ArrayList<String[]> getCSVLines(String csvPath, String separator) {
		boolean virgolette = false;

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		ArrayList<String[]> lines = null;
		try {
			fileReader = new FileReader(csvPath);
			bufferedReader = new BufferedReader(fileReader);
			lines = new ArrayList<String[]>();
			String row = "";
			int counter = 0;
			while ((row = bufferedReader.readLine())!=null) {
				String[] line;
				if (virgolette) {
					row = row.substring(1, row.length()-1);			//extreme quotes cleanup
					line = row.split("\""+separator+"\"");			//split
				} else {
					line = row.split(separator);		//split
				}

				if (counter>0 && line.length<lines.get(0).length) {
					List<String> newLine = new ArrayList<String>(Arrays.asList(line));
					while (newLine.size()<lines.get(0).length) {
						newLine.add("");
					}
					line = newLine.toArray(line);
				}
				lines.add(line);
				counter++;
				//	System.out.println(Arrays.toString(line));
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
		return lines;
	}

	public static ArrayList<Contatto> getCSVContacts(String csvPath, String separator) {		//returns arraylist of ints with the positions of NOME,COGNOME,EMAIL,TELEFONO
		ArrayList<Integer> bins = getCSVBins(csvPath, separator);
		ArrayList<String[]> lines = getCSVLines(csvPath, separator);
		ArrayList<Contatto> contatti = new ArrayList<>();

		for (int i = 1; i<lines.size(); i++) {
			Contatto c = new Contatto();
			for (int j=0; j<bins.size(); j++) {
				if (bins.get(j)==-1) {
					continue;
				}
				switch(j) {
				case 0:
					if (lines.get(i)[bins.get(j)].equals("")) {
						c.setNome(null);
					} else {
					c.setNome(lines.get(i)[bins.get(j)]);
					}
					break;
				case 1:
					if (lines.get(i)[bins.get(j)].equals("")) {
						c.setCognome(null);
					} else {
					c.setCognome(lines.get(i)[bins.get(j)]);
					}
					break;
				case 2:
					if (lines.get(i)[bins.get(j)].equals("")) {
						c.setEmail(null);
					} else {
					c.setEmail(lines.get(i)[bins.get(j)]);
					}
					break;
				case 3:
					if (lines.get(i)[bins.get(j)].equals("")) {
						c.setTelefono(null);
					} else {
					c.setTelefono(lines.get(i)[bins.get(j)]);
					}
					break;
				case 4:
					if (lines.get(i)[bins.get(j)].equals("")) {
						c.setNote(null);
					} else {
					c.setNote(lines.get(i)[bins.get(j)]);
					}
					break;
				default:
					System.out.println("anomaly in contact creation");
					break;
				}
			}
			contatti.add(c);
		}
		return contatti;
	}


}
