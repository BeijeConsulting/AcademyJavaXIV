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
//			System.out.println("GINO PAULI");
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
	
	public Tag getNodeChild() {
		String rootStringa = removeDeclarationTag();
		String nome = getTagNameFromString(rootStringa).trim();
		String textContent = getTextContentString(rootStringa);
		
		List<String> childrenStringa = getChildElements(textContent);
		
		Tag root = new Tag(nome, textContent);
		
		
		for (String child : childrenStringa) {
			Tag tagFiglio = new Tag(getTagNameFromString(child) , getTextContentString(child));
			root.addTag(tagFiglio);
		}
		return root;
	}
	
	public Tag getRootElement() {
		String rootStringa = removeDeclarationTag();
		String nome = getTagNameFromString(rootStringa).trim();
		String textContent = getTextContentString(rootStringa);
		
		Tag root = new Tag(nome, textContent);
		
		List<String> childrenStringa = getChildElements(textContent);
		
		
		for (String child : childrenStringa) {
			Tag tagFiglio = new Tag(getTagNameFromString(child) , getTextContentString(child));
			root.addTag(tagFiglio);
		}
		return root;
	}
	
	public Tag buildDoc(Tag tag) {
		String contentTag = tag.getContenuto();
//		System.out.println(contentTag);
		List<Tag> children = tag.getChildren();
		
		for (Tag child : children) {
			List<String> childrenString = getChildElements(child.getContenuto());
			
			
			for (String childString : childrenString) {
				String tagName = getTagNameFromString(childString);
				String tagContent = getTextContentString(childString);
				Tag tagFiglio = new Tag(tagName, tagContent);
				child.addTag(tagFiglio);
			}
			
			buildDoc(child);
		}
		return tag;
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
	
	public String getTextContentString(String el){
		int indexBegin = el.indexOf("<", el.indexOf(">"));
		int indexEnd = el.lastIndexOf("<");
		String textContent = el.substring(indexBegin, indexEnd);
		return textContent;
	}
	
	
	public List<String> getChildElements(String textContent) {
        List<String> children = new ArrayList<>();
//        int indexBegin = getIndexOfChild(el, "<");
//        int indexEnd = el.lastIndexOf("<");
//        String textContent = el.substring(indexBegin, indexEnd);
        String tagName = getTagNameFromString(textContent);



        while ((tagName != null) && textContent.contains(tagName)) {
            String closureTag = "/" + tagName + ">";
            int indexBegin = textContent.indexOf("<");
            int startClosure = textContent.indexOf(closureTag);
            int endClosure = startClosure + closureTag.length();

            String child = textContent.substring(indexBegin, endClosure);

            int cutContentFrom = textContent.indexOf("<", startClosure);
            if (cutContentFrom != -1) {
                textContent = textContent.substring(cutContentFrom);
                tagName = getTagNameFromString(textContent);
            } else {
                textContent = "";
            }

            children.add(child);
        }


        return children;
    }
	
	public int getIndexOfChild(String el , String c) {
		int index = el.indexOf(c , el.indexOf(">"));
		return index;
	}
	
	public String getTagNameFromString(String el) {
		String tagName = new String();
		if (el.length() > 0) {
			
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
		
		return null;
		
	}
	
}
