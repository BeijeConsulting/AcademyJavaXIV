package it.beije.turing.xmlparser5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class DocumentoXML {
	
	private String stringaFile;
	
	public String getStringaFile() {
		return stringaFile;
	}

	public void setStringaFile(String stringaFile) {
		this.stringaFile = stringaFile;
	}
	


	public List<String> getElementsByTagName(String tagName , String rootEle){
		List<String> lista = new ArrayList<String>();
		StringBuilder root = new StringBuilder(rootEle);
		while(root.toString().contains(tagName)) {
			String inizio = "<" + tagName;
			String fine = "</"+tagName;
			int index = root.indexOf("<" + tagName);
			System.out.println("GINO PAULI");
			System.out.println(root.substring(index + inizio.length() + 1, root.length()));
			getElementsByTagName(tagName, root.substring(index + inizio.length() , root.length()));
			String s = root.substring(root.indexOf("<"+tagName), root.indexOf("</"+tagName) + fine.length()+1);

			lista.add(s);
			System.out.println(s);
			System.out.println("DIMENSIONE LISTA " + tagName + " " + lista.size());
			root.delete(root.indexOf("<"+tagName), root.indexOf(fine) + fine.length()+1);
		}
		return lista;
	}




	//rimuove l intestazione del XML eventualmente esiste
	public String removeDeclarationTag() {
		String s = this.stringaFile;
		String senzaIntestazione = null;
		if(s.startsWith("<?") && s.contains("?>")) {
			senzaIntestazione = s.substring(s.indexOf("?>") + 2);
		}
		if(senzaIntestazione != null) {
			return senzaIntestazione;
		}
		return s;
		
	}
	
	public Tag getRootElement() {
		String rootStringa = removeDeclarationTag();
		String nome = null;
		nome = getTagNameFromString(rootStringa);
		System.out.println(nome);
		String textContent = null;
		Tag root = new Tag(nome, textContent);
		return root;
	}

	public String getContenutoFile(String path) {
		StringBuilder s = new StringBuilder();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			while (br.ready()) {
				s.append((char) br.read());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//System.out.println(s.toString());
		return s.toString();
	}
	
//	public List<String> getNodeChild(String e) {
//		List<String> figliInterni = new ArrayList<String>();
//		List<String> figli = getChildElements(e);
//		for (String string : figli) {
//			figliInterni.addAll(getChildElements(string));
//			System.out.println("STAMPA FIGLI DEI FIGLI");
//			System.out.println(figliInterni);
//		}
//		return figliInterni;
//	}
	
	public List<String> getChildElements(String el) {
		List<String> children = new ArrayList<>();
		int indexBegin = el.indexOf("<", el.indexOf(">"));
		int indexEnd = el.lastIndexOf("<");
		String textContent = el.substring(indexBegin, indexEnd);
		//System.out.println(" CONTENUTO PRELEVATO \n" + textContent);
		String tagName = null;
		int firstSpacebar = textContent.indexOf(" ");
		int closingTag = textContent.indexOf(">");
		if (firstSpacebar == -1) {
			tagName = textContent.substring(1, closingTag);
			//System.out.println("VOGLIO VEDERE IL TAG NAME " + tagName);
		} else if(firstSpacebar > closingTag){
			tagName = textContent.substring(1, closingTag);
			//System.out.println("VOGLIO VEDERE IL TAG NAME 2 " + tagName);
		} else {
			tagName = textContent.substring(1, closingTag);
			//System.out.println("VOGLIO VEDERE IL TAG NAME 3 " + tagName);
		}
		
		while (textContent.contains(tagName)) {
			String closureTag = "/" + tagName + ">";
			int occurrenceOfClosure = textContent.indexOf(closureTag);
			int endOfClosure = occurrenceOfClosure + closureTag.length() - 1;
			
			String child = textContent.substring(0, endOfClosure);
//			System.out.println(child);
//			System.out.println("=========================");
			
			textContent = textContent.substring(endOfClosure);
			
			children.add(child);
		}
		
		
		return children;
	}
	
	public String getTagNameFromString(String el) {
		String tagName = new String();
		int firstSpacebar = el.indexOf(" ");
		int startIndex = el.indexOf("<") + 1;
		int closingTag = el.indexOf(">");
		if (firstSpacebar == -1) {
			tagName = el.substring(startIndex, closingTag);
		} else if(firstSpacebar > closingTag){
			tagName = el.substring(startIndex, closingTag);
		} else {
			tagName = el.substring(startIndex, firstSpacebar);
		}
		
		return tagName;
	}
	
}
