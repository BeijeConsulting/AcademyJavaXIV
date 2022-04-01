package it.beije.xiv.esercizi.completi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Fraudolent {

	public static void main(String[] args) {
		
		ArrayList<String> s = Fraudolent.readFromFile("fraudolent.txt");
	}
	
	public static ArrayList<String> readFromFile(String filename) {
		ArrayList<String> ris = new ArrayList<>();
		ArrayList<String> err = new ArrayList<>();
		Path path = Paths.get("File",filename);
		double buy = 0.0, sell = 0.0;
		
		//System.out.println(path.toAbsolutePath());
		try(Stream<String> stream = Files.lines(path)){
			//stream.forEach(System.out::println);
			List<String> tmp =  stream.toList();
			for(String s : tmp) {
				boolean lineCorrectFormat = true;
				StringBuilder q = new StringBuilder();
				StringBuilder v = new StringBuilder();
				double quantity = 0.0, value = 0.0;
				if(s.isBlank() || s.isEmpty() || s.length() < 11) {
					err.add(s);
					continue;				//11 numero minimo di caratteri presenti in una riga
				}
				for(int i = 0; i<3; i++) {
					if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
						continue;
					}
					lineCorrectFormat = false;
					break;
				}
				if(s.charAt(3) != ' ') lineCorrectFormat = false;
				for(int i = 4; i < s.length()&& s.charAt(i) != ' '; i++) {
					v.append(s.charAt(i));
				}
				try{
					value = Double.parseDouble(v.toString());
				}catch(Exception e) {
					lineCorrectFormat = false;
				}
				for(int i = (4+v.length()+1);i < s.length() && s.charAt(i) != ' '; i++) {
					q.append(s.charAt(i));
				}
				try{
					quantity = Double.parseDouble(q.toString());
				}catch(Exception e) {
					lineCorrectFormat = false;
				}
				if(lineCorrectFormat) {
					ris.add(s);
					switch(s.charAt(s.length()-1)) {
						case 'B':
							buy += (quantity*value);
							break;
						case 'S':
							sell += (quantity*value);
							break;
						default:
							break;
					}
				}else {
					err.add(s);
				}
				
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("File: "+path.toAbsolutePath().getFileName());
		System.out.println("Op: " + ris.size() + " Buy: " + buy + " Sell: " + sell);
		System.out.println("Err:");
		for(String s : err) {
			System.out.println(s);
		}
		return ris;
	}
}
